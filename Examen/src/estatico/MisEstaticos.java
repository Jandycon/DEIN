package estatico;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class MisEstaticos {
	
	public static final String DIRIMG= System.getProperty("user.dir")+"/imagenes/";
	public static final Icon IMGMERCADO = new ImageIcon(MisEstaticos.DIRIMG+"supermercado.jpeg");
	public static final String [] SECCIONES = {"","FRUTERIA","CHARCUTERIA", "CARNICERIA", "COSMETICOS","PESCADERIA","PANADERIA"};
	public static final String [] ESTANTERIAS = {"","PASILLO CENTRAL","LATERAL IZQUIERDO", "PLANTA 2", "PASILLO CENTRAL"};
	
	public static JScrollPane scrollForPanel(JTable jtabla, int largo, int altura) {
		JScrollPane esteScroll = new JScrollPane(jtabla);
		esteScroll.setBorder(null);
		esteScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		esteScroll.setPreferredSize(new Dimension(largo,altura));		
		return esteScroll;
	}
	
	public static JTable tablaForPanel(DefaultTableModel modeltabla) {
		JTable estaTabla = new JTable(modeltabla);
		estaTabla.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		estaTabla.setBorder(null);        
		estaTabla.setRowHeight(30);
		estaTabla.setIntercellSpacing(new Dimension(0, 0));
		estaTabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		
		JTableHeader header = estaTabla.getTableHeader();
        header.setBorder(null);
        header.setForeground(Color.BLACK);
        
		return estaTabla;
	}
	
	public static Icon escalarIMG(Icon icontoresize, int newW, int newH) {		
		 Image img = ((ImageIcon) icontoresize).getImage() ;  
		 Image newimg = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);  
		 return new ImageIcon(newimg);
	}
	
	public KeyListener onlyNumbers(JTextField jt) {
		KeyListener esteMetodo = new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)) || jt.getText().length()>11){
					e.consume();
				}
			}
		};
		return esteMetodo;
	}
	
}
