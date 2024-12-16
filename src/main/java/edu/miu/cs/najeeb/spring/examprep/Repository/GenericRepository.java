package edu.miu.cs.najeeb.spring.examprep.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class GenericRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Object obj){
        entityManager.persist(obj);
    }
}
