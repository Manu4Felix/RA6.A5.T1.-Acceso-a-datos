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
        // Implement other methods as needed
        return null;
    }

    @Override
    public ClienteDTO findById(Long id) {
        // Implement other methods as needed
        return null;
    }

    @Override
    public ClienteDTO createCliente(ClienteDTO clienteDTO) {
        // Implement other methods as needed
        return null;
    }

    @Override
    public String deleteCliente(Long id) {
        // Implement other methods as needed
        return null;
    }
}