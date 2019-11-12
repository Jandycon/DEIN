package Intefaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

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

public class Ejercicio3g extends JFrame {

	private JPanel contentPane;
	private JPanel lc;
	private JLabel lblEso;
	private JRadioButton rbtnW;
	private JRadioButton rbtnL;
	private JRadioButton rbtnM;	
	private JLabel lblEte;
	private JCheckBox boxProg;
	private JCheckBox boxDG;
	private JCheckBox boxAdmin;
	private JLabel lblHoras;
	private JLabel numHoras;
	private JSlider slideH;
	private JButton btnGenerar;	
	private JSeparator separator1;
	private JSeparator separator2;
	private ArrayList<JCheckBox> checkboxes;
	private ArrayList<JRadioButton> radiobuttons;
	private int MIN=0;
	private int MAX=10;
	private int DEFECTO=10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio3g frame = new Ejercicio3g();
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
		contentPane.setLayout(new GridLayout(13,1));			
				
		setTitle("Formulario");		
		setBounds(200, 100, 300, 700);
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
	}
	
	public void agregarElementos() {
				
		lblEso = new JLabel("Elige un sistema operativo");
		
		rbtnW = new JRadioButton("Windows");
		rbtnL = new JRadioButton("Linux");		
		rbtnM = new JRadioButton("Mac",true);			
		
		separator1 = new JSeparator();
		separator2 = new JSeparator();
		
		lblEte = new JLabel("Elige tu especialidad");
		
		boxProg = new JCheckBox("Programación",true);		
		boxDG = new JCheckBox("Diseño gráfico");		
		boxAdmin = new JCheckBox("Administración");
				
		lblHoras = new JLabel("Horas que dedicas en el ordenador");		
		numHoras = new JLabel("10");		
		slideH = new JSlider(MIN,MAX,DEFECTO);		
		
		btnGenerar = new JButton("Generar");
		btnGenerar.setBorder(new RoundedBorder(6));
				
		lc = new JPanel();
		lc.setLayout(new FlowLayout(2));
		lc.add(numHoras);
		lc.add(slideH);		
		
		contentPane.add(lblEso);
		contentPane.add(rbtnW);
		contentPane.add(rbtnL);
		contentPane.add(rbtnM);
		contentPane.add(separator1);
		contentPane.add(lblEte);
		contentPane.add(boxProg);
		contentPane.add(boxDG);
		contentPane.add(boxAdmin);
		contentPane.add(separator2);
		contentPane.add(lblHoras);
		contentPane.add(lc);
		contentPane.add(btnGenerar);			
	}
	
	//Metodos utilizados para cada evento
	
	private MouseMotionListener updateLabel() {		
		MouseMotionListener esteMetodo = new MouseMotionListener() {		
			public void mouseMoved(MouseEvent arg0) {}			
			public void mouseDragged(MouseEvent arg0) {
				numHoras.setText(slideH.getValue()+"");
			}			
		};		
		return esteMetodo;	
	}
	
	private MouseListener updateLbl() {
		MouseListener esteMetodo = new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				numHoras.setText(slideH.getValue()+"");
		    }
		};
		return esteMetodo;
	}
	
	private ActionListener generar() {
		ActionListener esteMetodo = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(contentPane, msjPopUp(), "Muestra de datos", JOptionPane.INFORMATION_MESSAGE);
			}
		};
		return esteMetodo;		
	}
	
	private String msjPopUp() {
				
		String cadena;
		
		cadena ="Tu sistema operativo preferido es ";		
		boolean selectedRadio = false;
		for(int i=0; i<radiobuttons.size();i++) {
			JRadioButton each = radiobuttons.get(i);
			if(each.isSelected()) {
				cadena+=each.getText()+", ";
				selectedRadio = true;
			}
		}		
		if(selectedRadio == false) {
			cadena+=" ninguno,";
		}
				
		cadena+="\ntus especialidades son ";
		boolean selectedBox = false;		
		for (int i=0; i<checkboxes.size();i++) {
			JCheckBox each = checkboxes.get(i);
			if(each.isSelected()) {
				cadena+=each.getText()+", ";
				selectedBox=true;
			}			
		}
		if(selectedBox == false) {
			cadena+=" ninguno";
		}
		
		cadena+= "\ny el numero de horas dedicadas al ordenador son "+slideH.getValue();
		
		return cadena;
	}
	
	/**
	 * Create the frame.
	 */
	public Ejercicio3g() {
		
		prepararGUI();
		agregarElementos();	
		
		checkboxes = new ArrayList<JCheckBox>();
		
		checkboxes.add(boxProg);
		checkboxes.add(boxDG);
		checkboxes.add(boxAdmin);
		
		radiobuttons = new ArrayList<JRadioButton>();
		
		radiobuttons.add(rbtnW);
		radiobuttons.add(rbtnL);
		radiobuttons.add(rbtnM);
		
		slideH.addMouseMotionListener(updateLabel());
		slideH.addMouseListener(updateLbl());
		btnGenerar.addActionListener(generar());			
	}
}
