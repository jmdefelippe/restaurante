package dao;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.ComponenteMenu;

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
			Hibernate.initialize(objeto.getSubrubro());
			Hibernate.initialize(objeto.getSubrubro().getRubro());
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public ComponenteMenu traerComponenteMenu(String nombre) throws HibernateException {
		ComponenteMenu objeto = null;
		try {
			iniciaOperacion();
			
			String hql="from ComponenteMenu l where l.nombre=:nombre";
			objeto=(ComponenteMenu) session.createQuery(hql).setParameter("nombre", (String)nombre).uniqueResult();
	
		}catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;	
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
			lista=session.createQuery("from ComponenteMenu l order by l.id").list();
		} finally {
			session.close();
		}
		return lista;
	}

	
	public boolean existeComponenteMenu(int id) throws HibernateException {

		ComponenteMenu objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (ComponenteMenu) session.createQuery("from ComponenteMenu l where l.idComponenteMenu ="+ Integer.toString(id)).uniqueResult();
		} finally {
			session.close();
		}
	
		return objeto!=null;
	}	
	
	
	public boolean existeComponenteMenu(String nombre) throws HibernateException {

		ComponenteMenu objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (ComponenteMenu) session.createQuery("from ComponenteMenu l where l.nombre ='"+ nombre+"'").uniqueResult();
		} finally {
			session.close();
		}
	
		return objeto!=null;
	}
	
}