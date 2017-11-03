package datos;

import java.util.Set;

public class Producto extends ComponenteMenu {

	private Set<ItemComposicion> itemsComposicion;
	private Set<Vianda> viandas;
	
	public Producto() {
	}

	public Producto(String nombre, String imagen, String disponibilidad, boolean estado, Subrubro subrubro) {
		super(nombre, imagen, disponibilidad, estado, subrubro);
	}

	public Set<ItemComposicion> getItemsComposicion() {
		return itemsComposicion;
	}

	public void setItemsComposicion(Set<ItemComposicion> itemsComposicion) {
		this.itemsComposicion = itemsComposicion;
	}

	public Set<Vianda> getViandas() {
		return viandas;
	}

	public void setViandas(Set<Vianda> viandas) {
		this.viandas = viandas;
	}
	
	
	
}
