package terceraTanda;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

public class Eje2 extends JFrame {

	private JPanel contentPane;
	private ArrayList<JCheckBox> jboxes;
	private JCheckBox jbox1, jboxvelocity,jboxsize,jboxdebug;
	private JLabel lblchange, lblselected, lblopciones;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eje2 frame = new Eje2();
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
		contentPane.setLayout(new GridLayout(7,1)); 			
				
		setTitle("Cajas de Texto");		
		setBounds(200, 100, 450, 200);
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}	
	
	public void agregarElementos() {

		jboxes= new ArrayList<JCheckBox>();
				
		jbox1 = new JCheckBox("Habilita opciones");
		jboxvelocity = new JCheckBox("Mayor velocidad");
		jboxvelocity.setEnabled(false);
		jboxsize = new JCheckBox("Menor tamaño");
		jboxsize.setEnabled(false);
		jboxdebug = new JCheckBox("Debug");
		jboxdebug.setEnabled(false);
		
		jboxes.add(jbox1);
		jboxes.add(jboxvelocity);		
		jboxes.add(jboxsize);
		jboxes.add(jboxdebug);		
		
		lblopciones = new JLabel("Opciones:");
		lblchange = new JLabel("Cambiar selección: ");
		lblselected = new JLabel("Opciones seleccionadas: ");
				
		contentPane.add(jbox1);
		contentPane.add(lblopciones);		 
		contentPane.add(jboxvelocity);	 
		contentPane.add(jboxsize);		 
		contentPane.add(jboxdebug);		 
		contentPane.add(lblchange);		
		contentPane.add(lblselected);		
	}	
	
	public void controlEvents() {
		for (int i = 0; i < jboxes.size(); i++) {
			jboxes.get(i).addItemListener(controlBoxes());
		}
	}
	
	public ItemListener controlBoxes() {
		ItemListener esteMetodo = new ItemListener() {
			public void itemStateChanged(ItemEvent e) {	
				String msj="Opciones seleccionadas: ";
				JCheckBox ch = (JCheckBox) e.getItem();		
				
				switch (ch.getText()) {
				case "Habilita opciones":
					if (e.getStateChange() == ItemEvent.SELECTED) {
			        	jboxvelocity.setEnabled(true);
					 	jboxsize.setEnabled(true);
					 	jboxdebug.setEnabled(true);
			        }else {
			        	lblchange.setText("Cambiar selección: ");
			        	jboxvelocity.setEnabled(false);
					 	jboxsize.setEnabled(false);
					 	jboxdebug.setEnabled(false);
			        }
					break;
				default:
					if (e.getStateChange() == ItemEvent.SELECTED) {
						lblchange.setText("Cambiar selección: "+ch.getText()+" selecionado.");
					}else {
						lblchange.setText("Cambiar selección: "+ch.getText()+" deseleccionado.");;
					}	
					break;
				}

				for (int i = 0; i < jboxes.size(); i++) {
					if(jboxes.get(i).isSelected()){
						switch (jboxes.get(i).getText()) {
						case "Mayor velocidad":
							msj+="Velocidad"+" ";
							break;
						case "Menor tamaño":
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
	public Eje2() {
		prepararGUI();
		agregarElementos();
		controlEvents();
	}

}
