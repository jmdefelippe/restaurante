package dao;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.TipoUsuario;

public class TipoUsuarioDao {
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
	
	public int agregar(TipoUsuario objeto) {
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
	
	public void actualizar(TipoUsuario objeto) throws HibernateException {
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
	
	public void eliminar(TipoUsuario objeto) throws HibernateException {
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
	
	public TipoUsuario traerTipoUsuario(int idTipoUsuario) throws HibernateException {
		TipoUsuario objeto = null;
		try {
			iniciaOperacion();
			objeto = (TipoUsuario) session.get(TipoUsuario.class, idTipoUsuario);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public TipoUsuario traerTipoUsuario(String nombre) throws HibernateException {
		TipoUsuario objeto = null;
		try {
			iniciaOperacion();
			objeto = (TipoUsuario) session.createQuery("from TipoUsuario t where t.nombre=" + nombre).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<TipoUsuario> traerTipoUsuario() throws HibernateException {
		List<TipoUsuario> lista=null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from TipoUsuario t order by t.id").list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	public TipoUsuario traerTipoUsuarioYUsuarios(int idTipoUsuario) throws HibernateException {
		TipoUsuario objeto = null ;
		try {
			iniciaOperacion();
			String hql= "from TipoUsuario t where t.idTipoUsuario =" + idTipoUsuario;
			objeto=(TipoUsuario) session .createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getUsuarios());
		}
		finally {
			session .close();
		}
		return objeto;
	}
	
	public TipoUsuario traerTipoUsuarioYPermisos(int idTipoUsuario) throws HibernateException {
		TipoUsuario objeto = null ;
		try {
			iniciaOperacion();
			String hql= "from TipoUsuario t where t.idTipoUsuario =" + idTipoUsuario;
			objeto=(TipoUsuario) session .createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getPermisos());
		}
		finally {
			session .close();
		}
		return objeto;
	}
	
	public boolean existeTipoUsuario(int id) throws HibernateException {

		TipoUsuario objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (TipoUsuario) session.createQuery("from TipoUsuario t where t.idTipoUsuario ="+ Integer.toString(id)).uniqueResult();
		} finally {
			session.close();
		}
	
		return objeto!=null;
	}	
	
	
	public boolean existeTipoUsuario(String nombre) throws HibernateException {

		TipoUsuario objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (TipoUsuario) session.createQuery("from TipoUsuario t where t.nombre ='"+ nombre+"'").uniqueResult();
		} finally {
			session.close();
		}
	
		return objeto!=null;
	}
	
	

	
}