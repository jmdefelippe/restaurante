package datos;

import java.util.Set;

public class MesaCompuesta {

	private int idMesaCompuesta;
	
	private Salon salon;
	
	private Set<Mesa> mesas;
	private Set<Comanda> comandas;

	public MesaCompuesta() {
	}

	public MesaCompuesta(Salon salon) {
		this.salon = salon;
	}

	public int getIdMesaCompuesta() {
		return idMesaCompuesta;
	}

	protected void setIdMesaCompuesta(int idMesaCompuesta) {
		this.idMesaCompuesta = idMesaCompuesta;
	}
		
	public Salon getSalon() {
		return salon;
	}

	public void setSalon(Salon salon) {
		this.salon = salon;
	}

	public Set<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(Set<Mesa> mesas) {
		this.mesas = mesas;
	}
			
	public Set<Comanda> getComandas() {
		return comandas;
	}

	public void setComandas(Set<Comanda> comandas) {
		this.comandas = comandas;
	}

	@Override
	public String toString() {
		return  "MesaCompuesta [idMesaCompuesta=" + idMesaCompuesta +
				"]";
	}
	
}
