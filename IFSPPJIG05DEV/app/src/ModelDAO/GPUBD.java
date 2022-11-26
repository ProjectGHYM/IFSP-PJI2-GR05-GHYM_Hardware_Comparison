package ModelDAO;

import java.sql.*;

public class GPUBD {
    static String listaGPUBD[][];

    public static String[][] getGPU() {
        return listaGPUBD;
    }

    public static void setGPU(String[][] listaGPUBD) {
        GPUBD.listaGPUBD = listaGPUBD;
    }

    public GPUBD() {
        Connection c = ConexaoBD.getConexao();

        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT COUNT(nome) AS NumeroGPU FROM GPU;";

        try {
            int i = 0;

            ps = c.prepareStatement(query);
            rs = ps.executeQuery();
            rs.next();
            listaGPUBD = new String[Integer.parseInt(rs.getString("NumeroGPU"))][3];
            query = "SELECT nome, clock, VRAM FROM GPU;";
            ps = c.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int j = 0;

                listaGPUBD[i][j] = rs.getString("nome");
                ++j;
                listaGPUBD[i][j] = rs.getString("clock");
                ++j;
                listaGPUBD[i][j] = rs.getString("VRAM");
                ++i;
            }
            setGPU(listaGPUBD);
        } catch (SQLException e) {
            System.exit(0);
        } finally {
            // Conexao.fecharConexao(c, ps, rs);
        }
    }

    public String[] getMinimaGPUBD(float gpuRequisitos[]) {
        int j = 0;
        for (int i = 0; i < 15; ++i) {
            if (Float.parseFloat(listaGPUBD[i][1]) * Float.parseFloat(listaGPUBD[i][2]) >= gpuRequisitos[0]) {
                if (Float.parseFloat(listaGPUBD[i][1]) * Float.parseFloat(listaGPUBD[i][2]) < gpuRequisitos[1])
                    ++j;
            }
        }
        String nomeGPUCompativel[] = new String[j];
        j = 0;
        for (int i = 0; i < 15; ++i) {
            if (Float.parseFloat(listaGPUBD[i][1]) * Float.parseFloat(listaGPUBD[i][2]) >= gpuRequisitos[0]) {
                if (Float.parseFloat(listaGPUBD[i][1]) * Float.parseFloat(listaGPUBD[i][2]) < gpuRequisitos[1]) {
                    nomeGPUCompativel[j] = listaGPUBD[i][0] + " " + listaGPUBD[i][2] + "GB";
                    ++j;
                }
            }
        }
        return nomeGPUCompativel;
    }

    public String[] getRecomendadaGPUBD(float gpuRequisitos[]) {
        int j = 0;

        for (int i = 0; i < 15; ++i) {
            if (Float.parseFloat(listaGPUBD[i][1]) * Float.parseFloat(listaGPUBD[i][2]) >= gpuRequisitos[1])
                ++j;
        }

        String nomeGPUCompativel[] = new String[j];
        j = 0;

        for (int i = 0; i < 15; ++i) {
            if (Float.parseFloat(listaGPUBD[i][1]) * Float.parseFloat(listaGPUBD[i][2]) >= gpuRequisitos[1]) {
                nomeGPUCompativel[j] = listaGPUBD[i][0] + " " + listaGPUBD[i][2] + "GB";
                ++j;
            }
        }

        return nomeGPUCompativel;
    }
}