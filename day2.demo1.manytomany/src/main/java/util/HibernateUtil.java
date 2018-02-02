package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;



public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {

		return sessionFactory=init();
	}

	protected  static SessionFactory init() {

		StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure().build();

		Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();

		return metadata.getSessionFactoryBuilder().build();
	}

}
