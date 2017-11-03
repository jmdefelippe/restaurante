package datos;

import java.util.GregorianCalendar;
import java.util.Set;

import funciones.Funciones;

public class ListaPrecio {

	private int idListaPrecio;
	
	private GregorianCalendar fechaDesde;
	private GregorianCalendar fechaHasta;
	
	private Set<ItemListaPrecio> itemsListaPrecio;
	private Set<Cliente> clientes;
	
	public ListaPrecio() {
	}

	public ListaPrecio(GregorianCalendar fechaDesde, GregorianCalendar fechaHasta) {
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
	}

	public int getIdListaPrecio() {
		return idListaPrecio;
	}

	protected void setIdListaPrecio(int idListaPrecio) {
		this.idListaPrecio = idListaPrecio;
	}

	public Set<ItemListaPrecio> getItemsListaPrecio() {
		return itemsListaPrecio;
	}

	public void setItemsListaPrecio(Set<ItemListaPrecio> itemsListaPrecio) {
		this.itemsListaPrecio = itemsListaPrecio;
	}

	public Set<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	@Override
	public String toString() {
		return  "ListaPrecio [idListaPrecio=" + idListaPrecio +
				", fechaDesde=" + Funciones.traerFechaCorta(fechaDesde) +
				", fechaHasta=" + Funciones.traerFechaCorta(fechaHasta) +
				"]";
	}	
	
}
