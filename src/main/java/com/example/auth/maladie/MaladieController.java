package com.example.auth.maladie;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
