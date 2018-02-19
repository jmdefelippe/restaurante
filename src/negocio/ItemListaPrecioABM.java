package negocio;

import java.util.List;

import dao.ItemListaPrecioDao;
import datos.ComponenteMenu;
import datos.ListaPrecio;
import datos.ItemListaPrecio;

public class ItemListaPrecioABM {

	ItemListaPrecioDao dao = new ItemListaPrecioDao();
	
	
	public ItemListaPrecio traerItemListaPrecio(int idItemListaPrecio) throws Exception{
		ItemListaPrecio itemListaPrecio = dao.traerItemListaPrecio(idItemListaPrecio);
			
    	if (itemListaPrecio.equals(null))
    		throw new Exception("Error:El itemListaPrecio no existe");
		
		return itemListaPrecio;
	}
	
	
    public int agregar(float precio, ComponenteMenu componenteMenu){
		ItemListaPrecio itemListaPrecio = new ItemListaPrecio(precio, componenteMenu);
		
		return dao.agregar(itemListaPrecio);
	}
    
    public int agregar(ItemListaPrecio itemListaPrecio){
		return dao.agregar(itemListaPrecio);
	}
	
    
	public void modificar(ItemListaPrecio itemListaPrecio){
		dao.actualizar(itemListaPrecio);
	}
	
	public void eliminar(int id) throws Exception{
		ItemListaPrecio itemListaPrecio = dao.traerItemListaPrecio(id);
		
		if(dao.existeItemListaPrecio(id)){
			dao.eliminar(itemListaPrecio);
		}else{
    		throw new Exception("Error:El itemListaPrecio no existe");
		}	
	}
	
	
	public List<ItemListaPrecio> traerItemListaPrecio(){
		return dao.traerItemListaPrecio();
	}
	
	public List<ItemListaPrecio> traerItemListaPrecio(ListaPrecio cliente) throws Exception{
		List<ItemListaPrecio> lstItemListaPrecio = dao.traerItemListaPrecio(cliente);
			
//    	if (lstItemListaPrecio.equals(null))
//    		throw new Exception("Error:El cliente no tiene ningun prestamo");
		
		return lstItemListaPrecio;
	}
	
}