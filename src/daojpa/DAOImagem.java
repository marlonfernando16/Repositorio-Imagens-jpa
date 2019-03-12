
package daojpa;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import fachada.Fachada;

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
//		Query q =  manager.createQuery("select img from Imagem img JOIN Tema t on img.id = t.id where t.tema = :tema");
		Query q =  manager.createQuery("select img from Imagem img JOIN img.tema t where t.tema = :tema and img.usuario = :current_user");

		q.setParameter("tema",tema);
		q.setParameter("current_user",Fachada.getLogado());
		List<Imagem> resultList = q.getResultList();
		return resultList;
		}catch(NoResultException e) {
			return null;
		}

	}

}

