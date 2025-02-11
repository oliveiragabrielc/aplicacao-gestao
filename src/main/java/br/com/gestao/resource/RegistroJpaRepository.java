package br.com.gestao.resource;

import java.util.List;

import br.com.gestao.model.Registro;
import jakarta.enterprise.context.RequestScoped;
import jakarta.transaction.Transactional;

@RequestScoped
public class RegistroJpaRepository implements RegistroRepository {

    

    @Transactional
    @Override
    public void adicionar(Registro produto) {
        persist(produto);
    }

    @Transactional
    @Override
    public void alterar(Registro registro) {
    update("nome = ?1, dataRegistro = ?2 where id = ?3",
    registro.getNome(),
    registro.getDataRegistro(), registro.getId());
    }

    @Transactional
    @Override
    public void deletar(Registro registro) {
        delete(registro);
    }

    @Override
    public List<Registro> listarRegistros() {
        return listAll();
    }

    @Override
    public Registro recuperarPorId(int id) {
        return findById(Long.valueOf(id));
    }

}
