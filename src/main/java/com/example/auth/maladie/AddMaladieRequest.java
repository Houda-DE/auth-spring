package com.example.auth.maladie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

import com.example.auth.user.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddMaladieRequest {

    public String name;

    public String details;

    public Set<Symptome> symptomes;

    private String image;

}
