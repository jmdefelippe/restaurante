package negocio;

import java.util.GregorianCalendar;
import java.util.List;

import dao.ComandaDao;
import datos.Camarero;
import datos.Cliente;
import datos.Comanda;
import datos.Mesa;
import datos.Ticket;

public class ComandaABM {

	ComandaDao dao = new ComandaDao();
	
	
	public Comanda traerComanda(int idComanda) throws Exception{
		Comanda comanda = dao.traerComanda(idComanda);
			
    	if (comanda.equals(null))
    		throw new Exception("Error:La comanda no existe");
		
		return comanda;
	}

	
    public int agregar(GregorianCalendar fechaHora, Camarero camarero, Cliente cliente, Mesa mesa){
		Comanda comanda = new Comanda(fechaHora, camarero, cliente, mesa);
		
		return dao.agregar(comanda);
	}
    
    public int agregar(Comanda comanda){
		return dao.agregar(comanda);
	}
	
    
	public void modificar(Comanda comanda){
		dao.actualizar(comanda);
	}
	
	public void eliminar(int id) throws Exception{
		Comanda comanda = dao.traerComanda(id);
		
		if(dao.existeComanda(id)){
			dao.eliminar(comanda);
		}else{
    		throw new Exception("Error:La comanda no existe");
		}	
	}

	public List<Comanda> traerComanda(){
		return dao.traerComanda();
	}
	
	public List<Comanda> traerComanda(GregorianCalendar fechaHora) throws Exception {
		List<Comanda> comandas = dao.traerComanda(fechaHora);
		
		if(comandas.size()==0) throw new Exception ("No hay comandas");
		
		return dao.traerComanda(fechaHora);
	}
	
}