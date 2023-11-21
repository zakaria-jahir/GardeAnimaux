package com.example.garde.Service;

import com.example.garde.Entity.Admin;
import com.example.garde.Entity.Client;
import com.example.garde.Entity.Gardien;
import com.example.garde.Entity.Reservation;
import com.example.garde.Repository.AdminRepository;
import com.example.garde.Repository.ClientRepository;
import com.example.garde.Repository.GardienRepository;
import com.example.garde.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private ClientRepository client;
    @Autowired
    private AdminRepository admin;
    @Autowired
    private GardienRepository gardien;
    @Autowired
    private ReservationRepository reservation;

    public List<Client> showClients(){
        return client.findAll();
    }
    public List<Admin> showAdmins(){
        return admin.findAll();
    }
    public List<Gardien> showGardiens(){
        return gardien.findAll();
    }
    public List<Reservation> showReservations(){
        return reservation.findAll();
    }
    public Client addClient(Client c){
        return client.save(c);
    }
    public Admin addAdmin(Admin a){
        return admin.save(a);
    }
    public Gardien addGardien(Gardien g){
        return gardien.save(g);
    }
    public Reservation reserver(Reservation r){
        return reservation.save(r);
    }

    public Client updateClient(Client c) {
        Client existing = client.findById(c.getId()).orElse(null);
        existing.setNom(c.getNom());
        existing.setPrenom(c.getPrenom());
        existing.setMail(c.getMail());
        existing.setTeleNum(c.getTeleNum());
        existing.setPassword(c.getPassword());

        return client.save(existing);
    }
    public Gardien updateGardien(Gardien g) {
        Gardien existing = gardien.findById(g.getId()).orElse(null);
        existing.setNom(g.getNom());
        existing.setPrenom(g.getPrenom());
        existing.setMail(g.getMail());
        existing.setTeleNum(g.getTeleNum());
        existing.setTypeGardien(g.getTypeGardien());
        existing.setTypeAnimaux(g.getTypeAnimaux());
        existing.setPassword(g.getPassword());

        return gardien.save(existing);
    }
    public Admin updateAdmin(Admin a) {
        Admin existing = admin.findById(a.getId()).orElse(null);
        existing.setNom(a.getNom());
        existing.setPrenom(a.getPrenom());
        existing.setMail(a.getMail());
        existing.setPassword(a.getPassword());
        return admin.save(existing);
    }
    public Reservation updateReservation(Reservation r) {
        Reservation existing = reservation.findById(r.getId()).orElse(null);
        existing.setDateDebut(r.getDateDebut());
        existing.setDateFin(r.getDateFin());
        existing.setTotal(r.getTotal());

        return reservation.save(existing);
    }

}
