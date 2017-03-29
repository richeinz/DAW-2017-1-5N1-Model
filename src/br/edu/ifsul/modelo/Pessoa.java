/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_pessoa", strategy = GenerationType.SEQUENCE)
    private Integer id;
    //nome
    @Length(max = 50, message = "O nome não pode ter mais que {max} caracteres")
    @NotNull(message = "O nome deve ser informado")
    @NotBlank(message = "O nome não pode ser em branco")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    //endereço
    @Length(max = 50, message = "O endereço não pode ter mais que {max} caracteres")
    @NotNull(message = "O endereço deve ser informado")
    @NotBlank(message = "O endereço não pode ser em branco")
    @Column(name = "endereco", length = 50, nullable = false)
    private String endereco;
    //email
    @Email(message = "O email deve ser válido")
    @Length(max = 50, message = "O email não pode ter mais que {max} caracteres")
    @NotNull(message = "O email deve ser informado")
    @NotBlank(message = "O email não pode ser em branco")
    @Column(name = "email", length = 50, nullable = false)
    private String email;
    //bairro
    @Length(max = 30, message = "O bairro não pode ter mais que {max} caracteres")
    @NotNull(message = "O bairro deve ser informado")
    @NotBlank(message = "O bairro não pode ser em branco")
    @Column(name = "bairro", length = 30, nullable = false)
    private String bairro;
    //cep
    @Length(max = 9, message = "O cep não pode ter mais que {max} caracteres")
    @NotNull(message = "O cep deve ser informado")
    @NotBlank(message = "O cep não pode ser em branco")
    @Column(name = "cep", length = 9, nullable = false)
    private String cep;
    //complemento
    @Length(max = 30, message = "O complemento não pode ter mais que {max} caracteres")
    @Column(name = "complemento", length = 30)
    private String complemento;
    //cidade
    @NotNull(message = "A cidade deve ser informado")
    @ManyToOne
    @JoinColumn(name = "cidade", referencedColumnName = "id", nullable = false)
    private Cidade cidade;
    
    //telefone
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Telefone> telefones = new ArrayList<>();
    
    public Pessoa(){
        
    }
    
    public void adicionarTelefone(Telefone obj){
        obj.setPessoa(this);
        this.telefones.add(obj);
    }
    
    public void removerTelefone (int index){
        this.telefones.remove(index);
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * @return the cidade
     */
    public Cidade getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
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
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     * @return the telefones
     */
    public List<Telefone> getTelefones() {
        return telefones;
    }

    /**
     * @param telefones the telefones to set
     */
    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
    
    
}
