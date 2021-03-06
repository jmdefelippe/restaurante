package datos;

import java.util.Set;

public class Salon {

	private int idSalon;
	private String descripcion;
	
	private Restaurant restaurant;
	
	private Set<Mesa> mesas;

	public Salon() {
	}

	public Salon(String descripcion, Restaurant restaurant) {
		this.descripcion = descripcion;
		this.restaurant = restaurant;
	}

	public int getIdSalon() {
		return idSalon;
	}

	protected void setIdSalon(int idSalon) {
		this.idSalon = idSalon;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	
	public Set<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(Set<Mesa> mesas) {
		this.mesas = mesas;
	}
	
	@Override
	public String toString() {
		return  "Salon [idSalon=" + idSalon +
				", descripcion=" + descripcion +
				"]";
	}
	
}
