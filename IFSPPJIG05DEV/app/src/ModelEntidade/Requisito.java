package ModelEntidade;

import java.util.SortedSet;

public class Requisito 
{
    private RecomendacaoCPU cpu = null;;
    private RecomendacaoGPU gpu = null;;
    private RecomendacaoRAM ram = null;;
    private SortedSet<Software> listaSoftwareEscolhido;
    
    public Requisito(SortedSet<Software> listaSoftwaresEscolhidos)
    {
        this.listaSoftwareEscolhido = listaSoftwaresEscolhidos;

        for(Software software: listaSoftwareEscolhido)
        {
            if(cpu == null && gpu == null && ram == null)
            {
                cpu = software.getRequisitoCpu();
                gpu = software.getRequisitoGpu();
                ram = software.getRequisitoRam();
            }
            else
            {
                cpu = RecomendacaoCPU.achaMaiorRequisito(cpu, software.getRequisitoCpu());
                gpu = RecomendacaoGPU.achaMaiorRequisito(gpu, software.getRequisitoGpu());
                ram = RecomendacaoRAM.achaMaiorRequisito(ram, software.getRequisitoRam());
            }
            System.out.println(gpu.getVramMin() + " " + cpu.getClockMin() + " " + ram.getCapacidadeMin());
        }    
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
