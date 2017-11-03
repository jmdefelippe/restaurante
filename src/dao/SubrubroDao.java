package dao;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Subrubro;

public class SubrubroDao {
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
	
	public int agregar(Subrubro objeto) {
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
	
	public void actualizar(Subrubro objeto) throws HibernateException {
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
	
	public void eliminar(Subrubro objeto) throws HibernateException {
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
	
	public Subrubro traerSubrubro(int idSubrubro) throws HibernateException {
		Subrubro objeto = null;
		try {
			iniciaOperacion();
			objeto = (Subrubro) session.get(Subrubro.class, idSubrubro);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Subrubro traerSubrubro(String nombre) throws HibernateException {
		Subrubro objeto = null;
		try {
			iniciaOperacion();
			objeto = (Subrubro) session.createQuery("from Subrubro s where s.nombre=" + nombre).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Subrubro> traerSubrubro() throws HibernateException {
		List<Subrubro> lista=null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from Subrubro s order by s.id").list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	public Subrubro traerSubrubroYComponentesMenu(int idSubrubro) throws HibernateException {
		Subrubro objeto = null ;
		try {
			iniciaOperacion();
			String hql= "from Subrubro s where s.idSubrubro =" + idSubrubro;
			objeto=(Subrubro) session .createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getComponentesMenu());
		}
		finally {
			session .close();
		}
		return objeto;
	}
	
	public boolean existeSubrubro(int id) throws HibernateException {

		Subrubro objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (Subrubro) session.createQuery("from Subrubro s where s.idSubrubro ="+ Integer.toString(id)).uniqueResult();
		} finally {
			session.close();
		}
	
		return objeto!=null;
	}	
	
	
	public boolean existeSubrubro(String nombre) throws HibernateException {

		Subrubro objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (Subrubro) session.createQuery("from Subrubro s where s.nombre ='"+ nombre+"'").uniqueResult();
		} finally {
			session.close();
		}
	
		return objeto!=null;
	}
	
}