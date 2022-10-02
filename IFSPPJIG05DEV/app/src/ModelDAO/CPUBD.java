package ModelDAO;

import java.sql.*;

public class CPUBD 
{
    static String listaProcessadorBD[][] = new String[15][3];
    
    public static String[][] getListaProcessadorBD() 
    {
        return listaProcessadorBD;
    }

    public static void setListaProcessadorBD(String[][] listaProcessadorBD) 
    {
        CPUBD.listaProcessadorBD = listaProcessadorBD;
    }

    public CPUBD()
    {
        Connection c = ConexaoBD.getConexao();

        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = null;

        query = "SELECT nome, cores, clock FROM Processador;";

        try 
        {
            int i = 0;

            ps = c.prepareStatement(query);
            rs = ps.executeQuery();

            while(rs.next())
            {
                int j = 0;

                listaProcessadorBD[i][j] = rs.getString("nome");
                ++j;
                listaProcessadorBD[i][j] = rs.getString("cores");
                ++j;
                listaProcessadorBD[i][j] = rs.getString("clock");
                ++i;
            }

            setListaProcessadorBD(listaProcessadorBD);
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

    public String[] getRecomendacaoMinimaCPU(String dadoRecomendadoCPU[]) 
    {
        int j = 0;

        for(int i = 0; i < 15; ++i)
        {
            if(Float.parseFloat(listaProcessadorBD[i][1]) * Float.parseFloat(listaProcessadorBD[i][2]) >= Float.parseFloat(dadoRecomendadoCPU[0]) * Float.parseFloat(dadoRecomendadoCPU[1]))
            {
                if(Float.parseFloat(listaProcessadorBD[i][1]) * Float.parseFloat(listaProcessadorBD[i][2]) < Float.parseFloat(dadoRecomendadoCPU[2]) * Float.parseFloat(dadoRecomendadoCPU[3]))
                {
                    ++j;
                }
            }
        }

        String nomeCPUsCompativeis[] = new String[j];
        j = 0;

        for(int i = 0; i < 15; ++i)
        {
            if(Float.parseFloat(listaProcessadorBD[i][1]) * Float.parseFloat(listaProcessadorBD[i][2]) >= Float.parseFloat(dadoRecomendadoCPU[0]) * Float.parseFloat(dadoRecomendadoCPU[1]))
            {
                if(Float.parseFloat(listaProcessadorBD[i][1]) * Float.parseFloat(listaProcessadorBD[i][2]) < Float.parseFloat(dadoRecomendadoCPU[2]) * Float.parseFloat(dadoRecomendadoCPU[3]))
                {
                    nomeCPUsCompativeis[j] = listaProcessadorBD[i][0];
                    ++j;
                }
            }
        }
        return nomeCPUsCompativeis;
    }

    public String[] getRecomendacaoRecomendadaCPU(String dadoRecomendadoCPU[]) 
    {
        int j = 0;
        for(int i = 0; i < 15; ++i)
        {
            if(Float.parseFloat(listaProcessadorBD[i][1]) * Float.parseFloat(listaProcessadorBD[i][2]) >= Float.parseFloat(dadoRecomendadoCPU[2]) * Float.parseFloat(dadoRecomendadoCPU[3]))
            {
                ++j;
            }
        }

        String nomeCPUsCompativeis[] = new String[j];
        j = 0;

        for(int i = 0; i < 15; ++i)
        {
            if(Float.parseFloat(listaProcessadorBD[i][1]) * Float.parseFloat(listaProcessadorBD[i][2]) >= Float.parseFloat(dadoRecomendadoCPU[2]) * Float.parseFloat(dadoRecomendadoCPU[3]))
            {
                nomeCPUsCompativeis[j] = listaProcessadorBD[i][0];
                ++j;
            }
        }

        return nomeCPUsCompativeis;
    }

    public String[] getGeralMinCPUBD(float resultCPUMin, float resultCPURec) 
    {
        int j = 0;
        for(int i = 0; i < 15; ++i){
            if(Float.parseFloat(listaProcessadorBD[i][1]) * Float.parseFloat(listaProcessadorBD[i][2]) >= resultCPUMin)
            {
                if(Float.parseFloat(listaProcessadorBD[i][1]) * Float.parseFloat(listaProcessadorBD[i][2]) < resultCPURec)
                {
                    ++j;
                }
            }
        }

        String resultNomeCPU[] = new String[j];
        j = 0;

        for(int i = 0; i < 15; ++i)
        {
            if(Float.parseFloat(listaProcessadorBD[i][1]) * Float.parseFloat(listaProcessadorBD[i][2]) >= resultCPUMin)
            {
                if(Float.parseFloat(listaProcessadorBD[i][1]) * Float.parseFloat(listaProcessadorBD[i][2]) < resultCPURec)
                {
                    resultNomeCPU[j] = listaProcessadorBD[i][0];
                    ++j;
                }
            }
        }

        return resultNomeCPU;
    }

    public String[] getGeralRecCPUBD(float resultCPU) 
    {
        int j = 0;
        for(int i = 0; i < 15; ++i)
        {
            if(Float.parseFloat(listaProcessadorBD[i][1]) * Float.parseFloat(listaProcessadorBD[i][2]) >= resultCPU)
                ++j;
        }

        String nomeCPUsCompativeis[] = new String[j];
        j = 0;

        for(int i = 0; i < 15; ++i)
        {
            if(Float.parseFloat(listaProcessadorBD[i][1]) * Float.parseFloat(listaProcessadorBD[i][2]) >= resultCPU)
            {
                nomeCPUsCompativeis[j] = listaProcessadorBD[i][0];
                ++j;
            }
        }
        return nomeCPUsCompativeis;
    }
}