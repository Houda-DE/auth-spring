package com.example.auth.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Lob
    @Column(name = "drImage" , nullable = false)
    private String drImage;

    @ManyToMany
    @JoinTable( name = "maladie_symptome",
            joinColumns = @JoinColumn( name = "id_Maladie" ),
            inverseJoinColumns = @JoinColumn( name = "id_Symptome" ) )
    private Set<Symptome> symptomes = new HashSet<Symptome>();

}
