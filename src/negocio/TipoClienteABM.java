package negocio;

import java.util.List;

import dao.TipoClienteDao;
import datos.ListaPrecio;
import datos.TipoCliente;

public class TipoClienteABM {

	TipoClienteDao dao = new TipoClienteDao();
	
	
	public TipoCliente traerTipoCliente(int idTipoCliente) throws Exception{
		TipoCliente tipoCliente = dao.traerTipoCliente(idTipoCliente);
			
    	if (tipoCliente.equals(null))
    		throw new Exception("Error:El tipoCliente no existe");
		
		return tipoCliente;
	}
	
	
	public TipoCliente traerTipoCliente(String nombre) throws Exception{
		TipoCliente tipoCliente = dao.traerTipoCliente(nombre);
		
		if (tipoCliente.equals(null))
    		throw new Exception("Error:El tipoCliente no existe");
		
		return tipoCliente;
	}
	
	public TipoCliente traerTipoClienteYClientes(int idTipoCliente) throws Exception{
		TipoCliente tipoCliente = dao.traerTipoClienteYClientes(idTipoCliente);
			
    	if (tipoCliente.equals(null))
    		throw new Exception("Error:El tipoCliente no existe");
		
		return tipoCliente;
	}

	
    public int agregar(String nombre) throws Exception{
		if(dao.existeTipoCliente(nombre)){
			throw new Exception("Error:El tipoCliente ya existe");
		}
		
		TipoCliente tipoCliente = new TipoCliente(nombre);
		
		return dao.agregar(tipoCliente);
	}
    
    public int agregar(TipoCliente tipoCliente) throws Exception{
		if(dao.existeTipoCliente(tipoCliente.getNombre())){
			throw new Exception("Error:El tipoCliente ya existe");
		}
	
		return dao.agregar(tipoCliente);
	}
	
    
	public void modificar(TipoCliente tipoCliente) throws Exception{
		if(!dao.existeTipoCliente(tipoCliente.getNombre())){
			throw new Exception("Error:El tipoCliente no existe");
		}
		
		dao.actualizar(tipoCliente);
	}
	
	public void eliminar(int id) throws Exception{
		TipoCliente tipoCliente = dao.traerTipoCliente(id);
		
		if(dao.existeTipoCliente(id)){
			dao.eliminar(tipoCliente);
		}else{
    		throw new Exception("Error:El tipoCliente no existe");
		}	
	}
	
	public void eliminar(String nombre) throws Exception{
		TipoCliente tipoCliente = dao.traerTipoCliente(nombre);
		
		if(dao.existeTipoCliente(nombre)){
			dao.eliminar(tipoCliente);
		}else{
    		throw new Exception("Error:El tipoCliente no existe");
		}	
	}
	
	public List<TipoCliente> traerTipoCliente(){
		return dao.traerTipoCliente();
	}
	
}