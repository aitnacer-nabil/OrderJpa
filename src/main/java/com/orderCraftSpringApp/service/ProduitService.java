package com.orderCraftSpringApp.service;

import com.orderCraftSpringApp.entities.Produit;
import com.orderCraftSpringApp.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProduitService {
    private final ProduitRepository produitRepository;

    @Autowired
    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    public Produit addProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    public Produit updateProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    public void deleteProduit(Long uuid) {
        produitRepository.deleteById(uuid);
    }

    public Produit getProduitById(Long uuid) {
        return produitRepository.findById(uuid).orElse(null);
    }

    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public List<Produit> getProduitsByCommande(Long commandeUUID) {
        return produitRepository.findProduitsByCommande(commandeUUID);
    }

    public void updateQteProduit(Produit produit) {
        produit.setQteStock(produit.getQteStock() - produit.getQteOrder());
        produit.setQteOrder(produit.getQteOrder() + produit.getQteOrder());
        produitRepository.save(produit);
    }
}
