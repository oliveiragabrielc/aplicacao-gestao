package br.com.casodeuso.crudregistro;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;

public record RegistroDto(
        int id,
        @NotBlank String nome,

        @NotBlank LocalDate dataRegistro,

        @NotBlank ParcelaDto parcela) {
}
