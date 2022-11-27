package ModelDAO;

import java.util.SortedSet;
import ModelEntidade.RecomendacaoCPU;
import ModelEntidade.RecomendacaoGPU;
import ModelEntidade.RecomendacaoRAM;
import ModelEntidade.Requisito;
import ModelEntidade.Software;

public class OrganizaBD 
{
    SortedSet<Software> softwareEscolhido;

    public OrganizaBD(SortedSet<Software> softwareEscolhido) 
    {
        this.softwareEscolhido = softwareEscolhido;    
    }

    public Requisito definirRequisitoGeral() 
    {
        RecomendacaoCPU requisitoCPU = null;
        RecomendacaoGPU requisitoGPU = null;
        RecomendacaoRAM requisitoRAM = null;
        for(Software software: softwareEscolhido)
        {
            if(requisitoCPU == null && requisitoGPU == null && requisitoRAM == null)
            {
                requisitoCPU = software.getRequisitoCpu();
                requisitoGPU = software.getRequisitoGpu();
                requisitoRAM = software.getRequisitoRam();
            }
            else
            {
                requisitoCPU = RecomendacaoCPU.achaMaiorRequisito(requisitoCPU, software.getRequisitoCpu());
                requisitoGPU = RecomendacaoGPU.achaMaiorRequisito(requisitoGPU, software.getRequisitoGpu());
                requisitoRAM = RecomendacaoRAM.achaMaiorRequisito(requisitoRAM, software.getRequisitoRam());
            }
        }

        Requisito requisitos = new Requisito(requisitoCPU, requisitoGPU, requisitoRAM);
        return requisitos;
    }
}
