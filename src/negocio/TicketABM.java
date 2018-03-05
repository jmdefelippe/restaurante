package negocio;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import dao.ComandaDao;
import dao.TicketDao;
import datos.Ticket;
import datos.Usuario;
import datos.Cliente;
import datos.Comanda;
import datos.ItemComanda;
import datos.ItemListaPrecio;
import datos.ItemTicket;
import datos.Restaurant;

public class TicketABM {

	TicketDao dao = new TicketDao();
	
	
	public Ticket traerTicket(int idTicket) throws Exception{
		Ticket ticket = dao.traerTicket(idTicket);
			
    	if (ticket.equals(null))
    		throw new Exception("Error:La ticket no existe");
		
		return ticket;
	}

	
    public int agregar(GregorianCalendar fecha, boolean pagado, boolean cortesia, float total, Restaurant restaurant, Usuario usuario){
		Ticket ticket = new Ticket(fecha, pagado, cortesia, total, restaurant, usuario);
		
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
	
	public Ticket emitirPreTicket(int idMesa, Restaurant restaurant, Usuario usuario) throws Exception {
		
		
		//Creo todas las clases y variables.
		ComandaABM comandaABM = new ComandaABM();
		Comanda comanda = new Comanda();
		List <ItemComanda> itemsComanda = new ArrayList();
		ItemComandaABM itemComandaABM = new ItemComandaABM();
		ItemListaPrecioABM itemListaPrecioABM = new ItemListaPrecioABM();
		List <ItemListaPrecio> itemsListaPrecio = new ArrayList(); 
		ClienteABM clienteABM = new ClienteABM();
		Cliente cliente = new Cliente();
		ItemTicket itemTicket = new ItemTicket();
		List <ItemTicket> itemsTicket = new ArrayList();
		ItemTicketABM itemTicketABM = new ItemTicketABM();

		//Recupero la comanda, ítems y el cliente y la lista de precios.
		comanda = comandaABM.traerComandasPorIdMesaConCamareroYCliente(idMesa).get(0);
		itemsComanda = itemComandaABM.traerItemsComandaPorComandaConComponente(comanda.getIdComanda());
		cliente = clienteABM.traerCliente(comanda.getCliente().getIdCliente());
		itemsListaPrecio = itemListaPrecioABM.traerItemListaPrecioConComponentePorIdLista(cliente.getTipoCliente().getListaPrecio().getIdListaPrecio());

		
		//Genero el ticket vacío que debo colocar en la base de datos.
		Ticket ticket = new Ticket();
		GregorianCalendar fecha = new GregorianCalendar();
		ticket.setFecha(fecha);
		ticket.setPagado(false);
		ticket.setCortesia(false);
		ticket.setRestaurant(restaurant);
		ticket.setUsuario(usuario);
//
//		//Guardo el ticket en la base de datos y obtengo el ID del mismo.
		int idTicketCreado = 0;
		idTicketCreado = dao.agregar(ticket);
//	
//		//Asocio el ticket recién creado a la comanda.
		comanda.setTicket(ticket);
		comandaABM.modificar(comanda);
//				
//		
		//Comienzo a agregar los ítems del ticket:
		int cantidad = 0;
		boolean encontrado = false;

		//Recorro todos los ítems de la comanda.
		for(int i = 0; i<= itemsComanda.size() - 1; i++) {
			
			//Verifico que ese ítem esté en el ticket.
			encontrado = false;
			int contador = 0;
			if (itemsTicket.size() > 0) {
				for (contador = 0; contador <= itemsTicket.size() - 1; contador++) {

					System.out.println("Comparando " + itemsComanda.get(i).getComponenteMenu().getIdComponenteMenu() + " con " + itemsTicket.get(contador).getComponenteMenu().getIdComponenteMenu());
		
					
					//Si coinciden el id del componente menú de la comanda, con el de ítem ticket, le sumo la cantidad de la comanda al ítem del ticket.
					if(itemsComanda.get(i).getComponenteMenu().getIdComponenteMenu() == itemsTicket.get(contador).getComponenteMenu().getIdComponenteMenu()) {			
	
						System.out.println("HICE UN REEMPLAZO!!!");
						cantidad = itemsTicket.get(contador).getCantidad() + itemsComanda.get(i).getCantidad();
						itemsTicket.get(contador).setCantidad(cantidad);
						encontrado = true;
						
					}
				}
				
				cantidad = 0;
			}
			
			//Como no encontré el ítem en la lista de ítems de Ticket, agrego el item con el id del componente.
			if(encontrado == false) {
				
				ItemTicket auxItemTicket = new ItemTicket();
				System.out.println("Estoy evaluando el valor i = " + i);
				System.out.println("El item de la comanda  es " + itemsComanda.get(i).getComponenteMenu() + " y la catidad es " +  itemsComanda.get(i).getCantidad());
				auxItemTicket.setComponenteMenu(itemsComanda.get(i).getComponenteMenu());
				auxItemTicket.setCantidad(itemsComanda.get(i).getCantidad());
				auxItemTicket.setTicket(ticket);
				itemTicketABM.agregar(auxItemTicket);
				itemsTicket.add(itemsTicket.size(),auxItemTicket);
				System.out.println(itemsTicket);

			}

		}
	
		//Recorro la matriz auxiliar itemsTicket agregándolos a la base de datos calculando los importes.
		float importe = 0;
		for (int k = 0; k <= itemsTicket.size() - 1; k++) {
			System.out.println("Estoy evaluando el K = " + k);
			System.out.println("La cantidad de este item es " + itemsTicket.get(k).getCantidad() + "  yel precio " + this.precioItemTicket(itemsListaPrecio , itemsTicket.get(k).getComponenteMenu().getIdComponenteMenu()));
			importe = importe + (itemsTicket.get(k).getCantidad() * this.precioItemTicket(itemsListaPrecio , itemsTicket.get(k).getComponenteMenu().getIdComponenteMenu()));
			itemsTicket.get(k).setImporte(itemsTicket.get(k).getCantidad() * this.precioItemTicket(itemsListaPrecio , itemsTicket.get(k).getComponenteMenu().getIdComponenteMenu()));
			itemTicketABM.modificar(itemsTicket.get(k));
		}
		
		//Actualizo el importe en el ticket y lo devuelvo.
		ticket.setTotal(importe);
		dao.actualizar(ticket);
		return ticket;
	}
	
	
	
	private float precioItemTicket(List<ItemListaPrecio> itemsListaPrecio, int idComponenteMenu) {
		
		//Recorro en bucle itemsListaPrecio y el ID que coincida lo devuelvo.
		float precio = 0;
		for (int i = 0; i <= itemsListaPrecio.size() - 1; i++) {
			if (itemsListaPrecio.get(i).getComponenteMenu().getIdComponenteMenu() == idComponenteMenu) {
				precio = itemsListaPrecio.get(i).getPrecio();	
			}
		}
		
		//OJOOO
		if (precio != 0) System.out.println("ENCONTRE UN PRECIO");
		
		return precio;
	}
	
	
	public void emitirTicket(Ticket ticket) {
		ticket.setPagado(true);
		dao.actualizar(ticket);
	}
	
	public void esCortesia(Ticket ticket) {
		ticket.setCortesia(true);
		ticket.setPagado(true);
		dao.actualizar(ticket);
	}
	
	
	
}	