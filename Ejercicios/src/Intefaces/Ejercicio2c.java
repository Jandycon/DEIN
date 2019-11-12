package Intefaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Ejercicio2c extends JFrame {

	private JPanel contentPane;
	private JPanel contentButton;
	private JPanel contentMsj;
	private JButton btnStart;
	private JButton btnStop;
	private JLabel textoElegir;
	private JLabel textoCrono;
	private int segPrev;
	private int segAfter;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio2c frame = new Ejercicio2c();
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
		contentPane.setLayout(null);		
		
		setTitle("Ejercicio 2c");		
		setBounds(100, 100, 450, 300);
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
	}
	
	public void agregarElementos() {	
		
		//Contenedores
		contentButton = new JPanel();
		contentButton.setLayout(new FlowLayout());
		contentButton.setBounds(12, 37, 420, 42);	
		
		contentMsj = new JPanel();
		contentMsj.setLayout(new FlowLayout());
		contentMsj.setBounds(63, 78, 330, 25);		
		
		//Elementos
		
		btnStart = new JButton("Start");
		btnStart.setBounds(40, 64, 114, 25);	
		
		btnStop = new JButton("Stop");
		btnStop.setBounds(250, 64, 114, 25);
		btnStop.setEnabled(false);
		
		textoCrono = new JLabel("Cronómetro en marcha...");
		textoCrono.setBounds(150, 100, 400, 25);
		textoCrono.setVisible(false);
				
		contentButton.add(btnStart);
		contentButton.add(btnStop);
		contentButton.add(textoCrono);
		
		contentPane.add(contentButton);
		contentPane.add(contentMsj);
		
		textoElegir = new JLabel("Presione arrancar para empezar a cronometrar");
		contentMsj.add(textoElegir);
	}
	
	public ActionListener pressBtnStart() {
		ActionListener esteMetodo = new ActionListener() {				
			public void actionPerformed(ActionEvent arg0) {	
								
				textoCrono.setText("Cronómetro en marcha...");
				textoCrono.setVisible(true);
				textoElegir.setVisible(false);
			
				Calendar calendario = Calendar.getInstance();
				
			    int hora =calendario.get(Calendar.HOUR_OF_DAY);
			    int minutos = calendario.get(Calendar.MINUTE);
			    int segundos = calendario.get(Calendar.SECOND); 
			    int miliseg = calendario.get(Calendar.MILLISECOND);
			    
			    segPrev = ((hora*360)+(minutos*60)+segundos)*1000 + miliseg;	
			    
			    btnStart.setEnabled(false);
			    btnStop.setEnabled(true);
			}
		};
		return esteMetodo;
	}
	
	public ActionListener pressBtnStop() {
		ActionListener esteMetodo = new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {						
												
				Calendar calendario = Calendar.getInstance();
					
				int hora =calendario.get(Calendar.HOUR_OF_DAY);
				int minutos = calendario.get(Calendar.MINUTE);
				int segundos = calendario.get(Calendar.SECOND);
				int miliseg = calendario.get(Calendar.MILLISECOND);
				    
				segAfter = ((hora*360)+(minutos*60)+segundos)*1000 + miliseg;			    
				    
				textoCrono.setText("Tiempo cronometrado: "+calcularTiempo(segAfter,segPrev)); 	
				    
				reiniciarCronometro();		
				
				btnStart.setEnabled(true);
				btnStop.setEnabled(false);
			}
		};
		return esteMetodo;
	}
	
	private String calcularTiempo(int num1,int num2) {		
		String tiempo;
		int seg;
		int miliseg;
		int t;
			t= segAfter-segPrev;
			seg= t/1000;
			miliseg= t%1000;	
		tiempo = seg+","+miliseg;
		return tiempo;
	}
	
	private void reiniciarCronometro() {
		segAfter=0;
	    segPrev=0;	
	}
		
	/**
	 * Create the frame.
	 */
	public Ejercicio2c() {
		
		prepararGUI();
		agregarElementos();
		
		btnStart.addActionListener(pressBtnStart());
		btnStop.addActionListener(pressBtnStop());
	}

}
