package com.javalent.curio.search;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface SearchRepository<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {

    List<T> searchBy(String text, int limit, String... fields);

    List<T> searchBy(List<SearchPredicate> predicates, String text, int limit);
}