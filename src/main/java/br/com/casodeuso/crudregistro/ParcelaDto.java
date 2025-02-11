package br.com.casodeuso.crudregistro;

import jakarta.validation.constraints.NotBlank;

public record ParcelaDto(
        int id,

        @NotBlank double valorParcela,

        @NotBlank int totalParcelas,

        @NotBlank int numeroParcela) {
}
