package Intefaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Ejercicio3i extends JFrame {

	private JPanel contentPane;
	private JTextField jtbuffer;
	private JTextField jtentrada;
	private ArrayList <JButton> botones;
	private GridBagLayout gridbag;
	private GridBagConstraints c;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio3i frame = new Ejercicio3i();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void prepararBotones() {
		botones = new ArrayList<JButton>();
		for(int i=1;i<=20;i++) {
			switch (i) {
			case 4:
				
				break;
			case 5:
				
				break;
			case 9:
				
				break;
			case 10:
				
				break;
			case 14:
				
				break;
			case 15:
				
				break;
			case 18:
				
				break;
			case 19:
				
				break;
			default:
				
				break;
			}			
		}
	}

	public void prepararGUI() {		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));		
		gridbag = new GridBagLayout();		
		c = new GridBagConstraints();		
		contentPane.setLayout(gridbag);
		c.fill = GridBagConstraints.VERTICAL; 			
				
		setTitle("Ejercicio 3i");		
		setBounds(200, 100, 300, 300);
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
	}
	
	
	public void agregarElementos() {
		
		//c.gridy = row
		//c.gridx = column
		
		jtbuffer = new JTextField();
		jtbuffer.setEditable(false);
		jtbuffer.setColumns(20);
		c.gridy = 0;
		c.gridx = 0;
		gridbag.setConstraints(jtbuffer, c);
		contentPane.add(jtbuffer);
				
		jtentrada = new JTextField("0.");
		jtentrada.setHorizontalAlignment(SwingConstants.RIGHT);
		jtentrada.setBackground(Color.yellow);
		jtentrada.setColumns(20);
		c.gridy = 1;
		c.gridx = 0;
		gridbag.setConstraints(jtentrada, c);
		contentPane.add(jtentrada);				
	}
	/*
	private void generarR1() { //Genera la primera linea de botones
		
		//Insets(top,left,bottom,right)
		
		btn7 = new JButton("7");		
		c.ipady = 0;
		c.gridy = 2;
		c.gridx = 0;
		c.weightx = 0.5;
		gridbag.setConstraints(btn7, c);
		contentPane.add(btn7);
		
		btn8 = new JButton("8");
		c.ipady = 0;
		c.gridy = 2;
		c.gridx = 1;
		gridbag.setConstraints(btn8, c);
		contentPane.add(btn8);		
		
		btn9 = new JButton("9");
		c.ipady = 0;
		c.gridy = 2;
		c.gridx = 2;
		gridbag.setConstraints(btn9, c);
		contentPane.add(btn9);
		
		btnC = new JButton(SIGNCLEAN);
		c.ipady = 0;
		c.gridy = 2;
		c.gridx = 3;
		gridbag.setConstraints(btnC, c);
		contentPane.add(btnC);
		
		btnCE = new JButton(SIGNCLEANALL);
		c.ipady = 0;
		c.gridy = 2;
		c.gridx = 4;
		gridbag.setConstraints(btnCE, c);
		contentPane.add(btnCE);
	}
	*/
	
	/**
	 * Create the frame.
	 */
	public Ejercicio3i() {
		prepararGUI();
		agregarElementos();		
	}

}
