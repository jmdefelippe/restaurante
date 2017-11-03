package dao;

import java.util.GregorianCalendar;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Comanda;
import datos.Menu;
import funciones.Funciones;

public class ComandaDao {
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
	
	public int agregar(Comanda objeto) {
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
	
	public void actualizar(Comanda objeto) throws HibernateException {
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
	
	public void eliminar(Comanda objeto) throws HibernateException {
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
	
	public Comanda traerComanda(int idComanda) throws HibernateException {
		Comanda objeto = null;
		try {
			iniciaOperacion();
			objeto = (Comanda) session.get(Comanda.class, idComanda);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Comanda> traerComanda() throws HibernateException {
		List<Comanda> lista=null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from Comanda c order by c.id").list();
		} finally {
			session.close();
		}
		return lista;
	}
	

	@SuppressWarnings("unchecked")
	public List<Comanda> traerComanda(GregorianCalendar fechaHora) throws HibernateException {
		List<Comanda> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Comanda c where c.fechaHora >=" + Funciones.traerFechaQuery(fechaHora) + " order by m.fechaHora asc").list();
		} finally {
			session.close();
		}
		return lista;
		
	}

	
	public boolean existeComanda(int id) throws HibernateException {

		Comanda objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (Comanda) session.createQuery("from Comanda c where c.idComanda ="+ Integer.toString(id)).uniqueResult();
		} finally {
			session.close();
		}
	
		return objeto!=null;
	}	
	
}