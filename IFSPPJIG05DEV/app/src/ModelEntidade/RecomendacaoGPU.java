package ModelEntidade;

public class RecomendacaoGPU 
{
    private int vramMin;
    private int clockMin;
    private int vramMax;
    private int clockMax;

    public RecomendacaoGPU(int vramMin, int clockMin, int vramMax, int clockMax) 
    {
        this.vramMin = vramMin;
        this.clockMin = clockMin;
        this.vramMax = vramMax;
        this.clockMax = clockMax;
    }

    public static RecomendacaoGPU achaMaiorRequisito(RecomendacaoGPU opcao1, RecomendacaoGPU opcao2)
    {
        RecomendacaoGPU maiorRequesito = new RecomendacaoGPU(0, 0, 0, 0);
        if(opcao1.getClockMin() >= opcao2.getClockMin() && (opcao1.getVramMin() >= opcao2.getVramMin() || opcao1.getVramMin()< opcao2.getVramMin()))
        {
            maiorRequesito.setClockMin(opcao1.getClockMin());
            maiorRequesito.setVramMin(opcao1.getVramMin());
        }
        else if(opcao1.getClockMax() >= opcao2.getClockMax() && (opcao1.getVramMax() >= opcao2.getVramMax() || opcao1.getVramMax()< opcao2.getVramMax()))
        {
            maiorRequesito.setClockMax(opcao1.getClockMax());
            maiorRequesito.setVramMax(opcao1.getVramMax());
        }
        else
        {
            maiorRequesito.setClockMin(opcao2.getClockMin());
            maiorRequesito.setVramMin(opcao2.getVramMin());
            maiorRequesito.setClockMax(opcao2.getClockMax());
            maiorRequesito.setVramMax(opcao2.getVramMax());
        }
        return opcao2;
    }

    public int getVramMax() 
    {
        return vramMax;
    }

    public void setVramMax(int vramMax) 
    {
        this.vramMax = vramMax;
    }

    public int getClockMax() 
    {
        return clockMax;
    }

    public void setClockMax(int clockMax) 
    {
        this.clockMax = clockMax;
    }

    public int getVramMin() 
    {
        return vramMin;
    }

    public void setVramMin(int vramMin) 
    {
        this.vramMin = vramMin;
    }

    public int getClockMin() 
    {
        return clockMin;
    }

    public void setClockMin(int clockMin) 
    {
        this.clockMin = clockMin;
    }
}
