package ModelDAO;

import java.sql.*;

public class RAMBD 
{
    static String listaRAMBD[][] = new String[15][3];

    public static String[][] getRAM() 
    {
        return listaRAMBD;
    }

    public static void setRAM(String[][] listaRAMBD) 
    {
        RAMBD.listaRAMBD = listaRAMBD;
    }

    public RAMBD()
    {
        Connection c = ConexaoBD.getConexao();

        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT nome, capacidade, frequencia FROM listaRAMBD;";

        try
        {
            int i = 0;

            ps = c.prepareStatement(query);
            rs = ps.executeQuery();

            while(rs.next())
            {
                int j=0;

                listaRAMBD[i][j] = rs.getString("nome");
                ++j;
                listaRAMBD[i][j] = rs.getString("capacidade");
                ++j;
                listaRAMBD[i][j] = rs.getString("frequencia");
                ++i;
            }

            setRAM(listaRAMBD);
        } 
        catch(SQLException e)
        {
            System.exit(0);
        }
        finally 
        {
            // Conexao.fecharConexao(c, ps, rs);
        }
    }

    public String[] getMinimaRAMBD(String dadoRecomendadoRAM[]) 
    {
        int j = 0;

        for(int i = 0; i < 15; ++i)
        {
            if(Float.parseFloat(listaRAMBD[i][1])>= Float.parseFloat(dadoRecomendadoRAM[0]))
            {
                if(Float.parseFloat(listaRAMBD[i][1]) < Float.parseFloat(dadoRecomendadoRAM[1]))
                    ++j;
            }
        }

        String nomeRAMCompativel[] = new String[j];
        j = 0;

        for(int i = 0; i < 15; ++i)
        {
            if(Float.parseFloat(listaRAMBD[i][1]) >= Float.parseFloat(dadoRecomendadoRAM[0]))
            {
                if(Float.parseFloat(listaRAMBD[i][1]) < Float.parseFloat(dadoRecomendadoRAM[1]))
                {
                    nomeRAMCompativel[j] = listaRAMBD[i][0] + " " + listaRAMBD[i][1] + "GB " + listaRAMBD[i][2] + " MHz";
                    ++j;
                }
            }
        }

        return nomeRAMCompativel;
    }

    public String[] getRecomendadaRAMBD(String dadoRecomendadoRAM[]) 
    {
        int j = 0;

        for(int i = 0; i < 15; ++i)
        {
            if(Float.parseFloat(listaRAMBD[i][1]) >= Float.parseFloat(dadoRecomendadoRAM[1]))
                ++j;
        }

        String nomeRAMCompativel[] = new String[j];
        j = 0;

        for(int i = 0; i < 15; ++i)
        {
            if(Float.parseFloat(listaRAMBD[i][1]) >= Float.parseFloat(dadoRecomendadoRAM[1]))
            {
                nomeRAMCompativel[j] = listaRAMBD[i][0] + " " + listaRAMBD[i][1] + "GB " + listaRAMBD[i][2] + " MHz";
                ++j;
            }
        }
        return nomeRAMCompativel;
    }

    public String[] getGeralMinRAMBD(float resultRAMMin, float resultRAMRec) 
    {
        int j = 0;

        for(int i = 0; i < 15; ++i)
        {
            if(Float.parseFloat(listaRAMBD[i][1])>= resultRAMMin)
            {
                if(Float.parseFloat(listaRAMBD[i][1]) < resultRAMRec)
                    ++j;
            }
        }

        String nomeRAMCompativel[] = new String[j];
        j = 0;

        for(int i = 0; i < 15; ++i)
        {
            if(Float.parseFloat(listaRAMBD[i][1]) >= resultRAMMin)
            {
                if(Float.parseFloat(listaRAMBD[i][1]) < resultRAMRec)
                {
                    nomeRAMCompativel[j] = listaRAMBD[i][0] + " " + listaRAMBD[i][1] + "GB " + listaRAMBD[i][2] + " MHz";
                    ++j;
                }
            }
        }

        return nomeRAMCompativel;
    }

    public String[] getGeralRecRAMBD(float resultRAM) 
    {
        int j = 0;

        for(int i = 0; i < 15; ++i)
        {
            if(Float.parseFloat(listaRAMBD[i][1]) >= resultRAM)
                ++j;
        }

        String nomeRAMCompativel[] = new String[j];
        j = 0;

        for(int i = 0; i < 15; ++i)
        {
            if(Float.parseFloat(listaRAMBD[i][1]) >= resultRAM)
            {
                nomeRAMCompativel[j] = listaRAMBD[i][0] + " " + listaRAMBD[i][1] + "GB " + listaRAMBD[i][2] + " MHz";
                ++j;
            }
        }
        
        return nomeRAMCompativel;
    }
}