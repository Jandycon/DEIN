package SegundaTanda;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;


public class Eje2b extends JFrame {

	private JPanel contentPane;
	private GridBagLayout gridbag;
	private GridBagConstraints c;
	private JScrollPane jsText;
	private JTextArea jtEntrada;
	private JLabel lblbuscar;
	private JTextArea jtBuscar;
	private JButton btnBegin;
	private JButton btnNext;
	private int cont;
	private boolean isPressed;
	private String prevTexto;
	private int posF=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eje2b frame = new Eje2b();
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
				
		setTitle("Editor Texto simple");		
		setBounds(200, 100, 300, 500);
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}		
	
	public void agregarElementos() {						
		
		//c.gridy = row
		//c.gridx = column		
				
		//First Column		
		Font font = new Font("Courier", Font.BOLD,12);	
		jtEntrada = new JTextArea();
		jtEntrada.setFont(font);
		
		jsText = new JScrollPane(jtEntrada);
		c.ipady = 300;
		c.ipadx = 250;
		c.gridy = 0;
		c.gridx = 0;
		c.insets = new Insets(2,2,2,2);
		gridbag.setConstraints(jsText, c);
		contentPane.add(jsText);		
		
		lblbuscar = new JLabel("Buscar...");
		lblbuscar.setHorizontalAlignment(JLabel.CENTER);
		c.ipady = 0;	
		c.gridy = 1;
		c.gridx = 0;
		c.insets = new Insets(2,2,2,2);
		gridbag.setConstraints(lblbuscar, c);
		contentPane.add(lblbuscar);	
		
		jtBuscar = new JTextArea();
		jtBuscar.setColumns(15);
		jtBuscar.setBorder(new EmptyBorder(5, 5, 5, 5));
		c.ipady = 0;	
		c.gridy = 2;
		c.gridx = 0;
		c.insets = new Insets(2,2,2,2);
		gridbag.setConstraints(jtBuscar, c);
		contentPane.add(jtBuscar);	
		
		btnBegin = new JButton("Busca desde inicio");
		c.ipadx = 40;
		c.ipady = 0;	
		c.gridy = 3;
		c.gridx = 0;
		c.insets = new Insets(5,5,5,5);
		gridbag.setConstraints(btnBegin, c);
		contentPane.add(btnBegin);	
		
		btnNext = new JButton("Buscar siguiente");
		btnNext.setEnabled(false);
		c.ipadx = 30;
		c.ipady = 0;	
		c.gridy = 4;
		c.gridx = 0;
		c.insets = new Insets(5,5,5,5);
		gridbag.setConstraints(btnNext, c);
		contentPane.add(btnNext);						
	}
	
	public void controlEvents() {
		btnBegin.addActionListener(buscar());
		btnNext.addActionListener(buscarNext());
		jtEntrada.addKeyListener(controlarBtnNext());
		jtBuscar.addKeyListener(controlarBtnNext());
	}
	
	public KeyListener controlarBtnNext() {
		KeyListener esteMetodo = new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
				prevTexto=jtEntrada.getText();	
				if(jtEntrada.equals("") || (!jtEntrada.equals(prevTexto))) {
					btnNext.setEnabled(false);
				}
			}
		};
		return esteMetodo;
	}
	
	public void resaltarPalabra(int ibegin, int ifinal) {	
		
	}
	
	public ActionListener buscar() {
		ActionListener esteMetodo = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				prevTexto = jtEntrada.getText();				
				if(jtEntrada.getText().equals("")) {
					JOptionPane.showMessageDialog(contentPane, "No hay texto en el que buscar la palabra");					
				}else {
					if(jtBuscar.getText().equals("")) {
						JOptionPane.showMessageDialog(contentPane, "La palabra a buscar no puede ser vacia");					
					}else {			            
			            String palabra = jtBuscar.getText().toString();
			            String texto = jtEntrada.getText().toString();
						
			            int posI = texto.indexOf(palabra,posF);
			            
			            if (posI == -1) {//palabra no encontrada			            	
			            	JOptionPane.showMessageDialog(contentPane, "No se ha encontrado ninguna palabra");
			            }else {
			            	posF=posI+palabra.length();	 			            
				            jtEntrada.requestFocus();
				    		jtEntrada.setSelectionStart(posI);
				            jtEntrada.setSelectionEnd(posF);		
			            }      
					}
				}
			}
		};
		return esteMetodo;
	}	
	
	
	
	public ActionListener buscarNext() {
		ActionListener esteMetodo = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				
			}
		};
		return esteMetodo;
	}
	
	/**
	 * Create the frame.
	 */
	public Eje2b() {
		prepararGUI();
		agregarElementos();
		controlEvents();
	}

}
