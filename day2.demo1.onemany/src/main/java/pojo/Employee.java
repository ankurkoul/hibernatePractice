package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="EmployeeTable")
public class Employee {
	@Id	
	private int empNo;

	private String eName;
	@Column(name="salary")
	private double salary;
@ManyToOne
@JoinColumn(name="deptFk")
	private Dept dept;
	public int getEmpNo() {
		return empNo;
	}

	public String geteName() {
		return eName;
	}  

	public double getSalary() {
		return salary;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Employee(int empNo, String eName, double salary) {
		super();
		this.empNo = empNo;
		this.eName = eName;
		this.salary = salary;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	
}
