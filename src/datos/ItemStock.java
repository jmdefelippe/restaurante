package datos;

public class ItemStock {

	private int idItemStock;
	private int cantidad;
	
	private Ingrediente ingrediente;
	private Stock stock;
	
	public ItemStock() {
	}

	public ItemStock(int cantidad, Ingrediente ingrediente, Stock stock) {
		this.cantidad = cantidad;
		this.ingrediente = ingrediente;
		this.stock = stock;
	}

	public int getIdItemStock() {
		return idItemStock;
	}

	protected void setIdItemStock(int idItemStock) {
		this.idItemStock = idItemStock;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}
	
	@Override
	public String toString() {
		return  "ItemStock [idItemStock=" + idItemStock +
				", cantidad=" + cantidad +
				"]";
	}	
	
}
