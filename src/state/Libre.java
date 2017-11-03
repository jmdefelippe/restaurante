package state;

import datos.Cliente;

public class Libre extends EstadoMesa{

	@Override
	public EstadoMesa dejarDisponible() {
		try {
			throw  new Exception( "Error, esta mesa ya esta libre" );
		}  catch (Exception  e ) {
			e .printStackTrace(); 
		}
		return  this ; 
	}

	@Override
	public EstadoMesa ocupar(Cliente  cliente ) { 
		Ocupada ocupada =  new Ocupada(); 
		ocupada.setCliente(cliente); 
		return ocupada ;
	}

	@Override
	public EstadoMesa terminar() {
		
		String s;
	
		try {
			throw  new Exception( "Error, no hay mesa que terminar" );
		}  catch (Exception  e ) {
			e .printStackTrace(); }
		return  this ; 
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Libre";
	}
	
}
