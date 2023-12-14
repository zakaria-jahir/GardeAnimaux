package com.example.garde.Controller;

import com.example.garde.Entity.Client;
import com.example.garde.Entity.Gardien;
import com.example.garde.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ClientController {

    @Autowired
    private Service service;

    @GetMapping("/clients")
    public List<Client> getClients(){
        return service.showClients();
    }

    @PostMapping("/addClient")
    public Client add(@RequestBody Client client){
        return service.addClient(client);
    }
    @PutMapping(value = "/updateClient", consumes = "application/json")
    public ResponseEntity<Object> update(@RequestBody Client client){
        System.out.println("Received JSON: " + client);
        Client updatedClient = service.updateClient(client);
        if (updatedClient != null) {
            return ResponseEntity.ok(updatedClient);
        } else {
            // You can customize the error response as needed
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }
    }
    @DeleteMapping("/deleteClient/{id}")
    public String delete(@PathVariable int id){
        return service.deleteClinet(id);
    }
    @GetMapping("/client/{id}")
    public Client getClinetById(@PathVariable int id){
        return service.getClientById(id);
    }
    @GetMapping("/clientByNom/{nom}")
    public List<Client> getByName(@PathVariable String nom){
        return service.getClientByNom(nom);
    }

    @PostMapping("/client/login")
    public ResponseEntity<?> login(@RequestBody Client client) {
        Client authenticatedClient = service.auth(client);

        if (authenticatedClient != null) {
            // Return client details, including the id, upon successful login
            return ResponseEntity.ok(authenticatedClient);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"error\": \"Invalid credentials\"}");
    }

}
