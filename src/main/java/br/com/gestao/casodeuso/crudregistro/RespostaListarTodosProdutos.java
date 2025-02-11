package br.com.gestao.casodeuso.crudregistro;

import java.util.List;

public record RespostaListarTodosProdutos(
        List<RegistroDto> produtos) {
}
