package Etapa4;

import java.util.ArrayList;
import java.util.List;

public class Shopping {
    String nome;
    Endereco endereco;
    List<Loja> lojas;
    int capacidadeMaximaShopping;

    public Shopping(String nome, Endereco endereco, int capacidadeMaximaShopping) {
        this.nome = nome;
        this.endereco = endereco;
        this.lojas = new ArrayList<>(capacidadeMaximaShopping);
        this.capacidadeMaximaShopping = capacidadeMaximaShopping;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }


    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


    public Loja[] getLojas() {
        Loja[] arrayLojas = new Loja[capacidadeMaximaShopping];
        for (int i = 0; i < lojas.size(); i++) {
            arrayLojas[i] = lojas.get(i);
        }
        return arrayLojas;
    }
    public void setLojas(List<Loja> lojas) {
        this.lojas = lojas;
    }


    public int getCapacidadeMaximaShopping() {
        return capacidadeMaximaShopping;
    }
    public void setCapacidadeMaximaShopping(int capacidadeMaximaShopping) {
        this.capacidadeMaximaShopping = capacidadeMaximaShopping;
    }

    @Override
    public String toString() {
        return "Shopping {" +
                "nome: " + nome + '\'' +
                ", endereco: " + endereco +
                ", lojas: " + lojas +
                ", capacidadeMaximaShopping: " + capacidadeMaximaShopping +
                '}';
    }

    //MÉTODO PARA INSERIR LOJAS NO SHOPPING
    public boolean insereLoja(Loja loja) {
        if (lojas.size() >= capacidadeMaximaShopping) { //verifica se o tamanho do estoque é menor q a capacidade maxima
            return false; //retorna falso se o shopping estiver cheio
        }

        for (Loja l : lojas) {
            if (l.getNome().equals(loja.getNome())) { //verifica se existem lojas com o mesmo nome
                return false; //retorna falso se já existe uma loja com o mesmo nome
            }
        }

        lojas.add(loja);//adiciona e retorna verdadeiro
        return true; //retorna verdadeiro se a loja foi adicionada com sucesso
    }

    //MÉTODO PARA REMOVER LOJA DO SHOPPING POR NOME
    public boolean removeLoja(String nome) {
        for (Loja loja : lojas) { //for each q percorre os elementos da lista
            if (loja.getNome().equals(nome)) { //verifica se o nome fornecido é igual ao nome da loja na lista
                lojas.remove(loja); //se sim, é removido e retorna verdadeiro
                return true;
            }
        }
        return false;
    }


    //MÉTODO PARA CONTAR A QUANTIDADE DE LOJAS POR TIPO
    public int quantidadeLojasPorTipo(String tipo) {
        int count = 0; // Inicializa o contador
        for (Loja loja : lojas) { // Percorre os elementos da lista de lojas
            // Verifica se o nome do tipo está contido no nome da classe da loja
            if (loja.getClass().getName().toLowerCase().contains(tipo.toLowerCase())) {
                count++; // Incrementa o contador se encontrar o tipo na descrição do nome da classe da loja
            }
        }
        return count; // Retorna o total de lojas encontradas com o tipo especificado
    }


    public Informatica lojaSeguroMaisCaro() {
        Informatica lojaSeguroCaro = null; //armazena qual loja tem seguro mais alto
        double maiorSeguro = 0; //armazena o valor de seguro
        for (Loja loja : lojas) { //for each percorre a lista "lojas"
            if (loja instanceof Informatica) {
                Informatica informatica = (Informatica) loja;
                if (informatica.getSeguroEletronicos() > maiorSeguro) { //verifica se esse é o maior seguro
                    maiorSeguro = informatica.getSeguroEletronicos(); //troca os valores
                    lojaSeguroCaro = informatica; //troca os valores
                }
            }
        }
        return lojaSeguroCaro;
    }

    //contador de quantas lojas foram adicionadas ao shopping
    public int contarLojas() {
        int contador = 0;
        for (Loja loja : lojas) {
            if (loja != null) {
                contador++;
            }
        }
        return contador;
    }
}
