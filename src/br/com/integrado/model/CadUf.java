package br.com.integrado.model;

import java.util.Date;
import java.util.Objects;
/**
 *
 * @author jsoliveira
 */
public class CadUf {
    
    
    private Integer cdUf;
    private String sgUf;
    private String nmUf;
    private Date dtTransacao;

    public CadUf() {
    }

    public CadUf(Integer cdUf, String sgUf, String nmUf, Date dtTransacao) {
        this.cdUf = cdUf;
        this.sgUf = sgUf;
        this.nmUf = nmUf;
        this.dtTransacao = dtTransacao;
    }    

    public Integer getCdUf() {
        return cdUf;
    }

    public void setCdUf(Integer cdUf) {
        this.cdUf = cdUf;
    }

    public String getSgUf() {
        return sgUf;
    }

    public void setSgUf(String sgUf) {
        this.sgUf = sgUf;
    }

    public String getNmUf() {
        return nmUf;
    }

    public void setNmUf(String nmUf) {
        this.nmUf = nmUf;
    }

    public Date getDtTransacao() {
        return dtTransacao;
    }

    public void setDtTransacao(Date dtTransacao) {
        this.dtTransacao = dtTransacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.cdUf);
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
        final CadUf other = (CadUf) obj;
        if (!Objects.equals(this.cdUf, other.cdUf)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CadUf{" + "cdUf=" + cdUf + ", sgUf=" + sgUf + ", nmUf=" + nmUf + ", dtTransacao=" + dtTransacao + '}';
    }


    
    
    
    }

   

