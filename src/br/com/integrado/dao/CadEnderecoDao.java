
package br.com.integrado.dao;

import br.com.integrado.model.CadEndereco;
import br.com.integrado.tools.UltimaSequencia;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author rodrigo.lucena
 */
public class CadEnderecoDao extends ConexaoOracle {

    private StringBuilder SQL = new StringBuilder();
    private UltimaSequencia fimSeq = new UltimaSequencia();
    private CadCidadeDao cidDao = new CadCidadeDao();
    private CadClienteDao cliDao = new CadClienteDao();

    public void inserir(CadEndereco endereco) {
        try {
            SQL.setLength(0);
            SQL.append("INSERT INTO CAD_ENDERECO(CD_ENDERECO, CD_CLIENTE, CD_CIDADE, DS_LOGRADOURO, DS_CEP, DS_BAIRRO, DT_TRANSACAO)\n");
            SQL.append("VALUES(?,?,?,?,?,?,?)");

            PreparedStatement ps = super.getConexao().prepareStatement(SQL.toString());
            ps.setInt(1, endereco.getCdEndereco());
            ps.setInt(2, endereco.getCliente().getCdCliente());
            ps.setLong(3, endereco.getCidade().getCdCidade());
            ps.setString(4, endereco.getDsLogradouro());
            ps.setString(5, endereco.getCep());
            ps.setString(6, endereco.getBairro());
            ps.setDate(7, new Date(endereco.getDtTransacao().getTime()));

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            super.fecharCursores();
        }

    }

    public void excluir(CadEndereco endereco) {
        PreparedStatement ps = null;
        try {
            SQL.setLength(0);
            SQL.append("DELETE FROM CAR_ENDERECO WHERE CD_ENDERECO = ? AND CD_CLIENTE = ?");
            ps = super.getConexao().prepareStatement(SQL.toString());
            ps.setInt(1, endereco.getCdEndereco());
            ps.setInt(2, endereco.getCliente().getCdCliente());
            ps.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            super.fecharCursores(ps);
        }
    }

    public void excluirPorCliente(CadEndereco endereco) {
        PreparedStatement ps = null;
        try {
            SQL.setLength(0);
            SQL.append("DELETE FROM CAR_ENDERECO WHERE CD_CLIENTE = ?");
            ps = super.getConexao().prepareStatement(SQL.toString());
            ps.setInt(1, endereco.getCliente().getCdCliente());
            ps.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            super.fecharCursores(ps);
        }
    }

    public CadEndereco getEndereco(Integer codEnd, Integer codCliente) {

        try {
            SQL.setLength(0);
            SQL.append("SELECT * FROM CAD_ENDERECO  ");
            SQL.append("WHERE CD_ENDERECO AND CD_CLIENTE =").append(codEnd).append(codCliente);

            super.executeSQL(SQL.toString());
            super.resultSet.first();

            CadEndereco e = new CadEndereco();
            e.setCdEndereco(super.resultSet.getInt(1));
            e.setCliente(cliDao.getById(super.resultSet.getInt(2)));
            e.setCidade(cidDao.getById(super.resultSet.getLong(3)));
            e.setDsLogradouro(super.resultSet.getString(4));
            e.setCep(super.resultSet.getString(5));
            e.setBairro(super.resultSet.getString(6));
            e.setDtTransacao(new java.util.Date(super.resultSet.getDate(7).getTime()));

            return e;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fecharCursores();
        }
        return null;

    }

    public List<CadEndereco> listaEnderecosPorCliente(Integer codCliente) {
        try {
            SQL.setLength(0);
            SQL.append("SELECT * FROM CAD_ENDERECO  ");
            SQL.append("WHERE CD_CLIENTE =").append(codCliente);

            super.executeSQL(SQL.toString());
            List<CadEndereco> list = new ArrayList<>();
            while (super.resultSet.next()) {
                CadEndereco e = new CadEndereco();
                e.setCdEndereco(super.resultSet.getInt(1));
                e.setCliente(cliDao.getById(super.resultSet.getInt(2)));
                e.setCidade(cidDao.getById(super.resultSet.getLong(3)));
                e.setDsLogradouro(super.resultSet.getString(4));
                e.setCep(super.resultSet.getString(5));
                e.setBairro(super.resultSet.getString(6));
                e.setDtTransacao(new java.util.Date(super.resultSet.getDate(7).getTime()));

                list.add(e);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            super.fecharCursores();
        }
        return null;
        

    }

    public ResultSet resultadoEnderecosPorCliente (Integer codCliente){
        try {
            SQL.setLength(0);
            SQL.append("SELECT E.CD_ENDERECO, C.NM_CIDADE, E.DS_LOGRADOUR, E.DS_CEP, E.DS_BAIRRO, \n");
            SQL.append("TO_CHAR(E.DT_TRANSACAO, 'DD/MM/YYYY' \n");
            SQL.append("FROM CAD_ENDERECO E\n");
            SQL.append("INNER JOIN CAD_CIDADE C ON (C.CD_CIDADE=E.CD_CIDADE)\n");
            SQL.append("WHERE E.CD_CLIENTE = ").append(codCliente);
            
            super.executeSQL(SQL.toString());
            
            return super.resultSet;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            super.fecharCursores();
        }
        return null;
    }
}
