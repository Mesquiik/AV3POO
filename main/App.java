package main;
import jogos.*;
import manipulacao.*;
import pagamento.*;
import java.util.*;

public class App{
  public static void main(String[] args) {
		
		TaxaLoja taxaBarra = new TaxaBarra();   //Perguntar antes de tudo
		TaxaLoja taxaSalvador = new TaxaSalvador();

	  
		FuncoesMenu menu = new FuncoesMenu();
		
		menu.cadastrarJogosIniciais();
		
		menu.menuLoop();
    
  }
}
