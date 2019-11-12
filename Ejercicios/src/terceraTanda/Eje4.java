package terceraTanda;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Eje4 extends JFrame {

	private JPanel contentPane;
	private ArrayList<JRadioButton> jradios, jradios2;
	private	JRadioButton jradio1, jradio2, jradio3, jradio11, jradio22, jradio33;
	private ArrayList<JCheckBox> jchecks, jchecks2;
	private JCheckBox jcheck1, jcheck2, jcheck3, jcheck11, jcheck22, jcheck33;
	private JTextField jtentrada, jtentrada2;
	private String[] items = new String[] {"Item 1", "Item 2", "Item 3", "Item 4"};
	private JComboBox<String> jcombo, jcombo2;
	private JSpinner jspinner, jspinner2;
	
	
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
		contentPane.setLayout(new GridLayout(9,6)); 			
				
		setTitle("Imitador");		
		setBounds(200, 100, 450, 500);
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}	
	
	public void agregarElementos() {
		
		JLabel lbl1 = new JLabel("Original");
		contentPane.add(lbl1);
		JLabel lbl11 = new JLabel("");
		contentPane.add(lbl11);
		JLabel lbl111 = new JLabel("");
		contentPane.add(lbl111);
		
		jradios = new ArrayList<JRadioButton>();		
		jradio1 = new JRadioButton("Opcion 1");
		jradio2 = new JRadioButton("Opcion 2");
		jradio3 = new JRadioButton("Opcion 3");		
		jradios.add(jradio1);
		jradios.add(jradio2);
		jradios.add(jradio3);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(jradio1);
		bg.add(jradio2);
		bg.add(jradio3);
		
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
	    jspinner.setEditor(new JSpinner.DefaultEditor(jspinner));
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
		
		JSeparator s = new JSeparator();   
        s.setOrientation(SwingConstants.HORIZONTAL); 
        contentPane.add(s);
        JSeparator s1 = new JSeparator();   
        s.setOrientation(SwingConstants.HORIZONTAL); 
        contentPane.add(s1);
        JSeparator s2 = new JSeparator();   
        s.setOrientation(SwingConstants.HORIZONTAL); 
        contentPane.add(s2);
		//Imitador
		
        JLabel lbl2 = new JLabel("Espejo");
		contentPane.add(lbl2);
		JLabel lbl22 = new JLabel("");
		contentPane.add(lbl22);
		JLabel lbl222 = new JLabel("");
		contentPane.add(lbl222);
		
		jradios2 = new ArrayList<JRadioButton>();
		jradio11 = new JRadioButton("Opcion 1");
		jradio22 = new JRadioButton("Opcion 2");
		jradio33 = new JRadioButton("Opcion 3");	
		
		jradios2.add(jradio11);
		jradios2.add(jradio22);
		jradios2.add(jradio33);
		
		jchecks2 = new ArrayList<JCheckBox>();		
		jcheck11 = new JCheckBox("Opcion 4");
		jcheck22 = new JCheckBox("Opcion 5");
		jcheck33 = new JCheckBox("Opcion 6");		
		jchecks2.add(jcheck11);
		jchecks2.add(jcheck22);
		jchecks2.add(jcheck33);
		
		jtentrada2 = new JTextField();
		jtentrada2.setEnabled(false);
		jtentrada2.setPreferredSize(new Dimension(120, 20));
		JPanel p4= new JPanel(new FlowLayout());
		p4.add(jtentrada2);
		
		jcombo2 = new JComboBox<String>(items);
		jcombo2.setEnabled(false);
		jcombo2.setPreferredSize(new Dimension(120, 20));
		JPanel p5= new JPanel(new FlowLayout());
		p5.add(jcombo2);
		
		// SpinnerNumberModel(int value, int minimum, int maximum, int stepSize)
	    SpinnerModel model2 = new SpinnerNumberModel(5, 0, 10, 1);	 
	    jspinner2 = new JSpinner(model2);
	    jspinner2.setEnabled(false);
	    jspinner2.setPreferredSize(new Dimension(120, 20));
	    JPanel p6= new JPanel(new FlowLayout());
	    p6.add(jspinner2);	    
			    	    
		contentPane.add(jradio11);
		contentPane.add(jcheck11);
		contentPane.add(p4);
		
		contentPane.add(jradio22);
		contentPane.add(jcheck22);
		contentPane.add(p5);
		
		contentPane.add(jradio33);
		contentPane.add(jcheck33);
		contentPane.add(p6);					
	}
	
	public void controlEvents() {
		
		for (int i = 0; i < jradios2.size(); i++) {
			JRadioButton each = jradios2.get(i);
			each.setEnabled(false);				
		}
		
		for (int i = 0; i < jchecks2.size(); i++) {
			JCheckBox each = jchecks2.get(i);
			each.setEnabled(false);				
		}		
		
		for (int i = 0; i < jradios.size(); i++) {
			jradios.get(i).addActionListener(actualizar());			
		}
		
		for (int i = 0; i < jchecks.size(); i++) {
			jchecks.get(i).addActionListener(actualizar());
		}
		
		jtentrada.addKeyListener(copiarTexto());
		jcombo.addActionListener(controlCombo());
		jspinner.addChangeListener(controlSpinner());
	}
	
	private ActionListener controlCombo() {
		ActionListener esteMetodo = new  ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				JComboBox comboBox = (JComboBox) e.getSource();
				jcombo2.setSelectedItem(comboBox.getSelectedItem());
			}
		};
		return esteMetodo;
	}
	
	private ChangeListener controlSpinner() {
		ChangeListener esteMetodo = new ChangeListener() {	
			public void stateChanged(ChangeEvent e) {
				JSpinner esteSpinner = (JSpinner) e.getSource();
				jspinner2.setValue(esteSpinner.getValue());
			}
		};
		return esteMetodo;
	}
	
	private KeyListener copiarTexto() {
		KeyListener esteMetodo = new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
				jtentrada2.setText(jtentrada.getText().toString());				
			}
		};
		return esteMetodo;
	}
	
	private ActionListener actualizar() {
		ActionListener esteMetodo = new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < jradios.size(); i++) {
					JRadioButton each=jradios.get(i);
					if(each.isSelected()) {
						jradios2.get(i).setSelected(true);
					}else {
						jradios2.get(i).setSelected(false);
					}
				}
				
				for (int i = 0; i < jchecks.size(); i++) {
					JCheckBox each=jchecks.get(i);
					if(each.isSelected()) {
						jchecks2.get(i).setSelected(true);
					}else {
						jchecks2.get(i).setSelected(false);
					}
				}		
			}
		};
		return esteMetodo;		
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
