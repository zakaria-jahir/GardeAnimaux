package com.example.garde.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Gardien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private String teleNum;
    private String mail;
    private String typeGardien; //veterinaire ou specialiste en garde animaux
    private String typeAnimaux; // chat ou chien ou les deux
    private double prixJour;
    private String password;

    @ManyToMany
    @JoinTable(name = "Client_Gardien",
            joinColumns = @JoinColumn(name = "id_Client"),
            inverseJoinColumns = @JoinColumn(name = "id_Gardien"))
    private List<Client> clients = new ArrayList<>();

    public Gardien() {
    }

    public Gardien(int id, String nom, String prenom, String teleNum, String mail, String typeGardien, String typeAnimaux, String password) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.teleNum = teleNum;
        this.mail = mail;
        this.typeGardien = typeGardien;
        this.typeAnimaux = typeAnimaux;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTeleNum() {
        return teleNum;
    }

    public void setTeleNum(String teleNum) {
        this.teleNum = teleNum;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTypeGardien() {
        return typeGardien;
    }

    public void setTypeGardien(String typeGardien) {
        this.typeGardien = typeGardien;
    }

    public String getTypeAnimaux() {
        return typeAnimaux;
    }

    public void setTypeAnimaux(String typeAnimaux) {
        this.typeAnimaux = typeAnimaux;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getPrixJour() {
        return prixJour;
    }

    public void setPrixJour(double prixJour) {
        this.prixJour = prixJour;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Gardien{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", teleNum='" + teleNum + '\'' +
                ", mail='" + mail + '\'' +
                ", typeGardien='" + typeGardien + '\'' +
                ", typeAnimaux='" + typeAnimaux + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
