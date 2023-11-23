package com.example.garde.Repository;

import com.example.garde.Entity.Gardien;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GardienRepository extends JpaRepository<Gardien,Integer> {
    List<Gardien> findByNom(String nom);

    List<Gardien> findByTypeGardien(String type);

    List<Gardien> findByTypeAnimaux(String type);
}
