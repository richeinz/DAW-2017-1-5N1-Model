/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario extends PessoaFisica implements Serializable{
    
    //apelido
    @Length(max = 30, message = "O apelido não pode ter mais que {max} caracteres")
    @NotNull(message = "O apelido deve ser informado")
    @NotBlank(message = "O apelido não pode ser em branco")
    @Column(name = "apelido", length = 30, nullable = false)
    private String apelido;
    
    //senha
    @Length(max = 30, message = "A senha não pode ter mais que {max} caracteres")
    @NotNull(message = "A senha deve ser informado")
    @NotBlank(message = "A senha não pode ser em branco")
    @Column(name = "senha", length = 30, nullable = false)
    private String senha;
    
    //ativo
    @NotNull(message = "O ativo deve ser informado")
    private Boolean ativo;
    
    //administrador
    @NotNull(message = "O administrador deve ser informado")
    private Boolean administrador;
    
    public Usuario(){
        
    }

    /**
     * @return the apelido
     */
    public String getApelido() {
        return apelido;
    }

    /**
     * @param apelido the apelido to set
     */
    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the ativo
     */
    public Boolean getAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    /**
     * @return the administrador
     */
    public Boolean getAdministrador() {
        return administrador;
    }

    /**
     * @param administrador the administrador to set
     */
    public void setAdministrador(Boolean administrador) {
        this.administrador = administrador;
    }

    
}
