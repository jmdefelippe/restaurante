package dao;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Restaurant;

public class RestaurantDao {
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
	
	public int agregar(Restaurant objeto) {
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
	
	public void actualizar(Restaurant objeto) throws HibernateException {
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
	
	public void eliminar(Restaurant objeto) throws HibernateException {
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
	
	public Restaurant traerRestaurant(int idRestaurant) throws HibernateException {
		Restaurant objeto = null;
		try {
			iniciaOperacion();
			objeto = (Restaurant) session.get(Restaurant.class, idRestaurant);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Restaurant traerRestaurant(String nombre) throws HibernateException {
		Restaurant objeto = null;
		try {
			iniciaOperacion();
			objeto = (Restaurant) session.createQuery("from Restaurant r where r.nombre=" + nombre).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Restaurant traerRestaurantYMenues(int idRestaurant) throws HibernateException {
		Restaurant objeto = null ;
		try {
			iniciaOperacion();
			String hql= "from Restaurant r where r.idRestaurant =" + idRestaurant;
			objeto=(Restaurant) session .createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getMenues());
		}
		finally {
			session .close();
		}
		return objeto;
	}
	
	public Restaurant traerRestaurantYSalones(int idRestaurant) throws HibernateException {
		Restaurant objeto = null ;
		try {
			iniciaOperacion();
			String hql= "from Restaurant r where r.idRestaurant =" + idRestaurant;
			objeto=(Restaurant) session .createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getSalones());
		}
		finally {
			session .close();
		}
		return objeto;
	}
	
	public Restaurant traerRestaurantYTickets(int idRestaurant) throws HibernateException {
		Restaurant objeto = null ;
		try {
			iniciaOperacion();
			String hql= "from Restaurant r where r.idRestaurant =" + idRestaurant;
			objeto=(Restaurant) session .createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getTickets());
		}
		finally {
			session .close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Restaurant> traerRestaurant() throws HibernateException {
		List<Restaurant> lista=null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from Restaurant r order by r.id").list();
		} finally {
			session.close();
		}
		return lista;
	}

	
	public boolean existeRestaurant(int id) throws HibernateException {

		Restaurant objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (Restaurant) session.createQuery("from Restaurant r where r.idRestaurant ="+ Integer.toString(id)).uniqueResult();
		} finally {
			session.close();
		}
	
		return objeto!=null;
	}	
	
	
	public boolean existeRestaurant(String nombre) throws HibernateException {

		Restaurant objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (Restaurant) session.createQuery("from Restaurant r where r.nombre ='"+ nombre+"'").uniqueResult();
		} finally {
			session.close();
		}
	
		return objeto!=null;
	}
	
}