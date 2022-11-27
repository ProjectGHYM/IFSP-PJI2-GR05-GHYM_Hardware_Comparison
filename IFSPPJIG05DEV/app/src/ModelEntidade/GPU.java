package ModelEntidade;

public class GPU extends Componentes
{
    private int clock;
    private int mark;
    private int VRAM;
    private int TDP;

    public GPU(int id, String nome, String marca, int clock, int vRAM, int mark, int tDP, float preco) 
    {
        super(id, nome, marca, preco);

        this.clock = clock;
        this.mark = mark;
        VRAM = vRAM;
        TDP = tDP;

    }

    public int getClock() 
    {
        return clock;
    }

    public void setClock(int clock) 
    {
        this.clock = clock;
    }

    public int getMark() 
    {
        return mark;
    }

    public void setMark(int mark) 
    {
        this.mark = mark;
    }

    public int getVRAM() 
    {
        return VRAM;
    }

    public void setVRAM(int vRAM) 
    {
        VRAM = vRAM;
    }

    public int getTDP() 
    {
        return TDP;
    }

    public void setTDP(int tDP) 
    {
        TDP = tDP;
    }
}
