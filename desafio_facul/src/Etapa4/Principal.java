package Etapa4;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //iniciando o scanner

        Loja loja = null; //loja inicia em null pq não foi criada ainda
        Shopping shopping = null; //shhpping inicia em null pq não foi criado ainda

        int opcaoEscolhida; //variável para validar a opção escolhida pelo usuário

        do {
            System.out.println("\nEscolha uma opção: \n(1) Criar um Shopping \n(2) Criar uma loja \n(3) Criar um produto \n(4) Mostrar lista de lojas do shopping \n(5) Sair");
            opcaoEscolhida = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoEscolhida) {
                case 1:
                    //verifica se já existe um shopping, se sim, não deixa criar outro
                    if (shopping != null) { //verifica se o shopping existe
                        System.out.println("Shopping já existe, não é possível criar outro!");
                        break;
                    }

                    System.out.println("Você escolheu criar um shopping!");
                    System.out.println("Digite o nome do shopping: ");
                    String nomeShopping = scanner.nextLine();
                    System.out.println("ENDEREÇO SHOPPING");
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
                    Endereco enderecoShopping = new Endereco(nomeDaRua, cidade, estado, pais, cep, numero, complemento);
                    System.out.println("Digite a capacidade máxima do shopping:");
                    int capacidadeMaximaShopping = scanner.nextInt();

                    //cria o objeto shopping
                    shopping = new Shopping(nomeShopping, enderecoShopping, capacidadeMaximaShopping);
                    System.out.println("Shopping criado com sucesso!");
                    break;

                case 2:
                    //verifica se existe um shopping
                    if (shopping == null) {
                        System.out.println("Crie um shopping antes de adicionar lojas.");
                        break;
                    }

                    //verifica se a capacidade máxima de lojas no shopping foi alcançada
                    if (shopping.contarLojas() >= shopping.getCapacidadeMaximaShopping()) {
                        System.out.println("A capacidade máxima de lojas foi alcançada. Não é possível adicionar mais lojas.");
                        break;
                    }

                    System.out.println("Escolha o tipo de loja: ");
                    System.out.println("(1) Alimentação");
                    System.out.println("(2) Bijuteria");
                    System.out.println("(3) Cosméticos");
                    System.out.println("(4) Informática");
                    System.out.println("(5) Vestuário");
                    System.out.println("(6) Sair");
                    int tipoLoja = scanner.nextInt();
                    scanner.nextLine();

                    //VARIÁVEIS QUE TODA LOJA TEM
                    System.out.println("Digite o nome da loja: ");
                    String nomeLoja = scanner.nextLine();
                    System.out.println("Digite a quantidade de funcionários: ");
                    int quantidadeFuncionarios = scanner.nextInt();
                    System.out.println("Digite o salário base dos funcionários da loja: ");
                    double salarioBaseFuncionario = scanner.nextDouble();
                    System.out.println("Digite a capacidade máxima de estoque da loja: ");
                    int capacidadeMaxima = scanner.nextInt();
                    scanner.nextLine();

                    //ENDEREÇO LOJA
                    System.out.println("ENDEREÇO DA LOJA");
                    System.out.print("Nome da Rua: ");
                    String nomeDaRuaLoja = scanner.nextLine();
                    System.out.print("Cidade: ");
                    String cidadeLoja = scanner.nextLine();
                    System.out.print("Estado: ");
                    String estadoLoja = scanner.nextLine();
                    System.out.print("País: ");
                    String paisLoja = scanner.nextLine();
                    System.out.print("CEP: ");
                    String cepLoja = scanner.nextLine();
                    System.out.print("Número: ");
                    String numeroLoja = scanner.nextLine();
                    System.out.print("Complemento: ");
                    String complementoLoja = scanner.nextLine();
                    Endereco endereco = new Endereco(nomeDaRuaLoja, cidadeLoja, estadoLoja, paisLoja, cepLoja, numeroLoja, complementoLoja);

                    //DATA DE FUNDAÇÃO DA LOJA
                    System.out.println("Digite a data de fundação da loja (DD/MM/AAAA): ");
                    String dataFundacaoLoja = scanner.next();
                    String[] partesDataFundacao = dataFundacaoLoja.split("/");
                    int diaFundacao = Integer.parseInt(partesDataFundacao[0]);
                    int mesFundacao = Integer.parseInt(partesDataFundacao[1]);
                    int anoFundacao = Integer.parseInt(partesDataFundacao[2]);
                    Data dataFundacao = new Data(diaFundacao, mesFundacao, anoFundacao);

                    switch (tipoLoja) {
                        case 1:
                            //LOJA DE ALIMENTAÇÃO
                            System.out.println("Digite a data do alvará da loja (DD/MM/AAAA): ");
                            String dataAlvaraLojaString = scanner.next();
                            String[] partesDataAlvaraLoja = dataAlvaraLojaString.split("/");
                            int diaAlvara = Integer.parseInt(partesDataAlvaraLoja[0]);
                            int mesAlvara = Integer.parseInt(partesDataAlvaraLoja[1]);
                            int anoAlvara = Integer.parseInt(partesDataAlvaraLoja[2]);
                            Data dataAlvara = new Data(diaAlvara, mesAlvara, anoAlvara);

                            loja = new Alimentacao(nomeLoja, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, dataAlvara, capacidadeMaxima);
                            break;

                        case 2:
                            //LOJA DE BIJUTERIA
                            System.out.println("Digite a meta de vendas: R$");
                            double metaVendas = scanner.nextDouble();
                            loja = new Bijuteria(nomeLoja, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, metaVendas, capacidadeMaxima);
                            break;

                        case 3:
                            //LOJA DE COSMÉTICOS
                            System.out.println("Digite a taxa de comercialização: R$");
                            double taxaComercializacao = scanner.nextDouble();
                            loja = new Cosmetico(nomeLoja, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, taxaComercializacao, capacidadeMaxima);
                            break;

                        case 4:
                            //LOJA DE INFORMÁTICA
                            System.out.println("Digite o valor do Seguro Eletrônicos: R$");
                            double seguroEletronicos = scanner.nextDouble();
                            loja = new Informatica(nomeLoja, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, seguroEletronicos, capacidadeMaxima);
                            break;

                        case 5:
                            //LOJA DE VESTUÁRIO
                            System.out.println("Vende produtos importados (sim/não): ");
                            String resposta = scanner.next().toLowerCase();
                            boolean produtosImportados = resposta.equals("sim") || resposta.equals("s");
                            loja = new Vestuario(nomeLoja, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, produtosImportados, capacidadeMaxima);
                            break;

                        case 6:
                            System.out.println("Você escolheu sair!");
                            break;

                        default:
                            System.out.println("Opção inválida!");
                    }

                    if (loja != null) {
                        if (shopping.insereLoja(loja)) {
                            System.out.println("Loja adicionada com sucesso!");
                        } else {
                            System.out.println("Não foi possível adicionar a loja. Capacidade máxima atingida ou loja já existe.");
                        }
                    }
                    break;

                case 3:
                    //se ainda nao houver uma loja criada, não há como criar um produto
                    if (shopping == null || shopping.getLojas() == null || shopping.getLojas().length == 0) {
                        System.out.println("Antes de adicionar produtos, crie um shopping e adicione pelo menos uma loja.");
                        break;
                    }

                    System.out.println("Você escolheu criar um produto!");

                    //LISTA DE LOJAS EXISTENTES
                    System.out.println("\nLojas disponíveis: ");
                    Loja[] lojas = shopping.getLojas();
                    boolean lojasDisponiveis = false;
                    for (int i = 0; i < lojas.length; i++) {
                        if (lojas[i] != null) {
                            System.out.println("(" + (i + 1) + ") " + lojas[i].getNome());
                            lojasDisponiveis = true;
                        }
                    }

                    //se não existir loja, não deixa adicioanr produtos
                    if (!lojasDisponiveis) {
                        System.out.println("Nenhuma loja disponível para adicionar produtos. Crie sua primeira loja!");
                        break;
                    }

                    System.out.println("Escolha a loja para adicionar o produto (digite o número correspondente): ");
                    int escolhaLoja = scanner.nextInt();
                    scanner.nextLine();

                    if (escolhaLoja < 1 || escolhaLoja > lojas.length || lojas[escolhaLoja - 1] == null) {
                        System.out.println("Opção inválida.");
                        break;
                    }

                    //obtém a loja escolhida pelo usuário de acordo com o array
                    Loja lojaEscolhida = lojas[escolhaLoja - 1];

                    //verifica se ainda é possível adicionar produtos de acordo com a capacidade máxima de estoque da loja
                    if (lojaEscolhida.contarProdutos() >= lojaEscolhida.getCapacidadeMaxima()) {
                        System.out.println("A capacidade máxima de estoque da loja foi alcançada. Não é possível adicionar mais produtos.");
                        break;
                    }

                    //adiciona infos do produto
                    System.out.println("Digite o nome do seu produto: ");
                    String nomeProduto = scanner.next();
                    System.out.println("Digite o preço do produto: R$");
                    double preco = scanner.nextDouble();
                    scanner.nextLine();

                    //data de validade do produto
                    System.out.println("Digite a data de validade do produto (DD/MM/AAAA): ");
                    String dataValidadeProduto = scanner.nextLine();
                    String[] partesData = dataValidadeProduto.split("/");
                    int dia = Integer.parseInt(partesData[0]);
                    int mes = Integer.parseInt(partesData[1]);
                    int ano = Integer.parseInt(partesData[2]);
                    Data dataValidade = new Data(dia, mes, ano);

                    //cria o objeto do produto
                    Produto produto = new Produto(nomeProduto, preco, dataValidade);

                    //adiciona o produto na lista de produtos da loja
                    System.out.println("Produto adicionado com sucesso à loja " + lojaEscolhida.getNome());
                    lojaEscolhida.insereProduto(produto);
                    break;

                case 4:
                    //verifica se há um shopping criado
                    if (shopping == null) {
                        System.out.println("Não existem shoppings cadastrados no sistema!");
                        break;
                    } else if (shopping.getLojas() == null || shopping.getLojas().length == 0) { //verifica se o shopping tem alguma loja
                        System.out.println("Não existem lojas cadastradas no sistema.");
                        break;
                    }

                    //mostra uma lista de lojas existentes para o usuário
                    Loja[] listaDeLojas = shopping.getLojas();
                    System.out.println("\nLista de Lojas do Shopping:");

                    boolean lojasEncontradas = false;
                    for (int i = 0; i < listaDeLojas.length; i++) {
                        if (listaDeLojas[i] != null) {
                            System.out.println((i + 1) + " - " + listaDeLojas[i].getNome());
                            lojasEncontradas = true;
                        }
                    }

                    if (!lojasEncontradas) {
                        System.out.println("Não existem lojas cadastradas no sistema.");
                        break;
                    }

                    //menu secundário para ver informações das lojas ou voltar ao menu principal
                    System.out.println("\nEscolha uma opção: \n(1) Ver infos de uma loja \n(2) Voltar ao menu principal");
                    int subOpcao = scanner.nextInt();
                    scanner.nextLine();

                    switch (subOpcao) {
                        case 1:
                            //usuário escolhe a loja e vê informações da mesma
                            System.out.println("Escolha a loja para ver informações detalhadas (digite o número correspondente): ");
                            System.out.println("\nLojas disponíveis: ");

                            //mostra lista de lojas
                            for (int i = 0; i < listaDeLojas.length; i++) {
                                if (listaDeLojas[i] != null) {
                                    System.out.println("(" + (i + 1) + ") " + listaDeLojas[i].getNome());
                                }
                            }

                            //usuário escolhe
                            int escolhaLojaInfo = scanner.nextInt();
                            scanner.nextLine();

                            if (escolhaLojaInfo < 1 || escolhaLojaInfo > listaDeLojas.length || listaDeLojas[escolhaLojaInfo - 1] == null) {
                                System.out.println("Opção inválida.");
                                break;
                            }

                            //mostra infos da loja escolhida
                            Loja lojaInfo = listaDeLojas[escolhaLojaInfo - 1];
                            System.out.println("Informações da Loja " + lojaInfo.getNome() + ":");
                            System.out.println(lojaInfo.obterInformacoes());

                            // menu secundário para editar produtos ou voltar ao menu anterior
                            System.out.println("\nEscolha uma opção: \n(1) Adicionar produtos \n(2) Remover produtos \n(3) Voltar ao menu anterior");
                            int subOpcaoLoja = scanner.nextInt();
                            scanner.nextLine();

                            switch (subOpcaoLoja) {
                                case 1:
                                    System.out.println("Você escolheu ADICIONAR produtos!");

                                    //solicita as informações do produto para o usuário
                                    System.out.println("Digite o nome do produto: ");
                                    String nomeNovoProduto = scanner.nextLine();
                                    System.out.println("Digite o preço do produto: R$");
                                    double precoNovoProduto = scanner.nextDouble();
                                    scanner.nextLine();
                                    System.out.println("Digite a data de validade do produto (DD/MM/AAAA): ");
                                    String dataPartesNovoProduto = scanner.nextLine();
                                    String[] partesDataNovoProduto = dataPartesNovoProduto.split("/");
                                    int diaNovoProduto = Integer.parseInt(partesDataNovoProduto[0]);
                                    int mesNovoProduto = Integer.parseInt(partesDataNovoProduto[1]);
                                    int anoNovoProduto = Integer.parseInt(partesDataNovoProduto[2]);
                                    Data dataValidadeNovoProduto = new Data(diaNovoProduto, mesNovoProduto, anoNovoProduto);

                                    //cria o objeto do produto
                                    Produto novoProduto = new Produto(nomeNovoProduto, precoNovoProduto, dataValidadeNovoProduto);

                                    //adiciona o produto à lista de estoque da loja
                                    if (lojaInfo.insereProduto(novoProduto)) {
                                        System.out.println("Produto adicionado com sucesso à loja " + lojaInfo.getNome());
                                    } else {
                                        System.out.println("Não foi possível adicionar o produto. Capacidade máxima de estoque atingida.");
                                    }
                                    break;

                                case 2:
                                    System.out.println("Você escolheu REMOVER produtos!");

                                    //verifica se há produtos na loja
                                    if (lojaInfo.contarProdutos() == 0) {
                                        System.out.println("A loja não possui produtos para remover.");
                                        break;
                                    }

                                    //solicita o nome do produto a ser removido
                                    System.out.println("Digite o nome do produto que deseja remover: ");
                                    String nomeProdutoRemover = scanner.nextLine();

                                    //verifica se o produto existe na lista de estoque da loja escolhida
                                    if (lojaInfo.removeProduto(nomeProdutoRemover)) {
                                        System.out.println("Produto removido com sucesso da loja " + lojaInfo.getNome());
                                    } else {
                                        System.out.println("Produto não encontrado na lista de estoque da loja.");
                                    }
                                    break;

                                case 3:
                                    System.out.println("Você escolheu voltar ao menu anterior!");
                                    break;
                                default:
                                    System.out.println("Opção inválida!");
                            }
                            break;

                        case 2:
                            System.out.println("Você escolheu voltar ao menu principal!");
                            break;

                        default:
                            System.out.println("Opção inválida!");
                    }
                    break;

                case 5:
                    System.out.println("Você escolheu sair!");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcaoEscolhida != 5); //continua o loop enquanto a opção escolhida não for válida

        scanner.close();
    }
}