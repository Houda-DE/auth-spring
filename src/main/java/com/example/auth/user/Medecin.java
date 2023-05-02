package com.example.auth.user;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "medecin")
public class Medecin{

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false , unique = true)
    private String name;

    @Column(nullable = false)
    private String adressse;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Specialite specialite;

    @Lob
    @Column(name = "drImage" , nullable = false)
    private String drImage;



}
