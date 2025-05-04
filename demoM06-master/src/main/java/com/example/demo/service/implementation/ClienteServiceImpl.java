package com.example.demo.service.implementation;

import com.example.demo.persistence.dao.interfaces.IClienteDAO;
import com.example.demo.persistence.entity.ClienteEntity;
import com.example.demo.presentation.dto.ClienteDTO;
import com.example.demo.service.interfaces.IClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteDAO clienteDAO;

    @Override
    public ClienteDTO updateCliente(ClienteDTO clienteDTO, Long id) {
        Optional<ClienteEntity> clienteEntity = this.clienteDAO.findById(id);

        if (clienteEntity.isPresent()) {
            ClienteEntity currentClienteEntity = clienteEntity.get();
            currentClienteEntity.setEmpresa(clienteDTO.getEmpresa());
            currentClienteEntity.setRepClie(clienteDTO.getRepClie());
            currentClienteEntity.setLimiteCredito(clienteDTO.getLimiteCredito());

            this.clienteDAO.save(currentClienteEntity);

            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(currentClienteEntity, ClienteDTO.class);
        } else {
            throw new IllegalArgumentException("El cliente no existe");
        }
    }

    @Override
    public List<ClienteDTO> findAll() {
        ModelMapper modelMapper = new ModelMapper();

        return this.clienteDAO.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, ClienteDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ClienteDTO findById(Long id) {
        Optional<ClienteEntity> clienteEntity = this.clienteDAO.findById(id);

        if (clienteEntity.isPresent()) {
            ModelMapper modelMapper = new ModelMapper();
            ClienteEntity currentCliente = clienteEntity.get();
            return modelMapper.map(currentCliente, ClienteDTO.class);
        } else {
            return new ClienteDTO();
        }
    }

    @Override
    public ClienteDTO createCliente(ClienteDTO clienteDTO) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            ClienteEntity clienteEntity = modelMapper.map(clienteDTO, ClienteEntity.class);
            this.clienteDAO.save(clienteEntity);
            return clienteDTO;
        } catch (Exception e) {
            throw new UnsupportedOperationException("Error al guardar el cliente");
        }
    }

    @Override
    public String deleteCliente(Long id) {
        Optional<ClienteEntity> clienteEntity = this.clienteDAO.findById(id);

        if (clienteEntity.isPresent()) {
            ClienteEntity currentClienteEntity = clienteEntity.get();
            this.clienteDAO.delete(currentClienteEntity);
            return "Cliente con ID " + id + " ha sido eliminado.";
        } else {
            return "El cliente con ID " + id + " no existe.";
        }
    }
}