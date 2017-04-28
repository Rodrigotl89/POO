
package br.com.integrado.model;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author rodrigo.lucena
 */
public class CadEndereco {
    private Integer cdEndereco;
    private CadCliente cliente;
    private CadCidade cidade;
    private String dsLogradouro;
    private String cep;
    private String bairro;
    private Date dtTransacao;

    public CadEndereco() {
    }

    public CadEndereco(Integer cdEndereco, CadCliente cliente, CadCidade cidade, String dsLogradouro, String cep, String bairro, Date dtTransacao) {
        this.cdEndereco = cdEndereco;
        this.cliente = cliente;
        this.cidade = cidade;
        this.dsLogradouro = dsLogradouro;
        this.cep = cep;
        this.bairro = bairro;
        this.dtTransacao = dtTransacao;
    }

    public Integer getCdEndereco() {
        return cdEndereco;
    }

    public void setCdEndereco(Integer cdEndereco) {
        this.cdEndereco = cdEndereco;
    }

    public CadCliente getCliente() {
        return cliente;
    }

    public void setCliente(CadCliente cliente) {
        this.cliente = cliente;
    }

    public CadCidade getCidade() {
        return cidade;
    }

    public void setCidade(CadCidade cidade) {
        this.cidade = cidade;
    }

    public String getDsLogradouro() {
        return dsLogradouro;
    }

    public void setDsLogradouro(String dsLogradouro) {
        this.dsLogradouro = dsLogradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
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
        hash = 17 * hash + Objects.hashCode(this.cdEndereco);
        hash = 17 * hash + Objects.hashCode(this.cliente);
        hash = 17 * hash + Objects.hashCode(this.cidade);
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
        final CadEndereco other = (CadEndereco) obj;
        if (!Objects.equals(this.cdEndereco, other.cdEndereco)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CadEndereco{" + "cdEndereco=" + cdEndereco + ", cliente=" + cliente + ", cidade=" + cidade + ", dsLogradouro=" + dsLogradouro + ", cep=" + cep + ", bairro=" + bairro + ", dtTransacao=" + dtTransacao + '}';
    }

   
}
