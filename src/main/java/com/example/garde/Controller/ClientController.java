package com.example.garde.Controller;

import com.example.garde.Entity.Client;
import com.example.garde.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PutMapping("/updateClient")
    public Client update(@RequestBody Client client){
        return service.updateClient(client);
    }
    @DeleteMapping("/deleteClient/{id}")
    public String delete(@PathVariable int id){
        return service.deleteClinet(id);
    }
    @GetMapping("/client/{id}")
    public Client getClinetById(@PathVariable int id){
        return service.getClientById(id);
    }
}
