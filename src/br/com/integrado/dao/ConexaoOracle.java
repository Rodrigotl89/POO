package br.com.integrado.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jsoliveira
 */
public abstract class ConexaoOracle {

    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USUARIO = "POO";
    private static final String SENHA = "POO";
    private static Connection conexao;
    public ResultSet resultSet;
    // ResultSet Representa o conjunto de resultados de uma tabela do banco de dados
    public Statement statement;

    public ConexaoOracle() {

        conectar();
    }
    

    private static void conectar() {

        try {

            if (conexao == null || conexao.isClosed()) {

                conexao = DriverManager.getConnection(URL, USUARIO, SENHA);

                System.out.println("Conexao efetuada com sucesso!!!");
            } else {
                System.out.println("Conexao recuperada com sucesso!");
            }

        } catch (SQLException ex) {

            ex.printStackTrace();
            System.out.println("Erro ao conectar !!!" + ex);
        }

    }

    public static void desconectar() {

        try {
            if (conexao != null) {

                conexao.close();
                System.out.println("Conexao fechada com sucesso!!!!");
            } else {
                System.out.println("Não existe conexão");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void executeSQL(String sql) {

        try {

            statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            resultSet = statement.executeQuery(sql);

        } catch (SQLException ex) {

            ex.printStackTrace();
            resultSet = null;
        }

    }

    public void executeUpdate(String update) {

        try {

            statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            statement.executeUpdate(update);

        } catch (SQLException ex) {

            ex.printStackTrace();
            resultSet = null;
        }

    }

    public void executeDelete(String delete) {

        try {

            statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            statement.executeUpdate(delete);

        } catch (SQLException ex) {

            ex.printStackTrace();
            resultSet = null;
        }

    }

    public void fecharCursores() {

        try {

            if (resultSet != null) {

                resultSet.close();
            }

            if (statement != null) {

                statement.close();
            }
            

        } catch (Exception ex) {
        }

    }
      public void fecharCursores(PreparedStatement ps) {

        try {

            if (resultSet != null) {

                resultSet.close();
            }

            if (statement != null) {

                statement.close();
            }
            if (ps != null) {
                ps.close();
            }
            

        } catch (Exception ex) {
        }

    }

    

    public static Connection getConexao() {
        return conexao;
    }


}
