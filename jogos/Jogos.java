packages jogos;

public abstract class Jogo {
  private String nome;
  private string codigo;
  private String categoria;
  private Double preco;

public Jogo (Sring nome, String codigo, String categoria, Double preco){
  this.nome = nome;
  this.codigo = codigo;
  this.categoria = categoria;
  this.preco = preco;
}

public String getNome() {
        return nome;
    }
public String getCodigo() {
        return codigo;
}

public String getCategoria() {
        return categoria;
}

public Double getPreco() {
        return preco;
}
}
