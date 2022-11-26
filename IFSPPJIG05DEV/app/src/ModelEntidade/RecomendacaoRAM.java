package ModelEntidade;

public class RecomendacaoRAM
{
    private int id;
    private int capacidade;
    
    public RecomendacaoRAM(int id, int capacidade) {
        this.id = id;
        this.capacidade = capacidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
    
    
}
