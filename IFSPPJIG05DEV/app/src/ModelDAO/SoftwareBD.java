package ModelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ModelEntidade.RecomendacaoCPU;
import ModelEntidade.RecomendacaoGPU;
import ModelEntidade.RecomendacaoRAM;
import ModelEntidade.Software;

public class SoftwareBD 
{
    public static Software listaSoftware[];

    public SoftwareBD()
    {
        achaTamanhoLista();
        String query = "SELECT * FROM requisitos_soft;";

        try(
            Connection c = ConexaoBD.getConexao();
            PreparedStatement ps = c.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            ) 
        {
            int i = 0;
            
            while (rs.next()) 
            {
                RecomendacaoRAM recRAM = new RecomendacaoRAM(rs.getInt("capacidademin"), rs.getInt("capacidaderec"));

                RecomendacaoCPU recCPU = new RecomendacaoCPU(rs.getInt("coremin"), rs.getFloat("clockmin_cpu"), rs.getInt("corerec"), rs.getFloat("clockrec_cpu"));

                RecomendacaoGPU recGPU = new RecomendacaoGPU(rs.getInt("vrammin"), rs.getInt("clockmin_gpu"), rs.getInt("vramrec"), rs.getInt("clockrec_gpu")); 

                listaSoftware[i] = new Software(rs.getInt("cod_soft"), rs.getString("tipo"), rs.getString("nome_soft"),
                recRAM, recCPU, recGPU);

                ++i;
            }

            setListaSoftware(listaSoftware);

        } catch (SQLException e) 
        {
            System.out.println("Erro BD do Software: " + e);
            System.exit(0);
        }
    }

    private static void achaTamanhoLista()
    {
        String query = "SELECT COUNT(nome_soft) AS NumeroSoftware FROM Software;";
        
        try(
            Connection c = ConexaoBD.getConexao();
            PreparedStatement ps = c.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            ) 
        {
            rs.next();
            listaSoftware = new Software[Integer.parseInt(rs.getString("NumeroSoftware"))];
        } 
        catch (SQLException e) 
        {
            System.out.println("Erro BD do Software: " + e);
            System.exit(0);
        }
    }

    public Software[] getListaSoftware() 
    {
        return listaSoftware;
    }

    public void setListaSoftware(Software[] listaSoftware) 
    {
        SoftwareBD.listaSoftware = listaSoftware;
    }
}