package SegundaTanda;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class Eje2a extends JFrame {

	private JPanel contentPane;
	private GridBagLayout gridbag;
	private GridBagConstraints c;
	private JScrollPane jsText;
	private JTextArea jtEntrada;
	private JLabel lblCont;
	final static String MSJ = "Cuenta actual: ";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eje2a frame = new Eje2a();
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
		gridbag = new GridBagLayout();		
		c = new GridBagConstraints();		
		contentPane.setLayout(gridbag);
		c.fill = GridBagConstraints.VERTICAL; 			
				
		setTitle("Area de Texto");		
		setBounds(200, 100, 350, 200);
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}		
	
	public void agregarElementos() {
		
		//c.gridy = row
		//c.gridx = column		
				
		//First Column
		
		jtEntrada = new JTextArea();
		
		jsText = new JScrollPane(jtEntrada);	
		//jsText.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		//jsText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		c.ipady = 100;
		c.ipadx = 100;
		c.gridy = 0;
		c.gridx = 0;
		c.insets = new Insets(2,2,2,2);
		gridbag.setConstraints(jsText, c);
		contentPane.add(jsText);		
		
		lblCont = new JLabel(MSJ);
		c.ipady = 0;	
		c.gridy = 0;
		c.gridx = 1;
		c.insets = new Insets(2,2,2,2);
		gridbag.setConstraints(lblCont, c);
		contentPane.add(lblCont);				
	}

	public void controlEvents() {
		jtEntrada.addKeyListener(contarPalabras());
	}
	
	private KeyListener contarPalabras() {
		KeyListener esteMetodo = new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
				String str = jtEntrada.getText();
				String [] strsplit = str.split("\\s+|\n");
				lblCont.setText(MSJ+strsplit.length);
			}

		};				
		return esteMetodo;
	}
	
	/**
	 * Create the frame.
	 */
	public Eje2a() {
		prepararGUI();
		agregarElementos();
		controlEvents();
	}

}
