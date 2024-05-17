package Etapa4;

//CLASSE PRODUTO
public class Produto {
    String nome;
    double preco;
    Data dataValidade;

    //CONSTRUTOR 1
    public Produto (String nome, double preco, Data dataValidade) {
        this.nome = nome;
        this.preco = preco;
        this.dataValidade = dataValidade;
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


    public Data getDataValidade() {
        return dataValidade;
    }
    public void setDataValidade(Data dataAtual) {
        this.dataValidade = dataValidade;
    }

    //MÉTODOS

    public boolean estaVencido(Data dataAtual) {
        // Comparando ano, mês e dia para determinar se o produto está vencido
        if (dataAtual.getAno() > dataValidade.getAno()) { //compara se o ano é maior
            return false;
        } else if (dataAtual.getAno() == dataValidade.getAno() && dataAtual.getMes() > dataValidade.getMes()) { //se o ano for igual, compara se o mês é maior
            return false;
        } else if (dataAtual.getAno() == dataValidade.getAno() && dataAtual.getMes() == dataValidade.getMes() && dataAtual.getDia() > dataValidade.getDia()) { //se o ano e o mês forem iguais, compara se o dia é maior
            return false;
        }
        return true;
    }


    //MÉTODO TOSTRING: TRANSFORMA O OBJETO EM STRING
    @Override
    public String toString() {
        return ("Produto "+nome+"\nPreço: "+preco+"\nData de validade: "+dataValidade);
    }
}
