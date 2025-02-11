package br.com.gestao.resource;

import br.com.gestao.model.Parcela;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public interface ParcelaRepository extends PanacheRepository<Parcela> {
    void alterar(Parcela parcela);
}