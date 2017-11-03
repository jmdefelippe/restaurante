package dao;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Permiso;

public class PermisoDao {
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
	
	public int agregar(Permiso objeto) {
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
	
	public void actualizar(Permiso objeto) throws HibernateException {
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
	
	public void eliminar(Permiso objeto) throws HibernateException {
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
	
	public Permiso traerPermiso(int idPermiso) throws HibernateException {
		Permiso objeto = null;
		try {
			iniciaOperacion();
			objeto = (Permiso) session.get(Permiso.class, idPermiso);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Permiso traerPermiso(String accion) throws HibernateException {
		Permiso objeto = null;
		try {
			iniciaOperacion();
			objeto = (Permiso) session.createQuery("from Permiso p where p.accion=" + accion).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Permiso> traerPermiso() throws HibernateException {
		List<Permiso> lista=null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from Permiso p order by p.id").list();
		} finally {
			session.close();
		}
		return lista;
	}

	public Permiso traerPermisoYTiposUsuarios(int idPermiso) throws HibernateException{
		Permiso permiso = null;
		try{
			iniciaOperacion();
			permiso = (Permiso) session.createQuery("from Permiso p where p.idPermiso= "+idPermiso).uniqueResult();
			Hibernate.initialize(permiso.getTiposUsuarios());
		}catch(HibernateException he){
			manejaExcepcion(he);
			throw he;
		}finally{
			session.close();
		}
		return permiso;
	}
	
	public boolean existePermiso(int id) throws HibernateException {

		Permiso objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (Permiso) session.createQuery("from Permiso p where p.idPermiso ="+ Integer.toString(id)).uniqueResult();
		} finally {
			session.close();
		}
	
		return objeto!=null;
	}	
	
	
	public boolean existePermiso(String accion) throws HibernateException {

		Permiso objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (Permiso) session.createQuery("from Permiso p where p.accion='"+ accion +"'").uniqueResult();
		} finally {
			session.close();
		}
	
		return objeto!=null;
	}
	
}