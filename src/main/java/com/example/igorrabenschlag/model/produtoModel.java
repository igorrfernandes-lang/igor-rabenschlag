package com.example.igorrabenschlag.model;

import jakarta.persistence .*;
import lombok.Getter;
import lombok.Setter;

public class produtoModel {

    @Getter
    @Setter
    @Entity
    @Table(name = "TBPRODUTO")
    public static class ProdutoModel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public Long id;
        public String nome;
        public Integer quantidade;
    }
}