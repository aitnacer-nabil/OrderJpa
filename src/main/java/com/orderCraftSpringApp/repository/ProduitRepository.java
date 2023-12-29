package com.orderCraftSpringApp.repository;

import com.orderCraftSpringApp.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitRepository  extends JpaRepository<Produit, Long> {
    @Query("SELECT p FROM Produit p WHERE p.qteOrder > 0")
    List<Produit> findProduitsByCommande(@Param("commandeUUID") Long commandeUUID);
}
