package com.example.demo.persistence.repository;

import com.example.demo.persistence.entity.ClienteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends CrudRepository<ClienteEntity, Long> {
}