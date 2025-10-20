package com.example.Aula_De_Spring_9.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClienteRequestDTO {

	@NotBlank(message = "O nome é obrigatório")
	@Size(min = 3, max = 100)
	private String nome;

	@NotBlank(message = "O email é obrigatório")
	@Email(message = "O email deve ser válido")
	@Size(max = 100)
	private String email;

	@NotBlank(message = "O telefone é obrigatório")
	@Size(max = 11)
	private String telefone;

	@NotBlank(message = "A forma de pagamento é obrigatória")
	@Size(max = 100)
	private String formaPagamento;

	@NotBlank(message = "O endereco é obrigatório")
	@Size(max = 100)
	private String endereco;

}
