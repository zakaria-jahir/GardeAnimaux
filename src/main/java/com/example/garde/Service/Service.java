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
}
