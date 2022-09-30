package ModelDAO;

import java.sql.*;

public class RecRamBD {
    static String recRAM[] = new String[2];
    public String[] getRecRAMBD(String escsoft) {
        Connection c;
        c = ConexaoBD.getConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = null;
        query = "SELECT capacidademin, capacidaderec FROM Software INNER JOIN RecomendacaoRam ON id_recomendacaoram = cod_recram WHERE nome_soft = \"" + escsoft + "\";";
        try {
            ps = c.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
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