package datos;

import java.util.Set;

public class Stock {
	
	private int idStock;
	
	private Set<ItemStock> itemsStock;

	public Stock() {
	}

	public int getIdStock() {
		return idStock;
	}

	protected void setIdStock(int idStock) {
		this.idStock = idStock;
	}

	public Set<ItemStock> getItemsStock() {
		return itemsStock;
	}

	public void setItemsStock(Set<ItemStock> itemsStock) {
		this.itemsStock = itemsStock;
	}

	@Override
	public String toString() {
		return  "Stock [idStock=" + idStock +
				"]";
	}	
	
	
}
