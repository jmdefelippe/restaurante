package datos;

import java.util.Set;

public class Cliente {

	private int idCliente;
	private long dni;
	private String nombre;
	private String apellido;
		
	private TipoCliente tipoCliente;
	
	private Set<Comanda> comandas;

	public Cliente() {
	}

	public Cliente(long dni, String nombre, String apellido, TipoCliente tipoCliente) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoCliente = tipoCliente;
	}

	public int getIdCliente() {
		return idCliente;
	}

	protected void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
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

	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public Set<Comanda> getComandas() {
		return comandas;
	}

	public void setComandas(Set<Comanda> comandas) {
		this.comandas = comandas;
	}
	
	@Override
	public String toString() {
		return  "Cliente [idCliente=" + idCliente +
				", dni=" + dni +
				", nombre=" + nombre +
				", apellido=" + apellido +
				"]";
	}
	
}
