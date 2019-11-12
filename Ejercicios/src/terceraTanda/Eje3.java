package terceraTanda;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class Eje3 extends JFrame {

	private JPanel contentPane;
	private ArrayList<JRadioButton> jradios;
	private JCheckBox jboxopciones;
	private JLabel lblopciones, lblselected;
	private JRadioButton jradio1, jradio2, jradio3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eje3 frame = new Eje3();
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
		contentPane.setLayout(new GridLayout(6,1)); 			
				
		setTitle("Radio Buttons");		
		setBounds(200, 100, 450, 200);
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}	
	
	public void agregarElementos() {
		jradios = new ArrayList<JRadioButton>();	
		
		jboxopciones = new JCheckBox("Habilitar opciones");
		
		jradio1 = new JRadioButton("Maximice Velocidad");
		jradio1.setEnabled(false);
		jradio2 = new JRadioButton("Minimice Tamaño");
		jradio2.setEnabled(false);
		jradio3 = new JRadioButton("Debug");
		jradio3.setEnabled(false);
		
		jradios.add(jradio1);
		jradios.add(jradio2);
		jradios.add(jradio3);
		
		lblopciones = new JLabel("Elige opción:");
		lblselected = new JLabel("Opción seleccionada:");
		
		contentPane.add(jboxopciones);
		contentPane.add(lblopciones);
		contentPane.add(jradio1);
		contentPane.add(jradio2);
		contentPane.add(jradio3);
		contentPane.add(lblselected);		
	}
	
	public void controlEvents() {
		jboxopciones.addItemListener(controladorCheckBox());
		
		for (int i = 0; i < jradios.size(); i++) {
			jradios.get(i).addItemListener(controladorRadio());
		}
	}
	
	public ItemListener controladorCheckBox() {
		ItemListener esteMetodo = new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				JCheckBox ch = (JCheckBox) e.getItem();		
				if (e.getStateChange() == ItemEvent.SELECTED) {
			        jradio1.setEnabled(true);
			        jradio2.setEnabled(true);
			        jradio3.setEnabled(true);
			    }else {
			        jradio1.setEnabled(false);
			        jradio2.setEnabled(false);
			        jradio3.setEnabled(false);
			    }
			}
		};
		return esteMetodo;
	}
	
	public ItemListener controladorRadio() {
		ItemListener esteMetodo = new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String msj ="Opcion seleccionada: ";		
				for (int i = 0; i < jradios.size(); i++) {
					if(jradios.get(i).isSelected()){
						switch (jradios.get(i).getText()) {
						case "Maximice Velocidad":
							msj+="Velocidad"+" ";
							break;
						case "Minimice Tamaño":
							msj+="Tamaño"+" ";
							break;
						case "Debug":
							msj+="Debug"+" ";
							break;
						}
					}
				}
				lblselected.setText(msj);
			}
		};
		return esteMetodo;
	}
	
	
	
	/**
	 * Create the frame.
	 */
	public Eje3() {
		prepararGUI();
		agregarElementos();
		controlEvents();
	}

}
