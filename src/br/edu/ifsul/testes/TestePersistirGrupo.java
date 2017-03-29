/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Grupo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author richeinz
 */
public class TestePersistirGrupo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-2017-1-5N1ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Grupo g = new Grupo();
        g.setNome("Audio");
        em.getTransaction().begin();
        em.persist(g);
        em.getTransaction().commit();
    }
    
}
