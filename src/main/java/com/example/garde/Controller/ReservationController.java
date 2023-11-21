package com.example.garde.Controller;


import com.example.garde.Entity.Reservation;
import com.example.garde.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservationController {
    @Autowired
    private Service service;

    @GetMapping("/reservations")
    public List<Reservation> getReservations(){
        return service.showReservations();
    }
}
