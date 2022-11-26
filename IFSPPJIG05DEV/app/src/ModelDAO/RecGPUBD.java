package ModelDAO;

import java.sql.*;

public class RecGPUBD {
    static String recGPU[] = new String[4];

    public String[] getRecGPUBD(String softwareEscolhido) {
        Connection c = ConexaoBD.getConexao();

        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT clockmin, vrammin, clockrec, vramrec\nFROM Software\nINNER JOIN RecomendacaoGpu\nON id_recomendacaogpu = cod_recgpu\nWHERE nome_soft = \""
                + softwareEscolhido + "\";";

        try {
            ps = c.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
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