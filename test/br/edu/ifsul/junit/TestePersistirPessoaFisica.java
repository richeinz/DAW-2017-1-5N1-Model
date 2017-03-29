/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.PessoaFisica;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ricardo
 */
public class TestePersistirPessoaFisica {
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirPessoaFisica() {
    }
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("DAW-2017-1-5N1ModelPU");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    
    @Test
    public void testar(){
        boolean exception = false;
        try {
            Cidade c = em.find(Cidade.class, 4);
            PessoaFisica pf = new PessoaFisica();
            pf.setCidade(c);
            pf.setNome("Ricardo");
            pf.setBairro("Operaria");
            pf.setCep("99025-040");
            pf.setComplemento("Apto 2");
            pf.setCpf("540.762.180-00");
            pf.setEmail("richeinz@hotmail.com");
            pf.setEndereco("rua Mascarenhas, 178");
            pf.setNascimento(new GregorianCalendar(1969, Calendar.SEPTEMBER, 20));
            pf.setRg("9999556632");        
            em.getTransaction().begin();
            em.persist(pf);
            em.getTransaction().commit();
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        //vou verificar se o resultado é o esperado
        Assert.assertEquals(false, exception);
    }
    
}
