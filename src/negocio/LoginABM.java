package negocio;

import java.util.List;

import dao.LoginDao;
import datos.Login;
import datos.Usuario;

public class LoginABM {

	LoginDao dao = new LoginDao();
	
	
	public Login traerLogin(int idLogin) throws Exception{
		Login login = dao.traerLogin(idLogin);
			
    	if (login.equals(null))
    		throw new Exception("Error:El login no existe");
		
		return login;
	}
	
	
	public Login traerLogin(String nick) throws Exception{
		Login login = dao.traerLogin(nick);
		
		if (login.equals(null))
    		throw new Exception("Error:El login no existe");
		
		return login;
	}

	/*
	public Login traerLoginYUsuario(int idLogin) throws Exception{
		Login login = dao.traerLoginYUsuario(idLogin);
			
    	if (login.equals(null))
    		throw new Exception("Error:El login no existe");
		
		return login;
	}
	*/

	
    public int agregar(String nick, String clave, Usuario usuario) throws Exception{
		if(dao.existeLogin(nick)){
			throw new Exception("Error:El login ya existe");
		}
		
		Login login = new Login(nick, clave, usuario);
		
		return dao.agregar(login);
	}
    
    public int agregar(Login login) throws Exception{
		if(dao.existeLogin(login.getNick())){
			throw new Exception("Error:El login ya existe");
		}
	
		return dao.agregar(login);
	}
	
    
	public void modificar(Login login) throws Exception{
		if(!dao.existeLogin(login.getNick())){
			throw new Exception("Error:El login no existe");
		}
		
		dao.actualizar(login);
	}
	
	public void eliminar(int id) throws Exception{
		Login login = dao.traerLogin(id);
		
		if(dao.existeLogin(id)){
			dao.eliminar(login);
		}else{
    		throw new Exception("Error:El login no existe");
		}	
	}
	
	public void eliminar(String nick) throws Exception{
		Login login = dao.traerLogin(nick);
		
		if(dao.existeLogin(nick)){
			dao.eliminar(login);
		}else{
    		throw new Exception("Error:El login no existe");
		}	
	}
	
	public List<Login> traerLogin(){
		return dao.traerLogin();
	}
	
}