package ModelEntidade;

public class CPU 
{
    private int id;
    private String nome;
    private String marca;
    private float clock;
    private int core;
    private int threads;
    private int mark;
    private float turbo;
    private int TDP;
    private String arquitetura;
    private float preco;
   
    public CPU(int id, String nome, String marca, float clock, int core, int threads, int mark, float turbo, int tDP,
            String arquitetura, float preco) 
    {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.clock = clock;
        this.core = core;
        this.threads = threads;
        this.mark = mark;
        this.turbo = turbo;
        TDP = tDP;
        this.arquitetura = arquitetura;
        this.preco = preco;
    } 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getClock() {
        return clock;
    }

    public void setClock(float clock) {
        this.clock = clock;
    }

    public int getCore() {
        return core;
    }

    public void setCore(int core) {
        this.core = core;
    }

    public int getThreads() {
        return threads;
    }

    public void setThreads(int threads) {
        this.threads = threads;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public float getTurbo() {
        return turbo;
    }

    public void setTurbo(float turbo) {
        this.turbo = turbo;
    }

    public int getTDP() {
        return TDP;
    }

    public void setTDP(int tDP) {
        TDP = tDP;
    }

    public String getArquitetura() {
        return arquitetura;
    }

    public void setArquitetura(String arquitetura) {
        this.arquitetura = arquitetura;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
