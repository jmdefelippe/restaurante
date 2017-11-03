package datos;

import java.util.GregorianCalendar;
import java.util.Set;

import funciones.Funciones;

public class Comanda {
		
	private int idComanda;
	private GregorianCalendar fechaHora;
	
	private Camarero camarero;
	private Cliente cliente;
	private MesaCompuesta mesaCompuesta;
	
	private Set<ItemComanda> itemsComanda;

	public Comanda() {
	}

	public Comanda(GregorianCalendar fechaHora, Camarero camarero, Cliente cliente, MesaCompuesta mesaCompuesta) {
		this.fechaHora = fechaHora;
		this.camarero = camarero;
		this.cliente = cliente;
		this.mesaCompuesta = mesaCompuesta;
	}

	public int getIdComanda() {
		return idComanda;
	}

	protected void setIdComanda(int idComanda) {
		this.idComanda = idComanda;
	}
		
	public GregorianCalendar getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(GregorianCalendar fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Camarero getCamarero() {
		return camarero;
	}

	public void setCamarero(Camarero camarero) {
		this.camarero = camarero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public MesaCompuesta getMesaCompuesta() {
		return mesaCompuesta;
	}

	public void setMesaCompuesta(MesaCompuesta mesaCompuesta) {
		this.mesaCompuesta = mesaCompuesta;
	}

	public Set<ItemComanda> getItemsComanda() {
		return itemsComanda;
	}

	public void setItemsComanda(Set<ItemComanda> itemsComanda) {
		this.itemsComanda = itemsComanda;
	}
	
	@Override
	public String toString() {
		return  "Comanda [idComanda=" + idComanda +
				", fechaHora=" + Funciones.traerFechaCortaConHora(fechaHora) +
				"]";
	}	
	
}
