package manipulacao;

import jogos.*;
import java.util.*;

public class FuncoesMenu {

    private static List<Jogos> listaJogos = new ArrayList<>();

   
    public static void cadastrarJogosIniciais() {
        listaJogos.add(new JogoCarta("Uno", "001", 5.00));
        listaJogos.add(new JogoCarta("Buraco", "002", 5.00));
        listaJogos.add(new JogoCarta("Blackjack", "003", 5.00));
        listaJogos.add(new JogoTabuleiro("Xadrez", "004", 7.00));
        listaJogos.add(new JogoTabuleiro("War", "005", 7.00));
        listaJogos.add(new JogoTabuleiro("Detetive", "006", 7.00));
        listaJogos.add(new JogoDado("Ludo", "007", 10.00));
        listaJogos.add(new JogoDado("American Dice", "008", 10.00));
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

 
    public static void alterarJogo(String codigo, String novoNome, double novoPreco) {
        for (Jogos jogo : listaJogos) {
            if (jogo.getCodigo().equalsIgnoreCase(codigo)) {
                jogo.setNome(novoNome);
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

    
    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Listar jogos");
            System.out.println("2 - Buscar jogo por código");
            System.out.println("3 - Listar jogos ordenados por nome");
            System.out.println("4 - Alterar jogo");
            System.out.println("5 - Remover jogo");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> listarJogos();
                case 2 -> {
                    System.out.print("Digite o código do jogo: ");
                    buscarPorCodigo(scanner.nextLine());
                }
                case 3 -> listarOrdenadoPorNome();
                case 4 -> {
                    System.out.print("Código do jogo para alterar: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Novo nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Novo preço: ");
                    double preco = scanner.nextDouble();
                    alterarJogo(codigo, nome, preco);
                }
                case 5 -> {
                    System.out.print("Código do jogo para remover: ");
                    removerJogo(scanner.nextLine());
                }
                case 6 -> System.out.println("Saindo.");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 6);

        scanner.close();
    }
}

  
