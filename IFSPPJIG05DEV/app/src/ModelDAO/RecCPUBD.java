package ModelDAO;

import java.sql.*;

public class RecCPUBD {
    static String recCPU[] = new String[4];
    public String[] getRecCPUBD(String escsoft) {
        Connection c;
        c = ConexaoBD.getConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = null;
        query = "SELECT coremin, clockmin, corerec, clockrec FROM Software INNER JOIN RecomendacaoCpu ON id_recomendacaocpu = cod_reccpu WHERE nome_soft = \"" + escsoft + "\";";
        try {
            ps = c.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
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