package state;

import datos.Cliente;

public class Ocupada extends EstadoMesa {
	
	@Override
	public EstadoMesa dejarDisponible() {		
		try {
			throw  new Exception( "Error, esta mesa no termino" );
		}  catch (Exception  e ) {
			e .printStackTrace(); 
		}
			return  this ; 
		}
	
	
	@Override
	public EstadoMesa ocupar(Cliente  cliente ) {
		try {
			throw  new Exception( "Error, esta mesa ya esta ocupada" );
		}  catch (Exception  e ) {
			e .printStackTrace(); 
		}
			return  this ; 
		}
	
	@Override
	public EstadoMesa terminar() {
			Terminada terminada =  new Terminada(); 
			return terminada ;
		}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Ocupado";
	}
	

}
