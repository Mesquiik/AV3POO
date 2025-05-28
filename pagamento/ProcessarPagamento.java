package pagamento;

public class ProcessarPagamento {

	private Double valorJogo;
	private TaxaLoja taxaLoja;
	private TaxaPagamento taxaPagamento;
	private Integer dias;
	
	public ProcessarPagamento(Double valorJogo, TaxaLoja taxaLoja, TaxaPagamento taxaPagamento, Integer dias) {		//MEXER NOS DIAS, TALVEZ COLOCAR DATA
		this.valorJogo = valorJogo;
		this.taxaLoja = taxaLoja;
		this.taxaPagamento = taxaPagamento;
		this.dias = dias;
	}
	
	
	public Double calculaValorFinal() {
		
		Double valor;
		
		valor = valorJogo*dias;
		valor += taxaLoja.calculaTaxa();
		valor += taxaPagamento.calculaTaxa(valor);
		
		return valor;
		
	}

	
	
	
	
}
