import org.hibernate.SessionFactory;

import demo.Dept;
import demo.DeptManager;
import util.HibernateUtil;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			DeptManager mgr = new DeptManager();
		
			Dept d= new Dept(10,"HR","Hyd");
			mgr.create(d);
			Dept d1= new Dept(20,"IT","Pune");
			mgr.create(d1);
			Dept d2= new Dept(30,"Fin","Blr");
			mgr.create(d2);
			mgr.list().forEach(System.out::println);
			System.out.println("------------------------------------------------------");
			Dept dept= new Dept(20,"Training","NEWDELHI");
			mgr.update(dept);
			mgr.delete(200);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			HibernateUtil.getSessionfactory().close();	
		}
		
	}

}
