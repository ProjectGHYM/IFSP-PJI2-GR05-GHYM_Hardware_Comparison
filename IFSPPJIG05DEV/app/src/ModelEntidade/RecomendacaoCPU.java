package ModelEntidade;

public class RecomendacaoCPU 
{
    private int id;
    private int core;
    private float clock;
    
    public RecomendacaoCPU(int id, int core, float clock) {
        this.id = id;
        this.core = core;
        this.clock = clock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCore() {
        return core;
    }

    public void setCore(int core) {
        this.core = core;
    }

    public float getClock() {
        return clock;
    }

    public void setClock(float clock) {
        this.clock = clock;
    } 

    
}
