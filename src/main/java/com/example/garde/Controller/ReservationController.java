package com.example.garde.Controller;



import com.example.garde.Entity.Reservation;
import com.example.garde.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {
    @Autowired
    private Service service;

    @GetMapping("/reservations")
    public List<Reservation> getReservations(){
        return service.showReservations();
    }
    @PostMapping("/reserver")
    public Reservation reserver(@RequestBody Reservation reservation){
        return service.reserver(reservation);
    }
    @PutMapping("/updateReservation")
    public Reservation update(@RequestBody Reservation reservation){
        return service.updateReservation(reservation);
    }
    @DeleteMapping("/deleteReservation/{id}")
    public String delete(@PathVariable int id){
        return service.deleteReservation(id);
    }
}
