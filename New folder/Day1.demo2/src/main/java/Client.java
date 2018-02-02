
import demo.Emp;
import demo.EmpManager;
import util.HibernateUtil;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			EmpManager mgr = new EmpManager();
	/*		for (int i = 0; i < 50; i++) {
				Emp e = new Emp();
				e.setEmpno(i+1100);
				e.setEname("Name" + i);
				e.setSalary(i*100);
				e.getEmail().add(e.getEname()+"@gmail.com");
				e.getEmail().add(e.getEname()+"@syne.com");
				mgr.create(e);
			}*/

		//	mgr.list().forEach(e->System.out.println(e  + ", number of emails = " + e.getEmail().size()));
			mgr.list2("Name10").forEach(System.out::println);
			mgr.list1(4000,4500).forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		 HibernateUtil.getSessionfactory().close();
		}

	}

}
