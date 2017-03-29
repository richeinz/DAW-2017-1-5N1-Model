
package br.edu.ifsul.modelo;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 */
@Entity
@Table(name = "venda")
public class Venda implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_venda", sequenceName = "seq_venda_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_venda", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "A data deve ser informada")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data", nullable = false)
    private Calendar data;
    @NotNull(message = "O valor total deve ser informado")
    @Column(name = "valor_total", nullable = false, 
            columnDefinition = "numeric(12,2)")
    private Double valorTotal;
    @NotNull(message = "A quantidade de parcelas deve ser informada")
    @Min(value = 1, message = "A quantidade mínima de parcelas é {value}")
    @Column(name = "quantidade_parcelas", nullable = false)
    private Integer quantidadeParcelas;
    @NotBlank(message = "O tipo de pagamento deve ser informado")
    @Column(name = "pagamento", nullable = false, length = 30)
    private String pagamento;
    @NotNull(message = "O usuario deve ser informado")
    @ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "id", nullable = false)
    private Usuario usuario;
    @NotNull(message = "A pessoa fisica deve ser informada")
    @ManyToOne
    @JoinColumn(name = "pessoa_fisica", referencedColumnName = "id", nullable = false)
    private PessoaFisica pessoaFisica;
    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<VendaItens> itens = new ArrayList<>();
    @OneToMany(mappedBy = "parcelaID.venda", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Parcela> listaPercelas = new ArrayList<>();

    public Venda(){
        this.valorTotal = 0.0;
    }  
    
    public void gerarParcelas(){
        Double valorParcela = this.valorTotal / this.quantidadeParcelas;
        for(int i=1; i <=this.quantidadeParcelas; i++){
            Parcela p = new Parcela();
            p.setValor(valorParcela);
            //maneira correta de criar a data
            Calendar vencimento = (Calendar)this.data.clone();
            //meneira errada
            //Calendar vencimento = this.data;
            vencimento.add(Calendar.MONTH, i);
            p.setVencimento(vencimento);
            ParcelaID id = new ParcelaID();
            id.setVenda(this);
            id.setNumero(i);
            p.setParcelaID(id);
            this.listaPercelas.add(p);
        }
    }
    
    public void adicionarItem(VendaItens obj){
        obj.setVenda(this);// seto a venda do objeto venda itens
        this.valorTotal += obj.getValorTotal(); // atualizo o valor
        this.itens.add(obj); // adiciono o item na venda
    }
    
    public void removerItem(int index){
        VendaItens obj = this.itens.get(index);
        this.valorTotal -= obj.getValorTotal();
        this.itens.remove(obj);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(Integer quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Venda other = (Venda) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Venda{" + "id=" + id + ", data=" + data + '}';
    }

    public List<VendaItens> getItens() {
        return itens;
    }

    public void setItens(List<VendaItens> itens) {
        this.itens = itens;
    }

    /**
     * @return the listaPercelas
     */
    public List<Parcela> getListaPercelas() {
        return listaPercelas;
    }

    /**
     * @param listaPercelas the listaPercelas to set
     */
    public void setListaPercelas(List<Parcela> listaPercelas) {
        this.listaPercelas = listaPercelas;
    }

    
}
