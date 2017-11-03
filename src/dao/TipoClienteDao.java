package dao;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Restaurant;
import datos.TipoCliente;

public class TipoClienteDao {
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
	
	public int agregar(TipoCliente objeto) {
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
	
	public void actualizar(TipoCliente objeto) throws HibernateException {
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
	
	public void eliminar(TipoCliente objeto) throws HibernateException {
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
	
	public TipoCliente traerTipoCliente(int idTipoCliente) throws HibernateException {
		TipoCliente objeto = null;
		try {
			iniciaOperacion();
			objeto = (TipoCliente) session.get(TipoCliente.class, idTipoCliente);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public TipoCliente traerTipoCliente(String nombre) throws HibernateException {
		TipoCliente objeto = null;
		try {
			iniciaOperacion();
			objeto = (TipoCliente) session.createQuery("from TipoCliente t where t.nombre=" + nombre).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	@SuppressWarnings("unchecked")
	public List<TipoCliente> traerTipoCliente() throws HibernateException {
		List<TipoCliente> lista=null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from TipoCliente t order by t.id").list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	public TipoCliente traerTipoClienteYClientes(int idTipoCliente) throws HibernateException {
		TipoCliente objeto = null ;
		try {
			iniciaOperacion();
			String hql= "from TipoCliente t where t.idTipoCliente =" + idTipoCliente;
			objeto=(TipoCliente) session .createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getClientes());
		}
		finally {
			session .close();
		}
		return objeto;
	}
	
	public boolean existeTipoCliente(int id) throws HibernateException {

		TipoCliente objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (TipoCliente) session.createQuery("from TipoCliente t where t.idTipoCliente ="+ Integer.toString(id)).uniqueResult();
		} finally {
			session.close();
		}
	
		return objeto!=null;
	}	
	
	
	public boolean existeTipoCliente(String nombre) throws HibernateException {

		TipoCliente objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (TipoCliente) session.createQuery("from TipoCliente t where t.nombre ='"+ nombre+"'").uniqueResult();
		} finally {
			session.close();
		}
	
		return objeto!=null;
	}
	
}