package com.example.auth.maladie;

import com.example.auth.user.Symptome;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddMaladieRequest {

    public String name;

    public String details;

    public List<Symptome> symptomeList;

}
