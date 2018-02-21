package negocio;

public class Facade {

	public CamareroABM getCamareroABM(){
		return new CamareroABM();
		}
	
	public ClienteABM getClienteABM(){
		return new ClienteABM();
	}
	
	public ComandaABM getComandaABM(){
		return new ComandaABM();
	}
	
	public ComponenteMenuABM getComponenteMenuABM(){
		return new ComponenteMenuABM();
	}
	
	public ItemComandaABM getItemComandaABM(){
		return new ItemComandaABM();
	}
	
	public ItemListaPrecioABM getItemListaPrecioABM(){
		return new ItemListaPrecioABM();
	}
	
	public ItemTicketABM getItemTicketABM(){
		return new ItemTicketABM();
	}
	
	public ListaPrecioABM getListaPrecioABM(){
		return new ListaPrecioABM();
	}
	
	public LoginABM getLoginABM(){
		return new LoginABM();
	}
	
	public MenuABM getMenuABM(){
		return new MenuABM();
	}
	
	public MesaABM getMesaABM(){
		return new MesaABM();
	}
	
	public RestaurantABM getRestaurantABM(){
		return new RestaurantABM();
	}
	
	public RubroABM getRubroABM(){
		return new RubroABM();
	}
	
	public SalonABM getSalonABM(){
		return new SalonABM();
	}
	
	public SubrubroABM getSubrubroABM(){
		return new SubrubroABM();
	}
	
	public TicketABM getTicketABM(){
		return new TicketABM();
	}
	
	public TipoClienteABM getTipoClienteABM(){
		return new TipoClienteABM();
	}
	
	public TipoUsuarioABM getTipoUsuarioABM(){
		return new TipoUsuarioABM();
	}
	
	public UsuarioABM getUsuarioABM(){
		return new UsuarioABM();
	}
	
}
