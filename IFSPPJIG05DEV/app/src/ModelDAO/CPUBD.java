package ModelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ModelEntidade.CPU;

public class CPUBD 
{
    public static CPU listaProcessador[];

    public CPUBD() 
    {
        CPUBD.achaTamanhoLista();
        String query = "SELECT * FROM lista_cpu;";
        
        try(
            Connection c = ConexaoBD.getConexao();
            PreparedStatement ps = c.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            ) 
        {
            int i = 0; 
            while (rs.next()) 
            {
                listaProcessador[i] = new CPU(rs.getInt("id"), rs.getString("nome"), rs.getString("marca"), 
                rs.getFloat("clock"), rs.getFloat("turbo"), rs.getInt("cores"), rs.getInt("threads"), 
                rs.getInt("mark"), rs.getInt("TDP"), rs.getString("arquitetura"), rs.getFloat("preco"));
                ++i;
            }
        } 
        catch (SQLException e) 
        {
            System.out.println("Erro BD da CPU: " + e);
            System.exit(0);
        }
    }

    public static void inicializar()
    {
        //Método que caso não seja inicializado nenhuma variável deste tipo preenche a lista com os componentes
        CPUBD.achaTamanhoLista();
        String query = "SELECT * FROM lista_cpu;";
        
        try(
            Connection c = ConexaoBD.getConexao();
            PreparedStatement ps = c.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            ) 
        {
            int i = 0; 
            while (rs.next()) 
            {
                listaProcessador[i] = new CPU(rs.getInt("id"), rs.getString("nome"), rs.getString("marca"), 
                rs.getFloat("clock"), rs.getFloat("turbo"), rs.getInt("cores"), rs.getInt("threads"), 
                rs.getInt("mark"), rs.getInt("TDP"), rs.getString("arquitetura"), rs.getFloat("preco"));
                ++i;
            }
        } 
        catch (SQLException e) 
        {
            System.out.println("Erro BD da CPU: " + e);
            System.exit(0);
        }
    }

    private static void achaTamanhoLista()
    {
        String query = "SELECT COUNT(nome) AS NumeroProcessador FROM Processador;";
        try(
            Connection c = ConexaoBD.getConexao();
            PreparedStatement ps = c.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            ) 
        {
            rs.next();
            listaProcessador = new CPU[Integer.parseInt(rs.getString("NumeroProcessador"))];
        } 
        catch (SQLException e) 
        {
            System.out.println("Erro BD da CPU na contagem da lista: " + e);
            System.exit(0);
        }
    }
}