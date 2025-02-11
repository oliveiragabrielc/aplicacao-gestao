package br.com.casodeuso.crudregistro;

import java.util.List;

public record RespostaListarTodosProdutos(
        List<RegistroDto> produtos) {
}
