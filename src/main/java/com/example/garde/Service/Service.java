package com.example.garde.Service;

import com.example.garde.Entity.*;
import com.example.garde.Repository.AdminRepository;
import com.example.garde.Repository.ClientRepository;
import com.example.garde.Repository.GardienRepository;
import com.example.garde.Repository.ReservationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    private final Logger log = LoggerFactory.getLogger(Service.class);

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

    @Transactional
    public Reservation reserver(Reservation r){
        try {
            log.info("Reserving: " + r.toString());
            // Ensure that the Client and Gardien associations are set
            if (r.getClient() == null || r.getGardien() == null) {
                log.error("Client or Gardien is null in the Reservation entity.");
                // You can throw an exception or return an error response
                return null;
            }
            r.setTotal();
            Reservation savedReservation = reservation.save(r);

            // Fetch associated Client and Gardien manually
            Client fetchedClient = client.findById(savedReservation.getClient().getId()).orElse(null);
            Gardien fetchedGardien = gardien.findById(savedReservation.getGardien().getId()).orElse(null);

            // Check if the fetched Client and Gardien are not null before setting them back
            if (fetchedClient != null) {
                savedReservation.setClient(fetchedClient);
            } else {
                log.error("Client not found for the reservation with ID: " + savedReservation.getId());
                // Handle the case where the associated Client is not found
                // You can throw an exception or return an error response
                return null;
            }

            if (fetchedGardien != null) {
                savedReservation.setGardien(fetchedGardien);
            } else {
                log.error("Gardien not found for the reservation with ID: " + savedReservation.getId());
                // Handle the case where the associated Gardien is not found
                // You can throw an exception or return an error response
                return null;
            }

            return savedReservation;
        } catch (Exception e) {
            // Log the exception
            log.error("Error occurred during reservation", e);
            // You can throw an exception or return an error response
            return null;
        }

    }


    @Transactional
    public Client updateClient(Client c) {
        Client existing = client.findById(c.getId()).orElse(null);
        if (existing == null) {
            // You can throw an exception or return null as needed
            return null;
        }

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
        existing.setNomFacture(r.getNomFacture());
        existing.setPrenomFacture(r.getPrenomFacture());
        existing.setMailFacture(r.getMailFacture());
        existing.setAdresseFacture(r.getAdresseFacture());
        existing.setNomAnimal(r.getNomAnimal());
        existing.setTypeAnimal(r.getTypeAnimal());
        existing.setDateDebut(r.getDateDebut());
        existing.setDateFin(r.getDateFin());
        existing.setTotal();

        return reservation.save(existing);
    }
    public String deleteClinet(int id){
        client.deleteById(id);
        return "client removed !!"+id;
    }
    public String deleteAdmin(int id){
        admin.deleteById(id);
        return "admin removed !!"+id;
    }
    public String deleteGardien(int id){
        gardien.deleteById(id);
        return "gardien removed !!"+id;
    }
    public String deleteReservation(int id){
        reservation.deleteById(id);
        return "reservation removed !!"+id;
    }
    public Client getClientById(int id){
        return client.findById(id).get();
    }
    public Gardien getGardienById(int id){
        return gardien.findById(id).get();
    }
    public Admin getAdminById(int id){
        return admin.findById(id).get();
    }
    public Reservation getReservationById(int id){
        return reservation.findById(id).get();
    }

    public List<Client> getClientByNom(String nom){
        System.out.println("Searching for clients with nom: " + nom);
        List<Client> clients = client.findByNom(nom);
        System.out.println("Found " + clients.size() + " clients with nom: " + nom);
        return clients;
    }
    public List<Admin> getAdminByNom(String nom){
        System.out.println("searching for admins whith nom: "+nom);
        List<Admin> admins=admin.findByNom(nom);
        System.out.println("Found" + admins.size() + "admins with nom "+nom);
        return admins;
    }

    public List<Gardien> getGardienByNom(String nom){
        System.out.println("searching for gardiens whith nom: "+nom);
        List<Gardien> gardiens=gardien.findByNom(nom);
        System.out.println("Found" + gardiens.size() + " gardien with nom "+nom);
        return gardiens;
    }
    public List<Gardien> getGardienByTypeGardien(String type){
        System.out.println("searching for gardiens whith type gardien: "+type);
        List<Gardien> gardiens=gardien.findByTypeGardien(type);
        System.out.println("Found" + gardiens.size() + " gardien with type "+type);
        return gardiens;
    }
    public List<Gardien> getGardienByTypeAnimaux(String type){
        System.out.println("searching for gardiens whith type animaux: "+type);
        List<Gardien> gardiens=gardien.findByTypeAnimaux(type);
        System.out.println("Found" + gardiens.size() + " gardien with type "+type);
        return gardiens;
    }
    public List<Gardien> getGardiensByPriceRange(double minValue,double maxValue) {
        System.out.println("Searching for gardiens with price between "+minValue+" and "+maxValue);
        List<Gardien> gardiens=gardien.findGardiensByPrixJourBetween(minValue,maxValue);
        System.out.println("Found" + gardiens.size());
        return gardiens;
    }
    public Admin findAdminByMail(String mail) {
        return admin.findByMail(mail);
    }
    public Client findClientByMail(String mail) {
        return client.findByMail(mail);
    }
    public Gardien findGardienByMail(String mail) {
        return gardien.findByMail(mail);
    }


