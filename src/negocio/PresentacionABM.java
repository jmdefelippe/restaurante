package negocio;

import java.util.List;

import dao.PresentacionDao;
import datos.Conversion;
import datos.Presentacion;

public class PresentacionABM {

	PresentacionDao dao = new PresentacionDao();
	
	
	public Presentacion traerPresentacion(int idPresentacion) throws Exception{
		Presentacion presentacion = dao.traerPresentacion(idPresentacion);
			
    	if (presentacion.equals(null))
    		throw new Exception("Error:El presentacion no existe");
		
		return presentacion;
	}
	
	
	public Presentacion traerPresentacion(String descripcion) throws Exception{
		Presentacion presentacion = dao.traerPresentacion(descripcion);
		
		if (presentacion.equals(null))
    		throw new Exception("Error:El presentacion no existe");
		
		return presentacion;
	}


    public int agregar(String descripcion, Conversion conversion) throws Exception{
		if(dao.existePresentacion(descripcion)){
			throw new Exception("Error:El presentacion ya existe");
		}
		
		Presentacion presentacion = new Presentacion(descripcion, conversion);
		
		return dao.agregar(presentacion);
	}
    
    public int agregar(Presentacion presentacion) throws Exception{
		if(dao.existePresentacion(presentacion.getDescripcion())){
			throw new Exception("Error:La presentacion ya existe");
		}
	
		return dao.agregar(presentacion);
	}
	
    
	public void modificar(Presentacion presentacion) throws Exception{
		if(!dao.existePresentacion(presentacion.getDescripcion())){
			throw new Exception("Error:La presentacion no existe");
		}
		
		dao.actualizar(presentacion);
	}
	
	public void eliminar(int id) throws Exception{
		Presentacion presentacion = dao.traerPresentacion(id);
		
		if(dao.existePresentacion(id)){
			dao.eliminar(presentacion);
		}else{
    		throw new Exception("Error:La presentacion no existe");
		}	
	}
	
	public void eliminar(String descripcion) throws Exception{
		Presentacion presentacion = dao.traerPresentacion(descripcion);
		
		if(dao.existePresentacion(descripcion)){
			dao.eliminar(presentacion);
		}else{
    		throw new Exception("Error:La presentacion no existe");
		}	
	}
	
	public List<Presentacion> traerPresentacion(){
		return dao.traerPresentacion();
	}
	
}