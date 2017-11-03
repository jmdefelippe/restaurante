package negocio;

import java.util.List;

import dao.RubroDao;
import datos.Rubro;

public class RubroABM {

	RubroDao dao = new RubroDao();
	
	
	public Rubro traerRubro(int idRubro) throws Exception{
		Rubro rubro = dao.traerRubro(idRubro);
			
    	if (rubro.equals(null))
    		throw new Exception("Error:El rubro no existe");
		
		return rubro;
	}
	
	
	public Rubro traerRubro(String nombre) throws Exception{
		Rubro rubro = dao.traerRubro(nombre);
		
		if (rubro.equals(null))
    		throw new Exception("Error:El rubro no existe");
		
		return rubro;
	}
	
	public Rubro traerRubroYSubrubros(int idRubro) throws Exception{
		Rubro rubro = dao.traerRubroYSubrubros(idRubro);
			
    	if (rubro.equals(null))
    		throw new Exception("Error:El rubro no existe");
		
		return rubro;
	}

	
    public int agregar(String nombre) throws Exception{
		if(dao.existeRubro(nombre)){
			throw new Exception("Error:El rubro ya existe");
		}
		
		Rubro rubro = new Rubro(nombre);
		
		return dao.agregar(rubro);
	}
    
    public int agregar(Rubro rubro) throws Exception{
		if(dao.existeRubro(rubro.getNombre())){
			throw new Exception("Error:El rubro ya existe");
		}
	
		return dao.agregar(rubro);
	}
	
    
	public void modificar(Rubro rubro) throws Exception{
		if(!dao.existeRubro(rubro.getNombre())){
			throw new Exception("Error:El rubro no existe");
		}
		
		dao.actualizar(rubro);
	}
	
	public void eliminar(int id) throws Exception{
		Rubro rubro = dao.traerRubro(id);
		
		if(dao.existeRubro(id)){
			dao.eliminar(rubro);
		}else{
    		throw new Exception("Error:El rubro no existe");
		}	
	}
	
	public void eliminar(String nombre) throws Exception{
		Rubro rubro = dao.traerRubro(nombre);
		
		if(dao.existeRubro(nombre)){
			dao.eliminar(rubro);
		}else{
    		throw new Exception("Error:El rubro no existe");
		}	
	}
	
	public List<Rubro> traerRubro(){
		return dao.traerRubro();
	}
	
}