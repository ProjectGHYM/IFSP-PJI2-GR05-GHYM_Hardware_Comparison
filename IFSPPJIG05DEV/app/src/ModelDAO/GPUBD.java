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
        String query = "SELECT * FROM lista_gpu;";
        
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
                 rs.getInt("VRAM"), rs.getInt("mark"), rs.getInt("TDP"), rs.getFloat("preco"));
                
                i++;
            }
        } 
        catch (SQLException e) 
        {
            System.out.println("Erro BD da GPU: " + e);
            System.exit(0);
        }
    }

    public static void inicializar()
    {
        //Método que caso não seja inicializado nenhuma variável deste tipo preenche a lista com os componentes
        GPUBD.achaTamanhoLista();
        String query = "SELECT * FROM lista_gpu;";
        
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
                 rs.getInt("VRAM"), rs.getInt("mark"), rs.getInt("TDP"), rs.getFloat("preco"));
                
                i++;
            }
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
            System.out.println("Erro BD da GPU na contagem: " + e);
            System.exit(0);
        }
    }
}