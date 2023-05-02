package com.example.auth.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MedecinRepository extends CrudRepository<Medecin , Integer> {

}
