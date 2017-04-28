/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.integrado.dao;

import br.com.integrado.model.CadContato;
import br.com.integrado.tools.UltimaSequencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import jdk.nashorn.internal.ir.TryNode;

/**
 *
 * @author Rodrigo
 */
public class CadContatoDao extends ConexaoOracle {

    StringBuilder SQL = new StringBuilder(); //Torna as strings mutáveis, o append é utilizado para inserir novas Strings
    //StringBuilder aloca espaço conforme  as concatenações.
    private final CadClienteDao clienteDao = new CadClienteDao();//conferir
    UltimaSequencia sequencia = new UltimaSequencia();

    public void inserir(CadContato contato) {
        try {
            //contato.setCdContato(sequencia.getUltimaSequencia("CAD_CONTATO", "CD_CONTATO"));
            SQL.setLength(0);
            SQL.append("INSERT INTO CAD_CONTATO (CD_CONTATO,CD_CLIENTE,NR_TELEFONE,DS_EMAIL) \n");
            SQL.append("VALUES (?,?,?,?,?)\n");
            PreparedStatement ps = super.getConexao().prepareStatement(SQL.toString());
            ps.setInt(1, contato.getCdContato());
            ps.setInt(2, contato.getCdCliente().getCdCliente());
            ps.setString(3, contato.getNrTelefone());
            ps.setString(4, contato.getDsEmail());

            //super.executeSQL(SQL.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            super.fecharCursores();
        }
    }

    public void excluir(CadContato contato) {

        try {

            SQL.setLength(0);
            SQL.append("DELETE FROM CAD_CONTATO WHERE CD_CONTATO =").append(contato.getCdContato());
            super.executeDelete(SQL.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            super.fecharCursores();
        }
    }

    public void alterar(CadContato contato) {
        try {
            SQL.setLength(0);
            SQL.append("UPDATE CAD_CONTATO \n");
            SQL.append("SET CD_CONTATO = '").append(contato.getCdContato()).append("', \n");
            //SQL.append("SET CD_CLIENTE = '").append(contato.getCdCliente()).append("', \n");
            SQL.append(" NR_TELEFONE = '").append(contato.getNrTelefone()).append("' , \n");
            SQL.append(" DS_EMAIL= '").append(contato.getDsEmail()).append("', \n");
            SQL.append(" WHERE CD_CONTATO =").append(contato.getCdContato());
            super.executeUpdate(SQL.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            super.fecharCursores();
        }
    }

    public CadContato getById(Integer codContato) {
        try {
            SQL.setLength(0);
            SQL.append("SELECT * FROM CAD_CONTATO \n");
            SQL.append("WHERE CD_CONTATO =").append(codContato);
            super.executeSQL(SQL.toString());
            super.resultSet.first();

            CadContato contato = new CadContato();
            contato.setCdContato(super.resultSet.getInt("CD_CONTATO"));
            contato.setCdCliente(clienteDao.getById(super.resultSet.getInt("CD_CLIENTE")));
            contato.setDsEmail(super.resultSet.getString("DS_EMAIL"));
            contato.setNrTelefone(super.resultSet.getString("NR_TELEFONE"));

            return contato;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            super.fecharCursores();
        }
        return null;

    }

    public List<CadContato> getAll() {
        try {
            SQL.setLength(0);
            SQL.append("SELECT * FROM CAD_CONTATO ORDER BY CD_CONTATO \n");

            List<CadContato> listar = new ArrayList<>();
            while (super.resultSet.next()) {
                CadContato contato = new CadContato();
                contato.setCdContato(super.resultSet.getInt("CD_CONTATO"));
                //contato.setCdCliente(clienteDao.getAll(super.resultSet.getInt("CD_CLIENTE")));
                contato.setCdCliente(clienteDao.getById(super.resultSet.getInt("CD_CLIENTE")));
                contato.setNrTelefone(super.resultSet.getString("NR_TELEFONE"));
                contato.setDsEmail(super.resultSet.getString("DS_EMAIL"));

                listar.add(contato);
            }
            super.executeSQL(SQL.toString());
            return listar;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet buscarTodos() {
        try {
            SQL.setLength(0);
            SQL.append("SELECT * FROM CAD_CONTATO");
            super.executeSQL(SQL.toString());

            return super.resultSet;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet buscarPorCodigoContato(Integer cod) {
        try {
            SQL.setLength(0);
            SQL.append("SELECT * FROM CAD_CONTATO WHERE CD_CONTATO");
            super.executeSQL(SQL.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet buscarPorCodigoCliente(Integer cod) {
        try {
            SQL.setLength(0);
            SQL.append("SELECT * FROM CAD_CONTATO WHERE CD_CLIENTE").append(cod);
            super.executeSQL(SQL.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet buscarPorTelefone(String nrTel) {
        try {
            SQL.setLength(0);
            SQL.append("SELECT * FROM CAD_CONTATO WHERE NR_TELEFONE").append(nrTel);
            super.executeSQL(SQL.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet buscarPorEmail(Integer email) {
        try {
            SQL.setLength(0);
            SQL.append("SELECT * FROM CAD_CONTATO WHERE DS_EMAIL %'").append(email).append("%'");
            super.executeSQL(SQL.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
