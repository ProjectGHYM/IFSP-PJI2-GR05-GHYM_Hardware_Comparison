package ModelEntidade;

public abstract class Componentes 
{
    private int id;
    private String nome;
    private String marca;
    private float preco;
   
    public Componentes(int id, String nome, String marca, float preco) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
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
    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }    
    
}