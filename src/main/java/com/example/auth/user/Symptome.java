package com.example.auth.user;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "symptome")
public class Symptome {


    @Id
    @Column(nullable = false)
    private String name;

    @ManyToMany
    @JoinTable( name = "maladie_symptome",
            joinColumns = @JoinColumn( name = "idSymptome" ),
            inverseJoinColumns = @JoinColumn( name = "idMaladie" ) )
    private List<Maladie> maladies = new ArrayList<>();

}
