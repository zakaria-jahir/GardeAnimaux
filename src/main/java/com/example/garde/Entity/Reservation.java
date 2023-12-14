package com.example.garde.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomFacture;
    private String prenomFacture;
    private String mailFacture;
    private String adresseFacture;
    private String nomAnimal;
    private String typeAnimal;
    private Date dateDebut;
    private Date dateFin;
    private double total;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Client")
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Gardien")
    private Gardien gardien;

    public Reservation() {
    }

    public Reservation(int id, String nomFacture, String prenomFacture, String mailFacture, String adresseFacture, String nomAnimal, String typeAnimal, Date dateDebut, Date dateFin, double total, Client client, Gardien gardien) {
        this.id = id;
        this.nomFacture = nomFacture;
        this.prenomFacture = prenomFacture;
        this.mailFacture = mailFacture;
        this.adresseFacture = adresseFacture;
        this.nomAnimal = nomAnimal;
        this.typeAnimal = typeAnimal;
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

    public void setTotal() {
        if (dateDebut != null && dateFin != null && gardien != null) {
            long durationInMilliseconds = dateFin.getTime() - dateDebut.getTime();
            long days = TimeUnit.MILLISECONDS.toDays(durationInMilliseconds);
            double total = days * gardien.getPrixJour();
            this.total = total;
        }


    }

    public String getNomFacture() {
        return nomFacture;
    }

    public void setNomFacture(String nomFacture) {
        this.nomFacture = nomFacture;
    }

    public String getPrenomFacture() {
        return prenomFacture;
    }

    public void setPrenomFacture(String prenomFacture) {
        this.prenomFacture = prenomFacture;
    }

    public String getMailFacture() {
        return mailFacture;
    }

    public void setMailFacture(String mailFacture) {
        this.mailFacture = mailFacture;
    }

    public String getAdresseFacture() {
        return adresseFacture;
    }

    public void setAdresseFacture(String adresseFacture) {
        this.adresseFacture = adresseFacture;
    }

    public String getNomAnimal() {
        return nomAnimal;
    }

    public void setNomAnimal(String nomAnimal) {
        this.nomAnimal = nomAnimal;
    }

    public String getTypeAnimal() {
        return typeAnimal;
    }

    public void setTypeAnimal(String typeAnimal) {
        this.typeAnimal = typeAnimal;
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
                ", nomFacture='" + nomFacture + '\'' +
                ", prenomFacture='" + prenomFacture + '\'' +
                ", mailFacture='" + mailFacture + '\'' +
                ", adresseFacture='" + adresseFacture + '\'' +
                ", nomAnimal='" + nomAnimal + '\'' +
                ", typeAnimal='" + typeAnimal + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", total=" + total +
                ", client=" + client +
                ", gardien=" + gardien +
                '}';
    }
}
