package pagamento;

public class TaxaSalvador implements TaxaLoja {

	@Override
	public Double calculaTaxa() {
		return 5.0;
	}

}

