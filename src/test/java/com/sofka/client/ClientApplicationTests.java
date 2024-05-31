package com.sofka.client;

import com.sofka.client.model.Client;
import com.sofka.client.repository.ClientRepository;
import com.sofka.client.service.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class ClientApplicationTests {


	@Autowired
	private ClientService clientService;

	@MockBean
	private ClientRepository clientRepository;

	@Test
	void testGetAllClients() {
		Client client1 = new Client();
		client1.setUsername("jlema");
		Client client2 = new Client();
		client2.setUsername("mmontalvo");

		List<Client> expectedClients = Arrays.asList(client1, client2);
		when(clientRepository.findAll()).thenReturn(expectedClients);

		List<Client> actualClients = clientService.getAllClients();
		assertEquals(expectedClients, actualClients);
	}

}
