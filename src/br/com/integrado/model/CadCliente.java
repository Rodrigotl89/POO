
package br.com.integrado.model;

import java.util.Date;
import java.util.Objects;
/**
 *
 * @author rodrigo.lucena
 */
public class CadCliente {
    private Integer cdCliente;
    private String nmCliente;
    private String cpf;
    private String rg;
    private Date dtNascimento;

    public CadCliente() {
    }

    public CadCliente(Integer cdCliente, String nmCliente, String cpf, String rg, Date dtNascimento) {
        this.cdCliente = cdCliente;
        this.nmCliente = nmCliente;
        this.cpf = cpf;
        this.rg = rg;
        this.dtNascimento = dtNascimento;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public Integer getCdCliente() {
        return cdCliente;
    }

    public void setCdCliente(Integer cdCliente) {
        this.cdCliente = cdCliente;
    }

    public String getNmCliente() {
        return nmCliente;
    }

    public void setNmCliente(String nmCliente) {
        this.nmCliente = nmCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.cdCliente);
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
        final CadCliente other = (CadCliente) obj;
        if (!Objects.equals(this.cdCliente, other.cdCliente)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CadCliente{" + "cdCliente=" + cdCliente + ", nmCliente=" + nmCliente + ", cpf=" + cpf + ", rg=" + rg + ", dtNascimento=" + dtNascimento + '}';
    }
    
    
    
}
