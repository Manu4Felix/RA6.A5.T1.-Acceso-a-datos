package com.example.demo.presentation.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    private Long numClie;
    private String empresa;
    private String repClie;
    private Double limiteCredito;
}