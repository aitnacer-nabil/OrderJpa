package com.orderCraftSpringApp.entities;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "commande")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commande_uuid")
    private Long uuid;
    @Column(name = "date_ajoute")
    private Timestamp dateAjoute;

    @Column(name = "date_update")
    private Timestamp dateUpdate;

    @Column(name = "commande_status")
    @Enumerated(EnumType.STRING)
    private CommandeStatus status;

    @Column(name = "commande_total")
    private float total;

    @ManyToOne
    @JoinColumn(name = "client_uuid")
    private Client client;


    public Commande(Timestamp dateAjoute, Timestamp dateUpdate, CommandeStatus status, float total, Client client) {
        this.dateAjoute = dateAjoute;
        this.dateUpdate = dateUpdate;
        this.status = status;
        this.total = total;
        this.client = client;
    }

    public Commande() {

    }

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public Timestamp getDateAjoute() {
        return dateAjoute;
    }

    public void setDateAjoute(Timestamp dateAjoute) {
        this.dateAjoute = dateAjoute;
    }

    public Timestamp getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Timestamp dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public CommandeStatus getStatus() {
        return status;
    }

    public void setStatus(CommandeStatus status) {
        this.status = status;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "uuid=" + uuid +
                ", dateAjoute=" + dateAjoute +
                ", dateUpdate=" + dateUpdate +
                ", status=" + status +
                ", total=" + total +
                ", client=" + client +
                '}';
    }
}
