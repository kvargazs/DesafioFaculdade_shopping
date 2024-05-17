package Etapa1;

//CLASSE LOJA
public class Loja {
    String nome;
    int quantidadeFuncionarios;
    double salarioBaseFuncionario;

    //CONSTRUTOR 1
    public Loja (String nome, int quantidadeFuncionarios, double salarioBaseFuncionario) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = salarioBaseFuncionario;
    }

    //CONSTRUTOR 2
    public Loja (String nome, int quantidadeFuncionarios) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = -1;
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

    //MÉTODO TOSTRING: TRANSFORMA O OBJETO EM STRING
    @Override
    public String toString() {
        return ("Loja "+nome+"\nQuantidade de funncionários: "+quantidadeFuncionarios+"\nSalário base: "+salarioBaseFuncionario);
    }
}
