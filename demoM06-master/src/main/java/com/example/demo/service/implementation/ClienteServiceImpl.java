import com.example.demo.persistence.entity.ClienteEntity;
import com.example.demo.presentation.dto.ClienteDTO;
import org.modelmapper.ModelMapper;

import java.util.Optional;

//@Override
//public ClienteDTO updateCliente(ClienteDTO clienteDTO, Long id) {
//   // Optional<ClienteEntity> clienteEntity = this.userDAO.findById(id);
//
//    if (clienteEntity.isPresent()) {
//        ClienteEntity currentClienteEntity = clienteEntity.get();
//        currentClienteEntity.setEmpresa(clienteDTO.getEmpresa());
//        currentClienteEntity.setRepClie(clienteDTO.getRepClie());
//        currentClienteEntity.setLimiteCredito(clienteDTO.getLimiteCredito());
//
//        this.userDAO.save(currentClienteEntity);
//
//        ModelMapper modelMapper = new ModelMapper();
//        return modelMapper.map(currentClienteEntity, ClienteDTO.class);
//    } else {
//        throw new IllegalArgumentException("El cliente no existe");
//    }
//}