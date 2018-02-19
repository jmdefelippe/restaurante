package dao;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.ItemListaPrecio;
import datos.ListaPrecio;

public class ItemListaPrecioDao {
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
	
	public int agregar(ItemListaPrecio objeto) {
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
	
	public void actualizar(ItemListaPrecio objeto) throws HibernateException {
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
	
	public void eliminar(ItemListaPrecio objeto) throws HibernateException {
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
	
	public ItemListaPrecio traerItemListaPrecio(int idItemListaPrecio) throws HibernateException {
		ItemListaPrecio objeto = null;
		try {
			iniciaOperacion();
			objeto = (ItemListaPrecio) session.get(ItemListaPrecio.class, idItemListaPrecio);
			Hibernate.initialize(objeto.getComponenteMenu());
		} finally {
			session.close();
		}
		return objeto;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<ItemListaPrecio> traerItemListaPrecio() throws HibernateException {
		List<ItemListaPrecio> lista=null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from ItemListaPrecio i order by i.id").list();
		} finally {
			session.close();
		}
		return lista;
	}

	
	public boolean existeItemListaPrecio(int id) throws HibernateException {

		ItemListaPrecio objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (ItemListaPrecio) session.createQuery("from ItemListaPrecio i where i.idItemListaPrecio ="+ Integer.toString(id)).uniqueResult();
		} finally {
			session.close();
		}
	
		return objeto!=null;
	}
	
	@SuppressWarnings ( "unchecked" )
	public List<ItemListaPrecio> traerItemListaPrecio(ListaPrecio c) throws HibernateException {
		List<ItemListaPrecio> lista= null ;
		try {
			iniciaOperacion();
			String hQL= "from ItemListaPrecio p inner join fetch p.cliente c where c.idListaPrecio=" +c.getIdListaPrecio();
			lista = session .createQuery(hQL).list();
		} finally {
			session .close();
		}
		return lista;
	}
	
}