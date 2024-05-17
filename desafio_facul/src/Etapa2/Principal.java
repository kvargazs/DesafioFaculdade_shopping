package Etapa2;

import java.util.Scanner; //importando o scanner par ler e armazenar as respostas do usuário

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //iniciando o scanner

        Loja loja = null; //loja inicia em null pq não foi criada ainda

        int opcaoEscolhida; //variável para validar a opção escolhida pelo usuário

        do {
            System.out.println("Escolha uma opção: \n(1) Criar uma loja \n(2) Criar um produto \n(3) Sair");
            opcaoEscolhida = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoEscolhida) {
                case 1:
                    System.out.println("Você escolheu criar uma loja!");
                    System.out.println("Digite o nome da loja: ");
                    String nomeLoja = scanner.next();
                    System.out.println("Digite a quantidade de funcionários: ");
                    int quantidadeFuncionarios = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite o salário base dos funcionários da loja: ");
                    double salarioBaseFuncionario = scanner.nextFloat();

                    //solicita o endereço da loja
                    System.out.println("Digite o endereço da sua loja");
                    System.out.print("Nome da Rua: ");
                    String nomeDaRua = scanner.next();
                    System.out.print("Cidade: ");
                    String cidade = scanner.next();
                    System.out.print("Estado: ");
                    String estado = scanner.next();
                    System.out.print("País: ");
                    String pais = scanner.next();
                    System.out.print("CEP: ");
                    String cep = scanner.next();
                    System.out.print("Número: ");
                    String numero = scanner.next();
                    System.out.print("Complemento: ");
                    String complemento = scanner.next();
                    Endereco endereco = new Endereco(nomeDaRua, cidade, estado, pais, cep, numero, complemento);

                    //solicita a data de fundação da loja
                    System.out.println("Digite a data de fundação da loja (DD/MM/AAAA): ");
                    String dataFundacaoLoja = scanner.next();
                    String[] partesDataFundacao = dataFundacaoLoja.split("/");
                    int diaFundacao = Integer.parseInt(partesDataFundacao[0]);
                    int mesFundacao = Integer.parseInt(partesDataFundacao[1]);
                    int anoFundacao = Integer.parseInt(partesDataFundacao[2]);
                    Data dataFundacao = new Data(diaFundacao, mesFundacao, anoFundacao);

                    loja = new Loja(nomeLoja, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao);
                    System.out.println("Etapa2.Loja " + nomeLoja + " criada com sucesso!");
                    break;

                case 2:
                    //se ainda nao houver uma loja criada, não há como criar um produto
                    if (loja == null) {
                        System.out.println("Crie uma loja antes de adicionar produtos.");
                        break;
                    }
                    System.out.println("Você escolheu criar um produto!");
                    System.out.println("Digite o nome do seu produto: ");
                    String nomeProduto = scanner.next();
                    System.out.println("Digite o preço do produto: R$");
                    double preco = scanner.nextInt();
                    scanner.nextLine();

                    //solicita a data de validade do produto
                    System.out.println("Digite a data de validade do produto (DD/MM/AAAA): "); //pede que usuário digite a data no padrão fornecido
                    String dataValidadeProduto = scanner.nextLine(); //scanner armazena
                    String[] partesData = dataValidadeProduto.split("/"); //divide a data forcenida a partir do caracter '/' e armazenando em um array com 3 elementos
                    int dia = Integer.parseInt(partesData[0]); //armazena o valor do dia como tipo inteiro no elemento 0
                    int mes = Integer.parseInt(partesData[1]); //armazena o valor do mes como tipo inteiro no elemento 1
                    int ano = Integer.parseInt(partesData[2]); //armazena o valor do ano como tipo inteiro no elemento 2
                    Data dataValidade = new Data(dia, mes, ano);
                    System.out.println("Validade " +dataValidade);

                    Produto produto = new Produto(nomeProduto, preco, dataValidade); //cria o objeto Produto com os parâmetros fornecidos
                    System.out.println(produto.estaVencido(new Data(20, 10, 2023)) ? "PRODUTO VENCIDO" : "PRODUTO NÃO VENCIDO"); //verifica a data de validade em relação a essa data padrão

                    break;

                case 3:
                    System.out.println("Você escolheu sair!");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcaoEscolhida != 3);

        scanner.close();
    }
}
