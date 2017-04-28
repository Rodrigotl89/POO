/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.integrado.model;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author rodrigo.lucena
 */
public class CadTipoPagamento {

    private Long cdTipoPagamento;
    private String dsTipoPagamento;
    private String inAtivo;
    private Date dtTransacao;

    public CadTipoPagamento() {
    }

    public CadTipoPagamento(Long cdTipoPagamento, String dsTipoPagamento, String inAtivo, Date dtTransacao) {
        this.cdTipoPagamento = cdTipoPagamento;
        this.dsTipoPagamento = dsTipoPagamento;
        this.inAtivo = inAtivo;
        this.dtTransacao = dtTransacao;
    }

    public Date getDtTransacao() {
        return dtTransacao;
    }

    public void setDtTransacao(Date dtTransacao) {
        this.dtTransacao = dtTransacao;
    }

    public Long getCdTipoPagamento() {
        return cdTipoPagamento;
    }

    public void setCdTipoPagamento(Long cdTipoPagamento) {
        this.cdTipoPagamento = cdTipoPagamento;
    }

    public String getDsTipoPagamento() {
        return dsTipoPagamento;
    }

    public void setDsTipoPagamento(String dsTipoPagamento) {
        this.dsTipoPagamento = dsTipoPagamento;
    }

    public String getInAtivo() {
        return inAtivo;
    }

    public void setInAtivo(String inAtivo) {
        this.inAtivo = inAtivo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.cdTipoPagamento);
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
        final CadTipoPagamento other = (CadTipoPagamento) obj;
        if (!Objects.equals(this.cdTipoPagamento, other.cdTipoPagamento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CadTipoPagamento{" + "cdTipoPagamento=" + cdTipoPagamento + ", dsTipoPagamento=" + dsTipoPagamento + ", inAtivo=" + inAtivo + ", dtTransacao=" + dtTransacao + '}';
    }

}
