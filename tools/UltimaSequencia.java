package br.com.integrado.tools;

import br.com.integrado.dao.ConexaoOracle;
import java.sql.SQLException;

/**
 *
 * @author jsoliveira
 */
public class UltimaSequencia extends ConexaoOracle {

    private final StringBuilder SQL = new StringBuilder();

    public Integer getUltimaSequencia(String tabela, String nomeColuna) {

        try {
            SQL.setLength(0);
            SQL.append("SELECT COALESCE(MAX(").append(nomeColuna).append("),0)+1 FROM ").append(tabela);
            super.executeSQL(SQL.toString());
            super.resultSet.first();
            return super.resultSet.getInt(1);

        } catch (SQLException ex) {
            ex.printStackTrace();

            return -1;
        } finally {
            super.fecharCursores();
        }

    }

    public static void main(String[] args) {

        
        UltimaSequencia u = new UltimaSequencia();
        System.out.println(u.getUltimaSequencia("CAD_CIDADE","CD_CIDADE"));
        System.out.println(u.getUltimaSequencia("CAD_UF","CD_UF"));
    }

}
