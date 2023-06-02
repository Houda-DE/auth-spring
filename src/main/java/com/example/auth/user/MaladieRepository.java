package com.example.auth.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MaladieRepository extends CrudRepository<Maladie , Integer> {
    @Query("SELECT m FROM Maladie m JOIN m.symptomes s WHERE s.name LIKE CONCAT('%', ?1, '%')"
            + " OR m.name LIKE CONCAT('%', ?1, '%')"
            + " OR m.details LIKE CONCAT('%', ?1, '%')")
    List<Maladie> search(String keyword);


}
