package tester;

import java.util.ArrayList;

import dao.EmployeeDAO;
import pojo.Employee;

public class EmployeeClient {

	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAO();
		ArrayList<String> list=new ArrayList<String>();
	/*	list.add("a@gmail.com");
	Employee employee=new Employee( "a", 100.05D, list);
		dao.create(employee);
		list.add("abc...@gmail.com");
		Employee employee2=new Employee( "b", 250.05D, list);
		dao.create(employee2);
		list.add("xyz...@gmail.com");
		Employee employee3=new Employee( "c", 50.05D, list);
		dao.create(employee3);
	//	dao.list().forEach(item->System.out.println(item));
*/		
	//	dao.listMinMax(10, 200).forEach(item->System.out.println(item));
		//dao.delete(employee2);
	//	dao.list().forEach(item->System.out.println(item));
	}
}
