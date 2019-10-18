package terceraTanda;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

public class Eje4 extends JFrame {

	private JPanel contentPane;
	private ArrayList<JRadioButton> jradios;
	private	JRadioButton jradio1, jradio2, jradio3;
	private ArrayList<JCheckBox> jchecks;
	private JCheckBox jcheck1, jcheck2, jcheck3;
	private JTextField jtentrada;
	private String[] items = new String[] {"Item 1", "Item 2", "Item 3", "Item 4"};
	private JComboBox<String> jcombo;
	private JSpinner jspinner;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eje4 frame = new Eje4();
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
		contentPane.setLayout(new GridLayout(3,3)); 			
				
		setTitle("Imitador");		
		setBounds(200, 100, 450, 200);
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}	
	
	public void agregarElementos() {
		jradios = new ArrayList<JRadioButton>();		
		jradio1 = new JRadioButton("Opcion 1");
		jradio2 = new JRadioButton("Opcion 2");
		jradio3 = new JRadioButton("Opcion 3");		
		jradios.add(jradio1);
		jradios.add(jradio2);
		jradios.add(jradio3);
		
		jchecks = new ArrayList<JCheckBox>();		
		jcheck1 = new JCheckBox("Opcion 4");
		jcheck2 = new JCheckBox("Opcion 5");
		jcheck3 = new JCheckBox("Opcion 6");		
		jchecks.add(jcheck1);
		jchecks.add(jcheck2);
		jchecks.add(jcheck3);
		
		jtentrada = new JTextField();
		jtentrada.setPreferredSize(new Dimension(120, 20));
		JPanel p1= new JPanel(new FlowLayout());
		p1.add(jtentrada);
		
		jcombo = new JComboBox<String>(items);
		jcombo.setPreferredSize(new Dimension(120, 20));
		JPanel p2= new JPanel(new FlowLayout());
		p2.add(jcombo);
		
		// SpinnerNumberModel(int value, int minimum, int maximum, int stepSize)
	    SpinnerModel model = new SpinnerNumberModel(5, 0, 10, 1);	 
	    jspinner = new JSpinner(model);
	    jspinner.setPreferredSize(new Dimension(120, 20));
	    JPanel p3= new JPanel(new FlowLayout());
	    p3.add(jspinner);	    
		
		contentPane.add(jradio1);
		contentPane.add(jcheck1);
		contentPane.add(p1);
		
		contentPane.add(jradio2);
		contentPane.add(jcheck2);
		contentPane.add(p2);
		
		contentPane.add(jradio3);
		contentPane.add(jcheck3);
		contentPane.add(p3);		
		
	}
	
	public void controlEvents() {
		
	}
		

	/**
	 * Create the frame.
	 */
	public Eje4() {
		prepararGUI();
		agregarElementos();
		controlEvents();
	}

}
