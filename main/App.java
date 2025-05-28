package main;
import jogos.*;
import manipulação;
import pagamento.*;

public class App{
  public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Jogo> jogos = new ArrayList <> ();
    
    String resposta;
    
    System.out.println("----- MENU DA LUDERIA -----");
    System.out.println("Você deseja:");
    System.out.println("1. Ver todos os jogos cadastrados?");
    System.out.println("2. Cadastrar um novo jogo?");
    System.out.println("3. Remover algum jogo existente?");
    System.out.println("4. Ver os jogos em ordem alfabética?");
    System.out.println("5. Procurar um jogo pelo código?");
    System.out.println("6. Alterar os dados de um jogo?");
    System.out.println("7. Sair do sistema?");
    System.out.print("Digite a opção desejada: ");
    resposta = scanner.nextLine();

    switch (resposta) {
              case "1":
                  // chamar função listarJogos();
                   break;
        
              case "2":
                  // chamar função cadastrarJogo();
                  break;
        
              case "3":
                  // chamar função removerJogo();
                  break;
        
              case "4":
                  // chamar função ordenarPorNome();
                  break;
        
              case "5":
                 // chamar função buscarJogoPorCodigo();
                  break;
        
              case "6":
                  // chamar função alterarJogo();
                  break;
        
              case "7":
                  System.out.println("Encerrando o sistema. Até logo!");
                  break;
        
              default:
                  System.out.println("Opção inválida.");
    }
  }
}

