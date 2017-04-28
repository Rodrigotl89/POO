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
public class MovVenda {
    Long cdVenda;
    FormaPagamento FormaPgto;
    CadTipoPagamento TipoPgto;
    CadCliente cliente;
    Double vlTotal;
    Double vlDeconto;
    Double vlTotalVenda;
    Date dtVenda;
    Date dtTransacao;

    public MovVenda() {
    }

    public MovVenda(Long cdVenda, FormaPagamento FormaPgto, CadTipoPagamento TipoPgto, CadCliente cliente, Double vlTotal, Double vlDeconto, Double vlTotalVenda, Date dtVenda, Date dtTransacao) {
        this.cdVenda = cdVenda;
        this.FormaPgto = FormaPgto;
        this.TipoPgto = TipoPgto;
        this.cliente = cliente;
        this.vlTotal = vlTotal;
        this.vlDeconto = vlDeconto;
        this.vlTotalVenda = vlTotalVenda;
        this.dtVenda = dtVenda;
        this.dtTransacao = dtTransacao;
    }

    public Long getCdVenda() {
        return cdVenda;
    }

    public void setCdVenda(Long cdVenda) {
        this.cdVenda = cdVenda;
    }

    public FormaPagamento getFormaPgto() {
        return FormaPgto;
    }

    public void setFormaPgto(FormaPagamento FormaPgto) {
        this.FormaPgto = FormaPgto;
    }

    public CadTipoPagamento getTipoPgto() {
        return TipoPgto;
    }

    public void setTipoPgto(CadTipoPagamento TipoPgto) {
        this.TipoPgto = TipoPgto;
    }

    public CadCliente getCliente() {
        return cliente;
    }

    public void setCliente(CadCliente cliente) {
        this.cliente = cliente;
    }

    public Double getVlTotal() {
        return vlTotal;
    }

    public void setVlTotal(Double vlTotal) {
        this.vlTotal = vlTotal;
    }

    public Double getVlDeconto() {
        return vlDeconto;
    }

    public void setVlDeconto(Double vlDeconto) {
        this.vlDeconto = vlDeconto;
    }

    public Double getVlTotalVenda() {
        return vlTotalVenda;
    }

    public void setVlTotalVenda(Double vlTotalVenda) {
        this.vlTotalVenda = vlTotalVenda;
    }

    public Date getDtVenda() {
        return dtVenda;
    }

    public void setDtVenda(Date dtVenda) {
        this.dtVenda = dtVenda;
    }

    public Date getDtTransacao() {
        return dtTransacao;
    }

    public void setDtTransacao(Date dtTransacao) {
        this.dtTransacao = dtTransacao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.cdVenda);
        hash = 53 * hash + Objects.hashCode(this.FormaPgto);
        hash = 53 * hash + Objects.hashCode(this.TipoPgto);
        hash = 53 * hash + Objects.hashCode(this.cliente);
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
        final MovVenda other = (MovVenda) obj;
        if (!Objects.equals(this.cdVenda, other.cdVenda)) {
            return false;
        }
        if (!Objects.equals(this.FormaPgto, other.FormaPgto)) {
            return false;
        }
        if (!Objects.equals(this.TipoPgto, other.TipoPgto)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MovVenda{" + "cdVenda=" + cdVenda + ", FormaPgto=" + FormaPgto + ", TipoPgto=" + TipoPgto + ", cliente=" + cliente + ", vlTotal=" + vlTotal + ", vlDeconto=" + vlDeconto + ", vlTotalVenda=" + vlTotalVenda + ", dtVenda=" + dtVenda + ", dtTransacao=" + dtTransacao + '}';
    }
    
    
}
