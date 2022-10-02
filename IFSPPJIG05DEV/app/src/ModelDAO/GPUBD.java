package ModelDAO;

import java.sql.*;

public class GPUBD 
{
    static String listaGPUBD[][] = new String[15][3];
    
    public static String[][] getGPU() 
    {
        return listaGPUBD;
    }

    public static void setGPU(String[][] listaGPUBD) 
    {
        GPUBD.listaGPUBD = listaGPUBD;
    }

    public GPUBD()
    {
        Connection c = ConexaoBD.getConexao();

        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT nome, clock, VRAM FROM listaGPUBD;";

        try 
        {
            int i = 0;

            ps = c.prepareStatement(query);
            rs = ps.executeQuery();

            while(rs.next())
            {
                int j=0;

                listaGPUBD[i][j] = rs.getString("nome");
                ++j;
                listaGPUBD[i][j] = rs.getString("clock");
                ++j;
                listaGPUBD[i][j] = rs.getString("VRAM");
                ++i;
            }

            setGPU(listaGPUBD);
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

    public String[] getMinimaGPU(String dadoRecomendadoGPU[]) 
    {
        int j = 0;

        for(int i = 0; i < 15; ++i)
        {
            if(Float.parseFloat(listaGPUBD[i][1]) * Float.parseFloat(listaGPUBD[i][2]) >= Float.parseFloat(dadoRecomendadoGPU[0]) * Float.parseFloat(dadoRecomendadoGPU[1]))
            {
                if(Float.parseFloat(listaGPUBD[i][1]) * Float.parseFloat(listaGPUBD[i][2]) < Float.parseFloat(dadoRecomendadoGPU[2]) * Float.parseFloat(dadoRecomendadoGPU[3]))
                    ++j;
            }
        }

        String nomeGPUCompativel[] = new String[j];
        j = 0;

        for(int i = 0; i < 15; ++i)
        {
            if(Float.parseFloat(listaGPUBD[i][1]) * Float.parseFloat(listaGPUBD[i][2]) >= Float.parseFloat(dadoRecomendadoGPU[0]) * Float.parseFloat(dadoRecomendadoGPU[1]))
            {
                if(Float.parseFloat(listaGPUBD[i][1]) * Float.parseFloat(listaGPUBD[i][2]) < Float.parseFloat(dadoRecomendadoGPU[2]) * Float.parseFloat(dadoRecomendadoGPU[3]))
                {
                    nomeGPUCompativel[j] = listaGPUBD[i][0] + " " + listaGPUBD[i][2] + "GB";
                    ++j;
                }
            }
        }
        return nomeGPUCompativel;
    }

    public String[] getRecomendadaGPU(String dadoRecomendadoGPU[]) 
    {
        int j = 0;

        for(int i = 0; i < 15; ++i)
        {
            if(Float.parseFloat(listaGPUBD[i][1]) * Float.parseFloat(listaGPUBD[i][2]) >= Float.parseFloat(dadoRecomendadoGPU[2]) * Float.parseFloat(dadoRecomendadoGPU[3]))
                ++j;
        }
        
        String nomeGPUCompativel[] = new String[j];
        j = 0;

        for(int i = 0; i < 15; ++i)
        {
            if(Float.parseFloat(listaGPUBD[i][1]) * Float.parseFloat(listaGPUBD[i][2]) >= Float.parseFloat(dadoRecomendadoGPU[2]) * Float.parseFloat(dadoRecomendadoGPU[3]))
            {
                nomeGPUCompativel[j] = listaGPUBD[i][0] + " " + listaGPUBD[i][2] + "GB";
                ++j;
            }
        }
        return nomeGPUCompativel;
    }

    public String[] getGeralMinGPUBD(float resultGPUMin, float resultGPURec) 
    {
        int j = 0;
        for(int i = 0; i < 15; ++i)
        {
            if(Float.parseFloat(listaGPUBD[i][1]) * Float.parseFloat(listaGPUBD[i][2]) >= resultGPUMin)
            {
                if(Float.parseFloat(listaGPUBD[i][1]) * Float.parseFloat(listaGPUBD[i][2]) < resultGPURec)
                    ++j;
            }
        }
        String nomeGPUCompativel[] = new String[j];
        j = 0;
        for(int i = 0; i < 15; ++i)
        {
            if(Float.parseFloat(listaGPUBD[i][1]) * Float.parseFloat(listaGPUBD[i][2]) >= resultGPUMin)
            {
                if(Float.parseFloat(listaGPUBD[i][1]) * Float.parseFloat(listaGPUBD[i][2]) < resultGPURec)
                {
                    nomeGPUCompativel[j] = listaGPUBD[i][0] + " " + listaGPUBD[i][2] + "GB";
                    ++j;
                }
            }
        }
        return nomeGPUCompativel;
    }

    public String[] getGeralRecGPUBD(float resultGPU) 
    {
        int j = 0;

        for(int i = 0; i < 15; ++i)
        {
            if(Float.parseFloat(listaGPUBD[i][1]) * Float.parseFloat(listaGPUBD[i][2]) >= resultGPU)
                ++j;
        }

        String nomeGPUCompativel[] = new String[j];
        j = 0;

        for(int i = 0; i < 15; ++i)
        {
            if(Float.parseFloat(listaGPUBD[i][1]) * Float.parseFloat(listaGPUBD[i][2]) >= resultGPU)
            {
                nomeGPUCompativel[j] = listaGPUBD[i][0] + " " + listaGPUBD[i][2] + "GB";
                ++j;
            }
        }

        return nomeGPUCompativel;
    }
}