/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.Produto;
import br.edu.ifsul.modelo.Grupo;
import br.edu.ifsul.modelo.Marca;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Ricardo
 */
public class TestePersistirProduto {
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirProduto() {
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
            Produto p = new Produto();
            p.setNome("Notebook Dell I14-5458-D08P Intel Core i3 5005U");
            p.setDescricao("Equipado com um processador Intel Core i3 de 5ª geração, com velocidade de 2GHz, esse é um notebook Dell ideal para quem só quer navegar pela internet"
                    + " e rodar programas mais leves, ou arquivos de texto, por exemplo.");
            p.setEstoque(10.00);
            p.setGrupo(em.find(Grupo.class, 1));
            p.setMarca(em.find(Marca.class,2));
            p.setPreco(1000.10);
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        //vou verificar se o resultado é o esperado
        Assert.assertEquals(false, exception);
    }
    
}
