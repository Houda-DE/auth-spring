package com.example.auth.user;

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
@Table(name = "symptome")
public class Symptome {

    @GeneratedValue
    @Id
    private Integer id;

    @Column(nullable = false)
    private String name;

}
