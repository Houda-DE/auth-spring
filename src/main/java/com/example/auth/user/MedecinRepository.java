package com.example.auth.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MedecinRepository extends JpaRepository<Medecin , Integer> {
    @Query("SELECT m FROM Medecin m WHERE m.name LIKE %?1%"
                      + " OR m.adressse LIKE %?1%")
    public List<Medecin> search(String keyword);
}
