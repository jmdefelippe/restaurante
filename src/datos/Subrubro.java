package datos;

import java.util.Set;

public class Subrubro {

	private int idSubrubro;
	private String nombre;
	
	private Rubro rubro;
	
	private Set<ComponenteMenu> componentesMenu;
	
	public Subrubro() {
	}

	public Subrubro(String nombre, Rubro rubro) {
		this.nombre = nombre;
		this.rubro = rubro;
	}

	public int getIdSubrubro() {
		return idSubrubro;
	}

	protected void setIdSubrubro(int idSubrubro) {
		this.idSubrubro = idSubrubro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Rubro getRubro() {
		return rubro;
	}

	public void setRubro(Rubro rubro) {
		this.rubro = rubro;
	}

	public Set<ComponenteMenu> getComponentesMenu() {
		return componentesMenu;
	}

	public void setComponentesMenu(Set<ComponenteMenu> componentesMenu) {
		this.componentesMenu = componentesMenu;
	}
	
	@Override
	public String toString() {
		return  "Subrubro [idSubrubro=" + idSubrubro +
				", nombre=" + nombre +
				"]";
	}	
	
}
