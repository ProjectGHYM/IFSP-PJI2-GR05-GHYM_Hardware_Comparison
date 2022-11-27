package ModelEntidade;

public class CPU extends Componentes
{

    private float clock;
    private int core;
    private int threads;
    private int mark;
    private float turbo;
    private int tDP;
    private String arquitetura;
    
    public CPU(int id, String nome, String marca, float clock, float turbo, int core, int threads, int mark, int tDP,
            String arquitetura, float preco) 
    {
        super(id, nome, marca, preco);
        
        this.clock = clock;
        this.core = core;
        this.threads = threads;
        this.mark = mark;
        this.turbo = turbo;
        this.tDP = tDP;
        this.arquitetura = arquitetura;
    
    } 

    public float getClock() 
    {
        return clock;
    }

    public void setClock(float clock) 
    {
        this.clock = clock;
    }

    public int getCore() 
    {
        return core;
    }

    public void setCore(int core) 
    {
        this.core = core;
    }

    public int getThreads() 
    {
        return threads;
    }

    public void setThreads(int threads) 
    {
        this.threads = threads;
    }

    public int getMark() 
    {
        return mark;
    }

    public void setMark(int mark) 
    {
        this.mark = mark;
    }

    public float getTurbo() 
    {
        return turbo;
    }

    public void setTurbo(float turbo) 
    {
        this.turbo = turbo;
    }

    public int getTDP() 
    {
        return tDP;
    }

    public void setTDP(int tDP) 
    {
        this.tDP = tDP;
    }

    public String getArquitetura() 
    {
        return arquitetura;
    }

    public void setArquitetura(String arquitetura) 
    {
        this.arquitetura = arquitetura;
    }
}
