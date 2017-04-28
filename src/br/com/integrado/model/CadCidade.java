package br.com.integrado.model;

import br.com.integrado.dao.CadUfDao;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author jsoliveira
 */
public class CadCidade {
    
    private Long cdCidade;
    private CadUf uf;
    private String nmCidade;
    private Date dtTranscao;

    public CadCidade() {
    }

    public CadCidade(Long cdCidade, CadUf uf, String nmCidade, Date dtTranscao) {
        this.cdCidade = cdCidade;
        this.uf = uf;
        this.nmCidade = nmCidade;
        this.dtTranscao = dtTranscao;
    }

    public Long getCdCidade() {
        return cdCidade;
    }

    public void setCdCidade(Long cdCidade) {
        this.cdCidade = cdCidade;
    }

    public CadUf getUf() {
        return uf;
    }

    public void setUf(CadUf uf) {
        this.uf = uf;
    }

    public String getNmCidade() {
        return nmCidade;
    }

    public void setNmCidade(String nmCidade) {
        this.nmCidade = nmCidade;
    }

    public Date getDtTranscao() {
        return dtTranscao;
    }

    public void setDtTranscao(Date dtTranscao) {
        this.dtTranscao = dtTranscao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.cdCidade);
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
        final CadCidade other = (CadCidade) obj;
        if (!Objects.equals(this.cdCidade, other.cdCidade)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CadCidade{" + "cdCidade=" + cdCidade + ", uf=" + uf + ", nmCidade=" + nmCidade + ", dtTranscao=" + dtTranscao + '}';
    }
    
    
  
}
