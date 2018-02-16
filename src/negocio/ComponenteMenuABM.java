package negocio;

import java.util.List;

import dao.ComponenteMenuDao;
import datos.ComponenteMenu;
import datos.Menu;
import datos.Subrubro;
import datos.TipoUsuario;

public class ComponenteMenuABM {

	ComponenteMenuDao dao = new ComponenteMenuDao();

	
	public ComponenteMenu traerComponenteMenu(int idComponenteMenu) throws Exception{
		ComponenteMenu componenteMenu = dao.traerComponenteMenu(idComponenteMenu);
			
    	if (componenteMenu.equals(null))
    		throw new Exception("Error:El componenteMenu no existe");
		
		return componenteMenu;
	}
	
	
	public ComponenteMenu traerComponenteMenu(String nombre) throws Exception{
		ComponenteMenu componenteMenu = dao.traerComponenteMenu(nombre);
		
		if (componenteMenu.equals(null))
    		throw new Exception("Error:El componenteMenu no existe");
		
		return componenteMenu;
	}


	
    public int agregar(String nombre, String descripcion, String imagen, String disponibilidad, boolean estado, Subrubro subrubro) throws Exception{
		if(dao.existeComponenteMenu(nombre)){
			throw new Exception("Error:El componenteMenu ya existe");
		}
		
		ComponenteMenu componenteMenu = new ComponenteMenu(nombre, descripcion, imagen, disponibilidad, estado, subrubro);
		
		return dao.agregar(componenteMenu);
	}
    
	
    public int agregar(ComponenteMenu componenteMenu) throws Exception{
		if(dao.existeComponenteMenu(componenteMenu.getNombre())){
			throw new Exception("Error:El componenteMenu ya existe");
		}
	
		return dao.agregar(componenteMenu);
	}
	
    
	public void modificar(ComponenteMenu componenteMenu) throws Exception{
		if(!dao.existeComponenteMenu(componenteMenu.getNombre())){
			throw new Exception("Error:El componenteMenu no existe");
		}
		
		dao.actualizar(componenteMenu);
	}
	
	public void eliminar(int id) throws Exception{
		ComponenteMenu componenteMenu = dao.traerComponenteMenu(id);
		
		if(dao.existeComponenteMenu(id)){
			dao.eliminar(componenteMenu);
		}else{
    		throw new Exception("Error:El componenteMenu no existe");
		}	
	}
	
	public void eliminar(String nombre) throws Exception{
		ComponenteMenu componenteMenu = dao.traerComponenteMenu(nombre);
		
		if(dao.existeComponenteMenu(nombre)){
			dao.eliminar(componenteMenu);
		}else{
    		throw new Exception("Error:El componenteMenu no existe");
		}	
	}
	
	public List<ComponenteMenu> traerComponenteMenu(){
		return dao.traerComponenteMenu();
	}
	
	public boolean agregarMenu(ComponenteMenu componenteMenu, Menu menu) throws Exception{
		return componenteMenu.agregar(menu);
	}
		
	public boolean eliminarMenu(ComponenteMenu componenteMenu, Menu menu)throws Exception{
		return componenteMenu.eliminar(menu);
	}

}