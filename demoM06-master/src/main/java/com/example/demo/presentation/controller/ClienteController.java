package com.example.demo.presentation.controller;

import com.example.demo.presentation.dto.ClienteDTO;
import com.example.demo.service.interfaces.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping
    public List<ClienteDTO> getAllClientes() {
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public ClienteDTO getClienteById(@PathVariable Long id) {
        return clienteService.findById(id);
    }

    @PostMapping
    public ClienteDTO createCliente(@RequestBody ClienteDTO clienteDTO) {
        return clienteService.createCliente(clienteDTO);
    }

    @PutMapping("/{id}")
    public ClienteDTO updateCliente(@RequestBody ClienteDTO clienteDTO, @PathVariable Long id) {
        return clienteService.updateCliente(clienteDTO, id);
    }

    @DeleteMapping("/{id}")
    public String deleteCliente(@PathVariable Long id) {
        return clienteService.deleteCliente(id);
    }
}