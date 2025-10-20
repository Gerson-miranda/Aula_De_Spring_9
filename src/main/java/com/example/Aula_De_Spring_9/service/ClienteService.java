package com.example.Aula_De_Spring_9.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Aula_De_Spring_9.dto.ClienteRequestDTO;
import com.example.Aula_De_Spring_9.dto.ClienteResponseDTO;
import com.example.Aula_De_Spring_9.model.ClienteModel;
import com.example.Aula_De_Spring_9.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<ClienteResponseDTO> listarTodos(){
		return clienteRepository.findAll().stream()
				.map(c -> new ClienteResponseDTO(c.getNome(), c.getEmail(), c.getTelefone(), c.getFormaPagamento(), c.getEndereco()))
				.toList();
	}

	public ClienteModel salvarCliente(ClienteRequestDTO dto){
		clienteRepository.findByEmail(dto.getEmail()).ifPresent(c -> { throw new IllegalArgumentException("Email já cadastrado"); });

		ClienteModel cliente = new ClienteModel();
		cliente.setNome(dto.getNome());
		cliente.setEmail(dto.getEmail());
		cliente.setTelefone(dto.getTelefone());
		cliente.setFormaPagamento(dto.getFormaPagamento());
		cliente.setEndereco(dto.getEndereco());

		clienteRepository.save(cliente);

		return cliente;
	}

	public ClienteModel atualizarCliente(Long id, ClienteRequestDTO dto){
		ClienteModel cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));

		cliente.setNome(dto.getNome());
		cliente.setEmail(dto.getEmail());
		cliente.setTelefone(dto.getTelefone());
		cliente.setFormaPagamento(dto.getFormaPagamento());
		cliente.setEndereco(dto.getEndereco());

		clienteRepository.save(cliente);

		return cliente;
	}

	public ClienteModel deletarClienteRetornando(Long id){
		ClienteModel cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));

		clienteRepository.deleteById(id);

		return cliente;
	}

}
