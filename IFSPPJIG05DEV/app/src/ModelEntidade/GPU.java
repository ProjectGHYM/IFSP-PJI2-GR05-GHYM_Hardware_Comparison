package ModelEntidade;

public class GPU 
{
    private int id;
    private String marca;
    private String nome;
    private int clock;
    private int mark;
    private int VRAM;
    private int TDP;
    private float preco;
    
    public GPU(int id, String nome, String marca, int clock, int vRAM, int mark, int tDP, float preco) {
        this.id = id;
        this.marca = marca;
        this.nome = nome;
        this.clock = clock;
        this.mark = mark;
        VRAM = vRAM;
        TDP = tDP;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getClock() {
        return clock;
    }

    public void setClock(int clock) {
        this.clock = clock;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getVRAM() {
        return VRAM;
    }

    public void setVRAM(int vRAM) {
        VRAM = vRAM;
    }

    public int getTDP() {
        return TDP;
    }

    public void setTDP(int tDP) {
        TDP = tDP;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    
}
