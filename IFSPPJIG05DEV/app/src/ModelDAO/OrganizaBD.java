package ModelDAO;

import java.util.ArrayList;

public class OrganizaBD 
{
    static float recMinSofts[][];

    public static float[][] getRecMinSofts() 
    {
        return recMinSofts;
    }

    public static void setRecMinSofts(float recMinSofts[][]) 
    {
        OrganizaBD.recMinSofts = recMinSofts;
    }

    public OrganizaBD(ArrayList<String> escsoft)
    {
        recMinSofts = new float[escsoft.size()][6];
        OrganizaBD.setRecMinSofts(recMinSofts);
    }
    
    public void juntaMin(String resultRecCPU[], String resultRecGPU[], String resultRecRAM[], byte cont)
    {
        recMinSofts[cont][0] = Float.parseFloat(resultRecCPU[0]) * Float.parseFloat(resultRecCPU[1]);
        recMinSofts[cont][1] = Float.parseFloat(resultRecCPU[2]) * Float.parseFloat(resultRecCPU[3]);
        recMinSofts[cont][2] = Float.parseFloat(resultRecGPU[0]) * Float.parseFloat(resultRecGPU[1]);
        recMinSofts[cont][3] = Float.parseFloat(resultRecGPU[2]) * Float.parseFloat(resultRecGPU[3]);
        recMinSofts[cont][4] = Float.parseFloat(resultRecRAM[0]);
        recMinSofts[cont][5] = Float.parseFloat(resultRecRAM[1]);
        OrganizaBD.setRecMinSofts(recMinSofts);
    }

    public float CPUMin()
    {       
        return RecomendacaoMultiplosSoftwares(0);   //Equivalente no array
    }
    
    public float CPURec()
    {
        return RecomendacaoMultiplosSoftwares(1);   //Equivalente no array
    }
    
    public float GPUMin()
    {
       return RecomendacaoMultiplosSoftwares(2);    //Equivalente no array
    }
    
    public float GPURec()
    {
        return RecomendacaoMultiplosSoftwares(3);    //Equivalente no array
    }
    
    public float RAMMin()
    {
        return RecomendacaoMultiplosSoftwares(4);    //Equivalente no array
    }

    public float RAMRec()
    {
        return RecomendacaoMultiplosSoftwares(5);    //Equivalente no array
    }

    public float RecomendacaoMultiplosSoftwares(int posicaoVetor)
    {
        float maior = 0;

        for(byte i = 0; i < recMinSofts.length; ++i)
        {
            if(recMinSofts[i][posicaoVetor] > maior)
                maior = recMinSofts[i][posicaoVetor];
        }
        
        return maior;
    }
}
