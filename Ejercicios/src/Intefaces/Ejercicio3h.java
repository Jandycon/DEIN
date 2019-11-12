package Intefaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Ejercicio3h extends JFrame {

	private JPanel contentPane;
	private JLabel lblnum1;
	private JLabel lblnum2;
	private JTextField jtnum1;
	private JTextField jtnum2;
	private JButton btnSumar;
	private JButton btnRestar;
	private JButton btnMultiplicar;
	private JButton btnDividir;
	private JButton btnClean;
	private JTextField jtResult;
	private final String NUMERO="Numero";
	private final String SIGNPLUS="+";
	private final String SIGNREST="-";
	private final String SIGNMULT="x";
	private final String SIGNDIV="/";
	private final String SIGNCLEAN="Limpiar";
	private GridBagLayout gridbag;
	private GridBagConstraints c;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio3h frame = new Ejercicio3h();
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
				
		setTitle("Ejercicio 3h");		
		setBounds(200, 100, 300, 300);
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
	}

	public void agregarElementos() {
		
		//c.gridy = row
		//c.gridx = column
		
		lblnum1 = new JLabel(NUMERO);
		c.ipady = 0;		
		c.gridy = 0;
		c.gridx = 0;
		gridbag.setConstraints(lblnum1, c);
		contentPane.add(lblnum1);
		
		lblnum2 = new JLabel(NUMERO);
		c.ipady = 0;
		c.gridy = 1;
		c.gridx = 0;		
		gridbag.setConstraints(lblnum2, c);
		contentPane.add(lblnum2);
		
		jtnum1 = new JTextField();		
		jtnum1.setColumns(10);
		c.weightx = 0.5;
		c.ipady = 0;
		c.gridy = 0;
		c.gridx = 1;
		gridbag.setConstraints(jtnum1, c);
		contentPane.add(jtnum1);
		
		jtnum2 = new JTextField();
		jtnum2.setColumns(10);
		c.ipady = 0;
		c.gridy = 1;
		c.gridx = 1;		
		gridbag.setConstraints(jtnum2, c);
		contentPane.add(jtnum2);
		
		btnSumar = new JButton(SIGNPLUS);
		c.insets = new Insets(10,0,0,0);
		c.ipady = 0;
		c.gridy = 2;
		c.gridx = 0;
		gridbag.setConstraints(btnSumar, c);
		contentPane.add(btnSumar);
		
		btnRestar = new JButton(SIGNREST);
		c.insets = new Insets(10,0,0,0);
		c.ipady = 0;
		c.gridy = 2;
		c.gridx = 1;		
		gridbag.setConstraints(btnRestar, c);
		contentPane.add(btnRestar);
		
		btnMultiplicar = new JButton(SIGNMULT);
		c.insets = new Insets(10,0,0,0);
		c.ipady = 0;
		c.gridy = 3;
		c.gridx = 0;		
		gridbag.setConstraints(btnMultiplicar, c);
		contentPane.add(btnMultiplicar);
		
		btnDividir = new JButton(SIGNDIV);
		c.insets = new Insets(10,0,0,0);
		c.ipady = 0;
		c.gridy = 3;
		c.gridx = 1;		
		gridbag.setConstraints(btnDividir, c);
		contentPane.add(btnDividir);
		
		btnClean = new JButton(SIGNCLEAN);
		c.insets = new Insets(10,0,0,0);
		c.gridy = 4;
		c.gridx = 0;
		c.gridwidth = 2;
		gridbag.setConstraints(btnClean, c);
		contentPane.add(btnClean);
		
		jtResult = new JTextField();
		jtResult.setColumns(10);
		jtResult.setEditable(false);
		c.insets = new Insets(10,0,0,0);
		c.gridy = 5;
		c.gridx = 0;	
		c.gridwidth = 2;
		gridbag.setConstraints(jtResult, c);
		contentPane.add(jtResult);		
	}
	
	private ActionListener operar(String operacion) {
		
		ActionListener esteMetodo = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int num1= Integer.parseInt(jtnum1.getText());
					int num2= Integer.parseInt(jtnum2.getText());
					switch (operacion) {
					case "sumar":
						jtResult.setText(num1+num2+"");
						break;
					case "restar":
						jtResult.setText(num1-num2+"");
						break;
					case "multiplicar":
						jtResult.setText(num1*num2+"");
						break;
					case "dividir":	
						jtResult.setText(num1/num2+"");
						break;
					case "limpiar":
						jtnum1.setText("");
						jtnum2.setText("");
						jtResult.setText("");
						break;
					}							
				}catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(contentPane, "Los campos no pueden estar vacíos.");
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
	public Ejercicio3h() {
		
		prepararGUI();
		agregarElementos();
		
		jtnum1.addKeyListener(validar());
		jtnum2.addKeyListener(validar());
		btnSumar.addActionListener(operar("sumar"));
		btnRestar.addActionListener(operar("restar"));
		btnMultiplicar.addActionListener(operar("multiplicar"));
		btnDividir.addActionListener(operar("dividir"));
		btnClean.addActionListener(operar("limpiar"));		
	}
}
