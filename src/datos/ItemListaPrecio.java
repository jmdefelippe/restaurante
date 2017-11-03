package datos;

public class ItemListaPrecio {

	private int idItemListaPrecio;
	private float precio;
	
	private ComponenteMenu componenteMenu;
	
	public ItemListaPrecio() {
	}

	public ItemListaPrecio(float precio, ComponenteMenu componenteMenu) {
		this.precio = precio;
		this.componenteMenu = componenteMenu;
	}

	public int getIdItemListaPrecio() {
		return idItemListaPrecio;
	}

	protected void setIdItemListaPrecio(int idItemListaPrecio) {
		this.idItemListaPrecio = idItemListaPrecio;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public ComponenteMenu getComponenteMenu() {
		return componenteMenu;
	}

	public void setComponenteMenu(ComponenteMenu componenteMenu) {
		this.componenteMenu = componenteMenu;
	}

	@Override
	public String toString() {
		return  "ItemListaPrecio [idItemListaPrecio=" + idItemListaPrecio +
				", precio=" + precio +
				"]";
	}	
	
}
