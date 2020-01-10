package jasper;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import con.Pool;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;


public class Supermercado extends JFrame {

	public JTabbedPane contentPane;
	public JButton btn1, btn2;	
	private Connection cn;
	private Pool mypool;
	private String usuario = "root";
	private String pass = "";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Supermercado frame = new Supermercado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Supermercado() {
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 100);
		contentPane = new JTabbedPane();
		
		JPanel p1=new JPanel();  
		JPanel p2=new JPanel();  
		
		btn1 = new JButton("Informe 1");
		btn2 = new JButton("Informe 2");
		
		p1.add(btn1);
		p2.add(btn2);
		
		contentPane.add("Productos",p1);  
		contentPane.add("Seccion",p2);  
		
		controlEvents();
		
		setContentPane(contentPane);		
	}
	
	public void controlEvents() {
		btn1.addActionListener(generarI1());
		btn2.addActionListener(generarI2());
	}
	
	public ActionListener generarI1() {
		ActionListener esteMetodo = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {					
					if(conectar()) {
						System.out.println("conectado");
						JasperReport report = JasperCompileManager.compileReport("/home/dm2/DM2/DEIN/JasperReportProject/Informe1_1.jrxml");
						JasperPrint print = JasperFillManager.fillReport(report, null, cn);
						JasperExportManager.exportReportToPdfFile(print, "/home/dm2/informe1.pdf");
						
					}else {
						System.out.println("No se ha podido conectar a la base de datos.");
					}
				} catch (JRException e) {
					e.printStackTrace();
				}
			}
		};
		return esteMetodo;
	}	
	
	public ActionListener generarI2() {
		ActionListener esteMetodo = new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {				
				Map seccion = new HashMap();	
				seccion.put("Parameter1","CHARCUTERIA");
				try {					
					if(conectar()) {
						System.out.println("conectado");
						JasperReport report = JasperCompileManager.compileReport("/home/dm2/DM2/DEIN/JasperReportProject/Informe1_2.jrxml");
						JasperPrint print = JasperFillManager.fillReport(report, seccion , cn);
						JasperExportManager.exportReportToPdfFile(print, "/home/dm2/informe2.pdf");
						
					}else {
						System.out.println("No se ha podido conectar a la base de datos.");
					}
				} catch (JRException e) {
					e.printStackTrace();
				}
			}
		};
		return esteMetodo;
	}	
	
	public boolean conectar() {
		boolean conectado=false;		
		mypool = new Pool(usuario, pass);
		cn = null;        
		try {
			cn=mypool.dataSource.getConnection();
			if(cn!=null)
				conectado=true;
			}catch (SQLException e) {
		           System.out.println(e);
		    }
		return conectado;
	}
	
	public void desconectar() {
		try {
    		cn.close();
        }catch (SQLException ex) {
        	System.out.println(ex);		            	
        }
	}
}
