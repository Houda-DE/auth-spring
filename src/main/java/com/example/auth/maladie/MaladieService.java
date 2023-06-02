package com.example.auth.maladie;

import com.example.auth.user.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MaladieService {

    private final MaladieRepository repository;

    private final SymptomeRepository symptomeRepository;

    public Maladie addMaladie(AddMaladieRequest request){
        var maladie = Maladie.builder()
                .name(request.getName())
                .details(request.getDetails())
                .symptomes(request.getSymptomes())
                .build();

        for (Symptome symptome : request.getSymptomes()) {
            if (!symptomeRepository.findById(symptome.getName()).isPresent()){
                symptomeRepository.save(symptome);
            }
        }

        repository.save(maladie);

        return maladie;
    }

    public List<Maladie> findMaladie(String keyword){
        if (keyword != ""){
            return repository.search(keyword);
        }
        return (List<Maladie>)repository.findAll();
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

    public Symptome getSymptomeById(String id){
        Optional<Symptome> optionalSymptome = symptomeRepository.findById(id);
        return optionalSymptome.get();
    }

}
