package negocio;

import java.util.List;

import dao.MesaCompuestaDao;
import datos.MesaCompuesta;

public class MesaCompuestaABM {

	MesaCompuestaDao dao = new MesaCompuestaDao();
	
	
	public MesaCompuesta traerMesaCompuesta(int idMesaCompuesta) throws Exception{
		MesaCompuesta mesaCompuesta = dao.traerMesaCompuesta(idMesaCompuesta);
			
    	if (mesaCompuesta.equals(null))
    		throw new Exception("Error:El mesaCompuesta no existe");
		
		return mesaCompuesta;
	}
	
	
    public int agregar(MesaCompuesta mesaCompuesta){
		return dao.agregar(mesaCompuesta);
	}
	
    
	public void modificar(MesaCompuesta mesaCompuesta){
		dao.actualizar(mesaCompuesta);
	}
	
	public void eliminar(int id) throws Exception{
		MesaCompuesta mesaCompuesta = dao.traerMesaCompuesta(id);
		
		if(dao.existeMesaCompuesta(id)){
			dao.eliminar(mesaCompuesta);
		}else{
    		throw new Exception("Error:La mesaCompuesta no existe");
		}	
	}
	
	
	public List<MesaCompuesta> traerMesaCompuesta(){
		return dao.traerMesaCompuesta();
	}
	
}