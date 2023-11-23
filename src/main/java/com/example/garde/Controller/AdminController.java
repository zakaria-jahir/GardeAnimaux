package com.example.garde.Controller;

import com.example.garde.Entity.Admin;
import com.example.garde.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private Service service;

    @GetMapping("/admins")
    public List<Admin> getAdmins(){
        return service.showAdmins();
    }
    @PostMapping("/addAdmin")
    public Admin add(@RequestBody Admin admin){
        return service.addAdmin(admin);
    }
    @PutMapping("/updateAdmin")
    public Admin update(@RequestBody Admin admin){
        return service.updateAdmin(admin);
    }
    @DeleteMapping("/deleteAdmin/{id}")
    public String delete(@PathVariable int id){
        return service.deleteAdmin(id);
    }
    @GetMapping("/admin/{id}")
    public Admin getAdminById(@PathVariable int id){
        return service.getAdminById(id);
    }
    @GetMapping("/adminByNom/{nom}")
    public List<Admin> getByName(@PathVariable String nom){
        return service.getAdminByNom(nom);
    }
}
