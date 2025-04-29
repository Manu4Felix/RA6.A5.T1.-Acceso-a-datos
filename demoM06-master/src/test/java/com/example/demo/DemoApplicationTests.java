package com.example.demo;

import com.example.demo.persistence.entity.ClienteEntity;
import com.example.demo.persistence.repository.IClienteRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
class ClienteRepositoryIntegrationTest {

	@Autowired
	private IClienteRepository clienteRepository;

	@Test
	void testSaveAndFindCliente() {
		ClienteEntity cliente = ClienteEntity.builder()
				.empresa("Empresa Test")
				.repClie("Representante Test")
				.limiteCredito(10000.0)
				.build();

		ClienteEntity savedCliente = clienteRepository.save(cliente);
		Optional<ClienteEntity> foundCliente = clienteRepository.findById(savedCliente.getNum_clie());

		assertTrue(foundCliente.isPresent());
		assertEquals("Empresa Test", foundCliente.get().getEmpresa());
	}
}