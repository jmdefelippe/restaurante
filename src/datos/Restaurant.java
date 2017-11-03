package datos;

import java.util.Set;

public class Restaurant {

	private int idRestaurant;
	private String nombre;
	private String telefono;
	private String direccion;
	private String localidad;
	private String correoElectronico;
	
	private Set<Menu> menues;
	private Set<Salon> salones;
	private Set<Ticket> tickets;
	
	public Restaurant() {
	}

	public Restaurant(String nombre, String telefono, String direccion, String localidad,
			String correoElectronico) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.localidad = localidad;
		this.correoElectronico = correoElectronico;
	}

	public int getIdRestaurant() {
		return idRestaurant;
	}

	protected void setIdRestaurant(int idRestaurant) {
		this.idRestaurant = idRestaurant;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public Set<Menu> getMenues() {
		return menues;
	}

	public void setMenues(Set<Menu> menues) {
		this.menues = menues;
	}

	public Set<Salon> getSalones() {
		return salones;
	}

	public void setSalones(Set<Salon> salones) {
		this.salones = salones;
	}
	
		
	public Set<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}

	@Override
	public String toString() {
		return  "Restaurant [idRestaurant=" + idRestaurant +
				", nombre=" + nombre +
				", telefono=" + telefono +
				", direccion=" + direccion +
				", localidad=" + localidad +
				", correoElectronico=" + correoElectronico +
				"]";
	}	
	
}
