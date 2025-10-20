package com.example.Aula_De_Spring_9.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Aula_De_Spring_9.dto.ProdutoRequestDTO;
import com.example.Aula_De_Spring_9.dto.ProdutoResponseDTO;
import com.example.Aula_De_Spring_9.model.ProdutoModel;
import com.example.Aula_De_Spring_9.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<ProdutoResponseDTO> listarTodos(){
		return produtoRepository.findAll().stream()
				.map(p -> new ProdutoResponseDTO(p.getNome(), p.getLote(), p.getValidade(), p.getCategoria(), p.getQuantidade()))
				.toList();
	}

	public ProdutoModel salvarProduto(ProdutoRequestDTO dto){
		ProdutoModel p = new ProdutoModel();
		p.setNome(dto.getNome());
		p.setLote(dto.getLote());
		p.setValidade(dto.getValidade());
		p.setCategoria(dto.getCategoria());
		p.setQuantidade(dto.getQuantidade());

		produtoRepository.save(p);

		return p;
	}

	public ProdutoModel atualizarProduto(Long id, ProdutoRequestDTO dto){
		ProdutoModel p = produtoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));

		p.setNome(dto.getNome());
		p.setLote(dto.getLote());
		p.setValidade(dto.getValidade());
		p.setCategoria(dto.getCategoria());
		p.setQuantidade(dto.getQuantidade());

		produtoRepository.save(p);

		return p;
	}

	public ProdutoModel deletarProdutoRetornando(Long id){
		ProdutoModel p = produtoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));

		produtoRepository.deleteById(id);

		return p;
	}

}
