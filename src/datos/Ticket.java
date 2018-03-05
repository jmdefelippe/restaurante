package datos;

import java.util.GregorianCalendar;
import java.util.Set;

import funciones.Funciones;

public class Ticket {

	private int idTicket;
	private GregorianCalendar fecha;
	private boolean pagado;
	private boolean cortesia;
	private float total;
	
	private Restaurant restaurant;
	private Usuario usuario;
	
	private Set<ItemTicket> itemsTicket;
	private Set<Comanda> comandas;
	
	public Ticket() {
	}

	public Ticket(GregorianCalendar fecha, boolean pagado, boolean cortesia, float total, Restaurant restaurant, Usuario usuario) {
		this.fecha = fecha;
		this.pagado = pagado;
		this.cortesia = cortesia;
		this.total = total;
		this.restaurant = restaurant;
		this.usuario = usuario;
	}

	public int getIdTicket() {
		return idTicket;
	}

	protected void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}

	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}

	public boolean isPagado() {
		return pagado;
	}

	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}
	
	

	public boolean isCortesia() {
		return cortesia;
	}

	public void setCortesia(boolean cortesia) {
		this.cortesia = cortesia;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<ItemTicket> getItemsTicket() {
		return itemsTicket;
	}

	public void setItemsTicket(Set<ItemTicket> itemsTicket) {
		this.itemsTicket = itemsTicket;
	}

	public Set<Comanda> getComandas() {
		return comandas;
	}

	public void setComandas(Set<Comanda> comandas) {
		this.comandas = comandas;
	}
	
	@Override
	public String toString() {
		return  "Ticket [idTicket=" + idTicket +
				", fecha=" + Funciones.traerFechaCorta(fecha) +
				", pagado=" + pagado +
				", cortesia=" + cortesia +
				", total=" + total +
				"]";
	}

	public Ticket(Restaurant restaurant, Usuario usuario) {
		super();
		this.restaurant = restaurant;
		this.usuario = usuario;
	}	
	
	
	
}
