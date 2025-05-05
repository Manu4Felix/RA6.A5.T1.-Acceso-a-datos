package com.example.demo.presentation.dto;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    private Long numClie;
    private String empresa;
    private Long repClie;
    private Long limiteCredito;
}