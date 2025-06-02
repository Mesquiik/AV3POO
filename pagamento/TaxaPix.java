package pagamento;

public class TaxaPix implements TaxaPagamento {

	@Override
	public Double calculaTaxa(Double valor) {
		
		Double taxa;
		taxa = valor * (-0.1); //10% de desconto (vai retornar negativo para reduzir o preço)
		return taxa;
	}

}

