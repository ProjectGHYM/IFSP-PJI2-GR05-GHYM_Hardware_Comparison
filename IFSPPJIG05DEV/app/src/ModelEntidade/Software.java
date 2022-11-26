package ModelEntidade;

public class Software 
{
    private int id;
    private String tipo;
    private String nome; 
    private RecomendacaoRAM ramMinima;
    private RecomendacaoCPU cpuMinima;
    private RecomendacaoGPU gpuMinima;
    private RecomendacaoRAM ramMax;
    private RecomendacaoCPU cpuMax;
    private RecomendacaoGPU gpuMax;
    
    public Software(int id, String tipo, String nome, RecomendacaoRAM ramMinima, RecomendacaoCPU cpuMinima,
            RecomendacaoGPU gpuMinima, RecomendacaoRAM ramMax, RecomendacaoCPU cpuMax, RecomendacaoGPU gpuMax) {
        this.id = id;
        this.tipo = tipo;
        this.nome = nome;
        this.ramMinima = ramMinima;
        this.cpuMinima = cpuMinima;
        this.gpuMinima = gpuMinima;
        this.ramMax = ramMax;
        this.cpuMax = cpuMax;
        this.gpuMax = gpuMax;
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

    public RecomendacaoRAM getRamMinima() {
        return ramMinima;
    }

    public void setRamMinima(RecomendacaoRAM ramMinima) {
        this.ramMinima = ramMinima;
    }

    public RecomendacaoCPU getCpuMinima() {
        return cpuMinima;
    }

    public void setCpuMinima(RecomendacaoCPU cpuMinima) {
        this.cpuMinima = cpuMinima;
    }

    public RecomendacaoGPU getGpuMinima() {
        return gpuMinima;
    }

    public void setGpuMinima(RecomendacaoGPU gpuMinima) {
        this.gpuMinima = gpuMinima;
    }

    public RecomendacaoRAM getRamMax() {
        return ramMax;
    }

    public void setRamMax(RecomendacaoRAM ramMax) {
        this.ramMax = ramMax;
    }

    public RecomendacaoCPU getCpuMax() {
        return cpuMax;
    }

    public void setCpuMax(RecomendacaoCPU cpuMax) {
        this.cpuMax = cpuMax;
    }

    public RecomendacaoGPU getGpuMax() {
        return gpuMax;
    }

    public void setGpuMax(RecomendacaoGPU gpuMax) {
        this.gpuMax = gpuMax;
    } 
    
    
    
}
