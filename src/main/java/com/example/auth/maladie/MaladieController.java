package com.example.auth.maladie;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.auth.user.Maladie;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/maladie")
public class MaladieController {

    public final MaladieService service;

    @PostMapping("/add")
    public ResponseEntity<AddMaladieResponse> addMaladie(
            @RequestBody AddMaladieRequest request
    ){
        return ResponseEntity.ok(service.addMaladie(request));
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

}