package negocio;

import java.util.List;

import dao.StockDao;
import datos.Stock;

public class StockABM {

	StockDao dao = new StockDao();
	
	
	public Stock traerStock(int idStock) throws Exception{
		Stock stock = dao.traerStock(idStock);
			
    	if (stock.equals(null))
    		throw new Exception("Error:El stock no existe");
		
		return stock;
	}


	public int agregar(Stock stock){
		return dao.agregar(stock);
	}
	
    
	public void modificar(Stock stock){
		dao.actualizar(stock);
	}
	
	public void eliminar(int id) throws Exception{
		Stock stock = dao.traerStock(id);
		
		if(dao.existeStock(id)){
			dao.eliminar(stock);
		}else{
    		throw new Exception("Error:El stock no existe");
		}	
	}

	public List<Stock> traerStock(){
		return dao.traerStock();
	}
	
}