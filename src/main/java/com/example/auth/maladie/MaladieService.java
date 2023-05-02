package com.example.auth.maladie;

import com.example.auth.medecin.AddDoctorResponse;
import com.example.auth.user.Maladie;
import com.example.auth.user.MaladieRepository;
import com.example.auth.user.MedecinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MaladieService {

    private final MaladieRepository repository;

    public AddMaladieResponse addMaladie(AddMaladieRequest request){

        var maladie = Maladie.builder()
                .name(request.getName())
                .details(request.getDetails())
                .symptomeList(request.getSymptomeList())
                .build();

        repository.save(maladie);

        return AddMaladieResponse.builder()
                .name(request.getName())
                .details(request.getDetails())
                .symptomeList(request.getSymptomeList())
                .build();
    }



}
