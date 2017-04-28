package br.com.integrado.dao;

import br.com.integrado.model.CadUf;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jsoliveira
 */
public class UfDao extends ConexaoOracle {

    private StringBuffer SQL = new StringBuffer();

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
            SQL.append("DELETE FROM CAD_UF WHERE CD_UF =" + uf.getCdUf());

            super.executeDelete(SQL.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            fecharCursores();
        }

    }

    public static void main(String[] args) {

        UfDao ufDao = new UfDao();

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
