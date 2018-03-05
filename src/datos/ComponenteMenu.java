package datos;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ComponenteMenu {

	private int idComponenteMenu;
	private String nombre;
	private String descripcion;
	private String imagen;
	private String disponibilidad;
	private boolean estado;
	
	private Subrubro subrubro;

	private Set<ItemTicket> itemsTicket;
	private Set<ItemComanda> itemsComanda;
	private Set<ItemListaPrecio> itemsListaPrecios;
	private Set<Menu> menues;
	
	public ComponenteMenu() {
	}

	public ComponenteMenu(String nombre, String descripcion, String imagen, String disponibilidad, boolean estado, Subrubro subrubro) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.disponibilidad = disponibilidad;
		this.estado = estado;
		this.subrubro = subrubro;
	}

	public int getIdComponenteMenu() {
		return idComponenteMenu;
	}

	protected void setIdComponenteMenu(int idComponenteMenu) {
		this.idComponenteMenu = idComponenteMenu;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Subrubro getSubrubro() {
		return subrubro;
	}

	public void setSubrubro(Subrubro subrubro) {
		this.subrubro = subrubro;
	}

	public Set<ItemTicket> getItemsTicket() {
		return itemsTicket;
	}

	public void setItemsTicket(Set<ItemTicket> itemsTicket) {
		this.itemsTicket = itemsTicket;
	}

	public Set<ItemComanda> getItemsComanda() {
		return itemsComanda;
	}

	public void setItemsComanda(Set<ItemComanda> itemsComanda) {
		this.itemsComanda = itemsComanda;
	}

	public Set<ItemListaPrecio> getItemsListaPrecios() {
		return itemsListaPrecios;
	}

	public void setItemsListaPrecios(Set<ItemListaPrecio> itemsListaPrecios) {
		this.itemsListaPrecios = itemsListaPrecios;
	}
			
	public Set<Menu> getMenues() {
		return menues;
	}

	public void setMenues(Set<Menu> menues) {
		this.menues = menues;
	}

	@Override
	public String toString() {
		return  "Plato: " + nombre;
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
		ComponenteMenu other = (ComponenteMenu) obj;
		if (nombre.compareTo(other.nombre) == 0)
			return false;
		return true;
	}

	public boolean agregar(Menu menu) throws Exception{
		List<Menu> listaMenues = new ArrayList(this.menues);
		
		for (int i=0; i < listaMenues.size(); i++){
			if(listaMenues.get(i).equals(menu)) throw new Exception ("ERROR: el menu ya esta en menues");
		}
		return this.menues.add(menu);
	}
	
	public boolean eliminar(Menu menu) throws Exception{
		List<Menu> listaMenues = new ArrayList(this.menues);
		
		boolean encontrado = false;
		for (int i=0; i < listaMenues.size(); i++){
			if(listaMenues.get(i).equals(menu))
				encontrado = true;
		}
		
		if (!encontrado) throw new Exception("ERROR: el menu no esta en lista");
		return menues.remove(menu);
	}
	
	
}
