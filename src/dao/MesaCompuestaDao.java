package dao;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.MesaCompuesta;

public class MesaCompuestaDao {
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
	
	public int agregar(MesaCompuesta objeto) {
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
	
	public void actualizar(MesaCompuesta objeto) throws HibernateException {
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
	
	public void eliminar(MesaCompuesta objeto) throws HibernateException {
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
	
	public MesaCompuesta traerMesaCompuesta(int idMesaCompuesta) throws HibernateException {
		MesaCompuesta objeto = null;
		try {
			iniciaOperacion();
			objeto = (MesaCompuesta) session.get(MesaCompuesta.class, idMesaCompuesta);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<MesaCompuesta> traerMesaCompuesta() throws HibernateException {
		List<MesaCompuesta> lista=null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from MesaCompuesta m order by m.id").list();
		} finally {
			session.close();
		}
		return lista;
	}

	
	public boolean existeMesaCompuesta(int id) throws HibernateException {

		MesaCompuesta objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (MesaCompuesta) session.createQuery("from MesaCompuesta m where m.idMesaCompuesta ="+ Integer.toString(id)).uniqueResult();
		} finally {
			session.close();
		}
	
		return objeto!=null;
	}	
	
	
}