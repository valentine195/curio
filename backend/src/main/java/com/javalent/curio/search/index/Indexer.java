package com.javalent.curio.search.index;

import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.massindexing.MassIndexer;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;


@Transactional
@Component
public class Indexer {

    private EntityManager entityManager;

    private static final int THREAD_NUMBER = 4;

    public Indexer(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void indexPersistedData(Class<?> clazz) throws IndexException {

        try {
            SearchSession searchSession = Search.session(entityManager);

            MassIndexer indexer = searchSession
                    .massIndexer(clazz)
                    .threadsToLoadObjects(THREAD_NUMBER);

            indexer.startAndWait();
        } catch (InterruptedException e) {
            throw new IndexException("Index Interrupted", e);
        }
    }
}