package ModelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ModelEntidade.RAM;

public class RAMBD 
{
    public static RAM listaRAM[];

    public RAMBD() 
    {
        RAMBD.achaTamanhoLista();
        String query = "SELECT * FROM lista_ram";
        
        try(
            Connection c = ConexaoBD.getConexao();
            PreparedStatement ps = c.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            ) 
        {
            int i = 0;
            while (rs.next()) 
            {
                listaRAM[i] = new RAM(rs.getInt("id"), rs.getString("nome"), rs.getString("marca"), rs.getInt("frequencia"),
                 rs.getInt("capacidade"), rs.getString("tipo"), rs.getFloat("preco"));            
                i++;
            }
        } 
        catch (SQLException e) 
        {
            System.out.println("Erro BD da RAM: " + e);
            System.exit(0);
        }
    }

    public static void inicializar()
    {
        //Método que caso não seja inicializado nenhuma variável deste tipo preenche a lista com os componentes
        RAMBD.achaTamanhoLista();
        String query = "SELECT * FROM lista_ram";
        
        try(
            Connection c = ConexaoBD.getConexao();
            PreparedStatement ps = c.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            ) 
        {
            int i = 0;
            while (rs.next()) 
            {
                listaRAM[i] = new RAM(rs.getInt("id"), rs.getString("nome"), rs.getString("marca"), rs.getInt("frequencia"),
                 rs.getInt("capacidade"), rs.getString("tipo"), rs.getFloat("preco"));            
                i++;
            }
        } 
        catch (SQLException e) 
        {
            System.out.println("Erro BD da RAM: " + e);
            System.exit(0);
        }
    }

    private static void achaTamanhoLista()
    {
        String query = "SELECT COUNT(nome) AS NumeroRAM FROM RAM;";
        
        try(
            Connection c = ConexaoBD.getConexao();
            PreparedStatement ps = c.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            ) 
        {
            rs.next();
            listaRAM = new RAM[Integer.parseInt(rs.getString("NumeroRAM"))];
        } 
        catch (SQLException e) 
        {
            System.out.println("Erro BD da RAM na contagem: " + e);
            System.exit(0);
        }
    }
}