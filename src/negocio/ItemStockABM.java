package negocio;

import java.util.List;

import dao.ItemStockDao;
import datos.Ingrediente;
import datos.Stock;
import datos.ItemStock;

public class ItemStockABM {

	ItemStockDao dao = new ItemStockDao();
	
	
	public ItemStock traerItemStock(int idItemStock) throws Exception{
		ItemStock itemStock = dao.traerItemStock(idItemStock);
			
    	if (itemStock.equals(null))
    		throw new Exception("Error:El itemStock no existe");
		
		return itemStock;
	}
	
	
    public int agregar(int cantidad, Ingrediente ingrediente, Stock stock){
		ItemStock itemStock = new ItemStock(cantidad, ingrediente, stock);
		
		return dao.agregar(itemStock);
	}
    
    public int agregar(ItemStock itemStock){
		return dao.agregar(itemStock);
	}
	
    
	public void modificar(ItemStock itemStock){
		dao.actualizar(itemStock);
	}
	
	public void eliminar(int id) throws Exception{
		ItemStock itemStock = dao.traerItemStock(id);
		
		if(dao.existeItemStock(id)){
			dao.eliminar(itemStock);
		}else{
    		throw new Exception("Error:El itemStock no existe");
		}	
	}
	
	
	public List<ItemStock> traerItemStock(){
		return dao.traerItemStock();
	}
	
}