package ModelDAO;

import java.sql.*;

public class ConexaoBD {
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String servidor = "localhost:3306";
    private static final String banco = "database";
    private static final String timezone = "?useTimezone=true&serverTimezone=UTC";
    private static final String url = "jdbc:mysql://" + servidor + "/" + banco + timezone;
    private static final String usuario = "userpassword";
    private static final String senha = "userpassword";

    public static Connection getConexao() {
        Connection connection = null;
        try {
            Class.forName(driver);
            // connection = (Connection) DriverManager.getConnection(url, usuario, senha);
            connection = DriverManager.getConnection(url, usuario, senha);
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            return connection;
            // throw new RuntimeException("Erro Conexao", e);
        }
    }
}