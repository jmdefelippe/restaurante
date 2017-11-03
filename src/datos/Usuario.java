package datos;

import java.util.Set;

public class Usuario {

	private int idUsuario;
	private long dni;
	private String nombre;
	private String apellido;
		
	private Set<Ticket> tickets;

	public Usuario() {
	}

	public Usuario(long dni, String nombre, String apellido) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	protected void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Set<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}
	
	@Override
	public String toString() {
		return  "Usuario [idUsuario=" + idUsuario +
				", dni=" + dni +
				", nombre=" + nombre +
				", apellido=" + apellido +
				"]";
	}	
	
}
