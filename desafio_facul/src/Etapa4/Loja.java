package Etapa4;

import java.util.ArrayList;
import java.util.List;

//CLASSE LOJA
public class Loja {
    String nome;
    int quantidadeFuncionarios;
    double salarioBaseFuncionario;
    Endereco endereco;
    Data dataFundacao;
    List<Produto> estoqueProdutos;
    int capacidadeMaxima;

    //CONSTRUTOR 1
    public Loja(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, Endereco endereco, Data dataFundacao, int capacidadeMaxima) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = salarioBaseFuncionario;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
        this.capacidadeMaxima = capacidadeMaxima;
        this.estoqueProdutos = new ArrayList<>(capacidadeMaxima); // Inicializa a lista com a capacidade máxima
    }

    //CONSTRUTOR 2
    public Loja (String nome, int quantidadeFuncionarios, Endereco endereco, Data dataFundacao, int capacidadeMaxima) {
        this(nome, quantidadeFuncionarios, -1, endereco, dataFundacao, capacidadeMaxima);
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


    public Produto[] getEstoqueProdutos() {
        Produto[] produtos = new Produto[capacidadeMaxima]; //cria um novo array com o tamanho da capacidade máxima
        for (int i = 0; i < estoqueProdutos.size(); i++) { //percorre a lista de produtos
            produtos[i] = estoqueProdutos.get(i); //copia os produtos da lista para o array
        }
        return produtos;
    }
    public void setEstoqueProdutos(List<Produto> estoqueProdutos) {
        this.estoqueProdutos = estoqueProdutos;
    }


    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }
    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }


    //MÉTODO TOSTRING: TRANSFORMA O OBJETO EM STRING
    @Override
    public String toString() {
        return ("Loja " + nome + "\nQuantidade de funcionários: " + quantidadeFuncionarios +
                "\nSalário base: R$" + salarioBaseFuncionario+"\nEndereço da loja: "+endereco+"\nData de fundação: "+dataFundacao+
                "\nLista de estoque de produtos: "+estoqueProdutos);
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

    //MÉTODO PARA MOSTRAR AS INFORMAÇÕES DOS PRODUTOS
    public void imprimeProdutos() {
        for (Produto produto : estoqueProdutos) { //loop for each, percorrendo todos os elementos da lista
            System.out.println(produto); //imprime os produtos da lista
        }
    }

    //MÉTODO PARA INSERIR PRODUTOS NA LISTA
    public boolean insereProduto(Produto produto) {
        if (estoqueProdutos.size() < capacidadeMaxima) { //verifica se o tamanho do estoque é menor que a capacidade máxima
            estoqueProdutos.add(produto); //se for, adiciona o produto ao estoque
            return true;
        } else { //se não, retorna falso
            return false;
        }
    }

    //MÉTODO PARA REMOVER O PRODUTO DA LISTA POR NOME
    public boolean removeProduto(String nome) {
        for (Produto produto : estoqueProdutos) { //for each q percorre os elementos da lista
            if (produto.getNome().equals(nome)) { //verifica se o nome fornecido é igual ao nome do produto da lista
                estoqueProdutos.remove(produto); //se sim, é removido e retorna verdadeiro
                return true;
            }
        }
        return false;
    }

    //MÉTODO PARA MOSTRAR INFORMAÇÕES SOBRE A LOJA
    public String obterInformacoes() {
        StringBuilder info = new StringBuilder();
        info.append("Nome: ").append(nome).append("\n");
        info.append("Quantidade de funcionários: ").append(quantidadeFuncionarios).append("\n");
        info.append("Salário base dos funcionários: ").append(salarioBaseFuncionario).append("\n");
        info.append("Endereço: ").append(endereco).append("\n");
        info.append("Fundação ").append(dataFundacao).append("\n");
        info.append("Capacidade máxima do estoque: ").append(capacidadeMaxima).append("\n");
        info.append("Tamanho da loja: ").append(tamanhoDaLoja()).append("\n");
        info.append("Gastos com salário: ").append(gastosComSalario()).append("\n");
        //mostra informações de cada produto no estoque
        if (estoqueProdutos.isEmpty()) {
            info.append("Nenhum produto disponível no estoque\n");
        } else {
            info.append("\nLista de estoque de produtos:\n");
            for (Produto produto : estoqueProdutos) {
                info.append(produto).append("\n\n");
            }
        }
        return info.toString();
    }

    //contador de quantos produtos foram adicionadas a cada loja
    public int contarProdutos() {
        return estoqueProdutos.size();
    }
}
