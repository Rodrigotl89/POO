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
public class MovParcelas {

    Long cdParcela;
    MovVenda venda;
    Date dtGeracao;
    Date dtVencimento;
    Double vlParcela;
    Date dtTransacao;
    Date dtPagamento;
    Double vlPagamento;

    public MovParcelas() {
    }

    public MovParcelas(Long cdParcela, MovVenda venda, Date dtGeracao, Date dtVencimento, Double vlParcela, Date dtTransacao, Date dtPagamento, Double vlPagamento) {
        this.cdParcela = cdParcela;
        this.venda = venda;
        this.dtGeracao = dtGeracao;
        this.dtVencimento = dtVencimento;
        this.vlParcela = vlParcela;
        this.dtTransacao = dtTransacao;
        this.dtPagamento = dtPagamento;
        this.vlPagamento = vlPagamento;
    }

    public Long getCdParcela() {
        return cdParcela;
    }

    public void setCdParcela(Long cdParcela) {
        this.cdParcela = cdParcela;
    }

    public MovVenda getVenda() {
        return venda;
    }

    public void setVenda(MovVenda venda) {
        this.venda = venda;
    }

    public Date getDtGeracao() {
        return dtGeracao;
    }

    public void setDtGeracao(Date dtGeracao) {
        this.dtGeracao = dtGeracao;
    }

    public Date getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(Date dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    public Double getVlParcela() {
        return vlParcela;
    }

    public void setVlParcela(Double vlParcela) {
        this.vlParcela = vlParcela;
    }

    public Date getDtTransacao() {
        return dtTransacao;
    }

    public void setDtTransacao(Date dtTransacao) {
        this.dtTransacao = dtTransacao;
    }

    public Date getDtPagamento() {
        return dtPagamento;
    }

    public void setDtPagamento(Date dtPagamento) {
        this.dtPagamento = dtPagamento;
    }

    public Double getVlPagamento() {
        return vlPagamento;
    }

    public void setVlPagamento(Double vlPagamento) {
        this.vlPagamento = vlPagamento;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.cdParcela);
        hash = 97 * hash + Objects.hashCode(this.venda);
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
        final MovParcelas other = (MovParcelas) obj;
        if (!Objects.equals(this.cdParcela, other.cdParcela)) {
            return false;
        }
        if (!Objects.equals(this.venda, other.venda)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MovParcelas{" + "cdParcela=" + cdParcela + ", venda=" + venda + ", dtGeracao=" + dtGeracao + ", dtVencimento=" + dtVencimento + ", vlParcela=" + vlParcela + ", dtTransacao=" + dtTransacao + ", dtPagamento=" + dtPagamento + ", vlPagamento=" + vlPagamento + '}';
    }

}
