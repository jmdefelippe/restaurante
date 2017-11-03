package negocio;

import java.util.List;

import dao.RestaurantDao;
import datos.Restaurant;

public class RestaurantABM {

	RestaurantDao dao = new RestaurantDao();
	
	
	public Restaurant traerRestaurant(int idRestaurant) throws Exception{
		Restaurant restaurant = dao.traerRestaurant(idRestaurant);
			
    	if (restaurant.equals(null))
    		throw new Exception("Error:El restaurant no existe");
		
		return restaurant;
	}
	
	
	public Restaurant traerRestaurant(String nombre) throws Exception{
		Restaurant restaurant = dao.traerRestaurant(nombre);
		
		if (restaurant.equals(null))
    		throw new Exception("Error:El restaurant no existe");
		
		return restaurant;
	}

	public Restaurant traerRestaurantYMenues(int idRestaurant) throws Exception{
		Restaurant restaurant = dao.traerRestaurantYMenues(idRestaurant);
			
    	if (restaurant.equals(null))
    		throw new Exception("Error:El restaurant no existe");
		
		return restaurant;
	}
	
	public Restaurant traerRestaurantYSalones(int idRestaurant) throws Exception{
		Restaurant restaurant = dao.traerRestaurantYSalones(idRestaurant);
			
    	if (restaurant.equals(null))
    		throw new Exception("Error:El restaurant no existe");
		
		return restaurant;
	}
	
	public Restaurant traerRestaurantYTickets(int idRestaurant) throws Exception{
		Restaurant restaurant = dao.traerRestaurantYTickets(idRestaurant);
			
    	if (restaurant.equals(null))
    		throw new Exception("Error:El restaurant no existe");
		
		return restaurant;
	}

	
    public int agregar(String nombre, String telefono, String direccion, String localidad, String correoElectronico) throws Exception{
		if(dao.existeRestaurant(nombre)){
			throw new Exception("Error:El restaurant ya existe");
		}
		
		Restaurant restaurant = new Restaurant(nombre, telefono, direccion, localidad, correoElectronico);
		
		return dao.agregar(restaurant);
	}
    
    public int agregar(Restaurant restaurant) throws Exception{
		if(dao.existeRestaurant(restaurant.getNombre())){
			throw new Exception("Error:El restaurant ya existe");
		}
	
		return dao.agregar(restaurant);
	}
	
    
	public void modificar(Restaurant restaurant) throws Exception{
		if(!dao.existeRestaurant(restaurant.getNombre())){
			throw new Exception("Error:El restaurant no existe");
		}
		
		dao.actualizar(restaurant);
	}
	
	public void eliminar(int id) throws Exception{
		Restaurant restaurant = dao.traerRestaurant(id);
		
		if(dao.existeRestaurant(id)){
			dao.eliminar(restaurant);
		}else{
    		throw new Exception("Error:El restaurant no existe");
		}	
	}
	
	public void eliminar(String nombre) throws Exception{
		Restaurant restaurant = dao.traerRestaurant(nombre);
		
		if(dao.existeRestaurant(nombre)){
			dao.eliminar(restaurant);
		}else{
    		throw new Exception("Error:El restaurant no existe");
		}	
	}
	
	public List<Restaurant> traerRestaurant(){
		return dao.traerRestaurant();
	}
	
}