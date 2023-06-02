package com.example.auth.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SymptomeRepository extends CrudRepository<Symptome , Integer> {

}
