package main;
import jogos.*;
import manipulacao.*;
import pagamento.*;
import java.util.*;

public class App{
  public static void main(String[] args) {
		
		
		FuncoesMenu menu = new FuncoesMenu();
		
		menu.cadastrarJogosIniciais();
		
		menu.menuLoop();
    
  }
}
