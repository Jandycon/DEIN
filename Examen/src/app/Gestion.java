package app;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import estatico.MisEstaticos;
import interfaces.JFrameDAO;
import obj.Producto;
import obj.Ubicacion;
import objimp.AtacanteBDImp;

@SuppressWarnings("serial")
public class Gestion extends JFrame implements JFrameDAO{
	
	private String usuario;
	private String pass;
	private JTabbedPane contentPane;
	private JPanel jpproducto, jpubicacion;
	private AtacanteBDImp atacanteImp;
	private JTable jtablaubi;	
	private JScrollPane jscrollubi;
	private DefaultTableModel modeltablaubi;
	private JTextField jtpropro, jtprepro, jtdispro, jtbuscar;
	private JButton btnnew, btnsave, btnbuscar;
	private JComboBox<String> combosec, comboest;
	private final String[] columnsUbi = {"SECCION","UBICACION","Nº ESTANTERIA"};
	private JRadioButton radiodis, radioago;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestion frame = new Gestion("root","");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Gestion(String user, String pass) {
		this.usuario=user;
		this.pass=pass;
		prepararGUI();
		agregarElementos();
		controlEventos();
		inhabilitarFields();
	}

	@Override
	public void prepararGUI() {
		contentPane = new JTabbedPane();		
		contentPane.setBorder(null);
				
		add(contentPane);
		setTitle("Mercado");
		setSize(600, 400);	
		setLocationRelativeTo(null);
		setContentPane(contentPane);	
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}

	@Override
	public void agregarElementos() {
		comboest = new JComboBox<String>();
		combosec = new JComboBox<String>();
		atacanteImp = new AtacanteBDImp(usuario, pass);
		
		/**************************** PANEL PRODUCTO ****************************************/
		jpproducto = new JPanel(new GridLayout(7,3,15,15));
		jpproducto.setBorder(new EmptyBorder(35,30,35,30));
				
		jtpropro = new JTextField();
		jtprepro = new JTextField();				
		jtdispro = new JTextField();
		jtbuscar = new JTextField();
		
		radiodis = new JRadioButton("Disponible");
		radioago = new JRadioButton("Agotado");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(radiodis);
		bg.add(radioago);
		
		btnnew = new JButton("Nuevo");
		btnsave = new JButton("Guardar");		
		btnbuscar = new JButton("BUSCAR");
		
		btnsave.setEnabled(false);
						
		jpproducto.add(new JLabel("Producto"));
		jpproducto.add(jtpropro);
		jpproducto.add(btnnew);		
		jpproducto.add(new JLabel("Precio/Kg"));
		jpproducto.add(jtprepro);
		jpproducto.add(btnsave);		
		jpproducto.add(new JLabel("Seccion"));
		jpproducto.add(combosec);
		jpproducto.add(new JLabel(""));
		jpproducto.add(new JLabel("Estantería"));
		jpproducto.add(comboest);
		jpproducto.add(new JLabel(""));
		jpproducto.add(new JLabel("Cantidad Stock"));
		jpproducto.add(jtdispro);
		jpproducto.add(btnbuscar);
		jpproducto.add(new JLabel(""));		
		jpproducto.add(radiodis);
		jpproducto.add(jtbuscar);
		jpproducto.add(new JLabel(""));	
		jpproducto.add(radioago);	
		jpproducto.add(new JLabel(""));	
				
		/**************************** PANEL UBICACION ****************************************/
		
		jpubicacion = new JPanel(new GridLayout(2, 1, 5, 5));		
		
		setModelTable();					
		jtablaubi = MisEstaticos.tablaForPanel(modeltablaubi); 
		setTableProFromBD();		
		jscrollubi = MisEstaticos.scrollForPanel(jtablaubi,410,150);
		
		JLabel lblIMGMercado= new JLabel(MisEstaticos.escalarIMG(MisEstaticos.IMGMERCADO, 410,150));	
		
		jpubicacion.add(jscrollubi);
		jpubicacion.add(lblIMGMercado);
		
		/**************************** JTABBED PANE ****************************************/
				
		contentPane.add("ARTICULOS",jpproducto);
		contentPane.add("SECCIONES",jpubicacion);	
	}

	@Override
	public void controlEventos() {
		btnbuscar.addActionListener(buscarProducto());
		btnnew.addActionListener(prepararNuevo());
		btnsave.addActionListener(agregarProducto());
		
	}
	
