package com.example.auth.medecin;

import com.example.auth.user.Medecin;
import com.example.auth.user.MedecinRepository;
import com.fasterxml.jackson.databind.util.NativeImageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MedecinService {

    private final MedecinRepository repository;

    private final String FOLDER_PATH="C:/Users/hdebz/OneDrive/Bureau/images";

    public Medecin addDocotor(AddDoctorRequest request){
        var medecin = Medecin.builder()
                .name(request.getName())
                .adressse(request.getAdresse())
                .description(request.getDescription())
                .specialite(request.getSpecialite())
                .drImage(FOLDER_PATH+request.getImage())
                        .build();
        repository.save(medecin);

        return medecin;
    }

    public List<Medecin> getAllMedecin()
    {
        return (List<Medecin>)
                repository.findAll();
    }

    public Medecin getMedecinById(Integer id) {
        Optional<Medecin> optionalMedecin = repository.findById(id);
        return optionalMedecin.get();
    }

    public List<Medecin> SearchMedecin(String keyword){
        if (keyword != ""){
            return repository.search(keyword);
        }
        return (List<Medecin>)repository.findAll();
    }
}
