package SegundaTanda;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

public class Eje3a extends JFrame {

	private JPanel contentPane;
	private GridBagLayout gridbag;
	private GridBagConstraints c;
	private JList<String> jlLista;
	private String[] listEle = { "Winesap","Cortland","Red Delicious", 
            "Golden Delicious","Gala","Winesap Delicious","Sunday"};  ;
    private JScrollPane jsScroll;
    private JButton btnComprar;
    private JLabel lblMsj;
    private final String MSJ="Selección actual: ";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eje3a frame = new Eje3a();
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
				
		setTitle("JList Demo");		
		setBounds(200, 100, 250, 200);
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}	
	
	public void agregarElementos() {	
		
		jlLista = new JList<String>(listEle);
		jlLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jsScroll = new JScrollPane(jlLista);
		c.ipady = 60;
		c.ipadx = 125;
		c.gridy = 0;
		c.gridx = 0;
		c.insets = new Insets(2,2,2,2);
		gridbag.setConstraints(jsScroll, c);
		contentPane.add(jsScroll);	
		
		btnComprar = new JButton("Buy Apple");
		c.ipady = 0;
		c.ipadx = 0;
		c.gridy = 1;
		c.gridx = 0;
		c.insets = new Insets(2,2,2,2);
		gridbag.setConstraints(btnComprar, c);
		contentPane.add(btnComprar);	
		
		lblMsj = new JLabel(MSJ);
		c.ipady = 0;
		c.ipadx = 0;
		c.gridy = 2;
		c.gridx = 0;
		c.insets = new Insets(2,2,2,2);
		gridbag.setConstraints(lblMsj, c);
		contentPane.add(lblMsj);
		
	}
	
	public void controlarEvents() {
		btnComprar.addActionListener(comprar());
	}
	
	private ActionListener comprar() {
		ActionListener esteMetodo = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblMsj.setText(MSJ+jlLista.getSelectedValue());
			}
		};
		return esteMetodo;
	}
	
	/**
	 * Create the frame.
	 */
	public Eje3a() {
		prepararGUI();
		agregarElementos();
		controlarEvents();
	}

}
