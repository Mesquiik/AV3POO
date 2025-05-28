package pagamento;

public class TaxaBarra implements TaxaLoja {

	@Override
	public Double calculaTaxa() {
		
		return 10.0;
	}

}
