/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Grupo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ricardo
 */
public class TesteAlterarGrupo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-2017-1-5N1ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Grupo g = em.find(Grupo.class, 3);//recuperei o estado
        g.setNome("Vestuario");
        em.getTransaction().begin();
        em.merge(g);
        em.getTransaction().commit();
        
    }
    
}
