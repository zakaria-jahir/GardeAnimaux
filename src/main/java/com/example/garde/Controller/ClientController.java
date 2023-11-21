package com.example.garde.Controller;

import com.example.garde.Entity.Client;
import com.example.garde.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public Client addClient(@RequestBody Client c){
        return service.addClient(c);
    }
}
