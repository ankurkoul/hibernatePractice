package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import pojo.Dept;
import util.HibernateUtil;

public class DeptDAO {
	
	private static SessionFactory sf=HibernateUtil.getSessionFactory();
	
	public void create(Dept dept){
		
		Session session=null;
		Transaction tx=null;
		
		try{
			session=sf.openSession();
			tx=session.getTransaction();
			tx.begin();
			session.save(dept);
			tx.commit();
		}catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
		}finally {
			session.close();
		}
			
		}
	
	
	public List<Dept> list(){
		Session session=null;
		
		try{
			session=sf.openSession();
			Query<Dept> query=session.createQuery("select d from Dept d");
			List<Dept> list=query.list();
			return list;
		}finally {
			session.close();
		}
	}

	
	public void update(Dept dept)	{
		Session session=null;
		Transaction tx=null;
		try{
			session=sf.openSession();
			session.beginTransaction();
			Dept d=session.get(Dept.class,dept.getDeptNo());			
			System.out.println(d);
			d.setDName(dept.getDName());
			d.setLoc(dept.getLoc());
			tx.commit();
		}catch (Exception e) {
			// TODO: handle exception
		tx.rollback();
		}finally {
			session.close();
		}
	}
	
	
	public void delete(Dept dept){
		Session session=null;
		Transaction tx=null;
		try{
			session=sf.openSession();
			tx=session.beginTransaction();
			Dept d=session.get(Dept.class,dept.getDeptNo());	
			if(d!=null){
				
				session.delete(d);
				System.out.println(d);
				
			}
			
			
			
			tx.commit();
		}catch (Exception e) {
			// TODO: handle exception
		tx.rollback();
		}finally {
			session.close();
		}
}
}
