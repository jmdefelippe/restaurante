package negocio;

import java.util.List;

import dao.MesaDao;
import datos.Mesa;
import datos.MesaCompuesta;
import datos.Salon;
import state.EstadoMesa;

public class MesaABM {

	MesaDao dao = new MesaDao();
	
	
	public Mesa traerMesa(int idMesa) throws Exception{
		Mesa mesa = dao.traerMesa(idMesa);
			
    	if (mesa.equals(null))
    		throw new Exception("Error:El mesa no existe");
		
		return mesa;
	}
	
	
    public int agregar(int capacidad, EstadoMesa estadoMesa, MesaCompuesta mesaCompuesta) throws Exception{
		Mesa mesa = new Mesa(capacidad, estadoMesa, mesaCompuesta);
		
		return dao.agregar(mesa);
	}
    
    public int agregar(Mesa mesa){
		return dao.agregar(mesa);
	}
	
    
	public void modificar(Mesa mesa){
		dao.actualizar(mesa);
	}
	
	public void eliminar(int id) throws Exception{
		Mesa mesa = dao.traerMesa(id);
		
		if(dao.existeMesa(id)){
			dao.eliminar(mesa);
		}else{
    		throw new Exception("Error:La mesa no existe");
		}	
	}
	
	
	public List<Mesa> traerMesa(){
		return dao.traerMesa();
	}
	
}