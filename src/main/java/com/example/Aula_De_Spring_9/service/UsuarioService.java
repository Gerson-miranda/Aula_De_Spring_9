package com.example.Aula_De_Spring_9.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Aula_De_Spring_9.dto.UsuarioRequestDTO;
import com.example.Aula_De_Spring_9.dto.UsuarioResponseDTO;
import com.example.Aula_De_Spring_9.model.UsuarioModel;
import com.example.Aula_De_Spring_9.repository.UsuarioRepository;



@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UsuarioModel salvarUsuario(UsuarioRequestDTO usuarioRequestDTO){
        usuarioRepository.findByEmail(usuarioRequestDTO.getEmail())
        .ifPresent(u -> {throw new IllegalArgumentException("Email já cadastrado");});
    

    UsuarioModel usuario = new UsuarioModel();
    usuario.setNome(usuarioRequestDTO.getNome());
    usuario.setEmail(usuarioRequestDTO.getEmail());
    
    usuario.setSenha(bCryptPasswordEncoder.encode(usuarioRequestDTO.getSenha()));//criptografa a senha

     usuarioRepository.save(usuario);

        return usuario;
    }

    //listar todos os usuarios
    public List<UsuarioResponseDTO> listarTodos(){
        return usuarioRepository.findAll()
        .stream()
        .map(u -> new UsuarioResponseDTO(u.getNome(), u.getEmail()))
        .toList();
    }

}
