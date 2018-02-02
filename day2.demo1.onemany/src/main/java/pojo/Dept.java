package pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="departmentTable")
public class Dept {

	@Id
	@Column(name="deptID")
	private int deptNo;
	@Column(name="deptName",length=20)
	private String dName;
	private String loc;
	@OneToMany(mappedBy="dept")
//@JoinColumn(name="deptFk")
	Set<Employee>emps=new HashSet<>();
	public int getDeptNo() {
		return deptNo;
	}

	public String getDName() {
		return dName;
	}

	
	public Dept() {
		super();
	
	}

	public String getLoc() {
		return loc;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public void setDName(String dName) {
		this.dName = dName;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public Dept(int deptNo, String dName, String loc) {
		super();
		this.deptNo = deptNo;
		this.dName = dName;
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "Dept [deptNo=" + deptNo + ", dName=" + dName + ", loc=" + loc + "]";
	}

	public String getdName() {
		return dName;
	}

	public Set<Employee> getEmps() {
		return emps;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public void setEmps(Set<Employee> emps) {
		this.emps = emps;
	}

	
	
	
	
}
