package com.orderCraftSpringApp.entities;


import javax.persistence.*;

@Entity
@Table(name = "produit")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produit_uuid")
    private Long uuid ;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "prix")
    private float prix;

    @Column(name = "qte_stock")
    private int qteStock;

    @Column(name = "qte_order")
    private int qteOrder;

    public Produit() {
    }

    public Produit(String name, String description, float prix, int qteStock, int qteOrder) {
        this.name = name;
        this.description = description;
        this.prix = prix;
        this.qteStock = qteStock;
        this.qteOrder = qteOrder;
    }

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getQteStock() {
        return qteStock;
    }

    public void setQteStock(int qteStock) {
        this.qteStock = qteStock;
    }

    public int getQteOrder() {
        return qteOrder;
    }

    public void setQteOrder(int qteOrder) {
        this.qteOrder = qteOrder;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                ", qteStock=" + qteStock +
                ", qteOrder=" + qteOrder +
                '}';
    }
}
