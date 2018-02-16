package test;

import negocio.CamareroABM;
import negocio.LoginABM;
import negocio.MesaABM;
import negocio.RestaurantABM;
import negocio.RubroABM;
import negocio.SalonABM;
import negocio.SubrubroABM;
import negocio.TipoUsuarioABM;
import negocio.UsuarioABM;

public class TestTraer {
	public static void main(String[] args) {
		try {
			TipoUsuarioABM tipoUsuarioABM = new TipoUsuarioABM();
			LoginABM loginABM = new LoginABM();
			UsuarioABM usuarioABM = new UsuarioABM();			
			System.out.println(tipoUsuarioABM.traerTipoUsuario(1));
			System.out.println();
			System.out.println(usuarioABM.traerUsuario(1));
			System.out.println();
			System.out.println(loginABM.traerLogin(1));
			System.out.println();
			
//			loginABM.traerLogin("asda");
			
//			System.out.println(loginABM.traerLogin(100)); //login que no existe
//			System.out.println();

			RubroABM rubroABM = new RubroABM();
			SubrubroABM subrubroABM = new SubrubroABM();
			System.out.println(rubroABM.traerRubro(2));
			System.out.println();
			System.out.println(subrubroABM.traerSubrubro(5));
			System.out.println();
			
			CamareroABM camareroABM = new CamareroABM();
			System.out.println(camareroABM.traerCamarero(1));
			System.out.println(camareroABM.traerCamarero(2));
			System.out.println();
			
			RestaurantABM restaurantABM = new RestaurantABM();
			System.out.println(restaurantABM.traerRestaurant(1));
			System.out.println();
			
			SalonABM salonABM = new SalonABM();
			System.out.println(salonABM.traerSalon(1));
			System.out.println(salonABM.traerSalon(2));
			
			MesaABM mesaABM = new MesaABM();
			System.out.println(mesaABM.traerMesa(1));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}