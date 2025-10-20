package com.example.Aula_De_Spring_9.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FuncionarioResponseDTO {

    private String nome;
    private String email;
}
