package persistence;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import config.HibernateUtil;
import entity.Funcionario;

public class FuncionarioDao {
	
	  Session session;
	  Transaction transaction;
	  Query query;
	  Criteria criteria;
	  public List<Funcionario>findAll(){
	   List<Funcionario> lista = null;
	   try {
	    session = HibernateUtil.getSessionFactory().openSession();
	    query = session.createQuery("from Funcionario");
	    lista = query.list();
	    } catch (Exception e) {
	    e.printStackTrace();
	   } finally {
	    HibernateUtil.fechar_conexao(session);
	   }
	   return lista;

	  }
	  
	  
//	  public static void main(String[] args) {
//		
//		  List<Funcionario> f = new ArrayList<>();
//		  
//		  f = new FuncionarioDao().findAll();
//		  
//		  System.out.println(f);
//	}


}
