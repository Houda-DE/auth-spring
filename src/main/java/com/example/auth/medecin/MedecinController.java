package com.example.auth.medecin;

import com.example.auth.user.Medecin;
import com.example.auth.user.User;
import com.example.auth.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medecin")
@RequiredArgsConstructor
public class MedecinController {

    private final MedecinService service;
    private final UserRepository repository;

    @PostMapping("/add")
    public ResponseEntity<AddDoctorResponse> addDoctor(
            @RequestBody AddDoctorRequest request
    ) {
        return ResponseEntity.ok(service.addDocotor(request));
    }

    @GetMapping("getall")
    public List<Medecin> getAllMedecin(){
        return service.getAllMedecin();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medecin> getUserById(@PathVariable("id") Integer id){
        Medecin medecin = service.getMedecinById(id);
        return new ResponseEntity<>(medecin, HttpStatus.OK);
    }

}
