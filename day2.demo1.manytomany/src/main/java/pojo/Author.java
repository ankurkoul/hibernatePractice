package pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Author {
	@Id
	private int authId;
	private String name;

	@ManyToMany(mappedBy="authors")
	private Set<Book> books = new HashSet<>();
	
	public Author() {
		super();
		
	}

	public int getAuthId() {
		return authId;
	}

	public String getName() {
		return name;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setAuthId(int authId) {
		this.authId = authId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Author [authId=" + authId + ", name=" + name + ", books=" + books + "]";
	}

	public Author(int authId, String name) {
		super();
		this.authId = authId;
		this.name = name;
	}
	
	
}
