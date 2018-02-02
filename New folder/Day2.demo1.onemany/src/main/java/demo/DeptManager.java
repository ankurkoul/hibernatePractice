package demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import util.HibernateUtil;

public class DeptManager {
	private static SessionFactory sf = HibernateUtil.getSessionfactory();

	public void create(Dept d) {
		Session session = null;
		Transaction tx = null;
		try {
			session = sf.openSession();
			// tx = session.beginTransaction();
			tx = session.getTransaction();
			tx.begin();
			// d - new / transient
			session.save(d);
			// d - attached / persistent
			System.out.println("saved ..." + d);
			tx.commit();
			// d - detached
			System.out.println("commited ..." + d);
		} catch (Exception e) {
			System.out.println("Exception in create " + e);
			tx.rollback();
		} finally {
			session.close();
		}
	}

	public List<Dept> list() {
		Session session = null;
		try {
			session = sf.openSession();
			Query<Dept> query = session.createQuery("select d from Dept d");
			List<Dept> depts = query.list();
			return depts;
		} finally {
			session.close();
		}
	}

	public void update(Dept newdept) {
		Session session = null;
		Transaction tx = null;
		try {
			session = sf.openSession();
			tx = session.beginTransaction();
	//Option 1 
		/*	Dept d= session.get(Dept.class,newdept.getDeptno());
			System.out.println(d);
			d.setDname(newdept.getDname());
			d.setLoc(newdept.getLoc());
		*/
	//Option 2	
		//	session.saveOrUpdate(newdept);
	//Option 3		
			session.update(newdept);
			tx.commit();
		} catch (Exception e) {
			System.out.println("Exception in update " + e);
			tx.rollback();
		} finally {
			session.close();
		}
	}

	public void delete(int deptno) {
		Session session = null;
		Transaction tx = null;
		try {
			session = sf.openSession();
			tx = session.beginTransaction();
			Dept d= session.get(Dept.class,deptno);
			if (d != null)
				session.delete(d);
			tx.commit();
		} catch (Exception e) {
			System.out.println("Exception in update " + e);
			tx.rollback();
		} finally {
			session.close();
		}
	}

}
