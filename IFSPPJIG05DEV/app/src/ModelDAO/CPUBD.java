package ModelDAO;

import java.sql.*;

public class CPUBD {
    static String CPU[][] = new String[15][3];
    public static String[][] getCPU() {
        return CPU;
    }
    public static void setCPU(String[][] CPU) {
        CPUBD.CPU = CPU;
    }
    public CPUBD(){
        Connection c;
        c = ConexaoBD.getConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = null;
        query = "SELECT nome, cores, clock FROM Processador;";
        try {
            int i = 0;
            ps = c.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                int j=0;
                CPU[i][j] = rs.getString("nome");
                ++j;
                CPU[i][j] = rs.getString("cores");
                ++j;
                CPU[i][j] = rs.getString("clock");
                ++i;
            }
            setCPU(CPU);
        } catch (SQLException e) {
            System.exit(0);
        } finally {
            // Conexao.fecharConexao(c, ps, rs);
        }
    }
    public String[] getMinCPUBD(String recCPU[]) {
        int j = 0;
        for(int i = 0; i < 15; ++i){
            if(Float.parseFloat(CPU[i][1]) * Float.parseFloat(CPU[i][2]) >= Float.parseFloat(recCPU[0]) * Float.parseFloat(recCPU[1])){
                if(Float.parseFloat(CPU[i][1]) * Float.parseFloat(CPU[i][2]) < Float.parseFloat(recCPU[2]) * Float.parseFloat(recCPU[3])){
                    ++j;
                }
            }
        }
        String resultNomeCPU[] = new String[j];
        j = 0;
        for(int i = 0; i < 15; ++i){
            if(Float.parseFloat(CPU[i][1]) * Float.parseFloat(CPU[i][2]) >= Float.parseFloat(recCPU[0]) * Float.parseFloat(recCPU[1])){
                if(Float.parseFloat(CPU[i][1]) * Float.parseFloat(CPU[i][2]) < Float.parseFloat(recCPU[2]) * Float.parseFloat(recCPU[3])){
                    resultNomeCPU[j] = CPU[i][0];
                    ++j;
                }
            }
        }
        return resultNomeCPU;
    }
    public String[] getRecCPUBD(String recCPU[]) {
        int j = 0;
        for(int i = 0; i < 15; ++i){
            if(Float.parseFloat(CPU[i][1]) * Float.parseFloat(CPU[i][2]) >= Float.parseFloat(recCPU[2]) * Float.parseFloat(recCPU[3])){
                ++j;
            }
        }
        String resultNomeCPU[] = new String[j];
        j = 0;
        for(int i = 0; i < 15; ++i){
            if(Float.parseFloat(CPU[i][1]) * Float.parseFloat(CPU[i][2]) >= Float.parseFloat(recCPU[2]) * Float.parseFloat(recCPU[3])){
                resultNomeCPU[j] = CPU[i][0];
                ++j;
            }
        }
        return resultNomeCPU;
    }
    public String[] getGeralMinCPUBD(float resultCPUMin, float resultCPURec) {
        int j = 0;
        for(int i = 0; i < 15; ++i){
            if(Float.parseFloat(CPU[i][1]) * Float.parseFloat(CPU[i][2]) >= resultCPUMin){
                if(Float.parseFloat(CPU[i][1]) * Float.parseFloat(CPU[i][2]) < resultCPURec){
                    ++j;
                }
            }
        }
        String resultNomeCPU[] = new String[j];
        j = 0;
        for(int i = 0; i < 15; ++i){
            if(Float.parseFloat(CPU[i][1]) * Float.parseFloat(CPU[i][2]) >= resultCPUMin){
                if(Float.parseFloat(CPU[i][1]) * Float.parseFloat(CPU[i][2]) < resultCPURec){
                    resultNomeCPU[j] = CPU[i][0];
                    ++j;
                }
            }
        }
        return resultNomeCPU;
    }
    public String[] getGeralRecCPUBD(float resultCPU) {
        int j = 0;
        for(int i = 0; i < 15; ++i){
            if(Float.parseFloat(CPU[i][1]) * Float.parseFloat(CPU[i][2]) >= resultCPU){
                ++j;
            }
        }
        String resultNomeCPU[] = new String[j];
        j = 0;
        for(int i = 0; i < 15; ++i){
            if(Float.parseFloat(CPU[i][1]) * Float.parseFloat(CPU[i][2]) >= resultCPU){
                resultNomeCPU[j] = CPU[i][0];
                ++j;
            }
        }
        return resultNomeCPU;
    }
}