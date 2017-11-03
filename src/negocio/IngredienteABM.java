package negocio;

import java.util.List;

import dao.IngredienteDao;
import datos.Ingrediente;
import datos.Presentacion;

public class IngredienteABM {

	IngredienteDao dao = new IngredienteDao();
	
	
	public Ingrediente traerIngrediente(int idIngrediente) throws Exception{
		Ingrediente ingrediente = dao.traerIngrediente(idIngrediente);
			
    	if (ingrediente.equals(null))
    		throw new Exception("Error:El ingrediente no existe");
		
		return ingrediente;
	}
	
	
	public Ingrediente traerIngrediente(String nombre) throws Exception{
		Ingrediente ingrediente = dao.traerIngrediente(nombre);
		
		if (ingrediente.equals(null))
    		throw new Exception("Error:El ingrediente no existe");
		
		return ingrediente;
	}

	
    public int agregar(String nombre, Presentacion presentacion) throws Exception{
		if(dao.existeIngrediente(nombre)){
			throw new Exception("Error:El ingrediente ya existe");
		}
		
		Ingrediente ingrediente = new Ingrediente(nombre, presentacion);
		
		return dao.agregar(ingrediente);
	}
    
    public int agregar(Ingrediente ingrediente) throws Exception{
		if(dao.existeIngrediente(ingrediente.getNombre())){
			throw new Exception("Error:El ingrediente ya existe");
		}
	
		return dao.agregar(ingrediente);
	}
	
    
	public void modificar(Ingrediente ingrediente) throws Exception{
		if(!dao.existeIngrediente(ingrediente.getNombre())){
			throw new Exception("Error:El ingrediente no existe");
		}
		
		dao.actualizar(ingrediente);
	}
	
	public void eliminar(int id) throws Exception{
		Ingrediente ingrediente = dao.traerIngrediente(id);
		
		if(dao.existeIngrediente(id)){
			dao.eliminar(ingrediente);
		}else{
    		throw new Exception("Error:El ingrediente no existe");
		}	
	}
	
	public void eliminar(String nombre) throws Exception{
		Ingrediente ingrediente = dao.traerIngrediente(nombre);
		
		if(dao.existeIngrediente(nombre)){
			dao.eliminar(ingrediente);
		}else{
    		throw new Exception("Error:El ingrediente no existe");
		}	
	}
	
	public List<Ingrediente> traerIngrediente(){
		return dao.traerIngrediente();
	}
	
}