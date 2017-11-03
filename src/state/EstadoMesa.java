package state;

import java.util.GregorianCalendar;
import datos.Cliente;

public abstract class EstadoMesa {
	
	private Cliente cliente ;
	
	public  abstract EstadoMesa dejarDisponible(); 
	public  abstract EstadoMesa ocupar(Cliente cliente ); 
	public  abstract EstadoMesa terminar();
	public 	abstract String toString();
	
		
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	
	

}
