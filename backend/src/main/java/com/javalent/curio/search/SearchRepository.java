package com.javalent.curio.search;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.javalent.curio.features.items.models.ItemSearchDTO;
import com.javalent.curio.search.models.SearchPredicate;

@NoRepositoryBean
public interface SearchRepository<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {

    List<T> searchBy(String text, int limit, String... fields);

    List<T> searchBy(List<SearchPredicate> predicates, ItemSearchDTO search, int limit);
}