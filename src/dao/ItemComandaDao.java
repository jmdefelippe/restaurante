package dao;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cliente;
import datos.Comanda;
import datos.ItemComanda;

public class ItemComandaDao {
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
	
	public int agregar(ItemComanda objeto) {
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
	
	public void actualizar(ItemComanda objeto) throws HibernateException {
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
	
	public void eliminar(ItemComanda objeto) throws HibernateException {
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
	
	public ItemComanda traerItemComanda(int idItemComanda) throws HibernateException {
		ItemComanda objeto = null;
		try {
			iniciaOperacion();
			objeto = (ItemComanda) session.get(ItemComanda.class, idItemComanda);
			Hibernate.initialize(objeto.getComponenteMenu());
		} finally {
			session.close();
		}
		return objeto;
	}
	
//------------------------------ Traigo Items Comanda de una Comanda especifica ------------
	
	public ItemComanda traerItemComanda(Comanda comanda) throws HibernateException {
		ItemComanda objeto = null;
		try {
			iniciaOperacion();
			objeto = (ItemComanda) session.createQuery("from ItemComanda ic where ic.idComanda=" + Integer.toString(comanda.getIdComanda())).uniqueResult();
			Hibernate.initialize(objeto.getComponenteMenu());
		} finally {
			session.close();
		}
		return objeto;
	}
	
//--------------------------------------------------------------------------------
	@SuppressWarnings("unchecked")
	public List<ItemComanda> traerItemComanda() throws HibernateException {
		List<ItemComanda> lista=null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from ItemComanda i order by i.id").list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	public List<ItemComanda> traerItemComandaPorComanda(int id) throws HibernateException {
		List<ItemComanda> lista=null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from ItemComanda where idComanda="+Integer.toString(id)).list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	
	public List<ItemComanda> traerItemsComandaPorComandaConComponente(int id) throws HibernateException {
		List<ItemComanda> lista= null ;
		try {
		iniciaOperacion();
		String hQL= "from ItemComanda as ic inner join fetch ic.componenteMenu where idComanda = " + Integer.toString(id);
		lista = session .createQuery(hQL).list();
		} finally {
		session .close();
		}
		return lista;
		}
		

	
	public boolean existeItemComanda(int id) throws HibernateException {

		ItemComanda objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (ItemComanda) session.createQuery("from ItemComanda i where i.idItemComanda ="+ Integer.toString(id)).uniqueResult();
		} finally {
			session.close();
		}
	
		return objeto!=null;
	}	
	
}