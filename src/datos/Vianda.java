package datos;

import java.util.Set;

public class Vianda extends ComponenteMenu {

	private Set<Producto> productos;

	public Vianda() {
	}

	public Vianda(String nombre, String imagen, String disponibilidad, boolean estado, Subrubro subrubro) {
		super(nombre, imagen, disponibilidad, estado, subrubro);
	}

	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}
	
	
	
}
