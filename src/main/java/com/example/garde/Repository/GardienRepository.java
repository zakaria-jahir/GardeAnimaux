package com.example.garde.Repository;

import com.example.garde.Entity.Gardien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GardienRepository extends JpaRepository<Gardien,Integer> {
    List<Gardien> findByNom(String nom);
    List<Gardien> findByTypeGardien(String type);
    List<Gardien> findByTypeAnimaux(String type);
    List<Gardien> findGardiensByPrixJourBetween(double minValue, double maxValue);
    Gardien findByMail(String mail);

}
