package com.orderCraftSpringApp.service;

import com.orderCraftSpringApp.dto.OrderDTO;
import com.orderCraftSpringApp.entities.*;
import com.orderCraftSpringApp.repository.CommandeProduitRepository;
import com.orderCraftSpringApp.repository.CommandeRepository;
import com.orderCraftSpringApp.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommandeService {
    @Autowired
    private ClientService clientService;

    @Autowired
    private ProduitService produitService;

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private CommandeProduitRepository commandeProduitRepository;

    @Autowired
    private ProduitRepository produitRepository;

    public List<Client> getClients() {
        return clientService.getAllClients();
    }

    public List<Produit> getAllProduits() {
        return produitService.getAllProduits();
    }

    public Commande addCommande(OrderDTO orderDTO) {
        List<Produit> produitsCommande = getProduitsListFromOrderDTO(orderDTO);
        float totalAmount = produitsCommande.stream().mapToInt(produit -> (int) (produit.getPrix() * produit.getPrix())).sum();
        Commande commande = new Commande(Timestamp.valueOf(LocalDateTime.now()),
                Timestamp.valueOf(LocalDateTime.now()),
                CommandeStatus.PREPARATION,
                totalAmount,
                null
        );
        commande.setClient(clientService.getClient(orderDTO.getClientId()));
//        commande.setProduitList(produitsCommande);
//        Commande savedCommande = commandeRepository.save(commande);
//
//        produitsCommande.forEach(produit -> {
//            produitService.updateQteProduit(produit);
//            CommandeProduit cp = new CommandeProduit();
//            cp.setCommandeUuid(savedCommande.getUuid());
//            cp.setProduitUuid(produit.getUuid());
//            cp.setAmount(produit.getAmount());
//            commandeProduitRepository.save(cp);
//        });

        return null;
    }

    public List<Commande> getAllCommandes() {
//        return commandeRepository.findAll().stream().map(commande -> {
//            commande.setClient(clientService.getClient(commande.getClientID()));
//            commande.setProduitList(produitService.getProduitsByCommande(commande.getUuid()));
//            return commande;
//        }).collect(Collectors.toList());
//
        return new ArrayList<>();
    }

    public Commande getCommandeById(Long uuid) {
        Commande commande = commandeRepository.findById(uuid).orElse(null);
//        if (commande != null) {
//            commande.setClient(clientService.getClient(commande.getClientID()));
//            commande.setProduitList(produitService.getProduitsByCommande(uuid));
//        }TODO
        return commande;
    }

    public boolean changeStatutCommande(Long commandeUUID, String status) {
        CommandeStatus commandeStatus = CommandeStatus.valueOf(status);
        Commande commande = commandeRepository.findById(commandeUUID).orElse(null);
        if (commande != null) {
            commande.setStatus(commandeStatus);
            commandeRepository.save(commande);
            return true;
        }
        return false;
    }

    public boolean deleteCommande(Long uuid) {
        if (commandeRepository.existsById(uuid)) {
            commandeRepository.deleteById(uuid);
            return true;
        }
        return false;
    }

    private List<Produit> getProduitsListFromOrderDTO(OrderDTO orderDTO) {
        List<Produit> list = new ArrayList<>();
//        orderDTO.getListProduits().forEach(produitDTO -> {
//            list.add(getAllProduits().stream().
//                    filter(produit -> produit.getUuid().equals(produitDTO.getUuid()))
//                    .findFirst()
//                    .map(
//                            produitMap -> {
//                                produitMap.setAmount(produitDTO.getProduitAmount());
//                                produitMap.setQte_order(produitDTO.getQteOrder());
//
//                                return produitMap;
//                            }
//                    ).get());
//        }); TODO

        return list;
    }
}