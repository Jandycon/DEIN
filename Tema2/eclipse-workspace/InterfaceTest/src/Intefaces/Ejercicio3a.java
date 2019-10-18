package Intefaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class Ejercicio3a extends JFrame {

	private JPanel contentPane;
	private JPanel contentRUno;
	private JPanel contentRDos;
	private JLabel textoDinam;
	private JTextField jtf1;
	private JTextField jtf2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio3a frame = new Ejercicio3a();
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
		
		setTitle("Ejercicio 3a");		
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
		contentRDos.setBounds(63, 78, 330, 25);
				
		textoDinam=new JLabel();
				
		jtf1 = new JTextField();
		jtf1.setColumns(10);	
		
		jtf2 = new JTextField();
		jtf2.setColumns(10);
		
		contentRUno.add(jtf1);
		contentRUno.add(jtf2);
		
		contentRDos.add(textoDinam);
		
		contentPane.add(contentRUno);
		contentPane.add(contentRDos);	
	}
	
	private KeyListener pressEnter(String txt) {
		
		KeyListener esteMetodo= new KeyListener() {	
			public void keyTyped(KeyEvent arg0) {}	
			public void keyReleased(KeyEvent arg0) {}
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode()==KeyEvent.VK_ENTER){
					
					String cadenaTxt;
					
					if(txt.contentEquals("jtf2")) {
						cadenaTxt=jtf2.getText();
					}else {
						cadenaTxt=jtf1.getText();
					}
					textoDinam.setText("ENTER pulsado en "+txt+": "+cadenaTxt);
		            
		        }
			}
		};
		
		return esteMetodo;
	}
	
	
	/**
	 * Create the frame.
	 */
	public Ejercicio3a() {
		
		prepararGUI();
		agregarElementos();
		
		jtf2.addKeyListener(pressEnter("jtf2"));
		jtf1.addKeyListener(pressEnter("jtf1"));
	}
}
