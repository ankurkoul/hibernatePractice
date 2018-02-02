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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="EmpTable")
public class Emp {
	@Id
	@GeneratedValue(generator="mygen",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="mygen",sequenceName="myseq",allocationSize=10, initialValue=30)
	@Column(name="empnoCol")
	private int empno;
	@Column(name="enameCol")
	private String ename;
	
	private double salary;
	//@Transient
//	private String[] email;
	//@OneToMany()
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="emp_emails", joinColumns=@JoinColumn(name="empnoCol"))
	@Column(name="email")
	private List<String> email= new ArrayList<>();
	
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
	public List<String> getEmail() {
		return email;
	}
	public void setEmail(List<String> email) {
		this.email = email;
	}
	
}
