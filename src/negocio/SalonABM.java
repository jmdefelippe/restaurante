package negocio;

import java.util.List;

import dao.SalonDao;
import datos.Restaurant;
import datos.Salon;

public class SalonABM {

	SalonDao dao = new SalonDao();
	
	
	public Salon traerSalon(int idSalon) throws Exception{
		Salon salon = dao.traerSalon(idSalon);
			
    	if (salon.equals(null))
    		throw new Exception("Error:El salon no existe");
		
		return salon;
	}
	
	
	public Salon traerSalon(String descripcion) throws Exception{
		Salon salon = dao.traerSalon(descripcion);
		
		if (salon.equals(null))
    		throw new Exception("Error:El salon no existe");
		
		return salon;
	}


    public int agregar(String descripcion, Restaurant restaurant) throws Exception{
		if(dao.existeSalon(descripcion)){
			throw new Exception("Error:El salon ya existe");
		}
		
		Salon salon = new Salon(descripcion, restaurant);
		
		return dao.agregar(salon);
	}
    
    public int agregar(Salon salon) throws Exception{
		if(dao.existeSalon(salon.getDescripcion())){
			throw new Exception("Error:El salon ya existe");
		}
	
		return dao.agregar(salon);
	}
	
    
	public void modificar(Salon salon) throws Exception{
		if(!dao.existeSalon(salon.getDescripcion())){
			throw new Exception("Error:El salon no existe");
		}
		
		dao.actualizar(salon);
	}
	
	public void eliminar(int id) throws Exception{
		Salon salon = dao.traerSalon(id);
		
		if(dao.existeSalon(id)){
			dao.eliminar(salon);
		}else{
    		throw new Exception("Error:El salon no existe");
		}	
	}
	
	public void eliminar(String descripcion) throws Exception{
		Salon salon = dao.traerSalon(descripcion);
		
		if(dao.existeSalon(descripcion)){
			dao.eliminar(salon);
		}else{
    		throw new Exception("Error:El salon no existe");
		}	
	}
	
	public List<Salon> traerSalon(){
		return dao.traerSalon();
	}
	
}