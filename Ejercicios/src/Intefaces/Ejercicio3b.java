package Intefaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Ejercicio3b extends JFrame {

	private JPanel contentPane;
	private JPanel contentRUno;
	private JPanel contentRDos;
	private JPanel contentRTres;
	private JTextField jtf1;
	private JButton btnCortar;
	private JButton btnPegar;
	private JLabel textoDinam1;
	private JLabel textoDinam2;
	private final String TEXTO="Todo el texto: ";
	private final String SELTEXTO="Texto seleccionado: ";	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio3b frame = new Ejercicio3b();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void prepararGUI() {		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);		
		
		setTitle("Ejercicio 3b");		
		setBounds(100, 100, 450, 300);
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
	}
	
	public void agregarElementos() {	
		
		contentRUno=new JPanel();
		contentRUno.setLayout(new FlowLayout());
		contentRUno.setBounds(12, 37, 420, 42);	
		
		contentRDos=new JPanel();
		contentRDos.setLayout(new FlowLayout());
		contentRDos.setBounds(62, 79, 330, 35);
		
		contentRTres= new JPanel();
		contentRTres.setLayout(new GridLayout(2,1));
		contentRTres.setBounds(62, 112, 330, 35);
		
										
		jtf1 = new JTextField();
		jtf1.setColumns(10);	
		
		textoDinam1=new JLabel(TEXTO);
		textoDinam1.setBounds(115, 125, 66, 15);
		
		textoDinam2=new JLabel(SELTEXTO);
		textoDinam2.setBounds(125, 141, 66, 15);
		
		btnCortar=new JButton("Cortar");
		btnPegar=new JButton("Pegar");		
		
		contentRUno.add(jtf1);
		
		contentRDos.add(btnCortar);
		contentRDos.add(btnPegar);
		
		contentRTres.add(textoDinam1);
		contentRTres.add(textoDinam2);
		
		contentPane.add(contentRUno);
		contentPane.add(contentRDos);
		contentPane.add(contentRTres);
		
	}
	
	private KeyListener pressLetra() {
		
		KeyListener esteMetodo= new KeyListener() {	
			public void keyTyped(KeyEvent arg0) {}	
			public void keyReleased(KeyEvent arg0) {
				textoDinam1.setText(TEXTO+jtf1.getText());
			}
			public void keyPressed(KeyEvent arg0) {}
		};
		
		return esteMetodo;
	}
	
	private MouseMotionListener selectTexto() {
		
		MouseMotionListener esteMetodo= new MouseMotionListener() {
			public void mouseMoved(MouseEvent arg0) {}
			public void mouseDragged(MouseEvent arg0) {
				textoDinam2.setText(SELTEXTO+jtf1.getSelectedText());				
			}
		};
		
		return esteMetodo;
	}
	
	private ActionListener cortar() {
		
		ActionListener esteMetodo = new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {
				jtf1.cut();				
			}
		};
		return esteMetodo;
	}
	
	private ActionListener pegar() {	
		
		ActionListener esteMetodo = new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {
				jtf1.paste();				
			}
		};
		return esteMetodo;
	}
		
	/**
	 * Create the frame.
	 */	
	public Ejercicio3b() {
		
		prepararGUI();
		agregarElementos();
		jtf1.addKeyListener(pressLetra());
		jtf1.addMouseMotionListener(selectTexto());
		btnCortar.addActionListener(cortar());
		btnPegar.addActionListener(pegar());
	}
}
