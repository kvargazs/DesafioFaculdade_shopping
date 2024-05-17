package Etapa4;

public class Vestuario extends Loja {
    boolean produtosImportados;

    public Vestuario(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, Endereco endereco, Data dataFundacao, boolean produtosImportados, int capacidadeMaxima) {
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, capacidadeMaxima);
        this.produtosImportados = produtosImportados;
    }

    public boolean getProdutosImportados() {
        return produtosImportados;
    }
    public void setProdutosImportados(boolean produtosImportados) {
        this.produtosImportados = produtosImportados;
    }

    @Override
    public String toString() {
        return ("Loja " + nome + "\nQuantidade de funcionários: " + quantidadeFuncionarios + "\nSalário base: R$" + salarioBaseFuncionario+"\nEndereço da loja: "+endereco+"\nData de fundação: "+dataFundacao+"\nVende produtos importados: "+produtosImportados);
    }
}

