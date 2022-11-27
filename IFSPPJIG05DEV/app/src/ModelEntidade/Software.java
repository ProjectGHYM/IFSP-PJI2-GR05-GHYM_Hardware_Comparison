package ModelEntidade;

public class Software
{
    private int id;
    private String tipo;
    private String nome; 
    private RecomendacaoRAM ram;
    private RecomendacaoCPU cpu;
    private RecomendacaoGPU gpu;
    
    public Software(int id, String tipo, String nome, RecomendacaoRAM ram, RecomendacaoCPU cpu, RecomendacaoGPU gpu) 
    {
        this.id = id;
        this.tipo = tipo;
        this.nome = nome;
        this.ram = ram;
        this.cpu = cpu;
        this.gpu = gpu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public RecomendacaoRAM getRequisitoRam() {
        return ram;
    }

    public void setRam(RecomendacaoRAM ram) {
        this.ram = ram;
    }

    public RecomendacaoCPU getRequisitoCpu() {
        return cpu;
    }

    public void setCpu(RecomendacaoCPU cpu) {
        this.cpu = cpu;
    }

    public RecomendacaoGPU getRequisitoGpu() {
        return gpu;
    }

    public void setGpu(RecomendacaoGPU gpu) {
        this.gpu = gpu;
    }  
}
