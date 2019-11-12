package terceraTanda;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Eje6 extends JFrame {

	private JPanel contentPane;
	private JSlider jsbass, jsmid, jstreble, jsbal,jsvol;
	private JRadioButton jradiodefault, jradio1, jradio2;
	private JLabel lbltreble, lblmid, lblbass, lblbal, lblvol;
	private JButton btnsave;
	private ArrayList<JSlider> jsliders;
	private ButtonGroup bgradio;
	private ArrayList<Integer> ldefault, lpreset1, lpreset2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eje6 frame = new Eje6();
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
		contentPane.setLayout(new FlowLayout()); //Flowlayout compuesto por 3 paneles			
				
		setTitle("Reproductor de audio sencillo");		
		setBounds(200, 100, 420, 500);
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}	
	
	public void agregarElementos() {
		
		ldefault = new ArrayList<Integer>();
		cargarDefault(ldefault);
		
		lpreset1 = new ArrayList<Integer>();
		cargarDefault(lpreset1);
		
		lpreset2 = new ArrayList<Integer>();	
		cargarDefault(lpreset2);
		
		jsliders = new ArrayList<JSlider>();		
		
		
		//Primer panel
		GridLayout gridL1 = new GridLayout(5,2);
		gridL1.setVgap(20);
		gridL1.setHgap(0);
		JPanel p1 = new JPanel(gridL1);
		
		jsbass = new JSlider(JSlider.HORIZONTAL,-10,+10,0);  
		jsbass.setName("bass");
		jsbass.setMinorTickSpacing(2);  
		jsbass.setMajorTickSpacing(2);  
		jsbass.setPaintTicks(true);  
		jsbass.setPaintLabels(true);  		
		
		jsmid = new JSlider(JSlider.HORIZONTAL,-10,+10,0);  
		jsmid.setName("mid");
		jsmid.setMinorTickSpacing(2);  
		jsmid.setMajorTickSpacing(2);  
		jsmid.setPaintTicks(true);  
		jsmid.setPaintLabels(true);  
		
		jstreble = new JSlider(JSlider.HORIZONTAL,-10,+10,0);  
		jstreble.setName("treble");
		jstreble.setMinorTickSpacing(2);  
		jstreble.setMajorTickSpacing(2);  
		jstreble.setPaintTicks(true);  
		jstreble.setPaintLabels(true);		
		
		Dictionary<Integer, JLabel> labels = new Hashtable<Integer, JLabel>();
        labels.put(0, new JLabel("L"));
        labels.put(5, new JLabel("Center"));
        labels.put(10, new JLabel("R"));
        
		jsbal = new JSlider(JSlider.HORIZONTAL);  
		jsbal.setName("balance");
		jsbal.setMinimum(0);
		jsbal.setValue(5);
		jsbal.setMaximum(10);
		jsbal.setMinorTickSpacing(5);
		jsbal.setSnapToTicks(true);
		jsbal.setPaintTicks(true);
		jsbal.setPaintLabels(true);
		jsbal.setLabelTable(labels);
		
		jsvol = new JSlider(JSlider.HORIZONTAL,0,+10,0);  
		jsvol.setName("volume");
		jsvol.setMinorTickSpacing(1);  
		jsvol.setMajorTickSpacing(1);  
		jsvol.setPaintTicks(true);  
		jsvol.setPaintLabels(true); 
		
		p1.add(new JLabel("Bass"));
		p1.add(jsbass);	
		p1.add(new JLabel("Midrange"));
		p1.add(jsmid);	
		p1.add(new JLabel("Treble"));
		p1.add(jstreble);	
		p1.add(new JLabel("Balance"));
		p1.add(jsbal);	
		p1.add(new JLabel("Volume"));
		p1.add(jsvol);	
		
		//Panel 2
		GridLayout gridL2 = new GridLayout(1,3);
		gridL2.setVgap(50);
		gridL2.setHgap(50);
		JPanel p2 = new JPanel(gridL2);
		
		jradiodefault = new JRadioButton("Defaults");
		jradiodefault.setSelected(true);
		jradiodefault.setName("radiodefault");
		jradio1 = new JRadioButton("Preset 1");
		jradio1.setName("radio1");
		jradio2 = new JRadioButton("Preset 2");
		jradio2.setName("radio2");
		
		bgradio = new ButtonGroup();
		bgradio.add(jradiodefault);
		bgradio.add(jradio1);
		bgradio.add(jradio2);
		
		p2.add(jradiodefault);
		p2.add(jradio1);
		p2.add(jradio2);		
		
		//Panel 3
		GridLayout gridL3 = new GridLayout(5,2);
		gridL3.setHgap(30);
		JPanel p3 = new JPanel(gridL3);
		
		btnsave = new JButton("Guardar selección");
		
		lbltreble = new JLabel("Treble +0");
		lblmid = new JLabel("Midrange +0");
		lblbass = new JLabel("Bass +0");
		lblbal = new JLabel("Balance +0");
		lblvol = new JLabel("Volume +0");
		
		p3.add(new JLabel());
		p3.add(lbltreble);
		p3.add(new JLabel());
		p3.add(lblmid);
		p3.add(btnsave);
		p3.add(lblbass);
		p3.add(new JLabel());
		p3.add(lblbal);
		p3.add(new JLabel());
		p3.add(lblvol);		
		
		jsliders.add(jsbass);
		jsliders.add(jsmid);
		jsliders.add(jstreble);
		jsliders.add(jsbal);
		jsliders.add(jsvol);
		
		contentPane.add(p1);
		contentPane.add(p2);
		contentPane.add(p3);
	}
	
	public void controlEvents() {
		for (int i = 0; i < jsliders.size(); i++) {
			jsliders.get(i).addChangeListener(controlSlider());
		}
		
		jradiodefault.addActionListener(controlRadios());
		jradio1.addActionListener(controlRadios());
		jradio2.addActionListener(controlRadios());
		
		btnsave.addActionListener(guardarCambios());
	}
	
	//Metodo del boton Guardar
	public ActionListener guardarCambios() {
		ActionListener esteMetodo = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jradiodefault.isSelected()) {
					sobreEscribir(ldefault);
				}else {
					if(jradio1.isSelected()) {
						sobreEscribir(lpreset1);
					}else {
						sobreEscribir(lpreset2);
					}
				}
			}
		};
		return esteMetodo;
	}
	
	//Metodo para cargar los datos de los presets
	public ActionListener controlRadios() {
		ActionListener esteMetodo = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JRadioButton esteJR = (JRadioButton) e.getSource();
				String nomComp = esteJR.getName();		
				switch (nomComp) {
				case "radiodefault":						
						mostrarCambios(ldefault); 
					break;
				case "radio1":
						mostrarCambios(lpreset1);
					break;
				case "radio2":
						mostrarCambios(lpreset2);
					break;
				}
			}
		};
		return esteMetodo;
	}
	
	//Metodo para reflejar los cambios en los jsliders al toquetear
	public ChangeListener controlSlider() {
		ChangeListener esteMetodo = new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider esteJS = (JSlider) e.getSource();
				String nomComp = esteJS.getName();	
				int val = esteJS.getValue();
				switch (nomComp) {
				case "bass":
						lblbass.setText("Bass: "+val);
					break;
				case "mid":
						lblmid.setText("Midrange: "+val);
					break;
				case "treble":
						lbltreble.setText("Treble: "+val);
					break;
				case "balance":
						lblbal.setText("Balance: "+parseValueFromBalance(val));
					break;
				case "volume":
						lblvol.setText("Volume: "+val);
					break;
				}
			}
		};
		return esteMetodo;
	}
	
	//Metodo para actualizar los cambios de cada una de las lista de los preset
	private void sobreEscribir(ArrayList<Integer> listaPreset) {
		listaPreset.clear();
		listaPreset.add(jsbass.getValue());
		listaPreset.add(jsmid.getValue());
		listaPreset.add(jstreble.getValue());
		listaPreset.add(jsbal.getValue());
		listaPreset.add(jsvol.getValue());
	}
	
	//Carga todo los preset con valores por defecto
	private void cargarDefault(ArrayList<Integer> listaPreset) {
		listaPreset.add(0);
		listaPreset.add(0);
		listaPreset.add(0);
		listaPreset.add(5);
		listaPreset.add(0);	
	}
	
	//coge el valor del jslider balance y lo transforma en un string -left, center o right
	private String parseValueFromBalance(int num) {
		String cadena = "";		
		switch (num) {
		case 0:
			cadena="Left";
			break;
		case 10:
			cadena="Right";
			break;
		default:
			cadena="Center";
			break;
		}
		return cadena;
	}
	
	//carga los valores almacenados, asociados a los radiobuttons
	private void mostrarCambios(ArrayList<Integer> listaPreset) {
		jsbass.setValue(listaPreset.get(0));
		jsmid.setValue(listaPreset.get(1));
		jstreble.setValue(listaPreset.get(2));
		jsbal.setValue(listaPreset.get(3));
		jsvol.setValue(listaPreset.get(4));
		
		lblbass.setText("Bass: "+listaPreset.get(0));
		lblmid.setText("Midrange: "+listaPreset.get(1));
		lbltreble.setText("Treble: "+listaPreset.get(2));
		lblbal.setText("Balance: "+parseValueFromBalance(listaPreset.get(3)));
		lblvol.setText("Volume: "+listaPreset.get(4));		
	}
	
	/**
	 * Create the frame.
	 */
	public Eje6() {
		prepararGUI();
		agregarElementos();
		controlEvents();
	}

}
