package test;

import datos.ItemListaPrecio;
import datos.ListaPrecio;
import negocio.CamareroABM;
import negocio.ClienteABM;
import negocio.ComandaABM;
import negocio.ComponenteMenuABM;
import negocio.ItemComandaABM;
import negocio.ItemListaPrecioABM;
import negocio.ItemTicketABM;
import negocio.ListaPrecioABM;
import negocio.LoginABM;
import negocio.MesaABM;
import negocio.RestaurantABM;
import negocio.RubroABM;
import negocio.SalonABM;
import negocio.SubrubroABM;
import negocio.TicketABM;
import negocio.TipoClienteABM;
import negocio.TipoUsuarioABM;
import negocio.UsuarioABM;

public class TestTraer {
	public static void main(String[] args) {
		try {
			TipoUsuarioABM tipoUsuarioABM = new TipoUsuarioABM();
			LoginABM loginABM = new LoginABM();
			UsuarioABM usuarioABM = new UsuarioABM();			
			System.out.println(tipoUsuarioABM.traerTipoUsuario(1));
			System.out.println();
			System.out.println(usuarioABM.traerUsuario(1));
			System.out.println();
			System.out.println(loginABM.traerLogin(1));
			System.out.println();
			
//			loginABM.traerLogin("asda");
			
//			System.out.println(loginABM.traerLogin(100)); //login que no existe
//			System.out.println();

			RubroABM rubroABM = new RubroABM();
			SubrubroABM subrubroABM = new SubrubroABM();
			System.out.println(rubroABM.traerRubro(2));
			System.out.println();
			System.out.println(subrubroABM.traerSubrubro(5));
			System.out.println();
			
			CamareroABM camareroABM = new CamareroABM();
			System.out.println(camareroABM.traerCamarero(1));
			System.out.println(camareroABM.traerCamarero(2));
			System.out.println();
			
			RestaurantABM restaurantABM = new RestaurantABM();
			System.out.println(restaurantABM.traerRestaurant(1));
			System.out.println();
			
					
			ComponenteMenuABM componenteMenuABM = new ComponenteMenuABM();
			System.out.println(componenteMenuABM.traerComponenteMenu(1));
			System.out.println("Subrubro: " + componenteMenuABM.traerComponenteMenu(1).getSubrubro().getNombre());
			System.out.println("Rubro: " + componenteMenuABM.traerComponenteMenu(1).getSubrubro().getRubro().getNombre());
			System.out.println();
			
			ItemListaPrecioABM itemListaPrecioABM = new ItemListaPrecioABM();
			System.out.println("itemListaPrecio: " + itemListaPrecioABM.traerItemListaPrecio(1).getIdItemListaPrecio());
			System.out.println("precio: " + itemListaPrecioABM.traerItemListaPrecio(1).getPrecio());
			System.out.println();
			
			ListaPrecioABM listaPrecioABM = new ListaPrecioABM();
			System.out.println("Lista precio id: " + listaPrecioABM.traerListaPrecio(1).getIdListaPrecio());
			System.out.println(listaPrecioABM.traerListaPrecio(1).getFechaDesde());
			System.out.println();
			
			TipoClienteABM tipoClienteABM = new TipoClienteABM();
			System.out.println("TipoCliente nombre: " + tipoClienteABM.traerTipoCliente(1).getNombre());
			System.out.println();
			
			ClienteABM clienteABM = new ClienteABM();
			System.out.println("Cliente nombre: " + clienteABM.traerCliente(1).getNombre());
			System.out.println();
			
			TicketABM ticketABM = new TicketABM();
			System.out.println("Ticket id: " + ticketABM.traerTicket(1).getIdTicket());
			System.out.println();
			
			ItemTicketABM itemTicketABM = new ItemTicketABM();
			System.out.println("ItemTicket id: "+ itemTicketABM.traerItemTicket(1).getIdItemTicket());
			System.out.println("cantidad: " + itemTicketABM.traerItemTicket(1).getCantidad());
			System.out.println();
			
			ComandaABM comandaABM = new ComandaABM();
			System.out.println("Comanda id: " + comandaABM.traerComanda(1).getIdComanda());
			System.out.println("Comanda 1 tiene camarero de nombre: " + comandaABM.traerComanda(1).getCamarero().getNombre());
			System.out.println("Comanda 1 tiene cliente de nombre: " + comandaABM.traerComanda(1).getCliente().getNombre());
			System.out.println("Tipo cliente: " + comandaABM.traerComanda(1).getCliente().getTipoCliente().getNombre());
			System.out.println("Tiene la lista de precios: " + comandaABM.traerComanda(1).getCliente().getTipoCliente().getListaPrecio().getIdListaPrecio());
			
			
			System.out.println("Traer listaPrecio e itemsListaPrecios: " + comandaABM.traerComanda(1).getCliente().getTipoCliente().getListaPrecio().getIdListaPrecio());
			
			int idListaPrecio = comandaABM.traerComanda(1).getCliente().getTipoCliente().getListaPrecio().getIdListaPrecio();
			ListaPrecio l = listaPrecioABM.traerListaPrecioEItemsListaPrecio(idListaPrecio);
			System.out.println( "\n---> Traer ListaPrecio e itemsListaPrecio	idLista=" +idListaPrecio);
			System.out.println( "\n" +l);
			for (ItemListaPrecio i: l.getItemsListaPrecio())
				System.out.println("\n" + i);
			System.out.println();
			
			ItemComandaABM itemComandaABM = new ItemComandaABM();
			System.out.println("ItemComanda id: " + itemComandaABM.traerItemComanda(1).getIdItemComanda());
			System.out.println("ItemComanda cantidad: " + itemComandaABM.traerItemComanda(1).getCantidad());
			System.out.println("Componente menu: " + itemComandaABM.traerItemComanda(1).getComponenteMenu().getNombre());
			System.out.println();
			
			SalonABM salonABM = new SalonABM();
			System.out.println("Salon 1: " + salonABM.traerSalon(1).getDescripcion() + " pertenece al restaurant llamado: " + salonABM.traerSalon(1).getRestaurant().getNombre());
			System.out.println("Salon 2: " + salonABM.traerSalon(2).getDescripcion());
			System.out.println();
			
			MesaABM mesaABM = new MesaABM();
			System.out.println(mesaABM.traerMesa(1));
			mesaABM.traerMesa(1).getState();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}