package main;
import jogos.*;
import manipulacao.*;
import pagamento.*;

public class App{
  public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Jogos> jogos = new ArrayList <> ();
    
    String resposta;

int x = 1;
	  while (x == 1){
		  x = 0;
    System.out.println("----- MENU DA LUDERIA -----");
    System.out.println("Você deseja:");
    System.out.println("1. Ver todos os jogos cadastrados?");
    System.out.println("2. Cadastrar um novo jogo?");
    System.out.println("3. Remover algum jogo existente?");
    System.out.println("4. Ver todos os jogos em ordem alfabética?");
    System.out.println("5. Alterar os dados de um jogo?");
    System.out.println("6. Sair do sistema?");
    System.out.print("Digite a opção desejada: ");
    resposta = sc.nextLine();

    switch (resposta) {
              case "1":
                  // chamar função listarJogos();
		    x = 1;
                   break;
        
              case "2":
                  // chamar função cadastrarJogo();
		     x = 1;
                  break;
        
              case "3":
                  // chamar função removerJogo();
		     x = 1;
                  break;
        
              case "4":
                 // chamar função listarJogosAlf();
		     x = 1;
                  break;
        
              case "5":
                  // chamar função alterarJogo();
		     x = 1;
                  break;
        
              case "6":
                  System.out.println("Encerrando o sistema. Até logo!");
		     x = 0;
                  break;
        
              default:
                  System.out.println("Opção inválida.");
			x = 1;
    }
  }
}

