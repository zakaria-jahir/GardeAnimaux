package com.example.garde.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date dateDebut;
    private Date dateFin;
    private double total;

    @ManyToOne
    @JoinColumn(name = "id_Client")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_Gardien")
    private Gardien gardien;

    public Reservation() {
    }

    public Reservation(int id, Date dateDebut, Date dateFin, double total, Client client, Gardien gardien) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.total = total;
        this.client = client;
        this.gardien = gardien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Gardien getGardien() {
        return gardien;
    }

    public void setGardien(Gardien gardien) {
        this.gardien = gardien;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", total=" + total +
                ", client=" + client +
                ", gardien=" + gardien +
                '}';
    }
}
