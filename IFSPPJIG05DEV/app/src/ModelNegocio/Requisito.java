package ModelNegocio;

import java.util.SortedSet;

import ModelEntidade.RecomendacaoCPU;
import ModelEntidade.RecomendacaoGPU;
import ModelEntidade.RecomendacaoRAM;
import ModelEntidade.Software;

public class Requisito 
{
    private RecomendacaoCPU cpu = null;;
    private RecomendacaoGPU gpu = null;;
    private RecomendacaoRAM ram = null;;
    private SortedSet<Software> listaSoftwareEscolhido;
    
    public Requisito(SortedSet<Software> listaSoftwaresEscolhidos)
    {
        this.listaSoftwareEscolhido = listaSoftwaresEscolhidos;
    }

    public Requisito definirRequisitoGeral() 
    {
        RecomendacaoCPU requisitoCPU = null;
        RecomendacaoGPU requisitoGPU = null;
        RecomendacaoRAM requisitoRAM = null;
        for(Software software: listaSoftwareEscolhido)
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
    

    public Requisito(RecomendacaoCPU cpu, RecomendacaoGPU gpu, RecomendacaoRAM ram) 
    {
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
    }

    public RecomendacaoCPU getCpu() 
    {
        return cpu;
    }

    public void setCpu(RecomendacaoCPU cpu) 
    {
        this.cpu = cpu;
    }

    public RecomendacaoGPU getGpu() 
    {
        return gpu;
    }

    public void setGpu(RecomendacaoGPU gpu) 
    {
        this.gpu = gpu;
    }

    public RecomendacaoRAM getRam() 
    {
        return ram;
    }

    public void setRam(RecomendacaoRAM ram) 
    {
        this.ram = ram;
    }   
     
}
