package br.com.gestao.model.builder;

import br.com.casodeuso.crudregistro.ParcelaDto;
import br.com.gestao.model.Parcela;

public class ParcelaBuilder {

    private Integer id;
    private Double valorParcela;
    private Integer totalParcelas;
    private Integer numeroParcela;
    public ParcelaBuilder builder;

    public Parcela build() {
        Parcela parcela = new Parcela();
        parcela.setId(id);
        parcela.setValorParcela(valorParcela);
        parcela.setTotalParcelas(totalParcelas);
        parcela.setNumeroParcela(numeroParcela);
        return parcela;
    }

    public void PacelaBuilder(ParcelaBuilder builder) {
        this.builder = builder;
    }

    public ParcelaBuilder comId(Integer id) {
        this.id = id;
        return this;
    }

    public ParcelaBuilder comValorParcela(Double valorParcela) {
        this.valorParcela = valorParcela;
        return this;
    }

    public ParcelaBuilder comTotalParcelas(Integer totalParcelas) {
        this.totalParcelas = totalParcelas;
        return this;
    }

    public ParcelaBuilder comNumeroParcela(Integer numeroParcela) {
        this.numeroParcela = numeroParcela;
        return this;
    }

    public ParcelaDto converterParcelaDto(Parcela parcela) {
        return new ParcelaDto(
                parcela.getId(),
                parcela.getValorParcela(),
                parcela.getTotalParcelas(),
                parcela.getNumeroParcela());
    }

    public ParcelaBuilder converterParcela(ParcelaDto parcelaDto) {
        this.id = parcelaDto.id();
        this.valorParcela = parcelaDto.valorParcela();
        this.numeroParcela = parcelaDto.numeroParcela();
        this.totalParcelas = parcelaDto.totalParcelas();
        return this;
    }

}
