package manipulacao; // Pacote onde a classe está localizada

import jogos.*; // Importa todas as classes do pacote jogos
import java.util.*; // Importa utilitários Java como List, Scanner, etc.
import pagamento.*; // Importa todas as classes do pacote pagamento

public class FuncoesMenu {

	// Lista que armazena os jogos disponíveis
	private static List<Jogos> listaJogos = new ArrayList<>();
	
	// Lista que representa o carrinho de compras (aluguel)
	private static List<Jogos> carrinho = new ArrayList<>();

	// Método que cadastra jogos iniciais na lista
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

	// Lista todos os jogos cadastrados
	public static void listarJogos() {
		System.out.println();
		System.out.println("=== Lista de Jogos ===");
		for (Jogos jogo : listaJogos) {
			System.out.println(jogo);
		}
	}

	// Busca um jogo na lista pelo código
	public static Jogos buscarPorCodigo(String codigo) {
		Jogos jogoEncontrado = null;
		for (Jogos jogo : listaJogos) {
			if (jogo.getCodigo().equalsIgnoreCase(codigo)) {
				System.out.println("Jogo encontrado:");
				System.out.println(jogo);
				jogoEncontrado = jogo;
			}
		}
		if (jogoEncontrado != null) {
			return jogoEncontrado;
		}
		System.out.println("Jogo não encontrado.");
		return null;
	}

	// Lista os jogos em ordem alfabética pelo nome
	public static void listarOrdenadoPorNome() {
		listaJogos.sort(Comparator.comparing(Jogos::getNome));
		listarJogos();
	}

	// Altera o preço de um jogo com base no código
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

	// Remove um jogo da lista usando Iterator (forma segura)
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

	// Outra forma de remover um jogo (usando índice)
	public static void removerJogo2(String codigo) {
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

	// Adiciona um novo jogo à lista
	public static void adicionarJogo(Jogos jogo) {
		listaJogos.add(jogo);
		listarJogos(); // Lista atualizada
	}

	// Menu interativo principal
	public void menuLoop() {
		Scanner scanner = new Scanner(System.in);
		int opcao;

		do {
			// Exibe o menu
			System.out.println();
			System.out.println();
			System.out.println("\n=========== MENU ===========");
			System.out.println("1 - Listar jogos");
			System.out.println("2 - Buscar jogo por código");
			System.out.println("3 - Listar jogos ordenados por nome");
			System.out.println("4 - Alterar preço");
			System.out.println("5 - Adicionar jogo");
			System.out.println("6 - Remover jogo");
			System.out.println("7 - Alugar jogo");
			System.out.println("8 - Sair");
			System.out.println("Escolha uma opção: ");
			opcao = scanner.nextInt();
			scanner.nextLine(); // Limpa buffer

			switch (opcao) {
				case 1 -> listarJogos();
				case 2 -> {
					System.out.println();
					System.out.println("Digite o código do jogo: ");
					buscarPorCodigo(scanner.nextLine());
				}
				case 3 -> listarOrdenadoPorNome();
				case 4 -> {
					System.out.println();
					System.out.println("Código do jogo para alterar: ");
					String codigo = scanner.nextLine();
					System.out.println("Novo preço: ");
					double preco = scanner.nextDouble();
					alterarPreco(codigo, preco);
				}
				case 5 -> {
					// Adiciona um novo jogo com dados informados pelo usuário
					System.out.println();
					System.out.println("Nome do novo jogo: ");
					String nome = scanner.nextLine();
					System.out.println("Código do jogo a adicionar: ");
					String codigo = scanner.nextLine();
					Integer tipo = 0;
					while (tipo != 1 && tipo != 2 && tipo != 3) {
						System.out.println("Tipo do jogo (1- Carta, 2- Tabuleiro, 3- Dado): ");
						tipo = scanner.nextInt();
						if (tipo != 1 && tipo != 2 && tipo != 3) {
							System.out.println("Tipo incorreto, tente novamente.");
						}
					}
					System.out.println("Preço do novo jogo: ");
					Double preco = scanner.nextDouble();
					Jogos jogo;
					if (tipo == 1) {
						System.out.println("Quantas cartas têm o jogo?");
						Integer cartas = scanner.nextInt();
						jogo = new JogoCarta(nome, codigo, preco, cartas);
					} else if (tipo == 2) {
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
					System.out.println();
					System.out.println("Código do jogo para remover: ");
					removerJogo(scanner.nextLine());
				}
				case 7 -> alugarJogos(scanner); // Função para alugar jogos
				
				case 8 -> System.out.println("Saindo."); // Encerra o loop
				default -> System.out.println("Opção inválida.");
			}

		} while (opcao != 8);

		scanner.close(); // Fecha o Scanner
	}

	// Remove um jogo do carrinho de aluguel
	public static void removerJogoCarrinho(String codigo) {
		Iterator<Jogos> iterator = carrinho.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getCodigo().equalsIgnoreCase(codigo)) {
				iterator.remove();
				System.out.println();
				System.out.println("Jogo removido do carrinho com sucesso.");
				return;
			}
		}
		System.out.println("Jogo não encontrado pra remoção.");
	}

