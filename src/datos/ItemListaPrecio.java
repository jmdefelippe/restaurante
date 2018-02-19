package datos;

public class ItemListaPrecio {

	private int idItemListaPrecio;
	private float precio;
	
	private ComponenteMenu componenteMenu;
	private ListaPrecio listaPrecio;
	
	public ListaPrecio getListaPrecio() {
		return listaPrecio;
	}

	public void setListaPrecio(ListaPrecio listaPrecio) {
		this.listaPrecio = listaPrecio;
	}

	public ItemListaPrecio() {
	}
		
	public ItemListaPrecio(float precio) {
		super();
		this.precio = precio;
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

	public void setPrecio(float precio) {
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
