package ModelEntidade;

public class RecomendacaoGPU 
{
    private int id;
    private int vram;
    private int clock;
    
    public RecomendacaoGPU(int id, int vram, int clock) {
        this.id = id;
        this.vram = vram;
        this.clock = clock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVram() {
        return vram;
    }

    public void setVram(int vram) {
        this.vram = vram;
    }

    public int getClock() {
        return clock;
    }

    public void setClock(int clock) {
        this.clock = clock;
    }

    
}
