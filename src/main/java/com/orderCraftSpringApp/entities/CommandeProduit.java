package com.orderCraftSpringApp.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "commande_produit")
@IdClass(CommandeProduitId.class)
public class CommandeProduit {

    @Id
    @Column(name = "commande_uuid")
    private String commandeUuid;

    @Id
    @Column(name = "produit_uuid")
    private String produitUuid;

    @Column(name = "amount")
    private int amount;

    @ManyToOne
    @JoinColumn(name = "commande_uuid", insertable = false, updatable = false)
    private Commande commande;

    @ManyToOne
    @JoinColumn(name = "produit_uuid", insertable = false, updatable = false)
    private Produit produit;

    // getters and setters

    public CommandeProduit() {
    }

    public CommandeProduit(String commandeUuid, String produitUuid, int amount, Commande commande, Produit produit) {
        this.commandeUuid = commandeUuid;
        this.produitUuid = produitUuid;
        this.amount = amount;
        this.commande = commande;
        this.produit = produit;
    }

    public String getCommandeUuid() {
        return commandeUuid;
    }

    public void setCommandeUuid(String commandeUuid) {
        this.commandeUuid = commandeUuid;
    }

    public String getProduitUuid() {
        return produitUuid;
    }

    public void setProduitUuid(String produitUuid) {
        this.produitUuid = produitUuid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public String toString() {
        return "CommandeProduit{" +
                "commandeUuid='" + commandeUuid + '\'' +
                ", produitUuid='" + produitUuid + '\'' +
                ", amount=" + amount +
                ", commande=" + commande +
                ", produit=" + produit +
                '}';
    }
}

