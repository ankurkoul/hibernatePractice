package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import pojo.Author;
import pojo.Book;
import util.HibernateUtil;

public class CombineDAO {
	
	private static SessionFactory sf = HibernateUtil.getSessionFactory();

	private static Session session = null;
	private static Transaction tx = null;

	public static void create() {

		Book book1=new Book(1, "aaaaaa", "publisher1");
		Book book2=new Book(2, "bbbbb", "publisher2");
		Book book3=new Book(3, "ccccc", "publisher3");
		
		
		
		Author author1=new Author(1, "Author1");
		Author author2=new Author(2, "Author2");
		Author author3=new Author(3, "Author3");
		
		/*
		 * since author is slave with mappedby hence no updation power
		 */
		author1.getBooks().add(book1);
		/*
		 * book is master therfore updation power
		 */
		book1.getAuthors().add(author1);
	

		try {
			session = sf.openSession();
			tx = session.beginTransaction();
		
			session.save(book1);
			session.save(book2);
			session.save(book3);
			session.save(author1);
			session.save(author2);
			session.save(author3);
		

			tx.commit();
		} catch (Exception exception) {

		} finally {
			session.close();
		}
	}
}
