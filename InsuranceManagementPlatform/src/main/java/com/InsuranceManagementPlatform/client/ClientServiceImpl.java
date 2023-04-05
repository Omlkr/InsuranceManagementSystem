package com.InsuranceManagementPlatform.client;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository repo;

	@Override
	public Client createClient(Client client) {
		return repo.save(client);
	}

	@Override
	public Client getClientById(Integer id) {
		Optional<Client> optinalClient = repo.findById(id);
		return optinalClient.get();
	}

	@Override
	public List<Client> getAllClients() {
		return repo.findAll();
	}

	@Override
	public Client updateClient(Client client) {
		Client existClient = repo.findById(client.getId()).get();
		existClient.setName(client.getName());
		existClient.setDob(client.getDob());
		existClient.setAddress(client.getAddress());
		existClient.setContact(client.getContact());
		return repo.save(existClient);

	}

	@Override
	public void deleteClient(Integer id) {
		repo.deleteById(id);
	}

}
