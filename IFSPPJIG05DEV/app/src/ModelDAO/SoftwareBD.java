package ModelDAO;

import java.sql.*;

public class SoftwareBD 
{
    static String nome_softs[] = new String[20];

    public String[] getNome_softs() 
    {
        return nome_softs;
    }
    
    public void setNome_softs(String[] nome_softs) 
    {
        SoftwareBD.nome_softs = nome_softs;
    }
    
    public void readSoftwareBD() 
    {
        Connection c;
        c = ConexaoBD.getConexao();
        SoftwareBD softbd = new SoftwareBD();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = null;

        query = "SELECT nome_soft FROM Software;";

        try
        {
            int i = 0;
            ps = c.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next())
            {
                nome_softs[i] = rs.getString("nome_soft");
                ++i;
            }

            softbd.setNome_softs(nome_softs);
        } 
        catch (SQLException e)
        {
            System.exit(0);
        }
        finally 
        {
            // Conexao.fecharConexao(c, ps, rs);
        }
    }
}