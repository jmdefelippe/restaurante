package dao;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Presentacion;

public class PresentacionDao {
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
	
	public int agregar(Presentacion objeto) {
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
	
	public void actualizar(Presentacion objeto) throws HibernateException {
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
	
	public void eliminar(Presentacion objeto) throws HibernateException {
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
	
	public Presentacion traerPresentacion(int idPresentacion) throws HibernateException {
		Presentacion objeto = null;
		try {
			iniciaOperacion();
			objeto = (Presentacion) session.get(Presentacion.class, idPresentacion);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Presentacion traerPresentacion(String descripcion) throws HibernateException {
		Presentacion objeto = null;
		try {
			iniciaOperacion();
			objeto = (Presentacion) session.createQuery("from Presentacion p where p.descripcion=" + descripcion).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Presentacion> traerPresentacion() throws HibernateException {
		List<Presentacion> lista=null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from Presentacion c order by c.id").list();
		} finally {
			session.close();
		}
		return lista;
	}


	public boolean existePresentacion(int id) throws HibernateException {

		Presentacion objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (Presentacion) session.createQuery("from Presentacion p where p.idPresentacion ="+ Integer.toString(id)).uniqueResult();
		} finally {
			session.close();
		}
	
		return objeto!=null;
	}	
	
	
	public boolean existePresentacion(String descripcion) throws HibernateException {

		Presentacion objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (Presentacion) session.createQuery("from Presentacion p where p.descripcion='"+ descripcion +"'").uniqueResult();
		} finally {
			session.close();
		}
	
		return objeto!=null;
	}
	
}