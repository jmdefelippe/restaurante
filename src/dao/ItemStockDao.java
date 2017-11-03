package dao;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.ItemStock;

public class ItemStockDao {
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
	
	public int agregar(ItemStock objeto) {
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
	
	public void actualizar(ItemStock objeto) throws HibernateException {
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
	
	public void eliminar(ItemStock objeto) throws HibernateException {
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
	
	public ItemStock traerItemStock(int idItemStock) throws HibernateException {
		ItemStock objeto = null;
		try {
			iniciaOperacion();
			objeto = (ItemStock) session.get(ItemStock.class, idItemStock);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<ItemStock> traerItemStock() throws HibernateException {
		List<ItemStock> lista=null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from ItemStock i order by i.id").list();
		} finally {
			session.close();
		}
		return lista;
	}

	
	public boolean existeItemStock(int id) throws HibernateException {

		ItemStock objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (ItemStock) session.createQuery("from ItemStock i where i.idItemStock ="+ Integer.toString(id)).uniqueResult();
		} finally {
			session.close();
		}
	
		return objeto!=null;
	}	
	
}