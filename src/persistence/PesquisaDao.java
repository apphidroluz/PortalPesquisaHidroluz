package persistence;



import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import config.HibernateUtil;
import entity.Pesquisa;

public class PesquisaDao {

	Session session;
	Transaction transaction;
	Query query;
	Criteria criteria;

	public void create(Pesquisa p) {

		try {

			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			session.save(p);

			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			HibernateUtil.fechar_conexao(session);

		}
	}

	public static void main(String[] args) {

	}

}
