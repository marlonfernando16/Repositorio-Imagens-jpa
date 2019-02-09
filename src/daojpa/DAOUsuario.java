package daojpa;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.NoResultException;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import modelo.Usuario;

public class DAOUsuario extends DAO<Usuario> {

	public Usuario login(String login,String senha) {
		try {
			Query q = manager.createQuery("select user from Usuario user where user.login = :login and user.senha = :senha");
			q.setParameter("login",login);
			q.setParameter("senha",senha);
			return (Usuario) q.getSingleResult();
			
		}catch(NoResultException e) {
			return null;
		}
	}




	public  Usuario readByNome (String nome) {
		try {
			Query q = manager.createQuery("select user from Usuario user where user.nome = :nome");
			q.setParameter("nome",nome);
			return (Usuario) q.getSingleResult();
		}catch(NoResultException e) {
			return null;

		}

	}


	//}

	public List<Usuario> listAll(){
			try {
				Query q = manager.createQuery("select user from Usuario user");
				return (List<Usuario>) q.getResultList();
			}catch(NoResultException e) {
				return null;

			}

		}

	}


