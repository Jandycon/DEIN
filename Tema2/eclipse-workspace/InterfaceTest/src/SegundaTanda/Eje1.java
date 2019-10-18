package SegundaTanda;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class Eje1 extends JFrame {

	private JPanel contentPane;
	private GridBagLayout gridbag;
	private GridBagConstraints c;
	private JLabel lblValor;
	private JLabel lbl50;
	private JLabel lbl20;
	private JLabel lbl10;
	private JLabel lbl5;
	private JLabel lbl1;
	private JButton btnCalcular;	
	private JTextField jtValor;
	private JTextField jt50;
	private JTextField jt20;
	private JTextField jt10;
	private JTextField jt5;
	private JTextField jt1;
	private ArrayList<JTextField> listaJT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eje1 frame = new Eje1();
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
				
		setTitle("Diseño previo [NewJFrame]");		
		setBounds(200, 100, 400, 200);
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
	}
	
	public void agregarElementos() {
		listaJT = new ArrayList<JTextField>();
		listaJT.add(jt50);
		listaJT.add(jt20);
		listaJT.add(jt10);
		listaJT.add(jt5);
		listaJT.add(jt1);
		
		//c.gridy = row
		//c.gridx = column		
		
		//First Column
		lblValor = new JLabel("Ingrese un valor:");		
		c.ipady = 0;	
		c.gridy = 0;
		c.gridx = 0;
		c.insets = new Insets(2,2,2,2);
		gridbag.setConstraints(lblValor, c);
		contentPane.add(lblValor);
		
		lbl50 = new JLabel("Monedas de 50:");
		c.ipady = 0;	
		c.gridy = 1;
		c.gridx = 0;
		c.insets = new Insets(2,2,2,2);
		gridbag.setConstraints(lbl50, c);
		contentPane.add(lbl50);
		
		lbl20 = new JLabel("Monedas de 20:");
		c.ipady = 0;	
		c.gridy = 2;
		c.gridx = 0;
		c.insets = new Insets(2,2,2,2);
		gridbag.setConstraints(lbl20, c);
		contentPane.add(lbl20);
		
		lbl10 = new JLabel("Monedas de 10:");
		c.ipady = 0;	
		c.gridy = 3;
		c.gridx = 0;
		c.insets = new Insets(2,2,2,2);
		gridbag.setConstraints(lbl10, c);
		contentPane.add(lbl10);
		
		lbl5 = new JLabel("Monedas de 5:");
		c.ipady = 0;	
		c.gridy = 4;
		c.gridx = 0;
		c.insets = new Insets(2,2,2,2);
		gridbag.setConstraints(lbl5, c);
		contentPane.add(lbl5);
		
		lbl1 = new JLabel("Monedas de 1:");
		c.ipady = 0;	
		c.gridy = 5;
		c.gridx = 0;
		c.insets = new Insets(2,2,2,2);
		gridbag.setConstraints(lbl1, c);
		contentPane.add(lbl1);
		
		//Second Column		
		jtValor = new JTextField();
		jtValor.setColumns(10);
		c.ipady = 0;	
		c.gridy = 0;
		c.gridx = 1;
		c.insets = new Insets(2,2,2,2);
		gridbag.setConstraints(jtValor, c);
		contentPane.add(jtValor);
		
		jt50 = new JTextField();
		jt50.setEditable(false);
		jt50.setColumns(10);
		c.ipady = 0;	
		c.gridy = 1;
		c.gridx = 1;
		c.insets = new Insets(2,2,2,2);
		gridbag.setConstraints(jt50, c);
		contentPane.add(jt50);
		
		jt20 = new JTextField();
		jt20.setEditable(false);
		jt20.setColumns(10);
		c.ipady = 0;	
		c.gridy = 2;
		c.gridx = 1;
		c.insets = new Insets(2,2,2,2);
		gridbag.setConstraints(jt20, c);
		contentPane.add(jt20);
		
		jt10 = new JTextField();
		jt10.setEditable(false);
		jt10.setColumns(10);
		c.ipady = 0;	
		c.gridy = 3;
		c.gridx = 1;
		c.insets = new Insets(2,2,2,2);
		gridbag.setConstraints(jt10, c);
		contentPane.add(jt10);
		
		jt5 = new JTextField();
		jt5.setEditable(false);
		jt5.setColumns(10);
		c.ipady = 0;	
		c.gridy = 4;
		c.gridx = 1;
		c.insets = new Insets(2,2,2,2);
		gridbag.setConstraints(jt5, c);
		contentPane.add(jt5);
		
		jt1 = new JTextField();
		jt1.setEditable(false);
		jt1.setColumns(10);
		c.ipady = 0;	
		c.gridy = 5;
		c.gridx = 1;
		c.insets = new Insets(2,2,2,2);
		gridbag.setConstraints(jt1, c);
		contentPane.add(jt1);
		
		//Third Column
		btnCalcular = new JButton("Calcular");
		btnCalcular.setBorder(new EmptyBorder(5, 5, 5, 5));
		c.ipady = 0;	
		c.gridy = 0;
		c.gridx = 2;
		c.insets = new Insets(2,2,2,2);
		gridbag.setConstraints(btnCalcular, c);
		contentPane.add(btnCalcular);
		
	}
	
	public void controlEvents() {
		
		jtValor.addKeyListener(validar());
		btnCalcular.addActionListener(calcular());		
	}	
	
	private ActionListener calcular() {
		ActionListener esteMetodo = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {					
				try {	
					int valor = Integer.parseInt(jtValor.getText());					
					if (valor < 1) {
						JOptionPane.showMessageDialog(contentPane, "El valor no puede ser menor o igual que 0.");
					}
					else {							
						int resto=valor;
						
						if(resto >=50) {
							jt50.setText(resto/50+"");
							resto=resto%50;							
						}else {
							jt50.setText("");
						}
						if(resto >=20 && resto <50) {
							jt20.setText(resto/20+"");
							resto=resto%20;
						}else {
							jt20.setText("");
						}
						if(resto >=10 && resto <20) {
							jt10.setText(resto/10+"");
							resto=resto%10;
						}else {
							jt10.setText("");
						}
						if(resto >=5 && resto <10) {
							jt5.setText(resto/5+"");
							resto=resto%5;
						}else {
							jt5.setText("");
						}
						if(resto <5) {							
							jt1.setText(resto+"");
							if(resto ==0)
								jt1.setText("");
						}	
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(contentPane, "Ingrese un valor.");
				}				
			}
		};
		return esteMetodo;
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
	
	/**
	 * Create the frame.
	 */
	public Eje1() {
		prepararGUI();
		agregarElementos();		
		controlEvents();		
	}
}
