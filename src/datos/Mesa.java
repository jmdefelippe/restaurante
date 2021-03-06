package datos;

import java.util.Set;

import state.EstadoMesa;
import state.Libre;
import state.Ocupada;
//import state.Terminada;

public class Mesa {

	private int idMesa;
	private int capacidad;
	
	private EstadoMesa estadoMesa;
	
	private String state;
	
	private Set<Mesa> mesas;
	
	private Salon salon;
	
	private Set<Comanda> comandas;

	public Mesa() {
	}

	public Mesa(int capacidad, EstadoMesa estadoMesa) {
		this.capacidad = capacidad;
		this.state = getStringEstadoMesa(estadoMesa);
	}

		
	public int getIdMesa() {
		return idMesa;
	}

	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}

	public int getCapacidad() {
		return capacidad;
	}

	protected void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	
	public Set<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(Set<Mesa> mesas) {
		this.mesas = mesas;
	}

	@Override
	public String toString() {
		return  "Mesa [idMesa=" + idMesa +
				", capacidad=" + capacidad +
				", estado=" + state +
				"]";
	}
	
	
	public String getState() {
		return state;
	}

	public void setState(String estadoMesa) {
		this.state = estadoMesa;
	}

	public EstadoMesa getEstadoMesa(){
		if(getState().equals("Libre"))
			estadoMesa = new Libre();
		if(getState().equals("Ocupada"))
			estadoMesa = new Ocupada();
			
	//	if(getState().equals("Reservado"))
	//		estadoMesa = new Terminada();
				
		return this.estadoMesa;
	}
	
	public void setEstadoMesa(EstadoMesa estadoMesa) {
		this.estadoMesa = estadoMesa;
		this.state = estadoMesa.toString();
	}
	
	private String getStringEstadoMesa(EstadoMesa estadoMesa) {
		this.estadoMesa = estadoMesa;
		return estadoMesa.toString();
	}

	public Salon getSalon() {
		return salon;
	}

	public void setSalon(Salon salon) {
		this.salon = salon;
	}

	public Set<Comanda> getComandas() {
		return comandas;
	}

	public void setComandas(Set<Comanda> comandas) {
		this.comandas = comandas;
	}
	
	
	
}
