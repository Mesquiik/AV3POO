package jogos;

public class JogoTabuleiro extends Jogos {

	private Integer numeroPecas;

	public JogoTabuleiro(String nome, String codigo, Double preco, Integer numeroPecas) {
		super(nome, codigo, "Tabuleiro", preco);
		this.numeroPecas = numeroPecas;
	}

	//adiciona atributo especifico no tostring
	@Override
	public String toString() {
		return super.toString() + " Número de peças: " + numeroPecas;
	}
}