//    public <T> T log(T user) {
//        try {
//            System.out.println("Processing user: " + user);
//
//            if (user instanceof Client) {
//                System.out.println("User is an instance of Client");
//                Client client1 = (Client) user;
//                Client clientDao = client.findByMail(client1.getMail());
//                System.out.println("Client found: " + clientDao);
//
//                if (clientDao != null && clientDao.getPassword().equals(client1.getPassword())) {
//                    System.out.println("Client login successful");
//                    return (T) clientDao;
//                }
//            } else if (user instanceof Admin) {
//                System.out.println("User is an instance of Admin");
//                Admin admin1 = (Admin) user;
//                Admin adminDao = admin.findByMail(admin1.getMail());
//                System.out.println("Admin found: " + adminDao);
//
//                if (adminDao != null && adminDao.getPassword().equals(admin1.getPassword())) {
//                    System.out.println("Admin login successful");
//                    return (T) adminDao;
//                }
//            } else if (user instanceof Gardien) {
//                System.out.println("User is an instance of Gardien");
//                Gardien gardien1 = (Gardien) user;
//                Gardien gardienDao = gardien.findByMail(gardien1.getMail());
//                System.out.println("Gardien found: " + gardienDao);
//
//                if (gardienDao != null && gardienDao.getPassword().equals(gardien1.getPassword())) {
//                    System.out.println("Gardien login successful");
//                    return (T) gardienDao;
//                }
//            }
//        } catch (Exception e) {
//            System.out.println("Exception: " + e.getMessage());
//            e.printStackTrace();  // Print the full stack trace for debugging
//        }
//
//        System.out.println("Invalid credentials");
//
//        return null;
//    }


    public Client auth(Client c){
        Client clientDao = client.findByMail(c.getMail());
        try {
            if(clientDao != null && clientDao.getPassword().equals(c.getPassword())){
                System.out.println(clientDao);
                return clientDao;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Admin auth(Admin a){
        Admin adminDao = admin.findByMail(a.getMail());
        try {
            if(adminDao !=null && adminDao.getPassword().equals(a.getPassword())){
                System.out.println(adminDao);
                return adminDao;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public Gardien auth(Gardien g){
        Gardien gardienDao = gardien.findByMail(g.getMail());
        try {
            if(gardienDao !=null && gardienDao.getPassword().equals(g.getPassword())){
                System.out.println(gardienDao);
                return gardienDao;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public List<Reservation> getClientReservations(int clientId) {
        return reservation.findByClientId(clientId);
    }

    public List<Reservation> getgardienReservations(int gardienId) {
        return reservation.findByGardienId(gardienId);
    }


}
