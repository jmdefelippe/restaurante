package state;

//VER!!

import datos.Cliente;

public class Terminada extends EstadoMesa {
	
	@Override
	public EstadoMesa dejarDisponible() {
		return  new Libre(); 
	}
	
	@Override
	public EstadoMesa ocupar(Cliente  cliente ) {
		try {
			throw  new Exception( "Error, esta mesa no esta libre" );
		}  catch (Exception  e ) { 
			e .printStackTrace();
		}
		
		return  this ; 
	}
	
	@Override
	public EstadoMesa terminar() {
		try {
			throw  new Exception( "Error, esta mesa ya termino" );
		}  catch (Exception  e ) { 
			e .printStackTrace();
		}
		
		return  this ; 
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Reservado";
	}

}
