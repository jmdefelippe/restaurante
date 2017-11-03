package negocio;

import java.util.List;

import dao.UsuarioDao;
import datos.Usuario;

public class UsuarioABM {

	UsuarioDao dao = new UsuarioDao();
	
	
	public Usuario traerUsuario(int idUsuario) throws Exception{
		Usuario usuario = dao.traerUsuario(idUsuario);
			
    	if (usuario.equals(null))
    		throw new Exception("Error:El usuario no existe");
		
		return usuario;
	}
	
	
	public Usuario traerUsuario(long dni) throws Exception{
		Usuario usuario = dao.traerUsuario(dni);
		
		if (usuario.equals(null))
    		throw new Exception("Error:El usuario no existe");
		
		return usuario;
	}
	
	public Usuario traerUsuarioYTickets(int idUsuario) throws Exception{
		Usuario usuario = dao.traerUsuarioYTickets(idUsuario);
			
    	if (usuario.equals(null))
    		throw new Exception("Error:El usuario no existe");
		
		return usuario;
	}

	
    public int agregar(long dni, String nombre, String apellido) throws Exception{
		if(dao.existeUsuario(dni)){
			throw new Exception("Error:El usuario ya existe");
		}
		
		Usuario usuario = new Usuario(dni, nombre, apellido);
		
		return dao.agregar(usuario);
	}
    
    public int agregar(Usuario usuario) throws Exception{
		if(dao.existeUsuario(usuario.getDni())){
			throw new Exception("Error:El usuario ya existe");
		}
	
		return dao.agregar(usuario);
	}
	
    
	public void modificar(Usuario usuario) throws Exception{
		if(!dao.existeUsuario(usuario.getDni())){
			throw new Exception("Error:El usuario no existe");
		}
		
		dao.actualizar(usuario);
	}
	
	public void eliminar(int id) throws Exception{
		Usuario usuario = dao.traerUsuario(id);
		
		if(dao.existeUsuario(id)){
			dao.eliminar(usuario);
		}else{
    		throw new Exception("Error:El usuario no existe");
		}	
	}
	
	public void eliminar(long dni) throws Exception{
		Usuario usuario = dao.traerUsuario(dni);
		
		if(dao.existeUsuario(dni)){
			dao.eliminar(usuario);
		}else{
    		throw new Exception("Error:El usuario no existe");
		}	
	}
	
	public List<Usuario> traerUsuario(){
		return dao.traerUsuario();
	}
	
}