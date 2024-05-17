package Etapa4;

public class Bijuteria extends Loja {
    double metaVendas;

    public Bijuteria(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, Endereco endereco, Data dataFundacao, double metaVendas, int capacidadeMaxima) {
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, capacidadeMaxima);
        this.metaVendas = metaVendas;
    }

    public double getMetaVendas() {
        return metaVendas;
    }
    public void setMetaVendas(double metaVendas) {
        this.metaVendas = metaVendas;
    }

    @Override
    public String toString() {
        return ("Loja " + nome + "\nQuantidade de funcionários: " + quantidadeFuncionarios + "\nSalário base: R$" + salarioBaseFuncionario+"\nEndereço da loja: "+endereco+"\nData de fundação: "+dataFundacao+"\nMeta de vendas: R$"+metaVendas);
    }
}
