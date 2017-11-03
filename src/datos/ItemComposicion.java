package datos;

public class ItemComposicion {

	private int idItemComposicion;
	private int cantidad;
	
	private Producto producto;
	private Ingrediente ingrediente;
	
	public ItemComposicion() {
	}

	public ItemComposicion(int cantidad, Producto producto, Ingrediente ingrediente) {
		this.cantidad = cantidad;
		this.producto = producto;
		this.ingrediente= ingrediente;
	}

	public int getIdItemComposicion() {
		return idItemComposicion;
	}

	protected void setIdItemComposicion(int idItemComposicion) {
		this.idItemComposicion = idItemComposicion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}
	
	@Override
	public String toString() {
		return  "ItemComposicion [idItemComposicion=" + idItemComposicion +
				", cantidad=" + cantidad +
				"]";
	}	
	
}
