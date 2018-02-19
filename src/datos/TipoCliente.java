package datos;

import java.util.Set;

public class TipoCliente {

	private int idTipoCliente;
	private String nombre;
	
	private ListaPrecio listaPrecio;
	
	private Set<Cliente> clientes;

	public TipoCliente() {
	}

	public TipoCliente(String nombre) {
		this.nombre = nombre;
	}

	public int getIdTipoCliente() {
		return idTipoCliente;
	}

	protected void setIdTipoCliente(int idTipoCliente) {
		this.idTipoCliente = idTipoCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

	public ListaPrecio getListaPrecio() {
		return listaPrecio;
	}

	public void setListaPrecio(ListaPrecio listaPrecio) {
		this.listaPrecio = listaPrecio;
	}

	public Set<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	@Override
	public String toString() {
		return  "TipoCliente [idTipoCliente=" + idTipoCliente +
				", nombre=" + nombre +
				"]";
	}	
	
}
