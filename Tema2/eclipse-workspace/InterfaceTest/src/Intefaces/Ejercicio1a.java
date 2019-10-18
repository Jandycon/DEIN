package Intefaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio1a extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField cuadroDeTexto;
	private JButton btnEmpezar;
	private int count=0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio1a frame = new Ejercicio1a();
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
		
		setTitle("Ejercicio 1a");		
		setBounds(100, 100, 450, 300);
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
	}
	
	public void agregarElementos() {		
		
		cuadroDeTexto = new JTextField();
		cuadroDeTexto.setBounds(40, 33, 124, 19);
		cuadroDeTexto.setColumns(20);	
		
		btnEmpezar = new JButton("Aceptar");		
		btnEmpezar.setBounds(40, 64, 114, 25);	
		
		contentPane.add(cuadroDeTexto);
		contentPane.add(btnEmpezar);
	}
	
	/* Mis metodos para los eventos*/
	public ActionListener cambiarTexto() {
	    ActionListener esteMetodo = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {							
				cuadroDeTexto.setText("Hola Colega");				
			}
		};
		return esteMetodo;
	}
		
	/**
	 * Create the frame
	 */
	public Ejercicio1a() {
				
		prepararGUI();	
		agregarElementos();				
		
		btnEmpezar.addActionListener(cambiarTexto());
	}			

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
