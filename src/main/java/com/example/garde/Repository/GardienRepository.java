package com.example.garde.Repository;

import com.example.garde.Entity.Gardien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GardienRepository extends JpaRepository<Gardien,Integer> {
}
