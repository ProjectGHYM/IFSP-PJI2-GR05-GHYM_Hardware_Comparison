package ModelEntidade;

public class RecomendacaoRAM
{
    private int capacidadeMin;
    private int capacidadeMax;

    public static RecomendacaoRAM achaMaiorRequisito(RecomendacaoRAM opcao1, RecomendacaoRAM opcao2)
    {
        if(opcao1.getCapacidadeMin() >= opcao2.getCapacidadeMin() && opcao1.getCapacidadeMax() >= opcao2.getCapacidadeMax())
        {
            return opcao1;
        }
        else
        {
            return opcao2;
        }      
    }

    public RecomendacaoRAM(int capacidadeMin, int capacidadeMax) 
    {
        this.capacidadeMin = capacidadeMin;
        this.capacidadeMax = capacidadeMax;
    }

    public int getCapacidadeMin() 
    {
        return capacidadeMin;
    }

    public void setCapacidadeMin(int capacidadeMin) 
    {
        this.capacidadeMin = capacidadeMin;
    }

    public int getCapacidadeMax() 
    {
        return capacidadeMax;
    }

    public void setCapacidadeMax(int capacidadeMax) 
    {
        this.capacidadeMax = capacidadeMax;
    }
}
