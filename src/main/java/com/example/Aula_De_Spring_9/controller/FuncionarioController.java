package com.example.Aula_De_Spring_9.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Aula_De_Spring_9.dto.FuncionarioRequestDTO;
import com.example.Aula_De_Spring_9.dto.FuncionarioResponseDTO;
import com.example.Aula_De_Spring_9.service.FuncionarioService;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<List<FuncionarioResponseDTO>> listar(){
        return ResponseEntity.ok().body(funcionarioService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar (@Valid @RequestBody FuncionarioRequestDTO dto){
        funcionarioService.salvarFuncionario(dto);
        return ResponseEntity.ok().body(Map.of("mensagem", "Funcionário cadastrado com sucesso"));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizar (@Valid @RequestBody FuncionarioRequestDTO dto, @PathVariable Long id){
        funcionarioService.atualizarFuncionario(id, dto);
        return ResponseEntity.ok().body(Map.of("mensagem", "Funcionário atualizado com sucesso","sucesso", true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletar (@PathVariable Long id){
        funcionarioService.deletarFuncionarioRetornando(id);
        return ResponseEntity.ok().body(Map.of("mensagem", "Funcionário deletado com sucesso","sucesso", true));
    }

}
