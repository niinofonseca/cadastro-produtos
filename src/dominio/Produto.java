package dominio;

public class Produto {
    public String nome;
    String tipo;
    double preco;

    //construtor
    public Produto(String nome, String tipo, double preco) {
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
    }

    // Método para exibir os dados do produto
    @Override
    public String toString() {
        return "Nome: " + nome + " | Tipo: " + tipo + " | Preço: R$ " + preco;
    }
}
