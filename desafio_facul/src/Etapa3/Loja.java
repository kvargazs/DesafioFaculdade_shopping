package Etapa3;

//CLASSE LOJA
public class Loja {
    String nome;
    int quantidadeFuncionarios;
    double salarioBaseFuncionario;
    Endereco endereco;
    Data dataFundacao;

    //CONSTRUTOR 1
    public Loja(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, Endereco endereco, Data dataFundacao) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = salarioBaseFuncionario;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
    }

    //CONSTRUTOR 2
    public Loja(String nome, int quantidadeFuncionarios, Endereco endereco, Data dataFundacao) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = -1;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
    }

    //GETTERS E SETTERS
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }


    public int getQuantidadeFuncionarios() {
        return quantidadeFuncionarios;
    }
    public void setQuantidadeFuncionarios(int quantidadeFuncionarios) {
        this.quantidadeFuncionarios = quantidadeFuncionarios;
    }


    public double getSalarioBaseFuncionario() {
        return salarioBaseFuncionario;
    }
    public void setSalarioBaseFuncionario(double salarioBaseFuncionario) {
        this.salarioBaseFuncionario = salarioBaseFuncionario;
    }


    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


    public Data getDataFundacao() {
        return dataFundacao;
    }
    public void setDataFundacao(Data dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    //MÉTODO TOSTRING: TRANSFORMA O OBJETO EM STRING
    @Override
    public String toString() {
        return ("Loja " + nome + "\nQuantidade de funcionários: " + quantidadeFuncionarios + "\nSalário base: R$" + salarioBaseFuncionario+"\nEndereço da loja: "+endereco+"\nData de fundação: "+dataFundacao);
    }

    //MÉTODO PARA SABER O GASTO TOTAL QUE A LOJA TEM COM FUNCIONÁRIOS
    public double gastosComSalario() {
        if (salarioBaseFuncionario == -1) {
            return -1;
        } else {
            return quantidadeFuncionarios * salarioBaseFuncionario;
        }
    }

    //MÉTODO PARA SABER O TAMANHO DA LOJA
    public String tamanhoDaLoja() {
        if (quantidadeFuncionarios < 10) {
            return "P";
        } else if (quantidadeFuncionarios >= 10 && quantidadeFuncionarios <= 30) {
            return "M";
        } else {
            return "G";
        }
    }
}
