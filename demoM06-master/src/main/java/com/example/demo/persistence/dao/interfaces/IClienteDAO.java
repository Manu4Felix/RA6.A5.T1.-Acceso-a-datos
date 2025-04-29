package com.example.demo.persistence.dao.interfaces;

import com.example.demo.persistence.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteDAO extends JpaRepository<ClienteEntity, Long> {
}