package Etapa1;

//CLASSE PRODUTO
public class Produto {
    String nome;
    double preco;

    //CONSTRUTOR 1
    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    //GETTERS E SETTERS
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    //MÉTODO TOSTRING: TRANSFORMA O OBJETO EM STRING
    @Override
    public String toString() {
        return ("Produto "+nome+"\nPreço: "+preco);
    }
}
