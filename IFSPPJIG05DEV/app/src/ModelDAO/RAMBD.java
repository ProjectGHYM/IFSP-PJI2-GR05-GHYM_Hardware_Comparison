package ModelDAO;

import java.sql.*;

public class RAMBD {
    static String listaRAMBD[][];

    public static String[][] getRAM() {
        return listaRAMBD;
    }

    public static void setRAM(String[][] listaRAMBD) {
        RAMBD.listaRAMBD = listaRAMBD;
    }

    public RAMBD() {
        Connection c = ConexaoBD.getConexao();

        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT COUNT(nome) AS NumeroRAM FROM RAM;";

        try {
            int i = 0;

            ps = c.prepareStatement(query);
            rs = ps.executeQuery();
            rs.next();
            listaRAMBD = new String[Integer.parseInt(rs.getString("NumeroRAM"))][3];

            query = "SELECT nome, capacidade, frequencia FROM RAM;";
            ps = c.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int j = 0;
                listaRAMBD[i][j] = rs.getString("nome");
                ++j;
                listaRAMBD[i][j] = rs.getString("capacidade");
                ++j;
                listaRAMBD[i][j] = rs.getString("frequencia");
                ++i;
            }

            setRAM(listaRAMBD);
        } catch (SQLException e) {
            System.exit(0);
        } finally {
            // Conexao.fecharConexao(c, ps, rs);
        }
    }

    public String[] getMinimaRAMBD(float ramRequisitos[]) {
        int j = 0;

        for (int i = 0; i < 15; ++i) {
            if (Float.parseFloat(listaRAMBD[i][1]) >= ramRequisitos[0]) {
                if (Float.parseFloat(listaRAMBD[i][1]) < ramRequisitos[1])
                    ++j;
            }
        }

        String nomeRAMCompativel[] = new String[j];
        j = 0;

        for (int i = 0; i < 15; ++i) {
            if (Float.parseFloat(listaRAMBD[i][1]) >= ramRequisitos[0]) {
                if (Float.parseFloat(listaRAMBD[i][1]) < ramRequisitos[1]) {
                    nomeRAMCompativel[j] = listaRAMBD[i][0] + " " + listaRAMBD[i][1] + "GB " + listaRAMBD[i][2]
                            + " MHz";
                    ++j;
                }
            }
        }

        return nomeRAMCompativel;
    }

    public String[] getRecomendadaRAMBD(float ramRequisitos[]) {
        int j = 0;

        for (int i = 0; i < 15; ++i) {
            if (Float.parseFloat(listaRAMBD[i][1]) >= ramRequisitos[1])
                ++j;
        }

        String nomeRAMCompativel[] = new String[j];
        j = 0;

        for (int i = 0; i < 15; ++i) {
            if (Float.parseFloat(listaRAMBD[i][1]) >= ramRequisitos[1]) {
                nomeRAMCompativel[j] = listaRAMBD[i][0] + " " + listaRAMBD[i][1] + "GB " + listaRAMBD[i][2] + " MHz";
                ++j;
            }
        }

        return nomeRAMCompativel;
    }
}