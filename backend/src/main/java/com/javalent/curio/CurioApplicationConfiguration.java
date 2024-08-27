package com.javalent.curio;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.javalent.curio.repository.search.SearchRepositoryImpl;

@Configuration
@EnableJpaRepositories(repositoryBaseClass = SearchRepositoryImpl.class)
public class CurioApplicationConfiguration {


}
