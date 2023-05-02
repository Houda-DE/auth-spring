package com.example.auth.medecin;

import com.example.auth.user.Specialite;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddDoctorRequest {

    private String name;

    private String description;

    private Specialite specialite;

    private String adresse;

    private String image;

}
