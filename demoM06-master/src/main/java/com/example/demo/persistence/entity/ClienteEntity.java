package com.example.demo.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clientes")
public class ClienteEntity {
    @Id
    private Long num_clie;
    private String empresa;
    @Column(name = "rep_clie")
    private Long repClie;
    @Column(name = "limite_credito")
    private Long limiteCredito;
}