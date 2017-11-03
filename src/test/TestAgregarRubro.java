package test;

import negocio.RubroABM;

public class TestAgregarRubro {
	public static void main(String[] args) {
		try {
		
			RubroABM rubroABM = new RubroABM();
								
/*			int ultimoId = rubroABM.agregar("entrada");
			System.out.println("Rubro agregado: Id=" + ultimoId + ", " + rubroABM.traerRubro(ultimoId));
*/					
						
			int ultimoId = rubroABM.agregar("principal");
			System.out.println("Rubro agregado: Id=" + ultimoId + ", " + rubroABM.traerRubro(ultimoId));
/*			
			ultimoId = rubroABM.agregar("postre");
			System.out.println("Rubro agregado: Id=" + ultimoId + ", " + rubroABM.traerRubro(ultimoId));
			
			ultimoId = rubroABM.agregar("minuta");
			System.out.println("Rubro agregado: Id=" + ultimoId + ", " + rubroABM.traerRubro(ultimoId));
			
			ultimoId = rubroABM.agregar("bebida");
			System.out.println("Rubro agregado: Id=" + ultimoId + ", " + rubroABM.traerRubro(ultimoId));
*/			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}