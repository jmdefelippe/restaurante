package test;

import negocio.LoginABM;
import negocio.TipoUsuarioABM;
import negocio.UsuarioABM;

public class TestTraerTipoUsuario {
	public static void main(String[] args) {
		try {
			TipoUsuarioABM tipoUsuarioABM = new TipoUsuarioABM();
			LoginABM loginABM = new LoginABM();
			UsuarioABM usuarioABM = new UsuarioABM();
			
			System.out.println(tipoUsuarioABM.traerTipoUsuario(1));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}