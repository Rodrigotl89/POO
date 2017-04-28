/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.integrado.model;

import java.util.Objects;

/**
 *
 * @author rodrigo.lucena
 */
public class MovItensVenda {

    MovVenda venda;
    CadProduto produto;

    public MovItensVenda() {
    }

    public MovItensVenda(MovVenda venda, CadProduto produto) {
        this.venda = venda;
        this.produto = produto;
    }

    public MovVenda getVenda() {
        return venda;
    }

    public void setVenda(MovVenda venda) {
        this.venda = venda;
    }

    public CadProduto getProduto() {
        return produto;
    }

    public void setProduto(CadProduto produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.venda);
        hash = 79 * hash + Objects.hashCode(this.produto);
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
        final MovItensVenda other = (MovItensVenda) obj;
        if (!Objects.equals(this.venda, other.venda)) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MovItensVenda{" + "venda=" + venda + ", produto=" + produto + '}';
    }

}
