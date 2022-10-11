package ModelDAO;

import java.sql.*;

public class CPUBD {
    static String listaProcessadorBD[][];

    public static String[][] getListaProcessadorBD() {
        return listaProcessadorBD;
    }

    public static void setListaProcessadorBD(String[][] listaProcessadorBD) {
        CPUBD.listaProcessadorBD = listaProcessadorBD;
    }

    public CPUBD() {
        Connection c = ConexaoBD.getConexao();

        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT COUNT(nome) AS NumeroProcessador FROM Processador;";

        try {
            int i = 0;

            ps = c.prepareStatement(query);
            rs = ps.executeQuery();
            rs.next();
            listaProcessadorBD = new String[Integer.parseInt(rs.getString("NumeroProcessador"))][3];
            query = "SELECT nome, cores, clock FROM Processador;";
            ps = c.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int j = 0;

                listaProcessadorBD[i][j] = rs.getString("nome");
                ++j;
                listaProcessadorBD[i][j] = rs.getString("cores");
                ++j;
                listaProcessadorBD[i][j] = rs.getString("clock");
                ++i;
            }

            setListaProcessadorBD(listaProcessadorBD);
        } catch (SQLException e) {
            System.exit(0);
        } finally {
            // Conexao.fecharConexao(c, ps, rs);
        }
    }

    public String[] getMinimaCPUBD(float cpuRequisitos[]) {
        int j = 0;

        for (int i = 0; i < 15; ++i) {
            if (Float.parseFloat(listaProcessadorBD[i][1])
                    * Float.parseFloat(listaProcessadorBD[i][2]) >= cpuRequisitos[0]) {
                if (Float.parseFloat(listaProcessadorBD[i][1])
                        * Float.parseFloat(listaProcessadorBD[i][2]) < cpuRequisitos[1])
                    ++j;
            }
        }

        String nomeCPUCompativel[] = new String[j];
        j = 0;

        for (int i = 0; i < 15; ++i) {
            if (Float.parseFloat(listaProcessadorBD[i][1])
                    * Float.parseFloat(listaProcessadorBD[i][2]) >= cpuRequisitos[0]) {
                if (Float.parseFloat(listaProcessadorBD[i][1])
                        * Float.parseFloat(listaProcessadorBD[i][2]) < cpuRequisitos[1]) {
                    nomeCPUCompativel[j] = listaProcessadorBD[i][0];
                    ++j;
                }
            }
        }

        return nomeCPUCompativel;
    }

    public String[] getRecomendadaCPUBD(float cpuRequisitos[]) {
        int j = 0;
        for (int i = 0; i < 15; ++i) {
            if (Float.parseFloat(listaProcessadorBD[i][1])
                    * Float.parseFloat(listaProcessadorBD[i][2]) >= cpuRequisitos[1])
                ++j;
        }

        String nomeCPUCompativel[] = new String[j];
        j = 0;

        for (int i = 0; i < 15; ++i) {
            if (Float.parseFloat(listaProcessadorBD[i][1])
                    * Float.parseFloat(listaProcessadorBD[i][2]) >= cpuRequisitos[1]) {
                nomeCPUCompativel[j] = listaProcessadorBD[i][0];
                ++j;
            }
        }
        return nomeCPUCompativel;
    }
}