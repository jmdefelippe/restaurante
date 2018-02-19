package datos;

import java.util.GregorianCalendar;
import java.util.Set;

import funciones.Funciones;

public class ListaPrecio {

	private int idListaPrecio;
	
	private GregorianCalendar fechaDesde;
	private GregorianCalendar fechaHasta;
	
	private Set<ItemListaPrecio> itemsListaPrecio;
	private Set<TipoCliente> tiposCliente;
	
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

	public Set<TipoCliente> getTiposCliente() {
		return tiposCliente;
	}

	public void setTiposCliente(Set<TipoCliente> tiposCliente) {
		this.tiposCliente = tiposCliente;
	}
	
	@Override
	public String toString() {
		return  "ListaPrecio [idListaPrecio=" + idListaPrecio +
				", fechaDesde=" + Funciones.traerFechaCorta(fechaDesde) +
				", fechaHasta=" + Funciones.traerFechaCorta(fechaHasta) +
				"]";
	}

	public GregorianCalendar getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(GregorianCalendar fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public GregorianCalendar getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(GregorianCalendar fechaHasta) {
		this.fechaHasta = fechaHasta;
	}	
	
	
	
}
