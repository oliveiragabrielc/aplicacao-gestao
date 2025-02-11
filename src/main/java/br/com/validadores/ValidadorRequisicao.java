package br.com.validadores;

import java.util.Set;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

@Dependent
public class ValidadorRequisicao<T> {

    Validator validator;

    @Inject
    public ValidadorRequisicao(Validator validator) {
        this.validator = validator;
    }

    public void validar(T requisicao) throws Exception {
        Set<ConstraintViolation<T>> erros = validator.validate(requisicao);
        
        if(!erros.isEmpty()){
            throw new Exception("Não pode ter campos em branco");
        }
    }

}
