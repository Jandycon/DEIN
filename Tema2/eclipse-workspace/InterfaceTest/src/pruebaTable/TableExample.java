package pruebaTable;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class TableExample extends JFrame {

	private JPanel contentPane;
	private JTable jtabla;
	private JScrollPane jscroll;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableExample frame = new TableExample();
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
				
		setTitle("Ejemplo tabla");		
		setSize(500, 150);
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}	

	public void agregarElementos() {
		//cabecera de la tabla
        String[] columns = new String[] {"Id", "Name", "Hourly Rate", "Part Time", "Age", "Sex"};
         
        //datos
        Object[][] data = new Object[][] {
            {1, "John", 40.0, false, 15, "F" },
            {2, "Rambo", 70.0, false, 15, "F" },
            {3, "Zorro", 60.0, true, 25, "F" },
            {4, "John", 40.0, false, 15, "M" },
            {5, "Rambo", 70.0, false, 45, "F" },
            {6, "Zorro", 60.0, true, 15, "M" },
            {7, "John", 40.0, false, 35, "F" },
            {8, "Rambo", 70.0, false, 15, "F" },
            {9, "Zorro", 60.0, true, 15, "M" }
        };
        
        //crear la tabla con los datos
        jtabla = new JTable(data, columns);
        jtabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        jscroll = new JScrollPane(jtabla);
        jscroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jscroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
        jscroll.setPreferredSize(new Dimension(400, 100));        
        
		contentPane.add(jscroll);
	}
	
	/**
	 * Create the frame.
	 */
	public TableExample() {
		prepararGUI();
		agregarElementos();
	}

}
