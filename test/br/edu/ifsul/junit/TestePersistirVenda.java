package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.modelo.Produto;
import br.edu.ifsul.modelo.Usuario;
import br.edu.ifsul.modelo.Venda;
import br.edu.ifsul.modelo.VendaItens;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jorge
 */
public class TestePersistirVenda {

    
    EntityManagerFactory emf;
    EntityManager em;
    

    public TestePersistirVenda() {
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
    public void teste() {
        boolean exception = false;
        try {
            Venda v = new Venda();
            v.setData(Calendar.getInstance());
           //v.setData(new GregorianCalendar(2016, 15, 45));
            v.setPagamento("A vista");
            v.setPessoaFisica(em.find(PessoaFisica.class, 1));
            v.setQuantidadeParcelas(6);
            v.setUsuario(em.find(Usuario.class, 9));
            VendaItens vi = new VendaItens();
            vi.setProduto(em.find(Produto.class, 2));
            vi.setValorUnitario(vi.getProduto().getPreco());
            vi.setQuantidade(3.0);
            vi.setValorTotal(vi.getValorUnitario()*vi.getQuantidade());
            v.adicionarItem(vi);
            em.getTransaction().begin();
            em.persist(v);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(false, exception);
    }

}
