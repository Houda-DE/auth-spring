package com.example.auth.maladie;

import com.example.auth.medecin.AddDoctorResponse;
import com.example.auth.user.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MaladieService {

    private final MaladieRepository repository;

    private final SymptomeRepository symptomeRepository;

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

    public AddSymptomeResponse addSymptome(AddSymptomeRequest request){

        var symptome = Symptome.builder()
                .name(request.getName())
                .build();
        symptomeRepository.save(symptome);
        return AddSymptomeResponse.builder()
                .name(request.getName())
                .build();

    }



}
