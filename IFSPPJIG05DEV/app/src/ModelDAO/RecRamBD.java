package ModelDAO;

import java.sql.*;

public class RecRamBD {
    static String recRAM[] = new String[2];

    public String[] getRecRAMBD(String softwareEscolhido) {
        Connection c = ConexaoBD.getConexao();

        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT capacidademin, capacidaderec\nFROM Software\nINNER JOIN RecomendacaoRam\nON id_recomendacaoram = cod_recram\nWHERE nome_soft = \""
                + softwareEscolhido + "\";";

        try {
            ps = c.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                recRAM[0] = rs.getString("capacidademin");
                recRAM[1] = rs.getString("capacidaderec");
            }
            return recRAM;
        } catch (SQLException e) {
            System.exit(0);
            return recRAM;
        } finally {
            // Conexao.fecharConexao(c, ps, rs);
        }
    }
}