	// Função principal para aluguel de jogos
	public void alugarJogos(Scanner scanner) {
		carrinho.clear(); // Limpa o carrinho anterior
		Double total = 0.0;

		// Adiciona jogos ao carrinho
		while (true) {
			listarJogos();
			System.out.println();
			System.out.println("Digite o código do jogo para adicionar ao carrinho (ou 'fim' para encerrar): ");
			String codigo = scanner.nextLine();
			if (codigo.equalsIgnoreCase("fim"))
				break;

			Jogos jogo = buscarPorCodigo(codigo);
			if (jogo != null) {
				carrinho.add(jogo);
				total += jogo.getPreco();
				System.out.println("Jogo adicionado ao carrinho: " + jogo.getNome());
			}
		}

		if (carrinho.isEmpty()) {
			System.out.println("Nenhum jogo selecionado.");
			return;
		}

		boolean x = true;
		while (x) {
			// Mostra os jogos no carrinho e opções ao usuário
			System.out.println();
			System.out.println("\n=== CARRINHO ATUAL ===");
			for (Jogos j : carrinho) {
				System.out.println(j);
			}
			
			System.out.println();
			System.out.println("\nDigite uma opção: ");
			System.out.println("'remover' para remover um jogo do carrinho");
			System.out.println("'cancelar' para cancelar a compra");
			System.out.println("'confirmar' para seguir para pagamento");
			System.out.print("Opção: ");
			String opcao = scanner.nextLine().toLowerCase();

			switch (opcao) {
				case "remover" -> {
					System.out.println();
					System.out.print("Digite o código do jogo que deseja remover: ");
					String codigoRemover = scanner.nextLine();
					removerJogoCarrinho(codigoRemover);
				}
				case "cancelar" -> {
					carrinho.clear();
					System.out.println();
					System.out.println("Compra cancelada.");
					return;
				}
				case "confirmar" -> x = false;
				default -> System.out.println("Escolha inválida.");
			}
		}

		// Processa o pagamento
		System.out.println();
		System.out.println("Digite o número de dias que os jogos serão alugados");
		int dias = scanner.nextInt();
		scanner.nextLine();

		ProcessarPagamento processar = new ProcessarPagamento();
		TaxaLoja taxaLoja = processar.unidadeLoja();

		Double valorBase = total * dias;
		Double valorTotalComTaxa = valorBase + taxaLoja.calculaTaxa();

		TaxaPagamento taxaCartao = new TaxaCartao();
		TaxaPagamento descontoPix = new TaxaPix();

		Double valorCartao = valorTotalComTaxa + taxaCartao.calculaTaxa(valorTotalComTaxa);
		Double valorPix = valorTotalComTaxa + descontoPix.calculaTaxa(valorTotalComTaxa);

		System.out.println("Valor base -> R$ " + String.format("%.2f", valorTotalComTaxa));
		System.out.println("1 - Cartão -> R$ " + String.format("%.2f", valorCartao));
		System.out.println("2 - Pix -> R$ " + String.format("%.2f", valorPix));

		int forma = 0;
		Double valorPago = 0.0;

		// Escolhe a forma de pagamento
		while (forma != 1 && forma != 2) {
			System.out.println();
			System.out.println("Escolha a forma de pagamento: ");
			forma = scanner.nextInt();
			scanner.nextLine();

			if (forma == 1) {
				valorPago = valorCartao;
			} else if (forma == 2) {
				valorPago = valorPix;
			} else {
				System.out.println("Escolha inválida.");
			}
		}

		// Finaliza o processo
		System.out.println();
		System.out.println("\nPagamento realizado com sucesso!");
		System.out.println("Total pago: R$ " + String.format("%.2f", valorPago));
	}
}
