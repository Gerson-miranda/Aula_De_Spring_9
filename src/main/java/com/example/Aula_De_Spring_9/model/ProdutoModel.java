package com.example.Aula_De_Spring_9.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "TAB_produtos")
public class ProdutoModel {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 100)
    private String nome;
    @Column(nullable = false,length = 100)
    private String lote;
    @Column(nullable = false,length = 100)
    private String validade;
    @Column(nullable = false,length = 100)
    private String categoria;
    @Column(nullable = false,length = 100)
    private int quantidade;


}
