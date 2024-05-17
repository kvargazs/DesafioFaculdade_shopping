package Etapa4;

public class Cosmetico extends Loja {
    double taxaComercializacao;

    public Cosmetico(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, Endereco endereco, Data dataFundacao, double taxaComercializacao, int capacidadeMaxima) {
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, capacidadeMaxima);
        this.taxaComercializacao = taxaComercializacao;
    }

    public double getTaxaComercializacao() {
        return taxaComercializacao;
    }
    public void setTaxaComercializacao(double taxaComercializacao) {
        this.taxaComercializacao = taxaComercializacao;
    }

    @Override
    public String toString() {
        return ("Loja " + nome + "\nQuantidade de funcionários: " + quantidadeFuncionarios + "\nSalário base: R$" + salarioBaseFuncionario+"\nEndereço da loja: "+endereco+"\nData de fundação: "+dataFundacao+"\nTaxa de comercialização: "+taxaComercializacao);
    }
}
