package Intefaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Ejercicio3d extends JFrame {
	
	private JPanel contentPane;
	private JPanel contentCenter;
	private JPanel contentSouth;
	private JLabel lblmsj;
	private JLabel lblImg;
	private JTextField jtentrada;
	private JButton btnCancel;
	private JButton btnAcept;
	private ImageIcon img;
	private int num1=0;
	private int num2=0;
	private int result=0;
	private int cont=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio3d frame = new Ejercicio3d();
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
		
		
		setTitle("Ejercicio 3d");		
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
		
		lblmsj = new JLabel("Introduce el #1");			
		
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
				System.out.println(System.getProperty("user.dir"));
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
				System.out.println(cont);
				switch (cont) {
				case 0:					
					try {
						num1=Integer.parseInt(jtentrada.getText());		
						cont++;
						lblmsj.setText("Introduce el #2");
						jtentrada.setText("");
					}catch (NumberFormatException nfe) {
						JOptionPane.showMessageDialog(contentPane, "El campo no puede estar vacío.");
					}
					break;
				case 1:					
					try {						
						num2=Integer.parseInt(jtentrada.getText());
						btnCancel.setVisible(false);
						jtentrada.setVisible(false);
						lblmsj.setText(mensajeResult(num1, num2));
						setBounds(120, 120,300, 200);
						setTitle("Mensaje");						
						cont++;
						
					}catch (NumberFormatException nfe) {
						JOptionPane.showMessageDialog(contentPane, "El campo no puede estar vacío.");
					}					
					break;	
				default:
					dispose();
					break;
				}						
			}
		};
		return esteMetodo;
	}

	protected ActionListener cerrarVentana() {
		
		ActionListener esteMetodo = new ActionListener() {		
			public void actionPerformed(ActionEvent e) {				
				dispose();
			}
		};
		return esteMetodo;
	}
	
	protected String mensajeResult(int num1, int num2) {
		
		String cadena="<html><body>";
		int suma=num1+num2;			
		cadena+="La suma de "+num1+" + "+num2+" = "+suma+"</body></html>";
		return cadena;
	}
	
	/**
	 * Create the frame.
	 */
	public Ejercicio3d() {
		
		prepararGUI();
		agregarElementos();
		
		jtentrada.addKeyListener(validar());
		btnAcept.addActionListener(btnAceptar());
		btnCancel.addActionListener(cerrarVentana());
	}

}
