package negocio;

import java.util.List;
import dao.ItemComandaDao;
import dao.ComandaDao;
import datos.ComponenteMenu;
import datos.Comanda;
import datos.ItemComanda;

public class ItemComandaABM {

	ItemComandaDao dao = new ItemComandaDao();
	ComandaDao comandaDao = new ComandaDao();
	
	public ItemComanda traerItemComanda(int idItemComanda) throws Exception{
		ItemComanda itemComanda = dao.traerItemComanda(idItemComanda);
    	if (itemComanda.equals(null))
    		throw new Exception("Error:El itemComanda no existe");
		
		return itemComanda;
	}
	//------------------------------ Traigo Items Comanda de una Comanda especifica ------------
	
	public ItemComanda traerItemComandaPorComanda(int idComanda) throws Exception{
		
		Comanda comanda = comandaDao.traerComanda(idComanda);
		ItemComanda itemComanda = dao.traerItemComanda(comanda);

		
    	if (itemComanda.equals(null))
    		throw new Exception("Error:El itemComanda no existe");
		
		return itemComanda;
	}
	
	//-------------------------------------------------------------------------------------------
	
    public int agregar(int cantidad, ComponenteMenu componenteMenu, Comanda comanda){
		ItemComanda itemComanda = new ItemComanda(cantidad, componenteMenu, comanda);
		
		return dao.agregar(itemComanda);
	}
    
    public int agregar(ItemComanda itemComanda){
		return dao.agregar(itemComanda);
	}
	
    
	public void modificar(ItemComanda itemComanda){
		dao.actualizar(itemComanda);
	}
	
	public void eliminar(int id) throws Exception{
		ItemComanda itemComanda = dao.traerItemComanda(id);
		
		if(dao.existeItemComanda(id)){
			dao.eliminar(itemComanda);
		}else{
    		throw new Exception("Error:El itemComanda no existe");
		}	
	}
	
	
	public List<ItemComanda> traerItemComanda(){
		return dao.traerItemComanda();
	}
	
	public List<ItemComanda> traerItemsComandaPorComanda( int id){
		return dao.traerItemComandaPorComanda(id);
	}
	
	public List<ItemComanda> traerItemsComandaPorComandaConComponente( int id){
		return dao.traerItemsComandaPorComandaConComponente(id);
	}
	
}