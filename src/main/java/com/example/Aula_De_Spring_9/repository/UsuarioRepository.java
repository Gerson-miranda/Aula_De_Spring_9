package com.example.Aula_De_Spring_9.repository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Aula_De_Spring_9.model.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    Optional<UsuarioModel> findByEmail(String email);
}
