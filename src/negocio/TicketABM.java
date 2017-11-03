package negocio;

import java.util.GregorianCalendar;
import java.util.List;

import dao.TicketDao;
import datos.Ticket;
import datos.Usuario;
import datos.Restaurant;

public class TicketABM {

	TicketDao dao = new TicketDao();
	
	
	public Ticket traerTicket(int idTicket) throws Exception{
		Ticket ticket = dao.traerTicket(idTicket);
			
    	if (ticket.equals(null))
    		throw new Exception("Error:La ticket no existe");
		
		return ticket;
	}

	
    public int agregar(GregorianCalendar fecha, boolean pagado, float total, Restaurant restaurant, Usuario usuario){
		Ticket ticket = new Ticket(fecha, pagado, total, restaurant, usuario);
		
		return dao.agregar(ticket);
	}
    
    public int agregar(Ticket ticket){
		return dao.agregar(ticket);
	}
	
    
	public void modificar(Ticket ticket){
		dao.actualizar(ticket);
	}
	
	public void eliminar(int id) throws Exception{
		Ticket ticket = dao.traerTicket(id);
		
		if(dao.existeTicket(id)){
			dao.eliminar(ticket);
		}else{
    		throw new Exception("Error:El ticket no existe");
		}	
	}

	public List<Ticket> traerTicket(){
		return dao.traerTicket();
	}
	
}