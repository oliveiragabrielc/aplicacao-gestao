package br.com.gestao.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import br.com.gestao.casodeuso.crudregistro.RegistroDto;
import br.com.gestao.model.Registro;
import br.com.gestao.model.builder.RegistroBuilder;
import br.com.gestao.resource.ParcelaRepository;
import br.com.gestao.resource.RegistroRepository;
import br.com.gestao.validadores.ValidadorRequisicao;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.validation.ValidationException;

@RequestScoped
public class RegistroService {

    RegistroRepository registroRepository;
    ParcelaRepository parcelaRepository;
    ValidadorRequisicao<RegistroDto> validador;

    @Inject
    public RegistroService(RegistroRepository repository, ParcelaRepository parcelaRepository,
            ValidadorRequisicao<RegistroDto> validador) {
        this.registroRepository = repository;
        this.parcelaRepository = parcelaRepository;
        this.validador = validador;
    }

    public List<RegistroDto> recuperaTodos() {
        return registroRepository.listAll()
                .stream()
                .map(r -> new RegistroBuilder().converterRegistroDto(r))
                .collect(Collectors.toList());
    }

    public RegistroDto recuperarRegistro(int id) {
        return new RegistroBuilder().converterRegistroDto(registroRepository.recuperarPorId(id));
    }

    public void salvarLista(List<RegistroDto> listaRegistroDtos) {
        listaRegistroDtos.forEach(r -> {
            salvar(r);
        });
    }

    public boolean salvar(RegistroDto registro) {
        try {
            registroRepository.adicionar(new RegistroBuilder()
                    .comNome(registro.nome())
                    .comDataRegistro(registro.dataRegistro())
                    .comParcelaSemID(registro.parcela())
                    .build());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public boolean alterar(RegistroDto registroDto) {
        try {
            registroRepository.alterar(new RegistroBuilder()
                    .converterRegistro(registroDto)
                    .build());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void deletar(List<Integer> lista) {
        lista.forEach(id -> {
            try {
                registroRepository.deletar(new RegistroBuilder()
                        .comId(id)
                        .build());

            } catch (Exception e) {
                // TODO: handle exception
            }
        });
    }

    public void validarRequisicao(List<RegistroDto> list) {
        if (Objects.isNull(list) || list.isEmpty()) {
            throw new ValidationException("Lista de dados Vazio");
        }

        list.forEach(r -> {
            try {
                validador.validar(r);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

    }

}
