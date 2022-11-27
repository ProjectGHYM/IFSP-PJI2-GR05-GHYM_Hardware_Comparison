package ModelEntidade;

public class Requisito 
{
    private RecomendacaoCPU cpu;
    private RecomendacaoGPU gpu;
    private RecomendacaoRAM ram;
    
    
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
