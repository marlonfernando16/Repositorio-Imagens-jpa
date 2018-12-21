package daojpa;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.NoResultException;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import modelo.Usuario;

@Entity
public class DAOUsuario extends DAO<Usuario> {

	public Usuario login(String login,String senha) {
		try {
			Query q = manager.createQuery("select user from Usuario user where user.login = ?1 and user.senha = ?2 ");
			return (Usuario) q.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}




	public  Usuario readByNome (String nome) {
		try {
			Query q = manager.createQuery("select user from Usuario user where user.nome = ?1  ");
			return (Usuario) q.getSingleResult();
		}catch(NoResultException e) {
			return null;

		}

	}


	//}

	public List<Usuario> listAll(){
			try {
				Query q = manager.createQuery("select * from Usuario ");
				return (List<Usuario>) q.getResultList();
			}catch(NoResultException e) {
				return null;

			}

		}

	}


