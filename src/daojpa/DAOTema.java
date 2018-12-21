package daojpa;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Tema;


public class DAOTema extends DAO<Tema> {

	public Tema readByNome (String tema) {
//		Query q = manager.query();
//		q.constrain(Tema.class);
//		q.descend("tema").constrain(tema);
//		List<Tema> temas = q.execute();
//		if (temas.size()>0)
//			return temas.get(0);
//		return null;
		
		try {
			Query q = manager.createQuery("select t from Tema t where t.tema = ?1 ");
			return (Tema) q.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
		
	}
	
	public static List<Tema> temaImagensDoUsuario(String tema)throws Exception {
//		Query q = manager.query();
//		q.constrain(Tema.class);
//		q.descend("imagensTema").descend("tema").descend("tema").constrain(tema);
//		List<Tema> temas = q.execute();
//		if(temas.size()>0)
//			return temas;
//		return null;
//	}

	try {
		Query q = manager.createQuery("select t from Tema t where t.tema= '" + tema + "'");
		return (List<Tema>) q.getSingleResult();
	} catch (Exception e) {
		return null;
	}
  }
}
