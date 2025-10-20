package com.example.Aula_De_Spring_9.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProdutoRequestDTO {

	@NotBlank(message = "O nome é obrigatório")
	@Size(max = 100)
	private String nome;

	@NotBlank(message = "O lote é obrigatório")
	@Size(max = 100)
	private String lote;

	@NotBlank(message = "A validade é obrigatória")
	@Size(max = 100)
	private String validade;

	@NotBlank(message = "A categoria é obrigatória")
	@Size(max = 100)
	private String categoria;

	private int quantidade;

}
