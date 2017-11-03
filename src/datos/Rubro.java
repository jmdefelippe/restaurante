package datos;

import java.util.Set;

public class Rubro {

	private int idRubro;
	private String nombre;
	
	private Set<Subrubro> subrubros;
	
	public Rubro() {
	}

	public Rubro(String nombre) {
		this.nombre = nombre;
	}

	public int getIdRubro() {
		return idRubro;
	}

	protected void setIdRubro(int idRubro) {
		this.idRubro = idRubro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Subrubro> getSubrubros() {
		return subrubros;
	}

	public void setSubrubros(Set<Subrubro> subrubros) {
		this.subrubros = subrubros;
	}
	
	@Override
	public String toString() {
		return  "Rubro [idRubro=" + idRubro +
				", nombre=" + nombre +
				"]";
	}	
		
}
