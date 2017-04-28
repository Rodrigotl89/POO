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
public class CadProduto {
    private Long cdProduto;
    private String dsProduto;
    private Double vlProduto;
    private Long qtdEstoque;
    private Date dtTransacao;

    public CadProduto() {
    }

    public CadProduto(Long cdProduto, String dsProduto, Double vlProduto, Long qtdEstoque, Date dtTransacao) {
        this.cdProduto = cdProduto;
        this.dsProduto = dsProduto;
        this.vlProduto = vlProduto;
        this.qtdEstoque = qtdEstoque;
        this.dtTransacao = dtTransacao;
    }

    public Date getDtTransacao() {
        return dtTransacao;
    }

    public void setDtTransacao(Date dtTransacao) {
        this.dtTransacao = dtTransacao;
    }

    public Long getCdProduto() {
        return cdProduto;
    }

    public void setCdProduto(Long cdProduto) {
        this.cdProduto = cdProduto;
    }

    public String getDsProduto() {
        return dsProduto;
    }

    public void setDsProduto(String dsProduto) {
        this.dsProduto = dsProduto;
    }

    public Double getVlProduto() {
        return vlProduto;
    }

    public void setVlProduto(Double vlProduto) {
        this.vlProduto = vlProduto;
    }

    public Long getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(Long qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.cdProduto);
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
        final CadProduto other = (CadProduto) obj;
        if (!Objects.equals(this.cdProduto, other.cdProduto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CadProduto{" + "cdProduto=" + cdProduto + ", dsProduto=" + dsProduto + ", vlProduto=" + vlProduto + ", qtdEstoque=" + qtdEstoque + ", dtTransacao=" + dtTransacao + '}';
    }
    
    
}
