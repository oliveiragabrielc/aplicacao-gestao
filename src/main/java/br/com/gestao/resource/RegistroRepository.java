package br.com.gestao.resource;

import java.util.List;

import br.com.gestao.model.Registro;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public interface RegistroRepository extends PanacheRepository<Registro>{
    
    List<Registro> listarRegistros();

    Registro recuperarPorId(int id);

    void adicionar(Registro registro);

    void alterar(Registro registro);

    void deletar(Registro registro);

}
