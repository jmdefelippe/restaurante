package datos;

public class Login {
	
	private int idLogin;
	private String nick;
	private String clave;
	
	private Usuario usuario;

	public Login() {
	}

	public Login(int idLogin, String nick, String clave) {
		super();
		this.idLogin = idLogin;
		this.nick = nick;
		this.clave = clave;
	}
	
	public Login(int idLogin, String nick, String clave, Usuario usuario) {
		super();
		this.idLogin = idLogin;
		this.nick = nick;
		this.clave = clave;
		this.usuario = usuario;
	}

	public int getIdLogin() {
		return idLogin;
	}

	protected void setIdLogin(int idLogin) {
		this.idLogin = idLogin;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
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
				", nick=" + nick +
				", clave=" + clave +
				", usuario=" + usuario.getNombre() + " " + usuario.getApellido() +
				"]";
	}	
	
}
