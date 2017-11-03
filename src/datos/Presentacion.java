package datos;

import java.util.Set;

public class Presentacion {

	private int idPresentacion;
	private String descripcion;
	
	private Conversion conversion;
	
	private Set<Ingrediente> ingredientes;

	public Presentacion() {
	}

	public Presentacion(String descripcion, Conversion conversion) {
		this.descripcion = descripcion;
		this.conversion = conversion;
	}

	public int getIdPresentacion() {
		return idPresentacion;
	}

	protected void setIdPresentacion(int idPresentacion) {
		this.idPresentacion = idPresentacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Conversion getConversion() {
		return conversion;
	}

	public void setConversion(Conversion conversion) {
		this.conversion = conversion;
	}

	public Set<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(Set<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	@Override
	public String toString() {
		return  "Presentacion [idPresentacion=" + idPresentacion +
				", descripcion=" + descripcion +
				"]";
	}
	
}
