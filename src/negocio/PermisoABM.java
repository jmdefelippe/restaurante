package negocio;

import java.util.List;

import dao.PermisoDao;
import datos.Permiso;
import datos.TipoUsuario;

public class PermisoABM {

	PermisoDao dao = new PermisoDao();
	
	
	public Permiso traerPermiso(int idPermiso) throws Exception{
		Permiso permiso = dao.traerPermiso(idPermiso);
			
    	if (permiso.equals(null))
    		throw new Exception("Error:El permiso no existe");
		
		return permiso;
	}
	
	
	public Permiso traerPermiso(String accion) throws Exception{
		Permiso permiso = dao.traerPermiso(accion);
		
		if (permiso.equals(null))
    		throw new Exception("Error:El permiso no existe");
		
		return permiso;
	}

	
	public Permiso traerPermisoYTiposUsuarios(int idPermiso) throws Exception{
		Permiso permiso = dao.traerPermisoYTiposUsuarios(idPermiso);
			
    	if (permiso.equals(null))
    		throw new Exception("Error:El permiso no existe");
		
		return permiso;
	}
	
	
    public int agregar(String accion) throws Exception{
		if(dao.existePermiso(accion)){
			throw new Exception("Error:El permiso ya existe");
		}
		
		Permiso permiso = new Permiso(accion);
		
		return dao.agregar(permiso);
	}
    
    public int agregar(Permiso permiso) throws Exception{
		if(dao.existePermiso(permiso.getAccion())){
			throw new Exception("Error:El permiso ya existe");
		}
	
		return dao.agregar(permiso);
	}
	
    
	public void modificar(Permiso permiso) throws Exception{
		if(!dao.existePermiso(permiso.getAccion())){
			throw new Exception("Error:El permiso no existe");
		}
		
		dao.actualizar(permiso);
	}
	
	public void eliminar(int id) throws Exception{
		Permiso permiso = dao.traerPermiso(id);
		
		if(dao.existePermiso(id)){
			dao.eliminar(permiso);
		}else{
    		throw new Exception("Error:El permiso no existe");
		}	
	}
	
	public void eliminar(String accion) throws Exception{
		Permiso permiso = dao.traerPermiso(accion);
		
		if(dao.existePermiso(accion)){
			dao.eliminar(permiso);
		}else{
    		throw new Exception("Error:El permiso no existe");
		}	
	}
	
	public List<Permiso> traerPermiso(){
		return dao.traerPermiso();
	}
	
	public boolean agregarTipoUsuario(Permiso permiso, TipoUsuario tipoUsuario) throws Exception{
		return permiso.agregar(tipoUsuario);
	}
		
	public boolean eliminarTipoUsuario(Permiso permiso, TipoUsuario tipoUsuario)throws Exception{
		return permiso.eliminar(tipoUsuario);
	}
	
}