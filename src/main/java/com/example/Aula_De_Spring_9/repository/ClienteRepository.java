package com.example.Aula_De_Spring_9.repository;

import org.springframework.stereotype.Repository;
import com.example.Aula_De_Spring_9.model.ClienteModel;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {

    Optional<ClienteModel> findByEmail(String email);

}
