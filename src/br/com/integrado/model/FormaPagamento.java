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
public class FormaPagamento {

    private Long cdForma;
    private String dsFormaPagamento;
    private String inAtivo;
    private Long qtDiasIntervalo;

    public FormaPagamento() {
    }

    public FormaPagamento(Long cdForma, String dsFormaPagamento, String inAtivo, Long qtDiasIntervalo) {
        this.cdForma = cdForma;
        this.dsFormaPagamento = dsFormaPagamento;
        this.inAtivo = inAtivo;
        this.qtDiasIntervalo = qtDiasIntervalo;
    }

    public Long getQtDiasIntervalo() {
        return qtDiasIntervalo;
    }

    public void setQtDiasIntervalo(Long qtDiasIntervalo) {
        this.qtDiasIntervalo = qtDiasIntervalo;
    }

    public Long getCdForma() {
        return cdForma;
    }

    public void setCdForma(Long cdForma) {
        this.cdForma = cdForma;
    }

    public String getDsFormaPagamento() {
        return dsFormaPagamento;
    }

    public void setDsFormaPagamento(String dsFormaPagamento) {
        this.dsFormaPagamento = dsFormaPagamento;
    }

    public String getInAtivo() {
        return inAtivo;
    }

    public void setInAtivo(String inAtivo) {
        this.inAtivo = inAtivo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.cdForma);
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
        final FormaPagamento other = (FormaPagamento) obj;
        if (!Objects.equals(this.cdForma, other.cdForma)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FormaPagamento{" + "cdForma=" + cdForma + ", dsFormaPagamento=" + dsFormaPagamento + ", inAtivo=" + inAtivo + ", qtDiasIntervalo=" + qtDiasIntervalo + '}';
    }

}
