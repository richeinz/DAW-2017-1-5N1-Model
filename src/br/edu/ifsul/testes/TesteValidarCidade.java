/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cidade;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 *
 * @author Ricardo
 */
public class TesteValidarCidade {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cidade c = new Cidade();
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Cidade>> erros = validador.validate(c);
        for (ConstraintViolation<Cidade> erro : erros){
            System.out.println("Erro: "+erro.getMessage());
        }
    }
    
}
