package negocio;

import java.util.List;

import dao.ClienteDao;
import datos.Cliente;
import datos.TipoCliente;

public class ClienteABM {

	ClienteDao dao = new ClienteDao();
	
	
	public Cliente traerCliente(int idCliente) throws Exception{
		Cliente cliente = dao.traerCliente(idCliente);
			
    	if (cliente.equals(null))
    		throw new Exception("Error:El cliente no existe");
		
		return cliente;
	}
	
	
	public Cliente traerCliente(long dni) throws Exception{
		Cliente cliente = dao.traerCliente(dni);
		
		if (cliente.equals(null))
    		throw new Exception("Error:El cliente no existe");
		
		return cliente;
	}
	
	public Cliente traerClienteYComandas(int idCliente) throws Exception{
		Cliente cliente = dao.traerClienteYComandas(idCliente);
			
    	if (cliente.equals(null))
    		throw new Exception("Error:El cliente no existe");
		
		return cliente;
	}

	
    public int agregar(long dni, String nombre, String apellido, TipoCliente tipoCliente) throws Exception{
		if(dao.existeCliente(dni)){
			throw new Exception("Error:El cliente ya existe");
		}
		
		Cliente cliente = new Cliente(dni, nombre, apellido, tipoCliente);
		
		return dao.agregar(cliente);
	}
    
    public int agregar(Cliente cliente) throws Exception{
		if(dao.existeCliente(cliente.getDni())){
			throw new Exception("Error:El cliente ya existe");
		}
	
		return dao.agregar(cliente);
	}
	
    
	public void modificar(Cliente cliente) throws Exception{
		if(!dao.existeCliente(cliente.getDni())){
			throw new Exception("Error:El cliente no existe");
		}
		
		dao.actualizar(cliente);
	}
	
	public void eliminar(int id) throws Exception{
		Cliente cliente = dao.traerCliente(id);
		
		if(dao.existeCliente(id)){
			dao.eliminar(cliente);
		}else{
    		throw new Exception("Error:El cliente no existe");
		}	
	}
	
	public void eliminar(long dni) throws Exception{
		Cliente cliente = dao.traerCliente(dni);
		
		if(dao.existeCliente(dni)){
			dao.eliminar(cliente);
		}else{
    		throw new Exception("Error:El cliente no existe");
		}	
	}
	
	public List<Cliente> traerCliente(){
		return dao.traerCliente();
	}
	
}