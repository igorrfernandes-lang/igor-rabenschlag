package com.example.igorrabenschlag.repository;

import com.example.igorrabenschlag.model.produtoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface produtoRepository extends JpaRepository<produtoModel, Integer> {
    Optional<produtoModel> findById(int id);

    Optional<produtoModel> findALlById(int id);
}