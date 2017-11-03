package dao;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Salon;

public class SalonDao {
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
	
	public int agregar(Salon objeto) {
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
	
	public void actualizar(Salon objeto) throws HibernateException {
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
	
	public void eliminar(Salon objeto) throws HibernateException {
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
	
	public Salon traerSalon(int idSalon) throws HibernateException {
		Salon objeto = null;
		try {
			iniciaOperacion();
			objeto = (Salon) session.get(Salon.class, idSalon);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Salon traerSalon(String descripcion) throws HibernateException {
		Salon objeto = null;
		try {
			iniciaOperacion();
			objeto = (Salon) session.createQuery("from Salon s where s.descripcion=" + descripcion).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Salon> traerSalon() throws HibernateException {
		List<Salon> lista=null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from Salon s order by s.id").list();
		} finally {
			session.close();
		}
		return lista;
	}


	public boolean existeSalon(int id) throws HibernateException {

		Salon objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (Salon) session.createQuery("from Salon s where s.idSalon ="+ Integer.toString(id)).uniqueResult();
		} finally {
			session.close();
		}
	
		return objeto!=null;
	}	
	
	
	public boolean existeSalon(String descripcion) throws HibernateException {

		Salon objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (Salon) session.createQuery("from Salon s where s.descripcion ='"+ descripcion +"'").uniqueResult();
		} finally {
			session.close();
		}
	
		return objeto!=null;
	}
	
}