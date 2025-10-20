package com.example.Aula_De_Spring_9.repository;

import java.lang.classfile.ClassFile.Option;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import com.example.Aula_De_Spring_9.model.FuncionarioModel;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Long> {

    Optional<FuncionarioModel> findByEmail(String email);

}
