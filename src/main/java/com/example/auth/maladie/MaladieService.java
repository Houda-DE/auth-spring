package com.example.auth.maladie;

import com.example.auth.medecin.AddDoctorResponse;
import com.example.auth.user.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

@Service
@RequiredArgsConstructor
public class MaladieService {

    private final MaladieRepository repository;

    private final SymptomeRepository symptomeRepository;

    public AddMaladieResponse addMaladie(AddMaladieRequest request){
        var maladie = Maladie.builder()
                .name(request.getName())
                .details(request.getDetails())
                .symptomes(request.getSymptomes())
                .build();


        repository.save(maladie);


        return AddMaladieResponse.builder()
                .name(request.getName())
                .details(request.getDetails())
                .build();
    }

    public List<Maladie> allMaladies(){
        return (List<Maladie>) repository.findAll();
    }

    public Maladie getMaladieById(Integer id) {
        Optional<Maladie> optionalMaladie = repository.findById(id);
        return optionalMaladie.get();
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

    public List<Symptome> getAllSymptomes(){
        return (List<Symptome>) symptomeRepository.findAll();
    }

    public Symptome getSymptomeById(Integer id){
        Optional<Symptome> optionalSymptome = symptomeRepository.findById(id);
        return optionalSymptome.get();
    }

}
