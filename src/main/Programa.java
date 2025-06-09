package main;

import manipulacao.*;

public class Programa {
	public static void main(String[] args) {

		FuncoesMenu menu = new FuncoesMenu();

		menu.cadastrarJogosIniciais();

		menu.menuLoop();

	}
}
