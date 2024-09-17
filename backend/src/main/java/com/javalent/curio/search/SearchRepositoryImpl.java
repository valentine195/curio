package com.javalent.curio.search;

import java.io.Serializable;
import java.util.List;

import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.javalent.curio.search.models.SearchPredicate;
import com.javalent.curio.search.models.TermSearchPredicate;
import com.javalent.curio.features.items.models.ItemSearchDTO;
import com.javalent.curio.search.models.FieldSearchPredicate;

import jakarta.persistence.EntityManager;

@Transactional
public class SearchRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
        implements SearchRepository<T, ID> {

    private final EntityManager entityManager;

    public SearchRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
    }

    public SearchRepositoryImpl(
            JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public List<T> searchBy(String text, int limit, String... fields) {

        SearchResult<T> result = getSearchResult(text, limit, fields);

        return result.hits();
    }

    public List<T> searchBy(List<SearchPredicate> predicates, ItemSearchDTO search) {
        SearchResult<T> result = getSearchResult(predicates, search);
        return result.hits();
    }

    private SearchResult<T> getSearchResult(String text, int limit, String[] fields) {
        SearchSession searchSession = Search.session(entityManager);

        SearchResult<T> result = searchSession
                .search(getDomainClass())
                .where(f -> f.match().fields(fields).boost(2).matching(text).fuzzy(1))
                .fetch(limit);
        return result;
    }

    private SearchResult<T> getSearchResult(List<SearchPredicate> predicates, ItemSearchDTO search) {
        SearchSession searchSession = Search.session(entityManager);
        SearchResult<T> result = searchSession
                .search(getDomainClass())
                .where((f, root) -> {
                    root.add(f.matchAll());
                    if (!search.getMuseums().isEmpty()) {
                        root.add(f.terms().field("museum.name").matchingAny(search.getMuseums()));
                    }
                    root.add(f.bool().with(b -> {
                        for (SearchPredicate predicate : predicates) {
                            switch (predicate) {
                                case FieldSearchPredicate p -> {
                                    b.should(f.match().fields(p.fields.toArray(new String[0])).boost(p.boost)
                                            .matching(search.getQuery()).fuzzy(p.fuzzy));
                                }
                                case TermSearchPredicate t -> {
                                }
                                default -> {
                                }
                            }
                        }
                    }));
                })
                .fetch(null);
        return result;
    }
}