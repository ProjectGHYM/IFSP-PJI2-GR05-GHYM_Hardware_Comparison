package ModelDAO;

import java.sql.*;

public class RAMBD {
    static String RAM[][] = new String[15][3];
    public static String[][] getRAM() {
        return RAM;
    }
    public static void setRAM(String[][] RAM) {
        RAMBD.RAM = RAM;
    }
    public RAMBD(){
        Connection c;
        c = ConexaoBD.getConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = null;
        query = "SELECT nome, capacidade, frequencia FROM RAM;";
        try {
            int i = 0;
            ps = c.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                int j=0;
                RAM[i][j] = rs.getString("nome");
                ++j;
                RAM[i][j] = rs.getString("capacidade");
                ++j;
                RAM[i][j] = rs.getString("frequencia");
                ++i;
            }
            setRAM(RAM);
        } catch (SQLException e) {
            System.exit(0);
        } finally {
            // Conexao.fecharConexao(c, ps, rs);
        }
    }
    public String[] getMinRAMBD(String recRAM[]) {
        int j = 0;
        for(int i = 0; i < 15; ++i){
            if(Float.parseFloat(RAM[i][1])>= Float.parseFloat(recRAM[0])){
                if(Float.parseFloat(RAM[i][1]) < Float.parseFloat(recRAM[1])){
                    ++j;
                }
            }
        }
        String resultNomeRAM[] = new String[j];
        j = 0;
        for(int i = 0; i < 15; ++i){
            if(Float.parseFloat(RAM[i][1]) >= Float.parseFloat(recRAM[0])){
                if(Float.parseFloat(RAM[i][1]) < Float.parseFloat(recRAM[1])){
                    resultNomeRAM[j] = RAM[i][0] + " " + RAM[i][1] + "GB " + RAM[i][2] + " MHz";
                    ++j;
                }
            }
        }
        return resultNomeRAM;
    }
    public String[] getRecRAMBD(String recRAM[]) {
        int j = 0;
        for(int i = 0; i < 15; ++i){
            if(Float.parseFloat(RAM[i][1]) >= Float.parseFloat(recRAM[1])){
                ++j;
            }
        }
        String resultNomeRAM[] = new String[j];
        j = 0;
        for(int i = 0; i < 15; ++i){
            if(Float.parseFloat(RAM[i][1]) >= Float.parseFloat(recRAM[1])){
                resultNomeRAM[j] = RAM[i][0] + " " + RAM[i][1] + "GB " + RAM[i][2] + " MHz";
                ++j;
            }
        }
        return resultNomeRAM;
    }
    public String[] getGeralMinRAMBD(float resultRAMMin, float resultRAMRec) {
        int j = 0;
        for(int i = 0; i < 15; ++i){
            if(Float.parseFloat(RAM[i][1])>= resultRAMMin){
                if(Float.parseFloat(RAM[i][1]) < resultRAMRec){
                    ++j;
                }
            }
        }
        String resultNomeRAM[] = new String[j];
        j = 0;
        for(int i = 0; i < 15; ++i){
            if(Float.parseFloat(RAM[i][1]) >= resultRAMMin){
                if(Float.parseFloat(RAM[i][1]) < resultRAMRec){
                    resultNomeRAM[j] = RAM[i][0] + " " + RAM[i][1] + "GB " + RAM[i][2] + " MHz";
                    ++j;
                }
            }
        }
        return resultNomeRAM;
    }
    public String[] getGeralRecRAMBD(float resultRAM) {
        int j = 0;
        for(int i = 0; i < 15; ++i){
            if(Float.parseFloat(RAM[i][1]) >= resultRAM){
                ++j;
            }
        }
        String resultNomeRAM[] = new String[j];
        j = 0;
        for(int i = 0; i < 15; ++i){
            if(Float.parseFloat(RAM[i][1]) >= resultRAM){
                resultNomeRAM[j] = RAM[i][0] + " " + RAM[i][1] + "GB " + RAM[i][2] + " MHz";
                ++j;
            }
        }
        return resultNomeRAM;
    }
}