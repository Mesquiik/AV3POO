package manipulacao;

import jogos.*;
import java.util.*;
import pagamento.*;

public class FuncoesMenu {

	private static List<Jogos> listaJogos = new ArrayList<>();
	private static List<Jogos> carrinho = new ArrayList<>();

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

	public static void removerJogo2(String codigo) { // ver se nao da erro
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

	public static void adicionarJogo(Jogos jogo) {
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
			System.out.println("7 - Alugar jogo");
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
				System.out.println("Novo preço: ");

				double preco = scanner.nextDouble();
				alterarPreco(codigo, preco);
			}

			case 5 -> {
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
				System.out.println("Código do jogo para remover: ");
				removerJogo(scanner.nextLine());
			}

			case 7 -> alugarJogos(scanner);

			case 8 -> {
				System.out.println("Saindo.");
				break;
			}

			default -> System.out.println("Opção inválida.");
			}

		} while (opcao != 8);

		scanner.close();
	}

	public static void removerJogoCarrinho(String codigo) {
		Iterator<Jogos> iterator = carrinho.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getCodigo().equalsIgnoreCase(codigo)) {
				iterator.remove();
				System.out.println("Jogo removido do carrinho com sucesso.");
				return;
			}
		}
		System.out.println("Jogo não encontrado pra remoção.");
	}

	public void alugarJogos(Scanner scanner) {
		List<Jogos> carrinho = new ArrayList<>();
		Double total = 0.0;

		while (true) {
			listarJogos();
			System.out.println("Digite o código do jogo para adicionar ao carrinho (ou 'fim' para encerrar): ");
			String codigo = scanner.nextLine();
			if (codigo.equalsIgnoreCase("fim"))
				break;

			Jogos jogo = buscarPorCodigo(codigo);
			if (jogo != null) {
				carrinho.add(jogo);
				total += jogo.getPreco();
				System.out.println("Jogo adicionado ao carrinho: " + jogo.getNome());

				System.out.println("Carrinho até o momento: ");

				for (Jogos jogoo : carrinho) {
					System.out.println(jogoo);
				}

			} else {
				System.out.println("Código inválido.");
			}
		}

		/*System.out.println("O que gostaria de fazer?");
		System.out.println("1 - Efetuar compra");
		System.out.println("2 - Remover jogo"); -> ta dando tilt
		System.out.println("3 - Cancelar compra"); -> ta dando tilt

		int op = scanner.nextInt();
		scanner.nextLine();

		ajustar o while*/

		if (carrinho.isEmpty()) {
			System.out.println("Nenhum jogo selecionado.");
			return;

		} else {

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

			while (forma != 1 && forma != 2) {

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

			System.out.println("\n Pagamento realizado com sucesso!");
			System.out.println("Total pago: R$ " + String.format("%.2f", valorPago));
		}
	}
}
