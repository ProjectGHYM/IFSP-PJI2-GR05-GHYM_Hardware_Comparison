package ModelDAO;

import java.sql.*;

public class RecCPUBD {
    static String recCPU[] = new String[4];

    public String[] getRecCPUBD(String softwareEscolhido) {
        Connection c = ConexaoBD.getConexao();

        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT coremin, clockmin, corerec, clockrec\nFROM Software\nINNER JOIN RecomendacaoCpu\nON id_recomendacaocpu = cod_reccpu\nWHERE nome_soft = \""
                + softwareEscolhido + "\";";
        try {
            ps = c.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                recCPU[0] = rs.getString("coremin");
                recCPU[1] = rs.getString("clockmin");
                recCPU[2] = rs.getString("corerec");
                recCPU[3] = rs.getString("clockrec");
            }
            return recCPU;

        } catch (SQLException e) {
            System.exit(0);
            return recCPU;
        } finally {
            // Conexao.fecharConexao(c, ps, rs);
        }
    }
}