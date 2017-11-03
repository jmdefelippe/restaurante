package dao;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.ItemTicket;

public class ItemTicketDao {
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
	
	public int agregar(ItemTicket objeto) {
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
	
	public void actualizar(ItemTicket objeto) throws HibernateException {
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
	
	public void eliminar(ItemTicket objeto) throws HibernateException {
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
	
	public ItemTicket traerItemTicket(int idItemTicket) throws HibernateException {
		ItemTicket objeto = null;
		try {
			iniciaOperacion();
			objeto = (ItemTicket) session.get(ItemTicket.class, idItemTicket);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<ItemTicket> traerItemTicket() throws HibernateException {
		List<ItemTicket> lista=null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from ItemTicket i order by i.id").list();
		} finally {
			session.close();
		}
		return lista;
	}

	
	public boolean existeItemTicket(int id) throws HibernateException {

		ItemTicket objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (ItemTicket) session.createQuery("from ItemTicket i where i.idItemTicket ="+ Integer.toString(id)).uniqueResult();
		} finally {
			session.close();
		}
	
		return objeto!=null;
	}	
	
}