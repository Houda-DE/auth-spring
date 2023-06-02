package com.example.auth.maladie;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.auth.user.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/maladie")
public class MaladieController {

    public final MaladieService service;

    @PostMapping("/add")
    public ResponseEntity<Maladie> addMaladie(
            @RequestBody AddMaladieRequest request

    ){
        return ResponseEntity.ok(service.addMaladie(request));
    }

    @PostMapping("/addsymptome")
    public ResponseEntity<AddSymptomeResponse> addSymptome(
            @RequestBody AddSymptomeRequest request
    ){
        return ResponseEntity.ok(service.addSymptome(request));
    }

    @GetMapping("/getall")
    public ResponseEntity<List> getAllMaladies(){
        return ResponseEntity.ok(service.allMaladies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Maladie> getMaladieById (
            @PathVariable("id") Integer id
    ){
        Maladie maladie = service.getMaladieById(id);
        return new ResponseEntity<>(maladie , HttpStatus.OK);
    }

    @GetMapping("symp/{id}")
    public ResponseEntity<Symptome> getSymptome (
            @PathVariable("id") String id
    ){
        Symptome symptome = service.getSymptomeById(id);
        return new ResponseEntity<>(symptome , HttpStatus.OK);
    }

    @GetMapping("/getallSym")
    public ResponseEntity<List> getAllSym(){
        return ResponseEntity.ok(service.getAllSymptomes());
    }

    @GetMapping("/search/{keyword}")
    public List<Maladie> searchMedecin(@PathVariable("keyword") String keyword){
        return service.findMaladie(keyword);
    }

}