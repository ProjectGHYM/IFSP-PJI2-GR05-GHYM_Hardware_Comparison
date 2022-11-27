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
        String query = "SELECT r.cod_ram AS id, r.nome, m.nome AS marca, r.frequencia, r.capacidade, r.tipo, r.preco " +
        "FROM ram AS r JOIN marca AS m ON r.id_marca = m.cod_marca;";
        
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
            setListaRAM(listaRAM);
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
            System.out.println("Erro BD da RAM: " + e);
            System.exit(0);
        }
    }

    public static RAM[] getListaRAM() 
    {
        return listaRAM;
    }

    public static void setListaRAM(RAM[] listaRAM) 
    {
        RAMBD.listaRAM = listaRAM;
    }
}