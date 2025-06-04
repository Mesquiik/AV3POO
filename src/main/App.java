package main;

import manipulacao.*;

public class App {
	public static void main(String[] args) {

		FuncoesMenu menu = new FuncoesMenu();

		menu.cadastrarJogosIniciais();

		menu.menuLoop();

	}
}
