package jogos;

public abstract class Jogos {
	private String nome;
	private String codigo;
	private String categoria;
	private Double preco;

	public Jogos(String nome, String codigo, String categoria, Double preco) {
		this.nome = nome;
		this.codigo = codigo;
		this.categoria = categoria;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + ", Código: " + codigo + ", Categoria: " + categoria + ", Preço/dia: R$" + preco + ",";
	}

}
