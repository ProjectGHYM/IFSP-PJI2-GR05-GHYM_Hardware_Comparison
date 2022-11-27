package ModelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ModelEntidade.GPU;

public class GPUBD 
{
    public static GPU listaGPU[];

    public GPUBD() 
    {
        GPUBD.achaTamanhoLista();
        String query = "SELECT g.cod_gpu AS id, g.nome, m.nome AS marca, g.clock, g.VRAM AS vRAM, g.mark, g.TDP AS tDP, g.preco " + 
            "FROM gpu AS g JOIN marca AS m ON g.id_marca = m.cod_marca;";
        
        try(
            Connection c = ConexaoBD.getConexao();
            PreparedStatement ps = c.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            ) 
        {
            int i = 0;
            while (rs.next()) 
            {
                listaGPU[i] = new GPU(rs.getInt("id"), rs.getString("nome"), rs.getString("marca"), rs.getInt("clock"),
                 rs.getInt("vRAM"), rs.getInt("mark"), rs.getInt("tDP"), rs.getFloat("preco"));
                
                i++;
            }
            setListaGPU(listaGPU);
        } 
        catch (SQLException e) 
        {
            System.out.println("Erro BD da GPU: " + e);
            System.exit(0);
        }
    }

    private static void achaTamanhoLista()
    {
        String query = "SELECT COUNT(nome) AS NumeroGPU FROM GPU;";
        try(
            Connection c = ConexaoBD.getConexao();
            PreparedStatement ps = c.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            ) 
        {
            rs.next();
            listaGPU = new GPU[Integer.parseInt(rs.getString("NumeroGPU"))];
        } 
        catch (SQLException e) 
        {
            System.out.println("Erro BD da GPU: " + e);
            System.exit(0);
        }
    }
    
    public static GPU[] getListaGPU() 
    {
        return listaGPU;
    }

    public static void setListaGPU(GPU[] listaGPU) 
    {
        GPUBD.listaGPU = listaGPU;
    }
}