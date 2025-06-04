package pagamento;

public class TaxaCartao implements TaxaPagamento {

	@Override
	public Double calculaTaxa(Double valor) {
		
		Double taxa;
		taxa = valor * (0.05); //5% de acrescimo
		return taxa;
	}

}

