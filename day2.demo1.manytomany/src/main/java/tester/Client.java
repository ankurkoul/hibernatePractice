package tester;

import dao.CombineDAO;
import util.HibernateUtil;

public class Client {
	public static void main(String[] args) {
		HibernateUtil.getSessionFactory();
		CombineDAO.create();
		//CombineDAO.list();
	//	CombineDAO.list2();
//	HibernateUtil.getSessionFactory().close();
	}

}
