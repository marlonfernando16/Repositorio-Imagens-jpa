
package daojpa;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.Entity;
import modelo.Imagem;
import modelo.Tema;

@Entity
public class DAOImagem  extends DAO<Imagem>{

	//	public Imagem read (Object chave){
	////		int id = (Integer) chave;
	////		Query q = manager.query();
	////		q.constrain(Imagem.class);
	////		q.descend("id").constrain(id);
	////		List<Imagem> resultados = q.execute();
	////		if (resultados.size()>0)
	////			return resultados.get(0);
	////		else
	////			return null;
	//	int id = (Integer) chave;
	//	Query q =  manager.createQuery("select img from Imagem img where img.nome= '" + n +"'");
	//	return (Produto) q.getSingleResult();
	//	
	//	
	//	}


	public Imagem readByNome (String nome){
		//		Query q = manager.query();
		//		q.constrain(Imagem.class);
		//		q.descend("nome").constrain(nome);
		//		List<Imagem> resultados = q.execute();
		//		if (resultados.size()>0)
		//			return resultados.get(0);
		//		else
		//			return null;
		try {
			Query q =  manager.createQuery("select img from Imagem p where p.nome= '" + nome +"'");
			return (Imagem) q.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}


	public List<Imagem> ConsultarImagensPorTema(String tema) {
//		Query q = manager.query();
//		q.constrain(Imagem.class);
//		q.descend("tema").descend("tema").constrain(tema);
//		List<Imagem> imagens = q.execute();
//		if(imagens.size()>0)
//			return imagens;
//		else
//			return null;
		try {
		Query q =  manager.createQuery("select img from Imagem img join Tema t on img.id = t.id where t.tema = '" + tema + "'");
		return (List<Imagem>) q.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}

	}

}

