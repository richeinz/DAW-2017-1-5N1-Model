/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "pessoa_fisica")
@Inheritance(strategy = InheritanceType.JOINED)
public class PessoaFisica extends Pessoa implements Serializable{
    
    //rg
    @Length(max = 10, message = "O RG não pode ter mais que {max} caracteres")
    @NotNull(message = "O RG deve ser informado")
    @NotBlank(message = "O RG não pode ser em branco")
    @Column(name = "rg", length = 10, nullable = false)
    private String rg;
    //CPF
    @Length(max = 14, message = "O CPF não pode ter mais que {max} caracteres")
    @NotNull(message = "O CPF deve ser informado")
    @NotBlank(message = "O CPF não pode ser em branco")
    @Column(name = "cpf", length = 14, nullable = false)
    @CPF(message = "O CPF deve ser válido")
    private String cpf;
    //nascimento
    @NotNull(message = "O nascimento deve ser informado")
    @Temporal(TemporalType.DATE)
    private Calendar nascimento;
    
    @ManyToMany
    @JoinTable(name = "desejos",
            joinColumns = @JoinColumn(name = "pessoa_fisica", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "produto", referencedColumnName = "id", nullable = false))
    private List<Produto> desejos = new ArrayList<>();
    
    
    public PessoaFisica(){
        
    }

    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the nascimento
     */
    public Calendar getNascimento() {
        return nascimento;
    }

    /**
     * @param nascimento the nascimento to set
     */
    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    public List<Produto> getDesejos() {
        return desejos;
    }

    public void setDesejos(List<Produto> desejos) {
        this.desejos = desejos;
    }
    
    
}
