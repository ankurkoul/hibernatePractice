import org.hibernate.SessionFactory;

import day1.util.HibernateUtil;
import demo.Dept;
import demo.DeptDAO;

public class Client {

	public static void main(String[] args) {
		DeptDAO dao = new DeptDAO();
		Dept dept = new Dept(1, "HR", "pune");
		dao.create(dept);

		Dept dept2 = new Dept(2, "IT", "BGLR");

		dao.create(dept2);
		
		dao.list().forEach(item->System.out.println(item));
		dao.delete(dept2);
		dao.list().forEach(item->System.out.println(item));
	}
}
