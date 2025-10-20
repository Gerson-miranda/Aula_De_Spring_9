package com.example.Aula_De_Spring_9.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Aula_De_Spring_9.dto.FuncionarioRequestDTO;
import com.example.Aula_De_Spring_9.dto.FuncionarioResponseDTO;
import com.example.Aula_De_Spring_9.model.FuncionarioModel;
import com.example.Aula_De_Spring_9.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private BCryptPasswordEncoder PasswordEncoder;

    public List<FuncionarioResponseDTO> listarTodos(){
        return funcionarioRepository.findAll().stream()
                .map(funcionario -> new FuncionarioResponseDTO(funcionario.getNome(), funcionario.getEmail()))
                .toList();
    }

    public FuncionarioModel salvarFuncionario(FuncionarioRequestDTO dto){
    funcionarioRepository.findByEmail(dto.getEmail())
        .ifPresent(u -> { throw new IllegalArgumentException("Email já cadastrado"); });

        FuncionarioModel funcionario = new FuncionarioModel();
        funcionario.setNome(dto.getNome());
        funcionario.setEmail(dto.getEmail());
        funcionario.setSenha(PasswordEncoder.encode(dto.getSenha())); // criptografa a senha

        funcionarioRepository.save(funcionario);

        return funcionario;
    }
    
    public FuncionarioModel atualizarFuncionario(Long id, FuncionarioRequestDTO dto){
        FuncionarioModel funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Funcionario não encontrado"));

        funcionario.setNome(dto.getNome());
        funcionario.setEmail(dto.getEmail());
        funcionario.setSenha(PasswordEncoder.encode(dto.getSenha()));

        funcionarioRepository.save(funcionario);

        return funcionario;
    }
    public FuncionarioModel deletarFuncionarioRetornando(Long id){
        FuncionarioModel funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Funcionario não encontrado"));

        funcionarioRepository.deleteById(id);

        return funcionario;
    }


}
