package ModelDAO;

import java.sql.*;

public class ConexaoBD 
{
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String servidor = "localhost:3306";
    private static final String banco = "GHYM";
    private static final String timezone = "?useTimezone=true&serverTimezone=UTC";
    private static final String url = "jdbc:mysql://" + servidor + "/" + banco + timezone;
    private static final String usuario = "root";
    private static final String senha = "Ingrid1410Dobby2804Cacau1410";

    public static Connection getConexao() 
    {
        Connection connection = null;
        try
        {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, usuario, senha);
            return connection;
        } catch (ClassNotFoundException | SQLException e) 
        {
            System.out.println("Erro de Conexão: " + e);
            System.exit(0);
            return connection;
        }
    }
}