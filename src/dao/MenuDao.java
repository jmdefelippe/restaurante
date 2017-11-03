package dao;

import java.util.GregorianCalendar;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Menu;
import datos.TipoUsuario;
import funciones.Funciones;

public class MenuDao {
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
	
	public int agregar(Menu objeto) {
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
	
	public void actualizar(Menu objeto) throws HibernateException {
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
	
	public void eliminar(Menu objeto) throws HibernateException {
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
	
	public Menu traerMenu(int idMenu) throws HibernateException {
		Menu objeto = null;
		try {
			iniciaOperacion();
			objeto = (Menu) session.get(Menu.class, idMenu);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Menu traerMenu(String nombre) throws HibernateException {
		Menu objeto = null;
		try {
			iniciaOperacion();
			objeto = (Menu) session.createQuery("from Menu m where m.nombre=" + nombre).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	//trae los menues vigentes desde fecha en adelante
	@SuppressWarnings("unchecked")
	public List<Menu> traerMenu(GregorianCalendar fecha) throws HibernateException {
		List<Menu> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Menu m where m.fecha >=" + Funciones.traerFechaQuery(fecha) + " order by m.fecha asc").list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Menu> traerMenu() throws HibernateException {
		List<Menu> lista=null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from Menu m order by m.id").list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	public Menu traerMenuYComponentesMenu(int idMenu) throws HibernateException {
		Menu objeto = null ;
		try {
			iniciaOperacion();
			String hql= "from Menu m where m.idMenu =" + idMenu;
			objeto=(Menu) session .createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getComponentesMenu());
		}
		finally {
			session .close();
		}
		return objeto;
	}
	
	public boolean existeMenu(int id) throws HibernateException {

		Menu objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (Menu) session.createQuery("from Menu m where m.idMenu ="+ Integer.toString(id)).uniqueResult();
		} finally {
			session.close();
		}
	
		return objeto!=null;
	}	
	
	
	public boolean existeMenu(String nombre) throws HibernateException {

		Menu objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (Menu) session.createQuery("from Menu m where m.nombre ='"+ nombre+"'").uniqueResult();
		} finally {
			session.close();
		}
	
		return objeto!=null;
	}
	
}