package aplicacao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import fachada.Fachada;
import modelo.Imagem;

public class TelaImagem {

	private JFrame frame;
	int img = 0;
	List<Imagem> imagensFiltro;
	BufferedImage bf = null;
	/**
	 * Launch the application.
	 */
	public static void Imagem() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaImagem window = new TelaImagem();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaImagem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JComboBox temas_cb = new JComboBox();
		String[] temas = {"Todos", "Paisagem", "Pessoal", "Aleatorio", "Animais", "Memes"};
		temas_cb.setModel(new DefaultComboBoxModel(temas));
		temas_cb.setBounds(175, 24, 112, 20);
		frame.getContentPane().add(temas_cb);
		
		for(String tema:temas) {
			Fachada.cadastrarTema(tema);
		}
		
		JButton button = new JButton("Excluir");
		button.setBounds(312, 227, 112, 23);
		frame.getContentPane().add(button);

		JLabel lbl_imagem = new JLabel("Vizualiza\u00E7\u00E3o");
		lbl_imagem.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_imagem.setBounds(63, 55, 308, 161);
		frame.getContentPane().add(lbl_imagem);

		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal tela = new TelaPrincipal();
				frame.dispose();
				tela.Principal();
			}
		});

		btnNewButton.setBounds(346, 11, 78, 23);
		frame.getContentPane().add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("Filtrar Tema");
		lblNewLabel_1.setFont(new Font("Century", Font.BOLD, 13));
		lblNewLabel_1.setBounds(23, 26, 131, 20);
		frame.getContentPane().add(lblNewLabel_1);

		JButton btnPrevious = new JButton("<");
		
		btnPrevious.setBounds(10, 124, 43, 23);
		frame.getContentPane().add(btnPrevious);

		JButton btnNext = new JButton(">");
		btnNext.setBounds(381, 124, 43, 23);
		frame.getContentPane().add(btnNext);

//				if(img.getUsuario() == Fachada.getLogado())
						
						
						JButton btnFiltrar = new JButton("Filtrar");
						btnFiltrar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								  try {
									if(imagensFiltro!=null) {	  
										imagensFiltro = Fachada.imagensPorTema(temas_cb.getSelectedItem().toString());
										bf = imagensFiltro.get(img).getBufferedImage();
										System.out.println(temas_cb.getSelectedItem());
										  System.out.println(imagensFiltro.size());
										  System.out.println(img);
									}
	//									
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							}
						});
						
//						

						
						btnFiltrar.setBounds(175, 227, 89, 23);
						frame.getContentPane().add(btnFiltrar);
						
						
							btnNext.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									try {
										System.out.println(Fachada.listarImagens());
//										if(img< imagensFiltro.size()-1) 
										img += 1;
////										bf = imagensFiltro.get(img).getBufferedImage();
////										ImageIcon icon = new  ImageIcon(bf.getScaledInstance(308,161,Image.SCALE_DEFAULT));
//										lbl_imagem.setIcon(icon);
									} catch (Exception e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									
								}
							  	
							});
						 
						
						
							btnPrevious.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									try {
//									  if(img > 0) 
										img-=1;
										bf = imagensFiltro.get(img).getBufferedImage();
									} catch (Exception e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									ImageIcon icon = new  ImageIcon(bf.getScaledInstance(308,161,Image.SCALE_DEFAULT));
									lbl_imagem.setIcon(icon);
								}
							});
						 	


		}
	}

