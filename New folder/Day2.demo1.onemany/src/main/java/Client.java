import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import demo.Dept;
import demo.Emp;
import util.HibernateUtil;

public class Client {
	
	public static void list() {
		Session session = null;
		try {
			session =HibernateUtil.getSessionfactory().openSession();
//			Query<Dept> query = session.createQuery("select d from Dept d");
//			List<Dept> depts = query.list();
			Query<Dept> query1 = session.createQuery("select d from Dept d");
			query1.list();
			Query<Emp> query = session.createQuery("select e from Emp e");
			List<Emp> depts = query.list();
			
			depts.forEach(System.out::println);
		} finally {
			session.close();
		}
		
	}
	public static void create() {
		Session session = null;
		Transaction tx = null;
		try {
			Dept dept = new Dept(30,"Training","Pnq");
			Dept d = new Dept(40,"F&T","Hyd");
			Emp e1= new Emp(6, "FFF", 6000);
			e1.setDepartment(d);
			
	//		d.getEmps().add(e1);
	//		d.getEmps().add(e2);
			session = HibernateUtil.getSessionfactory().openSession();
			tx = session.beginTransaction();
			session.save(d);
			session.save(dept);
			session.save(e1);
			
			tx.commit();
		} catch (Exception e) {
			System.out.println("Exception in create " + e);
			tx.rollback();
		} finally {
			session.close();
		}
	}
	
	public static  void update() {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionfactory().openSession();
			tx = session.beginTransaction();
			Emp e= session.get(Emp.class,2);
		    System.out.println("Emp = "+ e + e.getDepartment());
			tx.commit();
		} catch (Exception e) {
			System.out.println("Exception in update " + e);
			tx.rollback();
		} finally {
			session.close();
		}
	}
	
	
	public static void main(String[] args) {
		HibernateUtil.getSessionfactory();
	//	create();
	//	list();
		update();
		
		
		HibernateUtil.getSessionfactory().close();
	}

}
