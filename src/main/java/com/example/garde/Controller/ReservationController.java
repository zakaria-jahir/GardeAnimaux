package com.example.garde.Controller;



import com.example.garde.Entity.Reservation;
import com.example.garde.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
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
    public ResponseEntity<String> delete(@PathVariable int id){
        String result = service.deleteReservation(id);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/reservation/{id}")
    public Reservation getReservationById(@PathVariable int id){
        return service.getReservationById(id);
    }

    @GetMapping("/clientReservations/{clientId}")
    public List<Reservation> getClientReservations(@PathVariable int clientId) {
        return service.getClientReservations(clientId);
    }

    @GetMapping("/gardienReservations/{gardienId}")
    public List<Reservation> getgardienReservations(@PathVariable int gardienId) {
        return service.getgardienReservations(gardienId);
    }
}
