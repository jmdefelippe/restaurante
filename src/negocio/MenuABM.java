package negocio;

import java.util.GregorianCalendar;
import java.util.List;

import dao.MenuDao;
import datos.ComponenteMenu;
import datos.Menu;
import datos.Permiso;
import datos.Restaurant;
import datos.TipoUsuario;

public class MenuABM {

	MenuDao dao = new MenuDao();
	
	
	public Menu traerMenu(int idMenu) throws Exception{
		Menu menu = dao.traerMenu(idMenu);
			
    	if (menu.equals(null))
    		throw new Exception("Error:El menu no existe");
		
		return menu;
	}
	
	
	public Menu traerMenu(String nombre) throws Exception{
		Menu menu = dao.traerMenu(nombre);
		
		if (menu.equals(null))
    		throw new Exception("Error:El menu no existe");
		
		return menu;
	}
	
	public Menu traerMenuYComponentesMenu(int idMenu) throws Exception{
		Menu menu = dao.traerMenuYComponentesMenu(idMenu);
			
    	if (menu.equals(null))
    		throw new Exception("Error:El menu no existe");
		
		return menu;
	}

	
    public int agregar(String nombre, GregorianCalendar fecha, Restaurant restaurant) throws Exception{
		if(dao.existeMenu(nombre)){
			throw new Exception("Error:El menu ya existe");
		}
		
		Menu menu = new Menu(nombre, fecha, restaurant);
		
		return dao.agregar(menu);
	}
    
    public int agregar(Menu menu) throws Exception{
		if(dao.existeMenu(menu.getNombre())){
			throw new Exception("Error:El menu ya existe");
		}
	
		return dao.agregar(menu);
	}
	
    
	public void modificar(Menu menu) throws Exception{
		if(!dao.existeMenu(menu.getNombre())){
			throw new Exception("Error:El menu no existe");
		}
		
		dao.actualizar(menu);
	}
	
	public void eliminar(int id) throws Exception{
		Menu menu = dao.traerMenu(id);
		
		if(dao.existeMenu(id)){
			dao.eliminar(menu);
		}else{
    		throw new Exception("Error:El menu no existe");
		}	
	}
	
	public void eliminar(String nombre) throws Exception{
		Menu menu = dao.traerMenu(nombre);
		
		if(dao.existeMenu(nombre)){
			dao.eliminar(menu);
		}else{
    		throw new Exception("Error:El menu no existe");
		}	
	}
	
	public List<Menu> traerMenu(){
		return dao.traerMenu();
	}
	
	public List<Menu> traerMenu(GregorianCalendar fecha) throws Exception {
		List<Menu> menues = dao.traerMenu(fecha);
		
		if(menues.size()==0) throw new Exception ("No hay menues");
		
		return dao.traerMenu(fecha);
	}
	
	public boolean agregarComponenteMenu(Menu menu, ComponenteMenu componenteMenu) throws Exception{
		return menu.agregar(componenteMenu);
	}
		
	public boolean eliminarComponenteMenu(Menu menu, ComponenteMenu componenteMenu) throws Exception{
		return menu.eliminar(componenteMenu);
	}
}