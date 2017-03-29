/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.postgresql.translation.messages_bg;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "parcela")
public class Parcela implements Serializable{
    @EmbeddedId
    private ParcelaID parcelaID;
    @NotNull(message = "O valor deve ser informadao")
    @Column(name = "valor", nullable = false, columnDefinition = "numeric(12,2)")
    private Double valor;
    @NotNull(message = "O vencimento deve ser informado")
    @Temporal(TemporalType.DATE)
    @Column(name = "vencimento", nullable = false)
    private Calendar vencimento;
    @Column(name = "valor_pagamento", columnDefinition = "numeric(12,2)")
    private Double valorPagamento;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_pagamento")
    private Calendar dataPagamento;

    
    public Parcela(){
        
    }
    /**
     * @return the parcelaID
     */
    public ParcelaID getParcelaID() {
        return parcelaID;
    }

    /**
     * @param parcelaID the parcelaID to set
     */
    public void setParcelaID(ParcelaID parcelaID) {
        this.parcelaID = parcelaID;
    }

    /**
     * @return the valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * @return the vencimento
     */
    public Calendar getVencimento() {
        return vencimento;
    }

    /**
     * @param vencimento the vencimento to set
     */
    public void setVencimento(Calendar vencimento) {
        this.vencimento = vencimento;
    }

    /**
     * @return the valorPagamento
     */
    public Double getValorPagamento() {
        return valorPagamento;
    }

    /**
     * @param valorPagamento the valorPagamento to set
     */
    public void setValorPagamento(Double valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    /**
     * @return the dataPagamento
     */
    public Calendar getDataPagamento() {
        return dataPagamento;
    }

    /**
     * @param dataPagamento the dataPagamento to set
     */
    public void setDataPagamento(Calendar dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.parcelaID);
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
        final Parcela other = (Parcela) obj;
        if (!Objects.equals(this.parcelaID, other.parcelaID)) {
            return false;
        }
        return true;
    }
    
    
    
}
