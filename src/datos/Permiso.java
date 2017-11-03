package datos;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Permiso {

	private int idPermiso;
	private String accion;
	
	private Set<TipoUsuario> tiposUsuarios;

	public Permiso() {
	}

	public Permiso(String accion) {
		this.accion = accion;
	}

	public int getIdPermiso() {
		return idPermiso;
	}

	protected void setIdPermiso(int idPermiso) {
		this.idPermiso = idPermiso;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public Set<TipoUsuario> getTiposUsuarios() {
		return tiposUsuarios;
	}

	public void setTiposUsuarios(Set<TipoUsuario> tiposUsuarios) {
		this.tiposUsuarios = tiposUsuarios;
	}
	
	@Override
	public String toString() {
		return  "Permiso [idPermiso=" + idPermiso +
				", accion=" + accion +
				"]";
	}
	
/*	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accion == null) ? 0 : accion.hashCode());
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
		Permiso other = (Permiso) obj;
		if (accion.compareTo(other.accion) == 0)
			return false;
		return true;
	}

	public boolean agregar(TipoUsuario tipoUsuario) throws Exception{
		List<TipoUsuario> listaTiposUsuarios = new ArrayList(this.tiposUsuarios);
		
		for (int i=0; i < listaTiposUsuarios.size(); i++){
			if(listaTiposUsuarios.get(i).equals(tipoUsuario)) throw new Exception ("ERROR: el tipoUsuario ya esta en tiposUsuarios");
		}
		return this.tiposUsuarios.add(tipoUsuario);
	}
	
	public boolean eliminar(TipoUsuario tipoUsuario) throws Exception{
		List<TipoUsuario> listaTiposUsuarios = new ArrayList(this.tiposUsuarios);
		
		boolean encontrado = false;
		for (int i=0; i < listaTiposUsuarios.size(); i++){
			if(listaTiposUsuarios.get(i).equals(tipoUsuario))
				encontrado = true;
		}
		
		if (!encontrado) throw new Exception("ERROR: el tipoUsuario no esta en lista");
		return tiposUsuarios.remove(tipoUsuario);
	}
	
}
