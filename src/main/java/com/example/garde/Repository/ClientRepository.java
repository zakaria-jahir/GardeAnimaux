package com.example.garde.Repository;

import com.example.garde.Entity.Client;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    @Query(value = "SELECT * FROM client WHERE nom = :nom", nativeQuery = true)
    List<Client> findByNom(@Param("nom") String nom);

    Client findByMail(String mail);


}
