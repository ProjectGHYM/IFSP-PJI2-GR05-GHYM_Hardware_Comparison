package ModelDAO;

import java.sql.*;

public class SoftwareBD {
    public String[] readSoft(String nome_softs[]) {
        Connection c;
        c = ConexaoBD.getConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = null;
        query = "SELECT nome_soft FROM Software";
        try {
            int i = 0;
            ps = c.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                nome_softs[i] = rs.getString("nome_soft");
                ++i;
            }
            return nome_softs;
        } catch (SQLException e) {
            return nome_softs;
        } finally {
            // Conexao.fecharConexao(c, ps, rs);
        }
    }
}