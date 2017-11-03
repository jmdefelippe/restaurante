package negocio;

import java.util.List;

import dao.CamareroDao;
import datos.Camarero;

public class CamareroABM {

	CamareroDao dao = new CamareroDao();
	
	
	public Camarero traerCamarero(int idCamarero) throws Exception{
		Camarero camarero = dao.traerCamarero(idCamarero);
			
    	if (camarero.equals(null))
    		throw new Exception("Error:El camarero no existe");
		
		return camarero;
	}
	
	
	public Camarero traerCamarero(long dni) throws Exception{
		Camarero camarero = dao.traerCamarero(dni);
		
		if (camarero.equals(null))
    		throw new Exception("Error:El camarero no existe");
		
		return camarero;
	}
	
	public Camarero traerCamareroYComandas(int idCamarero) throws Exception{
		Camarero camarero = dao.traerCamareroYComandas(idCamarero);
			
    	if (camarero.equals(null))
    		throw new Exception("Error:El camarero no existe");
		
		return camarero;
	}

	
    public int agregar(long dni, String nombre, String apellido) throws Exception{
		if(dao.existeCamarero(dni)){
			throw new Exception("Error:El camarero ya existe");
		}
		
		Camarero camarero = new Camarero(dni, nombre, apellido);
		
		return dao.agregar(camarero);
	}
    
    public int agregar(Camarero camarero) throws Exception{
		if(dao.existeCamarero(camarero.getDni())){
			throw new Exception("Error:El camarero ya existe");
		}
	
		return dao.agregar(camarero);
	}
	
    
	public void modificar(Camarero camarero) throws Exception{
		if(!dao.existeCamarero(camarero.getDni())){
			throw new Exception("Error:El camarero no existe");
		}
		
		dao.actualizar(camarero);
	}
	
	public void eliminar(int id) throws Exception{
		Camarero camarero = dao.traerCamarero(id);
		
		if(dao.existeCamarero(id)){
			dao.eliminar(camarero);
		}else{
    		throw new Exception("Error:El camarero no existe");
		}	
	}
	
	public void eliminar(long dni) throws Exception{
		Camarero camarero = dao.traerCamarero(dni);
		
		if(dao.existeCamarero(dni)){
			dao.eliminar(camarero);
		}else{
    		throw new Exception("Error:El camarero no existe");
		}	
	}
	
	public List<Camarero> traerCamarero(){
		return dao.traerCamarero();
	}
	
}