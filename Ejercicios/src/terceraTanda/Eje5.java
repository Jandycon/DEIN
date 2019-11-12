package terceraTanda;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class Eje5 extends JFrame {

	private JTabbedPane contentPane;
	private JTabbedPane panelTab;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eje5 frame = new Eje5();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void prepararGUI() {			
		contentPane = new JTabbedPane();
		contentPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));				
				
		setTitle("Panel de Pestañas");		
		setBounds(200, 100, 315, 200);
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}	
	
	public void agregarElementos() {
		
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		p1.add(new JLabel("Pestaña del File Manager."));
		
		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		p2.add(new JLabel("Pestaña de Desarrollo."));
		
		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout());
		p3.add(new JLabel("Pestaña de Informes."));
		
		JPanel p4 = new JPanel();
		p4.setLayout(new FlowLayout());
		p4.add(new JLabel("Pestaña de Administración."));
		
		JPanel p5 = new JPanel();
		p5.setLayout(new FlowLayout());
		p5.add(new JLabel("Pestaña de Proyectos"));
		
		contentPane.addTab("File Manager",p1);	
		contentPane.addTab("Desarollo",p2);
		contentPane.addTab("Informes",p3);
		contentPane.addTab("Administración",p4);
		contentPane.addTab("Proyectos",p5);
	}

	/**
	 * Create the frame.
	 */
	public Eje5() {
		prepararGUI();
		agregarElementos();
	}

}
