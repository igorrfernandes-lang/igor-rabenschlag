package com.example.igorrabenschlag.controller;

import com.example.igorrabenschlag.model.produtoModel;
import com.example.igorrabenschlag.repository.produtoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation .*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/produtoModel")
public class produtoController {

    @Autowired
    produtoRepository ProdutoRepository;

    @PostMapping
    public ResponseEntity<produtoModel> saveProduct(@RequestBody @Valid ProdutoRecordDto produtoRecordDto) {
        var produto = new produtoModel();
        BeanUtils.copyProperties(produtoRecordDto, produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
    }

    @GetMapping
    public ResponseEntity<List<produtoModel.ProdutoModel>> getAllProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.findAlL());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable(value="id") int id) {
        Optional<produtoModel.ProdutoModel> product0 = produtoRepository.findById(id);
        if (produtoModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ProdutoModel não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(product0.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value = "id") int id,
                                                @RequestBody @Valid ProdutoRecordDto productRecordDto) {
        Optional<produtoModel> produt0 = produtoRepository.findALLById(id);
        if (produt0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ProdutoModel não encontrado");
        }
        var produtoModel = ProdutoModel.get();
        BeanUtils.copyProperties(productRecordDto, produtoModel);
        return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produtoModel));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduto ( @PathVariable(value = "id") int id){
        Optional<produtoModel> product0 = produtoRepository.findById(id);
        if (product0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ProdutoModel não encontrado");
        }
            produtoRepository.delete(product0.get());
            return ResponseEntity.status(HttpStatus.OK).body("ProdutoModel excluido com sucesso!");
    }
}