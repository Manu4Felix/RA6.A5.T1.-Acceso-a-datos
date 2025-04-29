package com.example.demo.service.interfaces;

import com.example.demo.presentation.dto.ClienteDTO;

import java.util.List;

public interface IClienteService {
    List<ClienteDTO> findAll();
    ClienteDTO findById(Long id);
    ClienteDTO createCliente(ClienteDTO clienteDTO);
    ClienteDTO updateCliente(ClienteDTO clienteDTO, Long id);
    String deleteCliente(Long id);
}