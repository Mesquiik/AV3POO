package jogos;

public class JogoDado extends Jogos{
	
	private Integer numeroDados;
	
  public JogoDado (String nome, String codigo, Double preco, Integer numeroDados){
	  super (nome, codigo, "Dado", preco);
	  this.numeroDados = numeroDados;
  }
}
