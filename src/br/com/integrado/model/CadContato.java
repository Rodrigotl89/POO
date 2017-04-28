
package br.com.integrado.model;

import java.util.Objects;

/**
 *
 * @author rodrigo.lucena
 */
public class CadContato {
    private Integer cdContato;
    private CadCliente cdCliente;
    private String nrTelefone;
    private String dsEmail;

    public CadContato() {
    }

    public CadContato(Integer cdContato, CadCliente cdCliente, String nrTelefone, String dsEmail) {
        this.cdContato = cdContato;
        this.cdCliente = cdCliente;
        this.nrTelefone = nrTelefone;
        this.dsEmail = dsEmail;
    }

    public Integer getCdContato() {
        return cdContato;
    }

    public void setCdContato(Integer cdContato) {
        this.cdContato = cdContato;
    }

    public CadCliente getCdCliente() {
        return cdCliente;
    }

    public void setCdCliente(CadCliente cdCliente) {
        this.cdCliente = cdCliente;
    }

    public String getNrTelefone() {
        return nrTelefone;
    }

    public void setNrTelefone(String nrTelefone) {
        this.nrTelefone = nrTelefone;
    }

    public String getDsEmail() {
        return dsEmail;
    }

    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.cdContato);
        hash = 67 * hash + Objects.hashCode(this.cdCliente);
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
        final CadContato other = (CadContato) obj;
        if (!Objects.equals(this.cdContato, other.cdContato)) {
            return false;
        }
        if (!Objects.equals(this.cdCliente, other.cdCliente)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CadContato{" + "cdContato=" + cdContato + ", cdCliente=" + cdCliente + ", nrTelefone=" + nrTelefone + ", dsEmail=" + dsEmail + '}';
    }
    
    }
