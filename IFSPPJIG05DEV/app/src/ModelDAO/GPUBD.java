package ModelDAO;

import java.sql.*;

public class GPUBD {
    static String GPU[][] = new String[15][3];
    public static String[][] getGPU() {
        return GPU;
    }
    public static void setGPU(String[][] GPU) {
        GPUBD.GPU = GPU;
    }
    public GPUBD(){
        Connection c;
        c = ConexaoBD.getConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = null;
        query = "SELECT nome, clock, VRAM FROM GPU;";
        try {
            int i = 0;
            ps = c.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                int j=0;
                GPU[i][j] = rs.getString("nome");
                ++j;
                GPU[i][j] = rs.getString("clock");
                ++j;
                GPU[i][j] = rs.getString("VRAM");
                ++i;
            }
            setGPU(GPU);
        } catch (SQLException e) {
            System.exit(0);
        } finally {
            // Conexao.fecharConexao(c, ps, rs);
        }
    }
    public String[] getMinGPUBD(String recGPU[]) {
        int j = 0;
        for(int i = 0; i < 15; ++i){
            if(Float.parseFloat(GPU[i][1]) * Float.parseFloat(GPU[i][2]) >= Float.parseFloat(recGPU[0]) * Float.parseFloat(recGPU[1])){
                if(Float.parseFloat(GPU[i][1]) * Float.parseFloat(GPU[i][2]) < Float.parseFloat(recGPU[2]) * Float.parseFloat(recGPU[3])){
                    ++j;
                }
            }
        }
        String resultNomeGPU[] = new String[j];
        j = 0;
        for(int i = 0; i < 15; ++i){
            if(Float.parseFloat(GPU[i][1]) * Float.parseFloat(GPU[i][2]) >= Float.parseFloat(recGPU[0]) * Float.parseFloat(recGPU[1])){
                if(Float.parseFloat(GPU[i][1]) * Float.parseFloat(GPU[i][2]) < Float.parseFloat(recGPU[2]) * Float.parseFloat(recGPU[3])){
                    resultNomeGPU[j] = GPU[i][0] + " " + GPU[i][2] + "GB";
                    ++j;
                }
            }
        }
        return resultNomeGPU;
    }
    public String[] getRecGPUBD(String recGPU[]) {
        int j = 0;
        for(int i = 0; i < 15; ++i){
            if(Float.parseFloat(GPU[i][1]) * Float.parseFloat(GPU[i][2]) >= Float.parseFloat(recGPU[2]) * Float.parseFloat(recGPU[3])){
                ++j;
            }
        }
        String resultNomeGPU[] = new String[j];
        j = 0;
        for(int i = 0; i < 15; ++i){
            if(Float.parseFloat(GPU[i][1]) * Float.parseFloat(GPU[i][2]) >= Float.parseFloat(recGPU[2]) * Float.parseFloat(recGPU[3])){
                resultNomeGPU[j] = GPU[i][0] + " " + GPU[i][2] + "GB";
                ++j;
            }
        }
        return resultNomeGPU;
    }
    public String[] getGeralMinGPUBD(float resultGPUMin, float resultGPURec) {
        int j = 0;
        for(int i = 0; i < 15; ++i){
            if(Float.parseFloat(GPU[i][1]) * Float.parseFloat(GPU[i][2]) >= resultGPUMin){
                if(Float.parseFloat(GPU[i][1]) * Float.parseFloat(GPU[i][2]) < resultGPURec){
                    ++j;
                }
            }
        }
        String resultNomeGPU[] = new String[j];
        j = 0;
        for(int i = 0; i < 15; ++i){
            if(Float.parseFloat(GPU[i][1]) * Float.parseFloat(GPU[i][2]) >= resultGPUMin){
                if(Float.parseFloat(GPU[i][1]) * Float.parseFloat(GPU[i][2]) < resultGPURec){
                    resultNomeGPU[j] = GPU[i][0] + " " + GPU[i][2] + "GB";
                    ++j;
                }
            }
        }
        return resultNomeGPU;
    }
    public String[] getGeralRecGPUBD(float resultGPU) {
        int j = 0;
        for(int i = 0; i < 15; ++i){
            if(Float.parseFloat(GPU[i][1]) * Float.parseFloat(GPU[i][2]) >= resultGPU){
                ++j;
            }
        }
        String resultNomeGPU[] = new String[j];
        j = 0;
        for(int i = 0; i < 15; ++i){
            if(Float.parseFloat(GPU[i][1]) * Float.parseFloat(GPU[i][2]) >= resultGPU){
                resultNomeGPU[j] = GPU[i][0] + " " + GPU[i][2] + "GB";
                ++j;
            }
        }
        return resultNomeGPU;
    }
}