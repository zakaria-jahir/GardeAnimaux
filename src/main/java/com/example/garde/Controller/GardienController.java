package com.example.garde.Controller;


import com.example.garde.Entity.Gardien;
import com.example.garde.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GardienController {
    @Autowired
    private Service service;

    @GetMapping("/gardines")
    public List<Gardien> getGardiens(){
        return service.showGardiens();
    }
}
