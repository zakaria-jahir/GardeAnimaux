package com.example.garde.Repository;

import com.example.garde.Entity.Reservation;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {
    @EntityGraph(attributePaths = {"client", "gardien"})
    Optional<Reservation> findById(Long id);

    List<Reservation> findByClientId(int clientId);
    List<Reservation> findByGardienId(int gardienId);
}
