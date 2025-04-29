package com.example.demo.persistence.dao.implementation;

import com.example.demo.persistence.entity.ClienteEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteDaoImpl {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    public List<ClienteEntity> findAll() {
        return this.em.createQuery("SELECT c FROM ClienteEntity c", ClienteEntity.class).getResultList();
    }

    @Transactional(readOnly = true)
    public Optional<ClienteEntity> findById(Long id) {
        return Optional.ofNullable(this.em.find(ClienteEntity.class, id));
    }

    @Transactional
    public ClienteEntity save(ClienteEntity entity) {
        if (entity.getNum_clie() == null) {
            this.em.persist(entity);
        } else {
            this.em.merge(entity);
        }
        return entity;
    }

    @Transactional
    public void delete(ClienteEntity entity) {
        this.em.remove(this.em.contains(entity) ? entity : this.em.merge(entity));
    }
}