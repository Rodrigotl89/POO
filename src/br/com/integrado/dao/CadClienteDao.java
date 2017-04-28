package br.com.integrado.dao;

import br.com.integrado.model.CadCliente;
import br.com.integrado.tools.DataUtils;
import br.com.integrado.tools.UltimaSequencia;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodrigo.lucena
 */
public class CadClienteDao extends ConexaoOracle {

    private StringBuilder SQL = new StringBuilder();
    private UltimaSequencia sequencia = new UltimaSequencia();

    public void inserir(CadCliente cliente) {
        try {
            SQL.setLength(0);
            SQL.append("INSERT INTO CAD_CLIENTE (CD_CLIENTE, NM_CLIENTE, NR_CPF, NR_RG, DT_NASCIMENTO) VALUES (?, ?, ?, ?, ?)");
            PreparedStatement ps = super.getConexao().prepareStatement(SQL.toString());
            ps.setInt(1, cliente.getCdCliente());
            cliente.setCpf((cliente.getCpf().replaceAll(".", "")));
            cliente.setCpf((cliente.getCpf().replace("-", "")));
            ps.setString(2, cliente.getNmCliente());
            ps.setString(3, cliente.getCpf());
            ps.setString(4, cliente.getRg());
            ps.setDate(5, new Date(cliente.getDtNascimento().getTime()));

            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void excluir(CadCliente cliente) {
        try {

            SQL.setLength(0);
            SQL.append("DELETE FROM CAD_CLIENTE WHERE CD_CLIENTE =").append(cliente.getCdCliente());
            super.executeDelete(SQL.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            super.fecharCursores();
        }
    }

    public void alterar(CadCliente cliente) {

        try {
            SQL.setLength(0);
            SQL.append("UPDATE CAD_CLIENTE SET CD_CLIENTE = ?, NM_CLIENTE = ?, NR_CPF = ?, NR_RG = ?, DT_NASCIMENTO = ?");
            PreparedStatement ps = super.getConexao().prepareStatement(SQL.toString());
            ps.setInt(1, cliente.getCdCliente());
            cliente.setCpf((cliente.getCpf().replaceAll(".", "")));
            cliente.setCpf((cliente.getCpf().replace("-", "")));
            ps.setString(2, cliente.getNmCliente());
            ps.setString(3, cliente.getCpf());
            ps.setString(4, cliente.getRg());
            ps.setDate(5, new Date(cliente.getDtNascimento().getTime()));

            ps.execute();

            /**
             * SQL.append("UPDATE CAD_CLIENTE\n"); SQL.append("SET CD_CLIENTE =
             * \n").append(cliente.getCdCliente()); SQL.append("SET NM_CLIENTE =
             * \n").append(cliente.getNmCliente()); SQL.append("SET NR_CPF =
             * \n").append(cliente.getCpf()); SQL.append("SET NR_RG =
             * \n").append(cliente.getRg()); SQL.append("SET DT_NASCIMENTO =
             * \n").append(DataUtils.dateTimeToString(cliente.getDtNascimento()));
             * SQL.append("WHERE CD_CLIENTE =
             * \n").append(cliente.getCdCliente());
             *
             * super.executeUpdate(SQL.toString());
             */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CadCliente getById(Integer cdCliente) {
        try {
            SQL.setLength(0);
            SQL.append("SELECT CD_CLIENTE, NM_CLIENTE, \n");
            SQL.append("NR_CPF, NR_RG, \n");
            SQL.append("DT_NASCIMENTO\n");
            SQL.append("FROM CAD_CLIENTE\n");
            SQL.append("WHERE CD_CLIENTE = ").append(cdCliente);
            super.executeSQL(SQL.toString());
            super.resultSet.first();

            CadCliente cliente = new CadCliente();
            cliente.setCdCliente(super.resultSet.getInt("CD_CLIENTE"));
            cliente.setNmCliente(super.resultSet.getString("NM_CLIENTE"));
            cliente.setCpf(super.resultSet.getString("NR_CPF"));
            cliente.setRg(super.resultSet.getString("NR_RG"));
            cliente.setDtNascimento(DataUtils.stringToDateTime(super.resultSet.getString("DT_NASCIMENTO")));

            return cliente;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            super.fecharCursores();
        }

    }

    public List<CadCliente> getAll(Integer cliente) {
        try {
            SQL.setLength(0);
            SQL.append("SELECT * FROM CAD_CLIENTE WHERE CD_CLIENTE = ?");
            super.executeSQL(SQL.toString());
            super.resultSet.first();
            
            List<CadCliente> list = new ArrayList<>();
            while (super.resultSet.next()) {

                CadCliente c = new CadCliente();
                c.setCdCliente(super.resultSet.getInt("CD_CLIENTE"));
                c.setNmCliente(super.resultSet.getString("NM_CLIENTE"));
                c.setCpf(super.resultSet.getString("NR_CPF"));
                c.setRg(super.resultSet.getString("NR_RG"));
                c.setDtNascimento(DataUtils.stringToDateTime(super.resultSet.getString("DT_NASCIMENTO")));
                list.add(c);
            }
            super.executeSQL(SQL.toString());
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            super.fecharCursores();
        }

    }

    public ResultSet buscarTodos() {
        try {
            SQL.setLength(0);
            SQL.append("SELECT * FROM CAD_CLIENTE");
            super.executeSQL(SQL.toString());

            return super.resultSet;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet buscaPorCodigo(Integer cod) {
        try {
            SQL.setLength(0);
            SQL.append("SELECT * FROM CAD_CLIENTE WHERE CD_CLIENTE = ").append(cod);
            super.executeSQL(SQL.toString());
            return super.resultSet;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public ResultSet buscaPorNome(String nome) {
        try {
            SQL.setLength(0);
            SQL.append("SELECT * FROM CAD_CLIENTE WHERE NM_CLIENTE = '%").append(nome).append("%'");
            super.executeSQL(SQL.toString());
            return super.resultSet;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public ResultSet buscaPorCpf(String cpf) {

        try {
            SQL.setLength(0);
            SQL.append("SELECT * FROM CAD_CLIENTE WHERE NR_CPF = ").append(cpf);
            super.executeSQL(SQL.toString());
            return super.resultSet;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet buscaPorRg(String rg) {

        try {
            SQL.setLength(0);
            SQL.append("SELECT * FROM CAD_CLIENTE WHERE NR_RG = ").append(rg);
            super.executeSQL(SQL.toString());
            return super.resultSet;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
