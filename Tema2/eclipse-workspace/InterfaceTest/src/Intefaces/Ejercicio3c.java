package Intefaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Ejercicio3c extends JFrame {

	private JPanel contentPane;
	private JPanel contentCenter;
	private JPanel contentSouth;
	private JLabel lblmsj;
	private JLabel lblImg;
	private JTextField jtentrada;
	private JButton btnCancel;
	private JButton btnAcept;
	private ImageIcon img;
	private int anioAct;
	private int anioNac;
	private int year= Calendar.getInstance().get(Calendar.YEAR);
	private int cont=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio3c frame = new Ejercicio3c();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void prepararGUI() {		
		
		BorderLayout contentBorder = new BorderLayout();
		contentBorder.setHgap(20);
		contentBorder.setVgap(30);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(contentBorder);			
				
		setTitle("Ejercicio 3c");		
		setBounds(100, 100,350, 200);
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
	}

	public void agregarElementos() {	
				
		contentCenter = new JPanel();
		contentCenter.setLayout(new GridLayout(2,1));
		
		contentSouth = new JPanel();
		contentSouth.setLayout(new FlowLayout());
		
		img = new ImageIcon("src/github.png");	
		Image image = img.getImage();
		Image newimg = image.getScaledInstance(80, 80,  java.awt.Image.SCALE_SMOOTH);
		img = new ImageIcon(newimg);		
		lblImg = new JLabel(img);
		
		lblmsj = new JLabel("Año actual:");			
		
		jtentrada= new JTextField();
		jtentrada.setColumns(20);
		jtentrada.setFont(jtentrada.getFont().deriveFont(20f));
				
		btnCancel= new JButton("Cancelar");
		btnCancel.setBorder(new RoundedBorder(6));
		
		btnAcept= new JButton("Aceptar");
		btnAcept.setBackground(new Color(11721215));
		btnAcept.setBorder(new RoundedBorder(6));
		
		contentCenter.add(lblmsj);
		contentCenter.add(jtentrada);
		
		contentSouth.add(btnCancel);
		contentSouth.add(btnAcept);
		
		contentPane.add(lblImg,BorderLayout.WEST);
		contentPane.add(contentCenter, BorderLayout.CENTER);
		contentPane.add(contentSouth, BorderLayout.SOUTH);
		
	}
	
	protected ImageIcon createImageIcon(String path,String description) {
			java.net.URL imgURL = getClass().getResource(path);
			if (imgURL != null) {
				return new ImageIcon(imgURL, description);
			}else {
				System.err.println("Couldn't find file: " + path);
				return null;
			}
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
	
	protected ActionListener btnAceptar() {
		
		ActionListener esteMetodo = new ActionListener() {		
			public void actionPerformed(ActionEvent e) {			
				
				switch (cont) {
				case 0:					
					try {
						anioAct=Integer.parseInt(jtentrada.getText());					
						if(anioAct!=year) {
							JOptionPane.showMessageDialog(contentPane, "Año actual erróneo.");
						}else {
							lblmsj.setText("Año nacimiento:");
							jtentrada.setText("");
							cont++;
						}
						
						break;
					}catch (NumberFormatException nfe) {
						JOptionPane.showMessageDialog(contentPane, "El campo año actual no puede estar vacío.");
					}
					
				case 1:					
					try {
						anioNac=Integer.parseInt(jtentrada.getText());					
						if(anioNac > anioAct) {
							JOptionPane.showMessageDialog(contentPane, "El año nacimiento no puede ser mayor al actual.");
						}else {
							btnCancel.setVisible(false);
							jtentrada.setVisible(false);
							lblmsj.setText(mensajeEdad(anioAct,anioNac));							
														
							setSize(300, 320);
							setTitle("Mensaje");
							
							cont++;
						}						
						break;
					}catch (NumberFormatException nfe) {
						JOptionPane.showMessageDialog(contentPane, "Ingrese año de nacimiento.");
					}
				default:
					dispose();
				}			
			}
		};
		return esteMetodo;
	}
	
	/*Probar mouseListener -- getClickCount==*/
	
	protected ActionListener cerrarVentana() {
		
		ActionListener esteMetodo = new ActionListener() {		
			public void actionPerformed(ActionEvent e) {				
				dispose();
			}
		};
		return esteMetodo;
	}
	
	protected String mensajeEdad(int num1, int num2) {
		
		String cadena="<html><body>";
		int anios=num1-num2;		
		int meses=(anios*365)/30;
		int dias=anios*365;
		int horas=dias*24;
		int minutos=horas*60;
		int segundos=minutos*60;	
		
		cadena+="Tienes:"+"<br>";		
		cadena+=anios+"años cumplidos"+"<br>";
		cadena+=meses+" meses"+"<br>";
		cadena+=dias+" dias"+"<br>";
		cadena+=horas+" horas"+"<br>";
		cadena+=minutos+" minutos"+"<br>";
		cadena+=segundos+" segundos";
		
		cadena+="</body></html>";
		
		return cadena;
	}
	
	/**
	 * Create the frame.
	 */
	public Ejercicio3c() {	
		
		prepararGUI();
		agregarElementos();
		
		jtentrada.addKeyListener(validar());
		btnAcept.addActionListener(btnAceptar());
		btnCancel.addActionListener(cerrarVentana());
	}

}
