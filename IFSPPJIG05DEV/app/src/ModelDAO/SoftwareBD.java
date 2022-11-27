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
        String query = "SELECT s.cod_soft AS id, t.nome AS tipo, s.nome_soft AS nome, r.capacidademin, c.coremin, c.clockmin, g.vrammin, g.clockmin, " +
        "r.capacidaderec, c.corerec, c.clockrec, g.vramrec, g.clockrec FROM Software AS s JOIN tipo AS t ON s.id_tipo = t.cod_tipo " +
        "JOIN recomendacaoram AS r ON s.id_recomendacaoram = r.cod_recram JOIN recomendacaocpu AS c ON s.id_recomendacaocpu = c.cod_reccpu " +
        "JOIN recomendacaogpu AS g ON s.id_recomendacaogpu = g.cod_recgpu;";

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

                RecomendacaoCPU recCPU = new RecomendacaoCPU(rs.getInt("coremin"), rs.getFloat("clockmin"), rs.getInt("corerec"), rs.getFloat("clockrec"));

                RecomendacaoGPU recGPU = new RecomendacaoGPU(rs.getInt("vrammin"), rs.getInt("clockmin"), rs.getInt("vramrec"), rs.getInt("clockrec")); 

                listaSoftware[i] = new Software(rs.getInt("id"), rs.getString("tipo"), rs.getString("nome"),
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