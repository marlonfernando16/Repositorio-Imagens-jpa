package modelo;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Tema {	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String tema;
	@OneToMany(mappedBy="tema")
	private ArrayList<Imagem> imagensTema = new ArrayList<>();
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	public ArrayList<Imagem> getImagens() {
		return imagensTema;
	}
	public void setImagem(Imagem imagem) {
		this.imagensTema.add(imagem);
	}
	
	public Tema() {};
	
	@Override
	public String toString() {
		String texto =  "Tema [tema=" + tema + ", imagens= ";
		for (Imagem i : imagensTema) {
			texto+=" "+i.getNome()+", ";
		}
		texto+="]";
		return texto;
	}
}
