package datos;

public class Login {
	
	private int idLogin;
	private String nombre;
	private String contrase�a;
	
	private Usuario usuario;

	public Login() {
	}

	public Login(String nombre, String contrase�a, Usuario usuario) {
		this.nombre = nombre;
		this.contrase�a = contrase�a;
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

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
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
				", contrase�a=" + contrase�a +
				"]";
	}	
	
}
