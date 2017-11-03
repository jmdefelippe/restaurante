package datos;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import funciones.Funciones;

public class Menu {

	private int idMenu;
	private String nombre;
	private GregorianCalendar fecha;
	
	private Restaurant restaurant;
	
	private Set<ComponenteMenu> componentesMenu;

	public Menu() {
	}

	public Menu(String nombre, GregorianCalendar fecha, Restaurant restaurant) {
		this.nombre = nombre;
		this.fecha = fecha;
		this.restaurant = restaurant;
	}

	public int getIdMenu() {
		return idMenu;
	}

	protected void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
			
	public GregorianCalendar getFecha() {
		return fecha;
	}

	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Set<ComponenteMenu> getComponentesMenu() {
		return componentesMenu;
	}

	public void setComponentesMenu(Set<ComponenteMenu> componentesMenu) {
		this.componentesMenu = componentesMenu;
	}
	
	@Override
	public String toString() {
		return  "Menu [idMenu=" + idMenu +
				", nombre=" + nombre +
				", fecha=" + Funciones.traerFechaCorta(fecha) +
				"]";
	}	
	
/*	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
*/	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		if (nombre.compareTo(other.nombre) == 0)
			return false;
		return true;
	}

	public boolean agregar(ComponenteMenu componenteMenu) throws Exception{
		List<ComponenteMenu> listaComponentesMenu = new ArrayList(this.componentesMenu);
		
		for (int i=0; i < listaComponentesMenu.size(); i++){
			if(listaComponentesMenu.get(i).equals(componenteMenu)) throw new Exception ("ERROR: el componenteMenu ya esta en componentesMenu");
		}
		return this.componentesMenu.add(componenteMenu);
	}
	
	public boolean eliminar(ComponenteMenu componenteMenu) throws Exception{
		List<ComponenteMenu> listaComponentesMenu = new ArrayList(this.componentesMenu);
		
		boolean encontrado = false;
		for (int i=0; i < listaComponentesMenu.size(); i++){
			if(listaComponentesMenu.get(i).equals(componenteMenu))
				encontrado = true;
		}
		
		if (!encontrado) throw new Exception("ERROR: el componenteMenu no esta en lista");
		return componentesMenu.remove(componenteMenu);
	}
}
