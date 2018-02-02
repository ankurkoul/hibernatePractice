package tester;
import dao.DeptDAO;
import pojo.Dept;

public class DeptClient {

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
