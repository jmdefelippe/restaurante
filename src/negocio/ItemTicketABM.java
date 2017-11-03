package negocio;

import java.util.List;

import dao.ItemTicketDao;
import datos.ComponenteMenu;
import datos.Ticket;
import datos.ItemTicket;

public class ItemTicketABM {

	ItemTicketDao dao = new ItemTicketDao();
	
	
	public ItemTicket traerItemTicket(int idItemTicket) throws Exception{
		ItemTicket itemTicket = dao.traerItemTicket(idItemTicket);
			
    	if (itemTicket.equals(null))
    		throw new Exception("Error:El itemTicket no existe");
		
		return itemTicket;
	}
	
	
    public int agregar(int cantidad, float importe, ComponenteMenu componenteMenu){
		ItemTicket itemTicket = new ItemTicket(cantidad, importe, componenteMenu);
		
		return dao.agregar(itemTicket);
	}
    
    public int agregar(ItemTicket itemTicket){
		return dao.agregar(itemTicket);
	}
	
    
	public void modificar(ItemTicket itemTicket){
		dao.actualizar(itemTicket);
	}
	
	public void eliminar(int id) throws Exception{
		ItemTicket itemTicket = dao.traerItemTicket(id);
		
		if(dao.existeItemTicket(id)){
			dao.eliminar(itemTicket);
		}else{
    		throw new Exception("Error:El itemTicket no existe");
		}	
	}
	
	
	public List<ItemTicket> traerItemTicket(){
		return dao.traerItemTicket();
	}
	
}