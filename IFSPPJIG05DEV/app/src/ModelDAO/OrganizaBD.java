package ModelDAO;

import java.util.ArrayList;

public class OrganizaBD {
    static float recMinSofts[][];

    public static float[][] getRecMinSofts() {
        return recMinSofts;
    }

    public static void setRecMinSofts(float recMinSofts[][]) {
        OrganizaBD.recMinSofts = recMinSofts;
    }

    public OrganizaBD(ArrayList<String> escsoft){
        recMinSofts = new float[escsoft.size()][6];
        OrganizaBD.setRecMinSofts(recMinSofts);
    }
    
    public void juntaMin(String resultRecCPU[], String resultRecGPU[], String resultRecRAM[], byte cont){
        recMinSofts[cont][0] = Float.parseFloat(resultRecCPU[0]) * Float.parseFloat(resultRecCPU[1]);
        recMinSofts[cont][1] = Float.parseFloat(resultRecCPU[2]) * Float.parseFloat(resultRecCPU[3]);
        recMinSofts[cont][2] = Float.parseFloat(resultRecGPU[0]) * Float.parseFloat(resultRecGPU[1]);
        recMinSofts[cont][3] = Float.parseFloat(resultRecGPU[2]) * Float.parseFloat(resultRecGPU[3]);
        recMinSofts[cont][4] = Float.parseFloat(resultRecRAM[0]);
        recMinSofts[cont][5] = Float.parseFloat(resultRecRAM[1]);
        OrganizaBD.setRecMinSofts(recMinSofts);
    }
    public float CPUMin(){
        float maiorCPUMin = 0;
        for(byte i = 0; i < recMinSofts.length; ++i){
            if(recMinSofts[i][0] > maiorCPUMin){
                maiorCPUMin = recMinSofts[i][0];
            }
        }
        float resultRecsCPUSoft = maiorCPUMin;
        return resultRecsCPUSoft;
    }
    public float CPURec(){
        float maiorCPURec = 0;
        for(byte i = 0; i < recMinSofts.length; ++i){
            if(recMinSofts[i][1] > maiorCPURec){
                maiorCPURec = recMinSofts[i][1];
            }
        }
        float resultRecsCPUSoft = maiorCPURec;
        return resultRecsCPUSoft;
    }
    
    public float GPUMin(){
        float maiorGPUMin = 0;
        for(byte i = 0; i < recMinSofts.length; ++i){
            if(recMinSofts[i][2] > maiorGPUMin){
                maiorGPUMin = recMinSofts[i][2];
            }
        }
        float resultRecsGPUSoft = maiorGPUMin;
        return resultRecsGPUSoft;
    }
    public float GPURec(){
        float maiorGPURec = 0;
        for(byte i = 0; i < recMinSofts.length; ++i){
            if(recMinSofts[i][3] > maiorGPURec){
                maiorGPURec = recMinSofts[i][3];
            }
        }
        float resultRecsGPUSoft = maiorGPURec;
        return resultRecsGPUSoft;
    }
    public float RAMMin(){
        float maiorRAMMin = 0;
        for(byte i = 0; i < recMinSofts.length; ++i){
            if(recMinSofts[i][4] > maiorRAMMin){
                maiorRAMMin = recMinSofts[i][4];
            }
        }
        float resultRecsRAMSoft = maiorRAMMin;
        return resultRecsRAMSoft;
    }
    public float RAMRec(){
        float maiorRAMRec = 0;
        for(byte i = 0; i < recMinSofts.length; ++i){
            if(recMinSofts[i][5] > maiorRAMRec){
                maiorRAMRec = recMinSofts[i][5];
            }
        }
        float resultRecsRAMSoft = maiorRAMRec;
        return resultRecsRAMSoft;
    }
}
