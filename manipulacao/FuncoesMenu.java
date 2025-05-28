package manipulacao; 

import jogos.*;
import java.util*;

public class FuncoesMenu{ 
         private  List<Jogos> listaJogos= new ArrayList<>(); 

        public static void cadastrarJogosInicias() { 
  listaJogos.add(new JogoCarta("Uno","001"));
  listaJogos.add(new JogoCarta("Buraco","002")); 
  listaJogos.add(new JogoCarta("Blackjack","003")); 
  listaJogos.add(new JogoTabuleiro("Xadrez","004"));  
  listaJogos.add(new JogoCarta("War","005"));  
  listaJogos.add(new JogoCarta("Detetive","006")); 
  listaJogos.add(new JogoCarta("Ludo","007")); 
  
