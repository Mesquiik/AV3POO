	package pagamento;
	import java.util.Scanner;
	
	public class ProcessarPagamento {

		public ProcessarPagamento() {		
			
		}
		

		public TaxaLoja unidadeLoja() { 
			
			Scanner sc = new Scanner(System.in);
			
			TaxaLoja taxaSalvador = new TaxaSalvador();
			TaxaLoja taxaBarra = new TaxaBarra();
			
			Integer escolha = 0;
			
			while(escolha != 1 && escolha != 2) {
				System.out.println("Qual a unidade?");
				System.out.println("1- Shopping Barra");
				System.out.println("2- Shopping Salvador");
				
				escolha = sc.nextInt();
				
				if(escolha != 1 && escolha != 2) {
					 System.out.println("Escolha inválida, tente novamente");
				}
			}
			
			if(escolha == 1) {
				return taxaSalvador;
			}else {
				return taxaBarra;
			}
			
			
		}
	}
