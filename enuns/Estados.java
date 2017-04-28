package br.com.integrado.enuns;

/**
 *
 * @author jsoliveira
 */
public enum Estados {
    
    padrao(0),insercao(1),alteracao(2);
    
    private Integer estado;

    private Estados(Integer estado) {
        this.estado = estado;
    }

    public static Estados getPadrao() {
        return padrao;
    }

    public static Estados getInsercao() {
        return insercao;
    }

    public static Estados getAlteracao() {
        return alteracao;
    }

    public Integer getEstado() {
        return estado;
    }
    
    
    
    
    
}
