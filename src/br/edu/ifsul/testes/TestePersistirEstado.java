/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Estado;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author richeinz
 */
public class TestePersistirEstado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-2017-1-5N1ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Estado e = new Estado();
        //e.setId(1);
        e.setNome("Rio de Janeiro");
        e.setUf("RJ");
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }
    
}
