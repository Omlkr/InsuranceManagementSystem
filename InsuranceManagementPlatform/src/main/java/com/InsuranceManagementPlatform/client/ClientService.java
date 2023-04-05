package com.InsuranceManagementPlatform.client;

import java.util.List;

public interface ClientService {

//	@Autowired
//	private ClientRepository repo;
//
//	public List<Client> listAll() {
//		return repo.findAll();
//	}
//
//	public Client get(Integer id) {
//		return repo.findById(id).get();
//	}
//	
//	public void save(Client client) {
//		 repo.save(client);
//	}
//	
////	public Client updateClient(Integer id, Client client) {
////		Optional<Client> optionalClient = repo.findById(id);
////		
////		if(optionalClient.isPresent()) {
////			Client existClient = optionalClient.get();
////			existClient.setName(client.getName());
////			existClient.setDob(client.getDob());
////			existClient.setAddress(client.getAddress());
////			existClient.setContact(client.getContact());
////			return repo.save(existClient);
////			
////		}else {
////			System.out.println("Client not fond");
////		}
////	}
//	
////	public Client UpdateClient(Integer id, Client client)  {
////	
////		Optional<Client> existClient = repo.findById(id);
////		if(optionalClient.isPresent()) {
////			Client existClient = optionalClient.get();
////			existClient.setName(client.getName());
////			existClient.setDob(client.getDob());
////			existClient.setAddress(client.getAddress());
////			existClient.setContact(client.getContact());
////			return repo.save(existClient);
////			
////
////		}
//	
//	public Client updateClien(Integer id,Client client) {
//		 repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Client","id",id));
//	}
//	
//	public void delete(Integer id) {
//		repo.deleteById(id);
//	}
	
	Client createClient(Client client);		
	Client getClientById(Integer id);
	List<Client> getAllClients();
	Client updateClient(Client client);
	void deleteClient(Integer id);

}