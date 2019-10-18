package terceraTanda;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class Eje1 extends JFrame {

	private JPanel contentPane, paneldatos, panelsexo, panellistado;
	private GridBagLayout gridbagPadre, gridbag;
	private GridBagConstraints c, cPadre;
	private JLabel lblapepat, lblapemat, lblnombre, lblestado;
	private JTextField txtapepat, txtapemat, txtnombre;
	private JComboBox<String> estadosCombo;
	private JRadioButton radioMale, radioFemale;
	private JButton btnSave, btnExit;
	private JTextArea jtArea;
	private String [] estados = {"casado","divorciado","viudo","soltero"};
	private String txtListado;
	private JScrollPane jscroll;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eje1 frame = new Eje1();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void prepararGUI() {		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));		
		gridbagPadre = new GridBagLayout();		
		cPadre = new GridBagConstraints();		
		contentPane.setLayout(gridbagPadre);
		cPadre.fill = GridBagConstraints.VERTICAL; 			
				
		setTitle("Datos Personales");		
		setBounds(200, 100, 530, 620);
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}	
	
	public void agregarElementos() {
		
		//BORDERS
		//https://docs.oracle.com/javase/tutorial/uiswing/components/border.html
		//http://www.java2s.com/Code/Java/Swing-JFC/TitledBorder.htm
		//https://www.codejava.net/java-se/swing/jcombobox-basic-tutorial-and-examples
		
		//c.gridy = row
		//c.gridx = column	
		txtListado = "";
		gridbag = new GridBagLayout();
		c= new GridBagConstraints();
		
		TitledBorder leftBorder = BorderFactory.createTitledBorder("Datos Personales");
	    leftBorder.setTitleJustification(TitledBorder.LEFT);
	    leftBorder.setTitlePosition(TitledBorder.ABOVE_TOP);
	    	    
		//PANEL DATOS	    
		paneldatos = new JPanel();
	    paneldatos.setLayout(gridbag);
	    paneldatos.setBorder(leftBorder);
	    cPadre.ipady = 0;
	    cPadre.ipadx = 0;
	    cPadre.gridy = 0;
	    cPadre.gridx = 0;
	    cPadre.insets = new Insets(10,10,10,10);
		gridbagPadre.setConstraints(paneldatos, cPadre);
		
	    lblapepat = new JLabel("Apellido Paterno:");		
		c.ipady = 0;
		c.ipadx = 30;
		c.gridy = 0;
		c.gridx = 0;
		c.insets = new Insets(10,10,10,10);
		gridbag.setConstraints(lblapepat, c);
		
		lblapemat = new JLabel("Apellido Materno:");
		c.ipady = 0;
		c.ipadx = 30;
		c.gridy = 1;
		c.gridx = 0;
		c.insets = new Insets(10,10,10,10);
		gridbag.setConstraints(lblapemat, c);
		
		lblnombre = new JLabel("Nombre:");
		c.ipady = 0;
		c.ipadx = 30;
		c.gridy = 2;
		c.gridx = 0;
		c.insets = new Insets(10,10,10,10);
		gridbag.setConstraints(lblnombre, c);
		
		lblestado = new JLabel("Estado Civil:");
		c.ipady = 0;
		c.ipadx = 30;
		c.gridy = 3;
		c.gridx = 0;
		c.insets = new Insets(10,10,10,10);
		gridbag.setConstraints(lblestado, c);
		
		txtapepat = new JTextField();
		c.ipady = 0;
		c.ipadx = 300;
		c.gridy = 0;
		c.gridx = 1;
		c.insets = new Insets(10,10,10,10);
		gridbag.setConstraints(txtapepat, c);
		
		txtapemat = new JTextField();
		c.ipady = 0;
		c.ipadx = 300;
		c.gridy = 1;
		c.gridx = 1;
		c.insets = new Insets(10,10,10,10);
		gridbag.setConstraints(txtapemat, c);
		
		txtnombre = new JTextField();
		c.ipady = 0;
		c.ipadx = 300;
		c.gridy = 2;
		c.gridx = 1;
		c.insets = new Insets(10,10,10,10);
		gridbag.setConstraints(txtnombre, c);
		
		estadosCombo = new JComboBox<String>(estados);		
		c.ipady = 0;
		c.ipadx = 0;
		c.gridy = 3;
		c.gridx = 1;		
		c.insets = new Insets(10,10,10,10);
	    c.anchor = GridBagConstraints.SOUTHWEST;
		gridbag.setConstraints(estadosCombo, c);
		
		TitledBorder leftBorder2 = BorderFactory.createTitledBorder("Sexo");
	    leftBorder2.setTitleJustification(TitledBorder.LEFT);
	    leftBorder2.setTitlePosition(TitledBorder.ABOVE_TOP);
		panelsexo = new JPanel();
		panelsexo.setLayout(new FlowLayout());
		panelsexo.setBorder(leftBorder2);	    
		c.ipady = 0;
		c.ipadx = 100;
		c.gridy = 4;
		c.gridx = 1;
		c.insets = new Insets(10,10,10,10);
		gridbag.setConstraints(panelsexo, c);
					
		radioMale = new JRadioButton("Masculino");
		radioMale.setSelected(true);
		radioFemale = new JRadioButton("Femenino");
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(radioMale);
		buttonGroup.add(radioFemale);
		
		//agregar al panel sexo
		panelsexo.add(radioMale);
		panelsexo.add(radioFemale);		
						
		//agregar al panel de datos
	    paneldatos.add(lblapepat);
	    paneldatos.add(lblapemat);
	    paneldatos.add(lblnombre);
	    paneldatos.add(lblestado);
	    paneldatos.add(txtapepat);
	    paneldatos.add(txtapemat);
	    paneldatos.add(txtnombre);
	    paneldatos.add(estadosCombo);
	    paneldatos.add(panelsexo);
	    
	    //PANEL DEL MEDIO
	    btnSave = new JButton("Guardar");
	    cPadre.ipady = 0;
	    cPadre.ipadx = 0;
	    cPadre.gridy = 1;
	    cPadre.gridx = 0;
	    cPadre.insets = new Insets(10,10,10,10);
	    cPadre.anchor = GridBagConstraints.SOUTHWEST;
		gridbagPadre.setConstraints(btnSave, cPadre);
		
	    btnExit = new JButton("Salir");
	    cPadre.ipady = 0;
	    cPadre.ipadx = 0;
	    cPadre.gridy = 1;
	    cPadre.gridx = 0;
	    cPadre.insets = new Insets(10,10,10,10);;
	    cPadre.anchor = GridBagConstraints.NORTHEAST;
		gridbagPadre.setConstraints(btnExit, cPadre);	
	    	
		TitledBorder leftBorder3 = BorderFactory.createTitledBorder("Listado");
	    leftBorder3.setTitleJustification(TitledBorder.LEFT);
	    leftBorder3.setTitlePosition(TitledBorder.ABOVE_TOP);
	    GridBagLayout gridlistado = new GridBagLayout();
	    
		panellistado = new JPanel();		
		panellistado.setBorder(leftBorder3);
		panellistado.setLayout(gridlistado);		
		cPadre.ipady = 0;
	    cPadre.ipadx = 0;
	    cPadre.gridy = 2;
	    cPadre.gridx = 0;
	    cPadre.insets = new Insets(10,10,10,10);;
		gridbagPadre.setConstraints(panellistado, cPadre);
				
		Border loweredBorder = new EtchedBorder(EtchedBorder.LOWERED);		
		jtArea = new JTextArea();
		jtArea.setBorder(loweredBorder);
		jtArea.setEditable(false);
		jscroll = new JScrollPane(jtArea);				
		c.ipady = 200;
		c.ipadx = 460;
		c.gridy = 0;
		c.gridx = 0;
		c.insets = new Insets(10,10,10,10);
		gridlistado.setConstraints(jscroll, c);		
		panellistado.add(jscroll);		
				
	    //Contenedor principal
	    contentPane.add(paneldatos);	
	    contentPane.add(btnSave);	
	    contentPane.add(btnExit);
	    contentPane.add(panellistado);	    
	}

	public void controlarEvents() {
		txtapemat.addKeyListener(validarLetra());
		txtapepat.addKeyListener(validarLetra());
		txtnombre.addKeyListener(validarLetra());
		btnSave.addActionListener(guardar());
		btnExit.addActionListener(salir());
	}
	
	public ActionListener guardar() {
		ActionListener esteMetodo = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String apepat = txtapepat.getText();
				String apemat = txtapemat.getText();				
				String nombre = txtnombre.getText();
				
				if(apepat.equals("") || apemat.equals("") || nombre.equals("")) {
					JOptionPane.showMessageDialog(contentPane, "Algunos de los campos estan vacíos");
				}else {
					String esteEstado = estadosCombo.getSelectedItem().toString();
					String esteSexo = "";
					
					if(radioMale.isSelected()) {
						esteSexo="Masculino";
					}else {
						esteSexo="Femenino";
					}
					
					txtListado+=apepat+" ";
					txtListado+=apemat+" ";
					txtListado+=nombre+" ";
					txtListado+=esteEstado+" ";
					txtListado+=esteSexo+"\n";
					
					jtArea.setText(txtListado);
				}
			}
		};
		return esteMetodo;
	}
	
	public ActionListener salir() {
		ActionListener esteMetodo = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		};
		return esteMetodo;
	}
	
	public KeyListener validarLetra() {
		KeyListener esteMetodo = new KeyAdapter() {
			public void keyTyped(KeyEvent evt) {				
				if(!Character.isLetter(evt.getKeyChar()) && !(evt.getKeyChar()==KeyEvent.VK_SPACE) && !(evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)){
			        evt.consume();
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
		controlarEvents();
	}
}
