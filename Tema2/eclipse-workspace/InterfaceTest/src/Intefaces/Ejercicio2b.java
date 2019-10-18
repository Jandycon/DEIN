package Intefaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Ejercicio2b extends JFrame {

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
					Ejercicio2b frame = new Ejercicio2b();
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
		
		setTitle("Ejercicio 2b");		
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
				textoElegir.setText("Botón segundo habilitado");	
				btnDos.setEnabled(true);
			}
		};
		return esteMetodo;
	}
	
	public ActionListener pressBtnDos() {
		ActionListener esteMetodo = new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {			
				
				btnDos.setEnabled(false);
				textoElegir.setText("Botón segundo deshabilitado");
			}
		};
		return esteMetodo;
	}
	
	public MouseListener mouseBtnDos() {
		
		MouseListener esteMetodo = new MouseListener() {
			
			public void mousePressed(MouseEvent arg0) {
				textoElegir.setText("Botón segundo presionado");			
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub				
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub				
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub				
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub				
			}
		};		
		return esteMetodo;		
	}
	
	/**
	 * Create the frame.
	 */
	public Ejercicio2b() {
		
		prepararGUI();
		agregarElementos();
		
		btnUno.addActionListener(pressBtnUno());
		btnDos.addActionListener(pressBtnDos());	
		btnDos.addMouseListener(mouseBtnDos());
	}

}
