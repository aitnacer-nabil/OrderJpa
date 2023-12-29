package com.orderCraftSpringApp.service;

import com.orderCraftSpringApp.entities.Client;
import com.orderCraftSpringApp.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
  //  private static final Logger logger = LogManager.getLogger();

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client addClient(Client client) {
  //      logger.info("Adding new client");
        return clientRepository.save(client);
    }

    public Client updateClient(Long uuid, Client client) {
     //   logger.info("Updating client");
        Optional<Client> existingClient = clientRepository.findById(uuid);
        if (existingClient.isPresent()) {
            Client updatedClient = existingClient.get();
            updatedClient.setName(client.getName());
            updatedClient.setEmail(client.getEmail());
            updatedClient.setPhone(client.getPhone());
            updatedClient.setAdress(client.getAdress());
            return clientRepository.save(updatedClient);
        }
        return null;
    }

    public void deleteClient(Long uuid) {
      //  logger.info("Deleting client");
        clientRepository.deleteById(uuid);
    }

    public Client getClient(Long uuid) {
      //  logger.info("Fetching client");
        return clientRepository.findById(uuid).orElse(null);
    }

    public List<Client> getAllClients() {
      //  logger.info("Fetching all clients");
        return clientRepository.findAll();
    }
}