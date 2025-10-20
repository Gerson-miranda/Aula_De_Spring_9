package com.example.Aula_De_Spring_9.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FuncionarioRequestDTO {
    
    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, message= "O nome deve ter no mínimo 3 caracteres")
    @Size(max = 200, message = "O nome deve ter no máximo 200 caracteres")
    private String nome;
    
    @NotBlank(message = "O email é obrigatório")
    @Email(message = "O email deve ser válido")
    @Size(max = 200, message = "O nome deve ter no máximo 200 caracteres")
    private String email;
    
    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 3, message = "A senha deve ter no mínimo 3 caracteres")
    @Size(max = 200, message = "A Senha  deve ter no máximo 200 caracteres")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{3,}$", message = "A senha deve conter pelo menos uma letra e um número")
    private String senha;
}
