package demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="EmpTable")
public class Emp {
	@Id
	@Column(name="empnoCol")
	private int empno;
	@Column(name="enameCol")
	private String ename;
	@Column(name="SalaryCol")
	private double salary;
		
	@ManyToOne()
	@JoinColumn(name="deptnoC")
	private Dept department;
	
	
	
	public Emp(){}
	public Emp(int empno, String ename, double salary) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.salary = salary;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", salary=" + salary + "]";
	}
	public Dept getDepartment() {
		return department;
	}
	public void setDepartment(Dept department) {
		this.department = department;
	}
	
	
}
