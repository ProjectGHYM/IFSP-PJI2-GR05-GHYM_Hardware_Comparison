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
        String query = "SELECT p.cod_cpu AS id, p.nome, m.nome AS marca, p.clock, p.turbo, p.cores, p.threads, p.mark, p.TDP AS tDP, p.arquitetura, p.preco" 
            + " FROM processador AS p JOIN marca AS m ON p.id_marca = m.cod_marca;";
        
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
                rs.getInt("mark"), rs.getInt("tDP"), rs.getString("arquitetura"), rs.getFloat("preco"));
                ++i;
            }
            setListaProcessador(listaProcessador);
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
            System.out.println("Erro BD da CPU: " + e);
            System.exit(0);
        }
    }

    public static CPU[] getListaProcessador() 
    {
        return listaProcessador;
    }

    public static void setListaProcessador(CPU[] listaProcessador) 
    {
        CPUBD.listaProcessador = listaProcessador;
    }
}