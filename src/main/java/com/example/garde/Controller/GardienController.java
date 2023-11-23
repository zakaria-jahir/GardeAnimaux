package com.example.garde.Controller;


import com.example.garde.Entity.Gardien;
import com.example.garde.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GardienController {
    @Autowired
    private Service service;

    @GetMapping("/gardiens")
    public List<Gardien> getGardiens(){
        return service.showGardiens();
    }
    @PostMapping("/addGardien")
    public Gardien add(@RequestBody Gardien gardien){
        return service.addGardien(gardien);
    }
    @PutMapping("/updateGardien")
    public Gardien update(@RequestBody Gardien gardien){
        return service.updateGardien(gardien);
    }
    @DeleteMapping("/deleteGardien/{id}")
    public String delete(@PathVariable int id){
        return service.deleteGardien(id);
    }
    @GetMapping("/gardien/{id}")
    public Gardien getGardienById(@PathVariable int id){
        return service.getGardienById(id);
    }
    @GetMapping("/gardienByNom/{nom}")
    public List<Gardien> getByNom(@PathVariable String nom){
        return service.getGardienByNom(nom);
    }
    @GetMapping("/gardienByTypeGardien/{type}")
    public List<Gardien> getByTypeGardien(@PathVariable String type){
        return service.getGardienByTypeGardien(type);
    }
}
