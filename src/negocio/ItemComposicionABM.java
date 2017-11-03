package negocio;

import java.util.List;

import dao.ItemComposicionDao;
import datos.Producto;
import datos.Ingrediente;
import datos.ItemComposicion;

public class ItemComposicionABM {

	ItemComposicionDao dao = new ItemComposicionDao();
	
	
	public ItemComposicion traerItemComposicion(int idItemComposicion) throws Exception{
		ItemComposicion itemComposicion = dao.traerItemComposicion(idItemComposicion);
			
    	if (itemComposicion.equals(null))
    		throw new Exception("Error:El itemComposicion no existe");
		
		return itemComposicion;
	}
	
	
    public int agregar(int cantidad, Producto producto, Ingrediente ingrediente){
		ItemComposicion itemComposicion = new ItemComposicion(cantidad, producto, ingrediente);
		
		return dao.agregar(itemComposicion);
	}
    
    public int agregar(ItemComposicion itemComposicion){
		return dao.agregar(itemComposicion);
	}
	
    
	public void modificar(ItemComposicion itemComposicion){
		dao.actualizar(itemComposicion);
	}
	
	public void eliminar(int id) throws Exception{
		ItemComposicion itemComposicion = dao.traerItemComposicion(id);
		
		if(dao.existeItemComposicion(id)){
			dao.eliminar(itemComposicion);
		}else{
    		throw new Exception("Error:El itemComposicion no existe");
		}	
	}
	
	
	public List<ItemComposicion> traerItemComposicion(){
		return dao.traerItemComposicion();
	}
	
}