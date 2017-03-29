/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.modelo.Usuario;
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
public class TestePersistirUsuario {
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirUsuario() {
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
            Usuario u = new Usuario();
            u.setApelido("ricardo.heinz");
            u.setNome("Ricardo Heinz");
            u.setCidade(c);
            u.setSenha("123456789");
            u.setAdministrador(true);
            u.setAtivo(true);
            u.setBairro("Boqueirao");
            u.setCep("99025-035");
            u.setCpf("975.822.249-06");
            u.setEmail("usuario1@usuario.com.br");
            u.setEndereco("Rua Moron, 2345");
            u.setNascimento(new GregorianCalendar(1980, Calendar.JULY, 19));
            u.setRg("1234567890");
            u.setComplemento("qualquer coisa");
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        //vou verificar se o resultado é o esperado
        Assert.assertEquals(false, exception);
    }
    
}
