package br.com.gestao.resource;

import br.com.gestao.model.Parcela;
import jakarta.enterprise.context.RequestScoped;
import jakarta.transaction.Transactional;

@RequestScoped
public class ParcelaJpaRepository implements ParcelaRepository {

    @Transactional
    @Override
    public void alterar(Parcela parcela) {
        update("valorParcela = ?1, totalParcela = ?2, numeroParcela = ?3 where id = ?4", parcela.getValorParcela(),
                parcela.getTotalParcelas(), parcela.getNumeroParcela(), parcela.getId());
    }

}
