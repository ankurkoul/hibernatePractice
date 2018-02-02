package demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import util.HibernateUtil;

public class EmpManager {
	private static SessionFactory sf = HibernateUtil.getSessionfactory();

	public void create(Emp d) {
		Session session = null;
		Transaction tx = null;
		try {
			session = sf.openSession();
			tx = session.getTransaction();
			tx.begin();
			session.save(d);
			tx.commit();
					} catch (Exception e) {
			System.out.println("Exception in create " + e);
			tx.rollback();
		} finally {
			session.close();
		}
	}

	public List<Emp> list() {
		Session session = null;
		try {
			session = sf.openSession();
			Query<Emp> query = session.createQuery("select e  from Emp e");
			//1 -> n rows 
			List<Emp> emps = query.list();
		//	emps.forEach(e->System.out.println(e  + ", number of emails = " + e.getEmail().size()));
			// e.getEmail() - fire a query per row
			return emps;
		} finally {
			session.close();
		}
	}
	public List<Emp> list1(double min, double max) {
		Session session = null;
		try {
			session = sf.openSession();
	//		session.createQuery("select e  from Emp e where e.salary between ? and ?");
			Query<Emp> query = 
			session.createQuery("select e  from Emp e where e.salary > :minparam and e.salary < :maxparam");
			query.setParameter("minparam",min);
			query.setParameter("maxparam",max);
			List<Emp> Emps = query.list();
			return Emps;
		} finally {
			session.close();
		}
	}
	public List<Emp> list2(String nm) {
		Session session = null;
		try {
			session = sf.openSession();
			Query<Emp> query = 
			session.createQuery("select e  from Emp e where e.ename =?");
		//	session.createQuery("from Emp  where eName =?");
			query.setParameter(0,nm);
			List<Emp> Emps = query.list();
			return Emps;
		} finally {
			session.close();
		}
	}
	

	public void update(Emp newEmp) {
		Session session = null;
		Transaction tx = null;
		try {
			session = sf.openSession();
			tx = session.beginTransaction();
			session.update(newEmp);
			tx.commit();
		} catch (Exception e) {
			System.out.println("Exception in update " + e);
			tx.rollback();
		} finally {
			session.close();
		}
	}

	public void delete(int Empno) {
		Session session = null;
		Transaction tx = null;
		try {
			session = sf.openSession();
			tx = session.beginTransaction();
			Emp d= session.get(Emp.class,Empno);
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
