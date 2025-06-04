package jogos;

public class JogoCarta extends Jogos {

	private Integer numeroCartas;

	public JogoCarta(String nome, String codigo, Double preco, Integer numeroCartas) {
		super(nome, codigo, "Carta", preco);
		this.numeroCartas = numeroCartas;
	}

	@Override
	public String toString() {
		return super.toString() + " Número de cartas: " + numeroCartas;
	}
}
