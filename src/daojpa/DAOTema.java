package daojpa;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Tema;


public class DAOTema extends DAO<Tema> {

	public Tema readByNome (String tema) {

		
		try {
			Query q = manager.createQuery("select t from Tema t where t.tema = :tema ");
			q.setParameter("tema",tema);
			return (Tema) q.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
		
	}
	
	public static List<Tema> temaImagensDoUsuario(String tema)throws Exception {

	try {
		Query q = manager.createQuery("select t from Tema t where t.tema= '" + tema + "'");
		return (List<Tema>) q.getSingleResult();
	} catch (Exception e) {
		return null;
	}
  }
}
