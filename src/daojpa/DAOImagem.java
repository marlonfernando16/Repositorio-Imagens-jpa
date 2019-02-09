
package daojpa;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.Entity;
import modelo.Imagem;
import modelo.Tema;

public class DAOImagem  extends DAO<Imagem>{


	public Imagem readByNome (String nome){
		try {
			Query q =  manager.createQuery("select img from Imagem p where p.nome= :nome");
			q.setParameter("nome",nome);
			return (Imagem) q.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}


	public List<Imagem> ConsultarImagensPorTema(String tema) {
		try {
		Query q =  manager.createQuery("select img from Imagem img join Tema t on img.id = t.id where t.tema = :tema");
		q.setParameter("tema",tema);
		List<Imagem> resultList = q.getResultList();
		return resultList;
		}catch(NoResultException e) {
			return null;
		}

	}

}