	private ActionListener prepararNuevo() {
		ActionListener esteMetodo = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
				setComboboxes();
				
				jtpropro.setText("[producto]");
				jtprepro.setText("[precio]");
				combosec.setSelectedItem("");
				comboest.setSelectedItem("");				
				jtdispro.setText("[cant]");	
				
				radiodis.setSelected(true);								
				jtpropro.setEditable(true);
				jtprepro.setEditable(true);
				combosec.setEnabled(true);
				comboest.setEnabled(true);
				jtdispro.setEnabled(true);
				jtdispro.setEditable(true);
				btnsave.setEnabled(true);
				btnnew.setEnabled(false);
				btnbuscar.setEnabled(false);
				jtbuscar.setEnabled(false);
			}
		};
		return esteMetodo;
	}
	
	private ActionListener buscarProducto() {
		ActionListener esteMetodo = new ActionListener() {
			public void actionPerformed(ActionEvent e) {								
				try {						
					String nomproducto = jtbuscar.getText();					
					Producto foundPro = atacanteImp.obtenerProducto(nomproducto);					
					if(foundPro!=null) {
						
						setComboboxes();
						
						jtpropro.setText(foundPro.getProducto());
						jtprepro.setText(foundPro.getPrecio()+"");	
						
						combosec.setSelectedItem(foundPro.getSeccion());
						comboest.setSelectedItem(foundPro.getEstanteria());
						
						jtdispro.setText(foundPro.getDisponible()+"");
						
						if(foundPro.getDisponible()>0) {
							radiodis.setSelected(true);
						}else {
							radioago.setSelected(true);						
						}
						
						inhabilitarFields();
						
					}else {
						JOptionPane.showMessageDialog(contentPane, "No se ecnontraron registros", "Buscar", JOptionPane.INFORMATION_MESSAGE);
						limpiar();
						inhabilitarFields();
					}
				} catch (Exception e2) {
					System.out.println("Error en buscarProducto");
				}
			}
		};
		return esteMetodo;
	}
	
	private ActionListener agregarProducto() {
		ActionListener esteMetodo = new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				
				try {
					String jt2 = jtpropro.getText();	
					String jt3 = jtprepro.getText();
					String jt4 = combosec.getSelectedItem().toString();
					String jt5 = comboest.getSelectedItem().toString();
					String jt6 = jtdispro.getText();
		
					int idpro = atacanteImp.getAllProductos().size();
					idpro++;
					Producto nuevoPro = new Producto(idpro, jt2, Float.parseFloat(jt3), jt4, jt5, Integer.parseInt(jt6));		
										
					atacanteImp.agregarProducto(nuevoPro);				
					JOptionPane.showMessageDialog(null, "Producto registrado correctamente","Guardar Producto", JOptionPane.INFORMATION_MESSAGE);
					
					radiodis.setSelected(false);
					radioago.setSelected(false);
					btnnew.setEnabled(true);
					btnsave.setEnabled(false);
					btnbuscar.setEnabled(true);
					jtbuscar.setEnabled(true);	
					
					limpiar();//resetamos los campos	
					inhabilitarFields();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Error en los valores de los campos","Format Exception",JOptionPane.ERROR_MESSAGE);
				}
			}
		};
		return esteMetodo;
	}
	
	
	public void setModelTable() {
		modeltablaubi = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		modeltablaubi.setColumnIdentifiers(columnsUbi);
		
	}
	
	public void setTableProFromBD() {
		modeltablaubi.setRowCount(0);
		ArrayList<Ubicacion> listaUbicacion = atacanteImp.getAllUbicacion();
		Object linea[] = new Object[3];	
		for (int i = 0; i < listaUbicacion.size(); i++) {
			linea[0] = listaUbicacion.get(i).getSeccion();  
			linea[1] = listaUbicacion.get(i).getUbicacion();  
			linea[2] = listaUbicacion.get(i).getNum_estanteria();  
			
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment(JLabel.CENTER);
			for (int j = 0; j <=2; j++) {
				jtablaubi.getColumnModel().getColumn(j).setCellRenderer(centerRenderer);
				jtablaubi.getColumnModel().getColumn(j).setMinWidth(130);
			}						
			modeltablaubi.addRow(linea);
		}		
	}
	
	private void setComboboxes() {
		combosec.setEditable(false);
		combosec.removeAllItems();
		for (int i = 0; i < MisEstaticos.SECCIONES.length; i++) {
			combosec.addItem(MisEstaticos.SECCIONES[i]);
		}
		comboest.setEditable(false);
		comboest.removeAllItems();
		for (int i = 0; i < MisEstaticos.ESTANTERIAS.length; i++) {
			comboest.addItem(MisEstaticos.ESTANTERIAS[i]);
		}
	}
	
	private void inhabilitarFields() {
		jtpropro.setEditable(false);
		jtprepro.setEditable(false);
		combosec.setEnabled(false);
		comboest.setEnabled(false);
		jtdispro.setEditable(false);
		radiodis.setEnabled(false);
		radioago.setEnabled(false);
		radiodis.setSelected(false);
	}
	
	private void limpiar() {
		jtpropro.setEditable(true);
		jtpropro.setText("");
		jtprepro.setEditable(true);
		jtprepro.setText("");
		combosec.setEnabled(true);
		combosec.removeAllItems();
		comboest.setEnabled(true);
		comboest.removeAllItems();
		jtdispro.setEditable(true);
		jtdispro.setText("");
		radiodis.setEnabled(true);
		radioago.setEnabled(true);
	}
}
