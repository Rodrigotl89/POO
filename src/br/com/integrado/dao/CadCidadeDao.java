package br.com.integrado.dao;

import br.com.integrado.model.CadCidade;
import br.com.integrado.tools.DataUtils;
import br.com.integrado.tools.UltimaSequencia;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author jsoliveira
 */
public class CadCidadeDao extends ConexaoOracle {

    private final StringBuilder SQL = new StringBuilder();
    private CadUfDao uDao = new CadUfDao();
    private UltimaSequencia sequencia = new UltimaSequencia();

    public void insert(CadCidade cidade) {

        try {
            cidade.setCdCidade(sequencia.getUltimaSequencia("CAD_CIDADE", "CD_CIDADE").longValue());

            SQL.setLength(0);
            SQL.append("INSERT \n");
            SQL.append("INTO CAD_CIDADE \n");
            SQL.append("  ( \n");
            SQL.append("    CD_CIDADE, \n");
            SQL.append("    CD_UF, \n");
            SQL.append("    NM_CIDADE, \n");
            SQL.append("    DT_TRANSACAO \n");
            SQL.append("  ) \n");
            SQL.append("  VALUES \n");
            SQL.append("  ( \n");
            SQL.append(cidade.getCdCidade()).append("  , \n");
            SQL.append(cidade.getUf().getCdUf()).append("  , \n");
            SQL.append("'").append(cidade.getNmCidade()).append("', \n");
            SQL.append("'").append(DataUtils.dateTimeToString(cidade.getDtTranscao())).append("' \n");
            SQL.append("  )");
            super.executeSQL(SQL.toString());

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            super.fecharCursores();
        }
    }
    public CadCidade getById(Long cdCidade) {

        try {
            SQL.setLength(0);
            SQL.append("SELECT CD_CIDADE, \n");
            SQL.append("  CD_UF, \n");
            SQL.append("  NM_CIDADE, \n");
            SQL.append("  TO_CHAR(DT_TRANSACAO,'DD/MM/YYYY HH24:MI:SS') AS DT_TRANSACAO \n");
            SQL.append("FROM CAD_CIDADE \n");
            SQL.append("WHERE CD_CIDADE=").append(cdCidade);
            super.executeSQL(SQL.toString());
            super.resultSet.first();

            CadCidade c = new CadCidade();
            c.setCdCidade(super.resultSet.getLong("CD_CIDADE"));
            c.setUf(uDao.getById(super.resultSet.getInt("CD_UF")));
            c.setNmCidade(super.resultSet.getString("NM_CIDADE"));
            c.setDtTranscao(DataUtils.stringToDateTime(super.resultSet.getString("DT_TRANSACAO")));
            return c;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            super.fecharCursores();
        }
    }
    public ResultSet getAll() {

        try {
            SQL.setLength(0);
            SQL.append("SELECT CID.CD_CIDADE, \n");
            SQL.append("  UF.NM_UF, \n");
            SQL.append("  CID.NM_CIDADE, \n");
            SQL.append("  TO_CHAR(CID.DT_TRANSACAO,'DD/MM/YYYY HH24:MI:SS') AS DT_TRANSACAO \n");
            SQL.append("FROM CAD_CIDADE CID \n");
            SQL.append("INNER JOIN CAD_UF UF \n");
            SQL.append("ON (UF.CD_UF = CID.CD_UF)\n");
            SQL.append("ORDER BY CID.CD_CIDADE");

            super.executeSQL(SQL.toString());

            return super.resultSet;

        } catch (Exception ex) {
            return null;
        }

    }
    public ResultSet getByCodigo(Long codigo) {

        try {
            SQL.setLength(0);
            SQL.append("SELECT CID.CD_CIDADE, \n");
            SQL.append("  UF.NM_UF, \n");
            SQL.append("  CID.NM_CIDADE, \n");
            SQL.append("  TO_CHAR(CID.DT_TRANSACAO,'DD/MM/YYYY HH24:MI:SS') AS DT_TRANSACAO \n");
            SQL.append("FROM CAD_CIDADE CID \n");
            SQL.append("INNER JOIN CAD_UF UF \n");
            SQL.append("ON (UF.CD_UF = CID.CD_UF)\n");
            SQL.append(" WHERE CID.CD_CIDADE =").append(codigo.toString()).append(" \n");
            SQL.append("ORDER BY CID.CD_CIDADE");

            super.executeSQL(SQL.toString());

            return super.resultSet;

        } catch (Exception ex) {
            return null;
        }

    }
    public ResultSet getByNmCidade(String nmCidade) {

        try {
            SQL.setLength(0);
            SQL.append("SELECT CID.CD_CIDADE, \n");
            SQL.append("  UF.NM_UF, \n");
            SQL.append("  CID.NM_CIDADE, \n");
            SQL.append("  TO_CHAR(CID.DT_TRANSACAO,'DD/MM/YYYY HH24:MI:SS') AS DT_TRANSACAO \n");
            SQL.append("FROM CAD_CIDADE CID \n");
            SQL.append("INNER JOIN CAD_UF UF \n");
            SQL.append("ON (UF.CD_UF = CID.CD_UF)\n");
            SQL.append(" WHERE CID.NM_CIDADE LIKE '%").append(nmCidade).append("%' \n");
            SQL.append("ORDER BY CID.CD_CIDADE");

            super.executeSQL(SQL.toString());

            return super.resultSet;

        } catch (Exception ex) {
            return null;
        }

    }
    public ResultSet getByNmUf(String nmUf) {

        try {
            SQL.setLength(0);
            SQL.append("SELECT CID.CD_CIDADE, \n");
            SQL.append("  UF.NM_UF, \n");
            SQL.append("  CID.NM_CIDADE, \n");
            SQL.append("  TO_CHAR(CID.DT_TRANSACAO,'DD/MM/YYYY HH24:MI:SS') AS DT_TRANSACAO \n");
            SQL.append("FROM CAD_CIDADE CID \n");
            SQL.append("INNER JOIN CAD_UF UF \n");
            SQL.append("ON (UF.CD_UF = CID.CD_UF)\n");
            SQL.append(" WHERE UF.NM_UF LIKE '%").append(nmUf).append("%' \n");
            SQL.append("ORDER BY CID.CD_CIDADE");

            super.executeSQL(SQL.toString());

            return super.resultSet;

        } catch (Exception ex) {
            return null;
        }

    }
    public void update(CadCidade cidade) {

        try {
            SQL.setLength(0);
            SQL.append("UPDATE CAD_CIDADE \n");
            SQL.append("SET CD_UF      =").append(cidade.getUf().getCdUf()).append(",\n");
            SQL.append("  NM_CIDADE    ='").append(cidade.getNmCidade()).append("', \n");
            SQL.append("  DT_TRANSACAO = '").append(DataUtils.dateTimeToString(cidade.getDtTranscao())).append("' \n");
            SQL.append("WHERE CD_CIDADE=").append(cidade.getCdCidade());

            super.executeUpdate(SQL.toString());

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            super.fecharCursores();
        }

    }
    public void exclurir(CadCidade cidade) {

        try {

            SQL.setLength(0);
            SQL.append("DELETE FROM CAD_CIDADE WHERE CD_CIDADE =").append(cidade.getCdCidade());
            super.executeDelete(SQL.toString());

        } catch (Exception ex) {

            ex.printStackTrace();

        } finally {
            fecharCursores();
        }

    }
    public static void main(String[] args) {
        CadUfDao ufDao = new CadUfDao();
        CadCidadeDao cDao = new CadCidadeDao();

//        CadCidade cidade = new CadCidade();
//        cidade.setCdCidade(Long.valueOf("1"));
//        cidade.setUf(ufDao.getById(1));
//        cidade.setNmCidade("Campo Mourão");
//        cidade.setDtTranscao(DataUtils.stringToDateTime("18/02/1988 23:59:54"));
//
//        cDao.insert(cidade);
        CadCidade c = cDao.getById(Long.valueOf("1"));
        c.setUf(ufDao.getById(2));
        c.setNmCidade("MARINGA");
        c.setDtTranscao(DataUtils.stringToDateTime("08/04/2017 22:25:00"));

        cDao.update(c);

    }

}
