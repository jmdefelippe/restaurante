package negocio;

import java.util.List;

import dao.SubrubroDao;
import datos.Rubro;
import datos.Subrubro;

public class SubrubroABM {

	SubrubroDao dao = new SubrubroDao();
	
	
	public Subrubro traerSubrubro(int idSubrubro) throws Exception{
		Subrubro subrubro = dao.traerSubrubro(idSubrubro);
			
    	if (subrubro.equals(null))
    		throw new Exception("Error:El subrubro no existe");
		
		return subrubro;
	}
	
	
	public Subrubro traerSubrubro(String nombre) throws Exception{
		Subrubro subrubro = dao.traerSubrubro(nombre);
		
		if (subrubro.equals(null))
    		throw new Exception("Error:El subrubro no existe");
		
		return subrubro;
	}

	
	public Subrubro traerSubrubroYComponentesMenu(int idSubrubro) throws Exception{
		Subrubro subrubro = dao.traerSubrubroYComponentesMenu(idSubrubro);
			
    	if (subrubro.equals(null))
    		throw new Exception("Error:El subrubro no existe");
		
		return subrubro;
	}

	
    public int agregar(String nombre, Rubro rubro) throws Exception{
		if(dao.existeSubrubro(nombre)){
			throw new Exception("Error:El subrubro ya existe");
		}
		
		Subrubro subrubro = new Subrubro(nombre, rubro);
		
		return dao.agregar(subrubro);
	}
    
    public int agregar(Subrubro subrubro) throws Exception{
		if(dao.existeSubrubro(subrubro.getNombre())){
			throw new Exception("Error:El subrubro ya existe");
		}
	
		return dao.agregar(subrubro);
	}
	
    
	public void modificar(Subrubro subrubro) throws Exception{
		if(!dao.existeSubrubro(subrubro.getNombre())){
			throw new Exception("Error:El subrubro no existe");
		}
		
		dao.actualizar(subrubro);
	}
	
	public void eliminar(int id) throws Exception{
		Subrubro subrubro = dao.traerSubrubro(id);
		
		if(dao.existeSubrubro(id)){
			dao.eliminar(subrubro);
		}else{
    		throw new Exception("Error:El subrubro no existe");
		}	
	}
	
	public void eliminar(String nombre) throws Exception{
		Subrubro subrubro = dao.traerSubrubro(nombre);
		
		if(dao.existeSubrubro(nombre)){
			dao.eliminar(subrubro);
		}else{
    		throw new Exception("Error:El subrubro no existe");
		}	
	}
	
	public List<Subrubro> traerSubrubro(){
		return dao.traerSubrubro();
	}
	
}