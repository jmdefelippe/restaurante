package negocio;

import java.util.List;

import dao.TipoUsuarioDao;
import datos.TipoUsuario;
import datos.Usuario;

public class TipoUsuarioABM {

	TipoUsuarioDao dao = new TipoUsuarioDao();
	
	
	public TipoUsuario traerTipoUsuario(int idTipoUsuario) throws Exception{
		TipoUsuario tipoUsuario = dao.traerTipoUsuario(idTipoUsuario);
			
    	if (tipoUsuario.equals(null))
    		throw new Exception("Error:El tipoUsuario no existe");
		
		return tipoUsuario;
	}
	
	
	public TipoUsuario traerTipoUsuario(String nombre) throws Exception{
		TipoUsuario tipoUsuario = dao.traerTipoUsuario(nombre);
		
		if (tipoUsuario.equals(null))
    		throw new Exception("Error:El tipoUsuario no existe");
		
		return tipoUsuario;
	}
	
	public TipoUsuario traerTipoUsuarioYUsuarios(int idTipoUsuario) throws Exception{
		TipoUsuario tipoUsuario = dao.traerTipoUsuarioYUsuarios(idTipoUsuario);
			
    	if (tipoUsuario.equals(null))
    		throw new Exception("Error:El tipoUsuario no existe");
		
		return tipoUsuario;
	}
	
	
    public int agregar(String nombre) throws Exception{
		if(dao.existeTipoUsuario(nombre)){
			throw new Exception("Error:El tipoUsuario ya existe");
		}
		
		TipoUsuario tipoUsuario = new TipoUsuario(nombre);
		
		return dao.agregar(tipoUsuario);
	}
    
    public int agregar(TipoUsuario tipoUsuario) throws Exception{
		if(dao.existeTipoUsuario(tipoUsuario.getNombre())){
			throw new Exception("Error:El tipoUsuario ya existe");
		}
	
		return dao.agregar(tipoUsuario);
	}
	
    
	public void modificar(TipoUsuario tipoUsuario) throws Exception{
		if(!dao.existeTipoUsuario(tipoUsuario.getNombre())){
			throw new Exception("Error:El tipoUsuario no existe");
		}
		
		dao.actualizar(tipoUsuario);
	}
	
	public void eliminar(int id) throws Exception{
		TipoUsuario tipoUsuario = dao.traerTipoUsuario(id);
		
		if(dao.existeTipoUsuario(id)){
			dao.eliminar(tipoUsuario);
		}else{
    		throw new Exception("Error:El tipoUsuario no existe");
		}	
	}
	
	public void eliminar(String nombre) throws Exception{
		TipoUsuario tipoUsuario = dao.traerTipoUsuario(nombre);
		
		if(dao.existeTipoUsuario(nombre)){
			dao.eliminar(tipoUsuario);
		}else{
    		throw new Exception("Error:El tipoUsuario no existe");
		}	
	}
	
	public List<TipoUsuario> traerTipoUsuario(){
		return dao.traerTipoUsuario();
	}
	
}