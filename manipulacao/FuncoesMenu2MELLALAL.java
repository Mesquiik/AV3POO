package manipulacao;

import jogos.*;
import java.util.*;

public class FuncoesMenu {

    private static List<Jogos> listaJogos = new ArrayList<>();

   
    public void cadastrarJogosIniciais() {
        listaJogos.add(new JogoCarta("Uno", "001", 5.00, 112));
        listaJogos.add(new JogoCarta("Buraco", "002", 5.00, 108));
        listaJogos.add(new JogoCarta("Blackjack", "003", 5.00, 52));
        listaJogos.add(new JogoTabuleiro("Xadrez", "004", 7.00, 32));
        listaJogos.add(new JogoTabuleiro("War", "005", 7.00, 78));
        listaJogos.add(new JogoTabuleiro("Detetive", "006", 7.00, 48));
        listaJogos.add(new JogoDado("Ludo", "007", 10.00, 2));
        listaJogos.add(new JogoDado("American Dice", "008", 10.00, 5));
    }

   
    public static void listarJogos() {
        System.out.println("=== Lista de Jogos ===");
        for (Jogos jogo : listaJogos) {
            System.out.println(jogo);
        }
    }


    public static void buscarPorCodigo(String codigo) {
        for (Jogos jogo : listaJogos) {
            if (jogo.getCodigo().equalsIgnoreCase(codigo)) {
                System.out.println("Jogo encontrado:");
                System.out.println(jogo);
                return;
            }
        }
        System.out.println("Jogo não encontrado.");
    }


    public static void listarOrdenadoPorNome() {
        listaJogos.sort(Comparator.comparing(Jogos::getNome));
        listarJogos();
    }

 
    public static void alterarPreco(String codigo, double novoPreco) {
        for (Jogos jogo : listaJogos) {
            if (jogo.getCodigo().equalsIgnoreCase(codigo)) {
                jogo.setPreco(novoPreco);
                System.out.println("Jogo atualizado com sucesso.");
                return;
            }
        }
        System.out.println("Jogo não encontrado para alteração.");
    }


    public static void removerJogo(String codigo) {
        Iterator<Jogos> iterator = listaJogos.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getCodigo().equalsIgnoreCase(codigo)) {
                iterator.remove();
                System.out.println("Jogo removido com sucesso.");
                return;
            }
        }
        System.out.println("Jogo não encontrado pra remoção.");
    }


    public static void removerJogo2(String codigo) { //ver se nao da erro
    	for (Jogos jogo : listaJogos) {
            if (jogo.getCodigo().equalsIgnoreCase(codigo)) {
                int index = listaJogos.indexOf(jogo);
                listaJogos.remove(index);
                System.out.println("Jogo removido com sucesso.");
                return;
            }
        }
        System.out.println("Jogo não encontrado para remoção.");
    }

    public static void adicionarJogo (Jogos jogo) {
        listaJogos.add(jogo);
        listarJogos();
    }

    public void menuLoop() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Listar jogos");
            System.out.println("2 - Buscar jogo por código");
            System.out.println("3 - Listar jogos ordenados por nome");
            System.out.println("4 - Alterar preço");
            System.out.println("5 - Adicionar jogo");
            System.out.println("6 - Remover jogo");
            System.out.println("7 -Alugar jogo"); // ainda incompleto
            System.out.println("8 - Sair");
            System.out.println("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> listarJogos();
                case 2 -> {
                    System.out.println("Digite o código do jogo: ");
                    buscarPorCodigo(scanner.nextLine());
                }
                case 3 -> listarOrdenadoPorNome();
                case 4 -> {
                    System.out.println("Código do jogo para alterar: ");
                    String codigo = scanner.nextLine();
                    System.out.println("Novo nome: ");
                    
                    double preco = scanner.nextDouble();
                    alterarPreco(codigo, preco);
                }

                case 5 -> {
                    System.out.println("Nome do novo jogo: ");
                    String nome = scanner.nextLine();
                    System.out.println("Código do jogo a adicionar: ");
                    String codigo = scanner.nextLine();
                    Integer tipo = 0;
                    while (tipo != 1 && tipo != 2 && tipo != 3){
                    System.out.println("Tipo do jogo (1- Carta, 2- Tabuleiro, 3- Dado: ");
                    tipo = scanner.nextInt();
                    if (tipo != 1 && tipo != 2 && tipo != 3){
                        System.out.println("Tipo incorreto, tente novamente.");
                    }
                    }
                    System.out.println("Preço do novo jogo: ");
                    Double preco = scanner.nextDouble();
                    Jogos jogo;
                    if (tipo == 1){
                    	System.out.println("Quantas cartas têm o jogo?");
                    	Integer cartas = scanner.nextInt();
                        jogo = new JogoCarta(nome, codigo, preco, cartas);
                    } else if (tipo == 2){
                    	System.out.println("Quantas peças têm o jogo?");
                    	Integer peças = scanner.nextInt();
                        jogo = new JogoTabuleiro(nome, codigo, preco, peças);
                    } else {
                    	System.out.println("Quantos dados têm o jogo?");
                    	Integer dados = scanner.nextInt();
                        jogo = new JogoDado(nome, codigo, preco, dados);
                    }
                    adicionarJogo(jogo);
                }
                case 6 -> {
                    System.out.println("Código do jogo para remover: ");
                    removerJogo(scanner.nextLine());
                }

                            case 7 -> alugarJogos(scanner);     
                case 8 -> System.out.println("Saindo.");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 6);

        scanner.close();
    }
    public void alugarJogos(Scanner scanner) { 
        List<Jogos> carrinho = new ArrayList<>();
        Double total = 0;

        while (true) { 
            listarJogos();
            System.out.println("Digite o código do jogo para adicionar ao carrinho (ou 'fim' para encerrar): ");
            String codigo = scanner.nextLine();
            if (codigo.equalsIgnoreCase("fim")) break;

            Jogos jogo = buscarJogoPorCodigo(codigo);
            if (jogo != null) { 
                carrinho.add(jogo); 
                total += jogo.getPreco();
                System.out.println("Jogo adicionado: " + jogo.getNome());
            } else { 
                System.out.prinln("Código inválido.");
            } 
        }
        if (carrinho.isEmpty()) { 
            System.out.println("Nenhum jogo selecionado.");
            int dias = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Escolha a loja (1 - Barra, 2 - Salvador): ");
            int lojaEscolha = scanner.nextInt();
            TaxaLoja taxaLoja = (lojaEscolha == 1) ? new TaxaBarra() : new TaxaSalvador();

            Double valorBase = total * dias;
            Double taxaLojaValor = taxaLoja.calculaTaxa();
            Double valorTotalComTaxa = valorBase + taxaLojaValor;

            Double restante = valorTotalComTaxa;
            Double pago = 0;

            while (restante > 0.01) { 
                System.out.println("Restante: R$ " + String.format("%.2f", restante)); 
                System.out.println("Escolha a forma de pagamento (1 - Cartão, 2 - Pix): ");
                int forma = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Quanto deseja pagar com essa forma?");
                Double valorParcial = scanner.nextDouble();
                scanner.nextLine();

                TaxaPagamento taxa;
                if (forma == 1) { 
                    taxa = new TaxaCartao();
                } else { 
                    taxa = new TaxaPix();
                } 
                Double valorComTaxa = valorParcial + taxa.calculaTaxa(valorParcial);
                pago += valorComTaxa;
                restante = valorTotalComTaxa - pago;
            } 
            System.out.println("\n Pagamento realizado com sucesso!");
            System.out.println("Total pago: R$ %.2f\n", pago);
        }
    }

