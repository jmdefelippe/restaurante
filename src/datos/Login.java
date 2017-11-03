package datos;

public class Login {
	
	private int idLogin;
	private String nombre;
	private String contraseña;
	
	private Usuario usuario;

	public Login() {
	}

	public Login(String nombre, String contraseña, Usuario usuario) {
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.usuario = usuario;
	}

	public int getIdLogin() {
		return idLogin;
	}

	protected void setIdLogin(int idLogin) {
		this.idLogin = idLogin;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public String toString() {
		return  "Login [idLogin=" + idLogin +
				", nombre=" + nombre +
				", contraseña=" + contraseña +
				"]";
	}	
	
}
