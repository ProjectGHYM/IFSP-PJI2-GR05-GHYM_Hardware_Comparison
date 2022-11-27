package ModelEntidade;

public class RecomendacaoCPU 
{
    private int coreMin;
    private float clockMin;
    private int coreMax;
    private float clockMax;
    

    public RecomendacaoCPU(int coreMin, float clockMin, int coreMax, float clockMax) 
    {
        this.coreMin = coreMin;
        this.clockMin = clockMin;
        this.coreMax = coreMax;
        this.clockMax = clockMax;
    }

    public static RecomendacaoCPU achaMaiorRequisito(RecomendacaoCPU opcao1, RecomendacaoCPU opcao2)
    {
        RecomendacaoCPU maiorRequesito = new RecomendacaoCPU(0, 0, 0, 0);
        if(opcao1.getClockMin() >= opcao2.getClockMin() && (opcao1.getCoreMin() >= opcao2.getCoreMin() || opcao1.getCoreMin()< opcao2.getCoreMin()))
        {
            maiorRequesito.setClockMin(opcao1.getClockMin());
            maiorRequesito.setCoreMin(opcao1.getCoreMin());
        }
        if(opcao1.getClockMax() >= opcao2.getClockMax() && (opcao1.getCoreMax() >= opcao2.getCoreMax() || opcao1.getCoreMax()< opcao2.getCoreMax()))
        {
            maiorRequesito.setClockMax(opcao1.getClockMax());
            maiorRequesito.setCoreMax(opcao1.getCoreMax());
        }
        else
        {
            maiorRequesito.setClockMin(opcao2.getClockMin());
            maiorRequesito.setCoreMin(opcao2.getCoreMin());
            maiorRequesito.setClockMax(opcao2.getClockMax());
            maiorRequesito.setCoreMax(opcao2.getCoreMax());
        }
        return maiorRequesito;
    }

    public int getCoreMax() 
    {
        return coreMax;
    }

    public void setCoreMax(int coreMax) 
    {
        this.coreMax = coreMax;
    }

    public float getClockMax() 
    {
        return clockMax;
    }

    public void setClockMax(float clockMax) 
    {
        this.clockMax = clockMax;
    }

    public int getCoreMin() 
    {
        return coreMin;
    }

    public void setCoreMin(int coreMin) 
    {
        this.coreMin = coreMin;
    }

    public float getClockMin() 
    {
        return clockMin;
    }

    public void setClockMin(float clockMin) 
    {
        this.clockMin = clockMin;
    } 
}
