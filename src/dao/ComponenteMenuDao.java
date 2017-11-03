package dao;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.ComponenteMenu;
import datos.Permiso;

public class ComponenteMenuDao {
		private static Session session;
	private Transaction tx;
	
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	public int agregar(ComponenteMenu objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}
	
	public void actualizar(ComponenteMenu objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	public void eliminar(ComponenteMenu objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	public ComponenteMenu traerComponenteMenu(int idComponenteMenu) throws HibernateException {
		ComponenteMenu objeto = null;
		try {
			iniciaOperacion();
			objeto = (ComponenteMenu) session.get(ComponenteMenu.class, idComponenteMenu);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public ComponenteMenu traerComponenteMenu(String nombre) throws HibernateException {
		ComponenteMenu objeto = null;
		try {
			iniciaOperacion();
			objeto = (ComponenteMenu) session.createQuery("from ComponenteMenu c where c.nombre=" + nombre).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<ComponenteMenu> traerComponenteMenu() throws HibernateException {
		List<ComponenteMenu> lista=null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from ComponenteMenu c order by c.id").list();
		} finally {
			session.close();
		}
		return lista;
	}

	public ComponenteMenu traerComponenteMenuYMenues(int idComponenteMenu) throws HibernateException{
		ComponenteMenu componenteMenu = null;
		try{
			iniciaOperacion();
			componenteMenu = (ComponenteMenu) session.createQuery("from ComponenteMenu c where c.idComponenteMenu= "+idComponenteMenu).uniqueResult();
			Hibernate.initialize(componenteMenu.getMenues());
		}catch(HibernateException he){
			manejaExcepcion(he);
			throw he;
		}finally{
			session.close();
		}
		return componenteMenu;
	}
	
	public boolean existeComponenteMenu(int id) throws HibernateException {

		ComponenteMenu objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (ComponenteMenu) session.createQuery("from ComponenteMenu c where c.idComponenteMenu ="+ Integer.toString(id)).uniqueResult();
		} finally {
			session.close();
		}
	
		return objeto!=null;
	}	
	
	
	public boolean existeComponenteMenu(String nombre) throws HibernateException {

		ComponenteMenu objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (ComponenteMenu) session.createQuery("from ComponenteMenu c where c.nombre ='"+ nombre+"'").uniqueResult();
		} finally {
			session.close();
		}
	
		return objeto!=null;
	}
	
}