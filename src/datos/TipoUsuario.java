package datos;

import java.util.Set;

public class TipoUsuario {

	private int idTipoUsuario;
	private String nombre;
	
	private Set<Usuario> usuarios;
	
	public TipoUsuario() {
	}

	public TipoUsuario(String nombre) {
		this.nombre = nombre;
	}

	public int getIdTipoUsuario() {
		return idTipoUsuario;
	}

	protected void setIdTipoUsuario(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	
	@Override
	public String toString() {
		return  "TipoUsuario [idTipoUsuario=" + idTipoUsuario +
				", nombre=" + nombre +
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
		TipoUsuario other = (TipoUsuario) obj;
		if (nombre.compareTo(other.nombre) == 0)
			return false;
		return true;
	}


		
}
