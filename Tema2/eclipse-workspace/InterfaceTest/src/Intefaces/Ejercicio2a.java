package Intefaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Ejercicio2a extends JFrame {

	private JPanel contentPane;
	private JButton btnUno;
	private JButton btnDos;
	private JLabel textoElegir;
	private JPanel contentButton;
	private JPanel contentMsj;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio2a frame = new Ejercicio2a();
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
		
		setTitle("Ejercicio 2a");		
		setBounds(100, 100, 450, 300);
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
	}
	
	public void agregarElementos() {
		
		contentButton = new JPanel();
		contentButton.setLayout(new FlowLayout());
		contentButton.setBounds(131, 37, 200, 42);	
		
		contentMsj = new JPanel();
		contentMsj.setLayout(new FlowLayout());
		contentMsj.setBounds(131, 78, 200, 25);		
		
		btnUno = new JButton("Primero");
		btnUno.setBounds(40, 64, 114, 25);	
		
		btnDos = new JButton("Segundo");
		btnDos.setBounds(250, 64, 114, 25);	
		
		textoElegir = new JLabel("Presione un botón");
		textoElegir.setBounds(150, 100, 400, 25);		
		
		contentButton.add(btnUno);
		contentButton.add(btnDos);
				
		contentMsj.add(textoElegir);
		
		contentPane.add(contentButton);
		contentPane.add(contentMsj);
	}
	
	public ActionListener pressBtnUno() {
		ActionListener esteMetodo = new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {
				textoElegir.setText("Primer botón presionado");				
			}
		};
		return esteMetodo;
	}
	
	public ActionListener pressBtnDos() {
		ActionListener esteMetodo = new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {
				textoElegir.setText("Segundo botón presionado");				
			}
		};
		return esteMetodo;
	}
	
	
	/**
	 * Create the frame.
	 */
	public Ejercicio2a() {
		
		prepararGUI();
		agregarElementos();
		
		btnUno.addActionListener(pressBtnUno());
		btnDos.addActionListener(pressBtnDos());		
		
	}

}
