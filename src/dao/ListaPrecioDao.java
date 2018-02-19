package dao;

import java.util.GregorianCalendar;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.ListaPrecio;
import datos.Menu;
import funciones.Funciones;

public class ListaPrecioDao {
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
	
	public int agregar(ListaPrecio objeto) {
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
	
	public void actualizar(ListaPrecio objeto) throws HibernateException {
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
	
	public void eliminar(ListaPrecio objeto) throws HibernateException {
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
	
	public ListaPrecio traerListaPrecio(int idListaPrecio) throws HibernateException {
		ListaPrecio objeto = null;
		try {
			iniciaOperacion();
			objeto = (ListaPrecio) session.get(ListaPrecio.class, idListaPrecio);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public ListaPrecio traerListaPrecioEItems(int idListaPrecio) throws HibernateException {
		ListaPrecio objeto = null;
		try {
			iniciaOperacion();
			objeto = (ListaPrecio) session.get(ListaPrecio.class, idListaPrecio);
			Hibernate.initialize(objeto.getItemsListaPrecio());
		} finally {
			session.close();
		}
		return objeto;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<ListaPrecio> traerListaPrecio() throws HibernateException {
		List<ListaPrecio> lista=null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from ListaPrecio l order by l.id").list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<ListaPrecio> traerListaPrecio(GregorianCalendar fechaDesde, GregorianCalendar fechaHasta){
		List<ListaPrecio> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from ListaPrecio l where l.fecha >=" + Funciones.traerFechaQuery(fechaDesde) + " and l.fecha <="+ Funciones.traerFechaQuery(fechaHasta) + " order by l.fecha asc").list();
		} finally {
			session.close();
		}
		return lista;
		
	}

	
	public boolean existeListaPrecio(int id) throws HibernateException {

		ListaPrecio objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (ListaPrecio) session.createQuery("from ListaPrecio l where l.idListaPrecio ="+ Integer.toString(id)).uniqueResult();
		} finally {
			session.close();
		}
	
		return objeto!=null;
	}
	
	public ListaPrecio traerListaPrecioEItemsListaPrecio(int idListaPrecio) throws HibernateException {
		ListaPrecio objeto = null ;
		try {
			iniciaOperacion();
			String hql= "from ListaPrecio l where l.idListaPrecio =" + idListaPrecio;
			objeto=(ListaPrecio) session .createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getItemsListaPrecio());
		}
		finally {
			session .close();
		}
		return objeto;
	}
	
	
}