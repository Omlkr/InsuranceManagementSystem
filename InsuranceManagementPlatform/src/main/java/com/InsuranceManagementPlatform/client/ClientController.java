package com.InsuranceManagementPlatform.client;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/clients")
public class ClientController {

	@Autowired
	private ClientService service;

	// Create Client Rest API
	@PostMapping
	public ResponseEntity<Client> createClient(@Valid @RequestBody Client client) {
		Client savedClient = service.createClient(client);
		return ResponseEntity.created(URI.create("api/clients/" + savedClient.getId())).body(savedClient);

	}

	// Get client by id REST API
	// http://localhost:8080/api/clients/1
	@GetMapping("{id}")
	public ResponseEntity<Client> getClientById(@PathVariable("id") Integer id) {
		Client client = service.getClientById(id);
		// return new ResponseEntity<Client>(client, HttpStatus.OK);
		if (client == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(client);
		}
	}

	// Get All clients REST API
	// http://localhost:8080/api/clients
	@GetMapping
	public ResponseEntity<List<Client>> getAllClients() {
		List<Client> client = service.getAllClients();
		return new ResponseEntity<>(client, HttpStatus.OK);
	}

	// Update Client REST API
	// http://localhost:8080/api/clients/1
	@PutMapping("{id}")
	public ResponseEntity<Client> updateClient(@PathVariable("id") Integer id, @Valid @RequestBody Client client) {
		client.setId(id);
		Client updateClient = service.updateClient(client);
		if (updateClient == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(updateClient);
	}

	// Delete Client REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteClient(@PathVariable("id") Integer id) {
		service.deleteClient(id);
		return new ResponseEntity<>("Client deleted successfully", HttpStatus.OK);

	}

}
