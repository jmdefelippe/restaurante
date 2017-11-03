package datos;

import java.util.Set;

public class Conversion {

	private int idConversion;
	private String presentacionCompra;
	private String presentacionVenta;
	private int cantidad;
	
	private Set<Presentacion> presentaciones;

	public Conversion() {
	}

	public Conversion(String presentacionCompra, String presentacionVenta, int cantidad) {
		this.presentacionCompra = presentacionCompra;
		this.presentacionVenta = presentacionVenta;
		this.cantidad = cantidad;
	}

	public int getIdConversion() {
		return idConversion;
	}

	protected void setIdConversion(int idConversion) {
		this.idConversion = idConversion;
	}

	public String getPresentacionCompra() {
		return presentacionCompra;
	}

	public void setPresentacionCompra(String presentacionCompra) {
		this.presentacionCompra = presentacionCompra;
	}

	public String getPresentacionVenta() {
		return presentacionVenta;
	}

	public void setPresentacionVenta(String presentacionVenta) {
		this.presentacionVenta = presentacionVenta;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Set<Presentacion> getPresentaciones() {
		return presentaciones;
	}

	public void setPresentaciones(Set<Presentacion> presentaciones) {
		this.presentaciones = presentaciones;
	}
	
	@Override
	public String toString() {
		return  "Conversion [idConversion=" + idConversion +
				", presentacionCompra=" + presentacionCompra +
				", presentacionVenta=" + presentacionVenta +
				", cantidad=" + cantidad +
				"]";
	}	
	
}
