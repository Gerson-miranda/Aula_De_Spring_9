package com.example.Aula_De_Spring_9.repository;

import org.springframework.stereotype.Repository;
import com.example.Aula_De_Spring_9.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProdutoRepository extends JpaRepository <ProdutoModel, Long>{ 

    

}
