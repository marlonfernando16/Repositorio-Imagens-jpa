package modelo;


import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

//import dao.IDInterface;
@Entity
public class Imagem /*implements IDInterface */ {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	private String nome;
	@Basic(fetch = FetchType.LAZY)
	@Lob
	private byte[] bytesimagem;
	@ManyToOne
	Usuario usuario;
	@ManyToOne
	private Tema tema;
	
	public Imagem(){}

	public Imagem(BufferedImage bf, String nome) {
		super();
		this.nome = nome;
		setBufferedImage(bf);
	}	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		 this.tema = tema;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
    @Lob
	public BufferedImage getBufferedImage() throws Exception{
		try {
			InputStream in = new ByteArrayInputStream(this.bytesimagem);
			BufferedImage bf = ImageIO.read(in);
			return bf;
		} catch (IOException e) {
			throw new Exception("leitura de arquivo invalida");
		}

	}
    @Lob
	public void setBufferedImage(BufferedImage bf) {
		try{
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(bf, "jpg", baos );		// tipo de gravacao
			baos.flush();
			baos.close();
			this.bytesimagem = baos.toByteArray();	
		
		}
		catch(Exception e ){
			e.printStackTrace();
		}

	}

	@Override
	public String toString() {
		return "Imagem [nome= " + nome + ", usuario=" + usuario.getNome() + ", tema=" + tema + "]";
	}


}

