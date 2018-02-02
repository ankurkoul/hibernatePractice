package pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Book {
	@Id
	private int bkno;
	private String bkName;
	private String publisher;
	@ManyToMany
	private Set<Author> authors = new HashSet<>();
	
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int bkno, String bkName, String publisher) {
		super();
		this.bkno = bkno;
		this.bkName = bkName;
		this.publisher = publisher;
	}
	public Book(int bkno, String bkName, String publisher, Set<Author> authors) {
		super();
		this.bkno = bkno;
		this.bkName = bkName;
		this.publisher = publisher;
		this.authors = authors;
	}
	
	public int getBkno() {
		return bkno;
	}
	public String getBkName() {
		return bkName;
	}
	public String getPublisher() {
		return publisher;
	}
	public Set<Author> getAuthors() {
		return authors;
	}
	public void setBkno(int bkno) {
		this.bkno = bkno;
	}
	public void setBkName(String bkName) {
		this.bkName = bkName;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	@Override
	public String toString() {
		return "Book [bkno=" + bkno + ", bkName=" + bkName + ", publisher=" + publisher + ", authors=" + authors + "]";
	}
	
	

}
