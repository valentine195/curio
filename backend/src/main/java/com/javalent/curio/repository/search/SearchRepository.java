package com.javalent.curio.repository.search;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.javalent.curio.repository.items.SearchPredicate;

@NoRepositoryBean
public interface SearchRepository<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {

    List<T> searchBy(String text, int limit, String... fields);

    List<T> searchBy(List<SearchPredicate> predicates, String text, int limit);
}