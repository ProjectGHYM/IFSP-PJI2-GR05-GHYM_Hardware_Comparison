package ModelDAO;

import java.sql.*;

public class RecGPUBD {
    static String recGPU[] = new String[4];
    public String[] getRecGPUBD(String escsoft) {
        Connection c;
        c = ConexaoBD.getConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = null;
        query = "SELECT clockmin, vrammin, clockrec, vramrec FROM Software INNER JOIN RecomendacaoGpu ON id_recomendacaogpu = cod_recgpu WHERE nome_soft = \"" + escsoft + "\";";
        try {
            ps = c.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                recGPU[0] = rs.getString("vrammin");
                recGPU[1] = rs.getString("clockmin");
                recGPU[2] = rs.getString("vramrec");
                recGPU[3] = rs.getString("clockrec");
            }
            return recGPU;
        } catch (SQLException e) {
            System.exit(0);
            return recGPU;
        } finally {
            // Conexao.fecharConexao(c, ps, rs);
        }
    }
}