package com.example.igorrabenschlag.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record produtoRecordDto(@NotBlank String nome, @NotNull Integer quantidade) {

}