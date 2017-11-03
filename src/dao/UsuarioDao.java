package dao;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Usuario;

public class UsuarioDao {
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
	
	public int agregar(Usuario objeto) {
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
	
	public void actualizar(Usuario objeto) throws HibernateException {
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
	
	public void eliminar(Usuario objeto) throws HibernateException {
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
	
	public Usuario traerUsuario(int idUsuario) throws HibernateException {
		Usuario objeto = null;
		try {
			iniciaOperacion();
			objeto = (Usuario) session.get(Usuario.class, idUsuario);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Usuario traerUsuario(long dni) throws HibernateException {
		Usuario objeto = null;
		try {
			iniciaOperacion();
			objeto = (Usuario) session.createQuery("from Usuario c where c.dni=" + Long.toString(dni)).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> traerUsuario() throws HibernateException {
		List<Usuario> lista=null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from Usuario c order by c.id").list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	public Usuario traerUsuarioYTickets(int idUsuario) throws HibernateException {
		Usuario objeto = null ;
		try {
			iniciaOperacion();
			String hql= "from Usuario c where c.idUsuario =" + idUsuario;
			objeto=(Usuario) session .createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getTickets());
		}
		finally {
			session .close();
		}
		return objeto;
	}
	
	public boolean existeUsuario(int id) throws HibernateException {

		Usuario objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (Usuario) session.createQuery("from Usuario u where u.idUsuario ="+ Integer.toString(id)).uniqueResult();
		} finally {
			session.close();
		}
	
		return objeto!=null;
	}	
	
	
	public boolean existeUsuario(long dni) throws HibernateException {

		Usuario objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (Usuario) session.createQuery("from Usuario u where u.dni ="+ Long.toString(dni)).uniqueResult();
		} finally {
			session.close();
		}
	
		return objeto!=null;
	}
	
}