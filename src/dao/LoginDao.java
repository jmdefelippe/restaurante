package dao;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Login;

public class LoginDao {
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
	
	public int agregar(Login objeto) {
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
	
	public void actualizar(Login objeto) throws HibernateException {
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
	
	public void eliminar(Login objeto) throws HibernateException {
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
	
	public Login traerLogin(int idLogin) throws HibernateException {
		Login objeto = null;
		try {
			iniciaOperacion();
			objeto = (Login) session.get(Login.class, idLogin);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Login traerLogin(String nick, String clave) throws HibernateException {
		Login objeto = null;
		try {
			iniciaOperacion();
			
			String hql="from Login l where l.nick= '" + nick + "' and l.clave= '" + clave + "'" ;
			objeto = (Login)session.createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getUsuario().getTipoUsuario());
			
//			objeto=(Login) session.createQuery(hql).setParameter("nick", (String)nick).uniqueResult();
//			objeto=(Login) session.createQuery(hql).setParameter("clave", (String)clave).uniqueResult();
	
		}catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;	
		} finally {
			session.close();
		}
		return objeto;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Login> traerLogin() throws HibernateException {
		List<Login> lista=null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from Login l order by l.id").list();
		} finally {
			session.close();
		}
		return lista;
	}


	public Login traerLoginYUsuario(int idLogin) throws HibernateException {
		Login objeto = null ;
		try {
			iniciaOperacion();
			String hql= "from Login l inner join fetch l.usuario where l.idLogin =" + idLogin;
			objeto = (Login) session .createQuery(hql).uniqueResult();
		} finally {
			session .close();
		}
		return objeto;
		}

	
	public boolean existeLogin(int id) throws HibernateException {

		Login objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (Login) session.createQuery("from Login l where l.idLogin ="+ Integer.toString(id)).uniqueResult();
		} finally {
			session.close();
		}
	
		return objeto!=null;
	}	
	
	
	public boolean existeLogin(String nick, String clave) throws HibernateException {

		Login objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (Login) session.createQuery("from Login l where l.nombre ='"+ nick+"' and l.clave ='"+ clave+"'").uniqueResult();
		} finally {
			session.close();
		}
	
		return objeto!=null;
	}
	
	
	
}