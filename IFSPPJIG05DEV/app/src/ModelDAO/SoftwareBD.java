package ModelDAO;

import java.sql.*;

public class SoftwareBD {
    static String listaSoftware[];

    public String[] getlistaSoftware() {
        return listaSoftware;
    }

    public void setlistaSoftware(String[] listaSoftware) {
        SoftwareBD.listaSoftware = listaSoftware;
    }

    public void readSoftwareBD() {
        Connection c;
        c = ConexaoBD.getConexao();
        SoftwareBD softbd = new SoftwareBD();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT COUNT(nome_soft) AS NumeroSoftwares FROM Software;";

        try {
            int i = 0;
            ps = c.prepareStatement(query);
            rs = ps.executeQuery();
            rs.next();
            listaSoftware = new String[Integer.parseInt(rs.getString("NumeroSoftwares"))];
            query = "SELECT nome_soft AS Nome FROM Software;";
            ps = c.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                listaSoftware[i] = rs.getString("Nome");
                ++i;
            }
            softbd.setlistaSoftware(listaSoftware);
        } catch (SQLException e) {
            System.exit(0);
        } finally {
            // Conexao.fecharConexao(c, ps, rs);
        }
    }
}