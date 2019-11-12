package Intefaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Ejercicio3f extends JFrame {

	private JPanel contentPane;
	private JTextField jtentrada;
	private JLabel lblPta;
	private JLabel lblEur;
	private JButton btnChange;
	private double CAMBIO=166.386;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio3f frame = new Ejercicio3f();
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
		contentPane.setLayout(new GridLayout(2,2));			
				
		setTitle("Ejercicio 3f");		
		setBounds(100, 100,350, 100);
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
	}

	public void agregarElementos() {
		
		jtentrada = new JTextField();
		
		lblPta = new JLabel("Pesetas");
		
		btnChange = new JButton("Cambio Pta -> E");
		
		lblEur = new JLabel("Euros");
		
		contentPane.add(jtentrada);
		contentPane.add(lblPta);
		contentPane.add(btnChange);
		contentPane.add(lblEur);
		
	}
	
	protected KeyListener validar() {
		
		KeyListener esteMetodo = new KeyAdapter() {			
			public void keyTyped(KeyEvent e) {
			      char c = e.getKeyChar();
			      if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
			        getToolkit().beep();
			        e.consume();
			      }
			}
		};
		return esteMetodo;
	}
	
	
	public String calcularPesetasAEuros(double num) {
		String cadena="";
		double result = num/CAMBIO;
		DecimalFormat df = new DecimalFormat("#.00");
		cadena+=df.format(result)+" Euros";
		return cadena;
	}
	
	protected ActionListener calcular() {
		
		ActionListener esteMetodo = new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					double cantidad = Double.parseDouble(jtentrada.getText());
					lblEur.setText(calcularPesetasAEuros(cantidad));
					
				}catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(contentPane, "El campo no puede estar vacío.");
				}
				
				
			}
		};
		return esteMetodo;
	}
	
	/**
	 * Create the frame.
	 */
	public Ejercicio3f() {
		
		prepararGUI();
		agregarElementos();
		jtentrada.addKeyListener(validar());
		btnChange.addActionListener(calcular());
		
	}

}
