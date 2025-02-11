package br.com.gestao.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "REGISTRO")
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_COMPRA")
    private Integer id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DATA_COMPRA")
    private LocalDate dataRegistro;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_PARCELA", referencedColumnName = "ID_PARCELA")
    private Parcela parcela;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Parcela getParcela() {
        return parcela;
    }

    public void setParcela(Parcela parcela) {
        this.parcela = parcela;
    }
}
