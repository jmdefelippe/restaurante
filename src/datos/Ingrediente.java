package datos;

import java.util.Set;

public class Ingrediente {

	private int idIngrediente;
	private String nombre;
	
	private Presentacion presentacion;
	
	private Set<ItemStock> itemsStock;
	private Set<ItemComposicion> itemsComposicion;

	public Ingrediente() {
	}

	public Ingrediente(String nombre, Presentacion presentacion) {
		this.nombre = nombre;
		this.presentacion = presentacion;
	}

	public int getIdIngrediente() {
		return idIngrediente;
	}

	protected void setIdIngrediente(int idIngrediente) {
		this.idIngrediente = idIngrediente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Presentacion getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(Presentacion presentacion) {
		this.presentacion = presentacion;
	}

	public Set<ItemStock> getItemsStock() {
		return itemsStock;
	}

	public void setItemsStock(Set<ItemStock> itemsStock) {
		this.itemsStock = itemsStock;
	}

	public Set<ItemComposicion> getItemsComposicion() {
		return itemsComposicion;
	}

	public void setItemsComposicion(Set<ItemComposicion> itemsComposicion) {
		this.itemsComposicion = itemsComposicion;
	}
	
	@Override
	public String toString() {
		return  "Ingrediente [idIngrediente=" + idIngrediente +
				", nombre=" + nombre +
				"]";
	}	
	
}
