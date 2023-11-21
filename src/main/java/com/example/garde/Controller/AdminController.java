package com.example.garde.Controller;

import com.example.garde.Entity.Admin;
import com.example.garde.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private Service service;

    @GetMapping("/admins")
    public List<Admin> getAdmins(){
        return service.showAdmins();
    }
}
