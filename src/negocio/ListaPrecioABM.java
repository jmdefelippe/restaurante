package negocio;

import java.util.GregorianCalendar;
import java.util.List;

import dao.ListaPrecioDao;
import datos.ListaPrecio;

public class ListaPrecioABM {

	ListaPrecioDao dao = new ListaPrecioDao();
	
	
	public ListaPrecio traerListaPrecio(int idListaPrecio) throws Exception{
		ListaPrecio listaPrecio = dao.traerListaPrecio(idListaPrecio);
			
    	if (listaPrecio.equals(null))
    		throw new Exception("Error:La listaPrecio no existe");
		
		return listaPrecio;
	}
	
 
    public int agregar(ListaPrecio listaPrecio){
		return dao.agregar(listaPrecio);
	}
	
    
	public void modificar(ListaPrecio listaPrecio){
		dao.actualizar(listaPrecio);
	}
	
	public void eliminar(int id) throws Exception{
		ListaPrecio listaPrecio = dao.traerListaPrecio(id);
		
		if(dao.existeListaPrecio(id)){
			dao.eliminar(listaPrecio);
		}else{
    		throw new Exception("Error:La listaPrecio no existe");
		}	
	}
	


	public ListaPrecio traerListaPrecio(int idListaPrecio){
		return dao.traerListaPrecio(idListaPrecio);
	}
	
	public ListaPrecio traerListaPrecioEItems(int idListaPrecio){
		return dao.traerListaPrecioEItems(idListaPrecio);
	}
	
	public List<ListaPrecio> traerListaPrecio(){
		return dao.traerListaPrecio();
	}
	
	public List<ListaPrecio> traerListaPrecio(GregorianCalendar fechaDesde, GregorianCalendar fechaHasta) throws Exception {
		List<ListaPrecio> listasPrecios = dao.traerListaPrecio(fechaDesde, fechaHasta);
		
		if(listasPrecios.size()==0) throw new Exception ("No hay menues");
		
		return dao.traerListaPrecio(fechaDesde, fechaHasta);
	}
	
}