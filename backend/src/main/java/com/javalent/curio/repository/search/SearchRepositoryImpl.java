package com.javalent.curio.repository.search;

import java.io.Serializable;
import java.util.List;
import java.util.function.Function;

import org.hibernate.search.engine.search.predicate.dsl.PredicateFinalStep;
import org.hibernate.search.engine.search.predicate.dsl.SearchPredicateFactory;
import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.javalent.curio.repository.items.SearchPredicate;

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

    public List<T> searchBy(List<SearchPredicate> predicates, String query, int limit) {
        SearchResult<T> result = getSearchResult(predicates, query, limit);
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

    private SearchResult<T> getSearchResult(List<SearchPredicate> predicates, String query, int limit) {
        SearchSession searchSession = Search.session(entityManager);
        System.out.println(predicates);
        SearchResult<T> result = searchSession
                .search(getDomainClass())
                .where((f) -> f.or().with(g -> {
                    for (SearchPredicate predicate : predicates) {
                        g.add(f.match().fields(predicate.fields.toArray(new String[0])).boost(predicate.boost)
                                .matching(query).fuzzy(predicate.fuzzy));
                    }
                }))
                .fetch(limit);
        return result;
    }
}