package br.com.integrado.tools;

import br.com.integrado.dao.ConexaoOracle;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jsoliveira
 */
public class jTableUtils {


    
    
    public static void preencherJtable(JTable table, ResultSet r, List<String> campos) {

        try {

            DefaultTableModel model = (DefaultTableModel) table.getModel();

            model.setNumRows(0);

            while (r.next()) {

                Object[] row = new Object[campos.size()];
                int contador = 0;
                for (String s : campos) {

                    row[contador] = r.getString(s);
                    contador++;
                }
                model.addRow(row);

            }

        } catch (Exception ex) {

        }

    }

    public static void formatarJtable(JTable tabela, int valores[]) {

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);

        if (modelo.getColumnCount() == valores.length) {
            for (int x = 0; x < valores.length; x++) {
                tabela.getColumnModel().getColumn(x).setPreferredWidth(valores[x]);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Favor verificar os parametros passados !");
        }
    }

    public static void limparJtable(JTable table) {

        try {

            DefaultTableModel model = (DefaultTableModel) table.getModel();

            model.setNumRows(0);

        } catch (Exception ex) {

        }

    }

}
