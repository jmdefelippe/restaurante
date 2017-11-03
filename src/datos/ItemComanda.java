package datos;

public class ItemComanda {

	private int idItemComanda;
	private int cantidad;
	
	private ComponenteMenu componenteMenu;
		
	public ItemComanda() {
	}

	public ItemComanda(int cantidad, ComponenteMenu componenteMenu) {
		this.cantidad = cantidad;
		this.componenteMenu = componenteMenu;
	}

	public int getIdItemComanda() {
		return idItemComanda;
	}

	protected void setIdItemComanda(int idItemComanda) {
		this.idItemComanda = idItemComanda;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public ComponenteMenu getComponenteMenu() {
		return componenteMenu;
	}

	public void setComponenteMenu(ComponenteMenu componenteMenu) {
		this.componenteMenu = componenteMenu;
	}
	
	@Override
	public String toString() {
		return  "ItemComanda [idItemComanda=" + idItemComanda +
				", cantidad=" + cantidad +
				"]";
	}	
	
}
