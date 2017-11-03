package dao;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Rubro;

public class RubroDao {
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
	
	public int agregar(Rubro objeto) {
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
	
	public void actualizar(Rubro objeto) throws HibernateException {
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
	
	public void eliminar(Rubro objeto) throws HibernateException {
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
	
	public Rubro traerRubro(int idRubro) throws HibernateException {
		Rubro objeto = null;
		try {
			iniciaOperacion();
			objeto = (Rubro) session.get(Rubro.class, idRubro);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Rubro traerRubro(String nombre) throws HibernateException {
		Rubro objeto = null;
		try {
			iniciaOperacion();
			objeto = (Rubro) session.createQuery("from Rubro r where r.nombre=" + nombre).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Rubro traerRubroYSubrubros(int idRubro) throws HibernateException {
		Rubro objeto = null ;
		try {
			iniciaOperacion();
			String hql= "from Rubro r where r.idRubro =" + idRubro;
			objeto=(Rubro) session .createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getSubrubros());
		}
		finally {
			session .close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Rubro> traerRubro() throws HibernateException {
		List<Rubro> lista=null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from Rubro r order by r.id").list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	public boolean existeRubro(int id) throws HibernateException {

		Rubro objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (Rubro) session.createQuery("from Rubro r where r.idRubro ="+ Integer.toString(id)).uniqueResult();
		} finally {
			session.close();
		}
	
		return objeto!=null;
	}	
	
	
	public boolean existeRubro(String nombre) throws HibernateException {

		Rubro objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (Rubro) session.createQuery("from Rubro r where r.nombre ='"+ nombre +"'").uniqueResult();
		} finally {
			session.close();
		}
	
		return objeto!=null;
	}
	
}