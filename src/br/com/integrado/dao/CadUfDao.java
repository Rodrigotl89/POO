package br.com.integrado.dao;

import br.com.integrado.model.CadUf;
import br.com.integrado.tools.DataUtils;
import br.com.integrado.tools.UltimaSequencia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jsoliveira
 */
public class CadUfDao extends ConexaoOracle {

    private final StringBuffer SQL = new StringBuffer();
    UltimaSequencia sequencia = new UltimaSequencia();

    public CadUf getById(Integer cdUf) {

        try {
            super.executeSQL("SELECT CD_UF,SG_UF,NM_UF,DT_TRANSACAO FROM CAD_UF WHERE CD_UF = " + cdUf);
            super.resultSet.first();
            CadUf ret = new CadUf();
            ret.setCdUf(super.resultSet.getInt("CD_UF"));
            ret.setSgUf(super.resultSet.getString("SG_UF"));
            ret.setNmUf(super.resultSet.getString("NM_UF"));
            ret.setDtTransacao(new java.util.Date(
                    super.resultSet.getTimestamp("DT_TRANSACAO").getTime()));

            return ret;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {

            super.fecharCursores();
        }

    }

    public List<CadUf> getAll() {

        try {
            super.executeSQL("SELECT CD_UF,SG_UF,NM_UF,DT_TRANSACAO FROM CAD_UF ORDER BY CD_UF ");
            List<CadUf> ret = new ArrayList<>();
            while (super.resultSet.next()) {
                CadUf uf = new CadUf();
                uf.setCdUf(super.resultSet.getInt("CD_UF"));
                uf.setSgUf(super.resultSet.getString("SG_UF"));
                uf.setNmUf(super.resultSet.getString("NM_UF"));
                uf.setDtTransacao(new java.util.Date(
                        super.resultSet.getTimestamp("DT_TRANSACAO").getTime()));
                ret.add(uf);
            }

            return ret;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {

            super.fecharCursores();
        }

    }

    public void inserir(CadUf uf) {
        try {
            uf.setCdUf(sequencia.getUltimaSequencia("CAD_UF", "CD_UF"));

            SQL.setLength(0);
            SQL.append("INSERT INTO CAD_UF (CD_UF,SG_UF,NM_UF,DT_TRANSACAO) VALUES (");
            SQL.append(uf.getCdUf()).append(",");
            SQL.append("'").append(uf.getSgUf()).append("',");
            SQL.append("'").append(uf.getNmUf()).append("',");
            SQL.append("SYSDATE)");
            System.out.println(SQL);
            super.executeSQL(SQL.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            fecharCursores();
        }
    }

    public void delete(CadUf uf) {

        try {
            SQL.setLength(0);
            SQL.append("DELETE FROM CAD_UF WHERE CD_UF =").append(uf.getCdUf());

            super.executeDelete(SQL.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            fecharCursores();
        }

    }

    public void update(CadUf uf) {
        try {
            SQL.setLength(0);
            SQL.append("UPDATE CAD_UF \n");
            SQL.append("SET CD_UF      =").append(uf.getCdUf()).append(",\n");
            SQL.append("  SG_UF    ='").append(uf.getSgUf()).append(",\n");
            SQL.append("  NM_UF    ='").append(uf.getNmUf()).append(",\n");
            SQL.append("  DT_TRANSACAO = '").append(DataUtils.dateTimeToString(uf.getDtTransacao())).append("' \n");
            SQL.append("WHERE CD_UF=").append(uf.getCdUf());

            super.executeUpdate(SQL.toString());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ResultSet buscarTodos() {

        try {

            SQL.setLength(0);
            SQL.append("SELECT CD_UF,NM_UF,SG_UF FROM CAD_UF");
            super.executeSQL(SQL.toString());

            return super.resultSet;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public ResultSet buscarPorCodigo(Integer codigo) {

        try {

            SQL.setLength(0);
            SQL.append("SELECT CD_UF,NM_UF,SG_UF FROM CAD_UF WHERE CD_UF=").append(codigo);
            super.executeSQL(SQL.toString());

            return super.resultSet;
        } catch (Exception ex) {

            return null;
        }

    }

    public ResultSet buscarPorNome(String nome) {

        try {

            SQL.setLength(0);
            SQL.append("SELECT CD_UF,NM_UF,SG_UF FROM CAD_UF WHERE NM_UF LIKE '%").append(nome).append("%'");
            super.executeSQL(SQL.toString());

            return super.resultSet;
        } catch (Exception ex) {

            return null;
        }

    }

    public ResultSet buscarPorSigla(String sigla) {

        try {

            SQL.setLength(0);
            SQL.append("SELECT CD_UF,NM_UF,SG_UF FROM CAD_UF WHERE SG_UF LIKE '%").append(sigla).append("%'");
            super.executeSQL(SQL.toString());

            return super.resultSet;
        } catch (Exception ex) {

            return null;
        }

    }

    public static void main(String[] args) {

        CadUfDao ufDao = new CadUfDao();

        CadUf uf = new CadUf();
        uf.setCdUf(4);
        uf.setSgUf("RR");
        uf.setNmUf("RORAIMA");
        uf.setDtTransacao(new Date());

        ufDao.inserir(uf);
        ufDao.delete(uf);

        System.out.println(ufDao.getAll());

        ufDao.desconectar();

    }

}
