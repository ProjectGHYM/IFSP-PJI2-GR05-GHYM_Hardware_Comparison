package ModelEntidade;

public class RAM 
{
    private int id;
    private String marca;
    private String nome;
    private int frequencia;
    private int capacidade;
    private String tipo;
    private float preco;
    
    public RAM(int id, String nome, String marca, int frequencia, int capacidade, String tipo, float preco) 
    {
        this.id = id;
        this.marca = marca;
        this.nome = nome;
        this.frequencia = frequencia;
        this.capacidade = capacidade;
        this.tipo = tipo;
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
    public int getFrequencia() {
        return frequencia;
    }
    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }
    public int getCapacidade() {
        return capacidade;
    }
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    
}
