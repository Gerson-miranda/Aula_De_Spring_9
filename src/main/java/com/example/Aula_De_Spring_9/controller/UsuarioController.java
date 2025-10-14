package com.example.Aula_De_Spring_9.controller;

import java.net.URI;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.Aula_De_Spring_9.dto.UsuarioRequestDTO;
import com.example.Aula_De_Spring_9.dto.UsuarioResponseDTO;
import com.example.Aula_De_Spring_9.model.UsuarioModel;
import com.example.Aula_De_Spring_9.service.UsuarioService;


import jakarta.validation.Valid;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody UsuarioRequestDTO dto  ){
         UsuarioModel usuario  = usuarioService.salvarUsuario(dto);
        
         
        URI Location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();//pega a uri do recurso que foi criado


        return ResponseEntity.created(Location).body(Map.of("mensagem", "Usuário cadastrado com sucesso"));
    }

    



}
