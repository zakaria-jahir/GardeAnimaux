package com.example.garde.Repository;

import com.example.garde.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    List<Admin> findByNom(String nom);
    Admin findByMail(String mail);
}
