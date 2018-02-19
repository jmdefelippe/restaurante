package datos;

public class ItemTicket {
	
	private int idItemTicket;
	private int cantidad;
	private float importe;
	
	private ComponenteMenu componenteMenu;
	private Ticket ticket;
	
	
	public ItemTicket() {
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	

	public ItemTicket(int cantidad, float importe) {
		super();
		this.cantidad = cantidad;
		this.importe = importe;
	}

	public ItemTicket(int cantidad, float importe, ComponenteMenu componenteMenu) {
		this.cantidad = cantidad;
		this.importe = importe;
		this.componenteMenu = componenteMenu;
	}

	public int getIdItemTicket() {
		return idItemTicket;
	}

	protected void setIdItemTicket(int idItemTicket) {
		this.idItemTicket = idItemTicket;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public ComponenteMenu getComponenteMenu() {
		return componenteMenu;
	}

	public void setComponenteMenu(ComponenteMenu componenteMenu) {
		this.componenteMenu = componenteMenu;
	}
	
	@Override
	public String toString() {
		return  "ItemTicket [idItemTicket=" + idItemTicket +
				", cantidad=" + cantidad +
				", importe=" + importe +
				"]";
	}	
	
}
