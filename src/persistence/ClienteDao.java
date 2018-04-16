package persistence;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import config.HibernateUtil;
import entity.Clientes;

/*
 * Classe que faz as operações no banco da tabela de Clientes
 */

public class ClienteDao {

	Session session;
	Transaction transaction;
	Query query;
	Criteria criteria;

	// Faz a consulta pelo id.
	public Clientes findByCode(Integer cod) {

		Clientes cliente = null;

		try {

			session = HibernateUtil.getSessionFactory().openSession();
			cliente = (Clientes) session.get(Clientes.class, cod);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			HibernateUtil.fechar_conexao(session);

		}

		return cliente;

	}

	public List<Clientes> findPendente() {
		List<Clientes> lista = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			query = session.createQuery("from Clientes as l where l.status_pesq= false order by codigo");
			query.setMaxResults(10);
			lista = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			HibernateUtil.fechar_conexao(session);

		}
		return lista;

	}

	public void update(Clientes c) throws Exception {
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			c.setStatus_pesq(true);
			session.update(c);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			HibernateUtil.fechar_conexao(session);

		}
	}

	// public static void main(String[] args) {
	//
	// List<Clientes> c = new ArrayList<>();
	//
	// c = new ClienteDao().findPendente();
	//
	// System.out.println(c);
	//
	//
	// }

}
