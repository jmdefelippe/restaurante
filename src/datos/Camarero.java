package datos;

import java.util.Set;

public class Camarero {

	private int idCamarero;
	private long dni;
	private String nombre;
	private String apellido;
	
	private Set<Comanda> comandas;

	public Camarero() {
	}

	public Camarero(long dni, String nombre, String apellido) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public int getIdCamarero() {
		return idCamarero;
	}

	protected void setIdCamarero(int idCamarero) {
		this.idCamarero = idCamarero;
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

	public Set<Comanda> getComandas() {
		return comandas;
	}

	public void setComandas(Set<Comanda> comandas) {
		this.comandas = comandas;
	}
	
	@Override
	public String toString() {
		return  "Camarero [idCamarero=" + idCamarero +
				", dni=" + dni +
				", nombre=" + nombre +
				", apellido=" + apellido +
				"]";
	}	
	
}
