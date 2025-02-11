package br.com.gestao.model.builder;

import java.time.LocalDate;

import br.com.gestao.casodeuso.crudregistro.ParcelaDto;
import br.com.gestao.casodeuso.crudregistro.RegistroDto;
import br.com.gestao.model.Parcela;
import br.com.gestao.model.Registro;

public class RegistroBuilder {

    private Integer id;
    private String nome;
    private LocalDate dataRegistro;
    private Parcela parcela;

    public Registro build() {
        Registro produto = new Registro();
        produto.setId(id);
        produto.setNome(nome);
        produto.setDataRegistro(dataRegistro);
        produto.setParcela(parcela);
        return produto;
    }

    public RegistroBuilder comId(int id) {
        this.id = id;
        return this;
    }

    public RegistroBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public RegistroBuilder comDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
        return this;
    }

    public RegistroBuilder comParcela(ParcelaDto parcelaDto) {
        this.parcela = new ParcelaBuilder()
                .comId(parcelaDto.id())
                .comValorParcela(parcelaDto.valorParcela())
                .comNumeroParcela(parcelaDto.numeroParcela())
                .comTotalParcelas(parcelaDto.totalParcelas())
                .build();
        return this;
    }

    public RegistroBuilder comParcelaSemID(ParcelaDto parcelaDto) {
        this.parcela = new ParcelaBuilder()
                .comValorParcela(parcelaDto.valorParcela())
                .comNumeroParcela(parcelaDto.numeroParcela())
                .comTotalParcelas(parcelaDto.totalParcelas())
                .build();
        return this;
    }

    public RegistroBuilder converterRegistro(RegistroDto registroDto) {
        this.id = registroDto.id();
        this.nome = registroDto.nome();
        this.dataRegistro = registroDto.dataRegistro();
        this.parcela = new ParcelaBuilder()
                .converterParcela(registroDto.parcela())
                .build();
        return this;
    }

    public RegistroDto converterRegistroDto(Registro registro) {
        return new RegistroDto(registro.getId(),
                registro.getNome(),
                registro.getDataRegistro(),
                new ParcelaBuilder()
                        .converterParcelaDto(registro.getParcela()));
    }

}
