package com.example.auth.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Maladie {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false , unique = true)
    private String name;

    @Column(nullable = false)
    private String details;

    @ManyToMany
    @JoinTable( name = "maladie_symptome",
            joinColumns = @JoinColumn( name = "idMaladie" ),
            inverseJoinColumns = @JoinColumn( name = "idSymptome" ) )
    private List<Symptome> symptomes = new ArrayList<>();

}
