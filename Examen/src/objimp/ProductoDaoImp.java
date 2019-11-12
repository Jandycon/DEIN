package objimp;

import java.sql.Connection;
import java.sql.SQLException;

import con.Pool;

public class ProductoDaoImp {
	private Connection cn;
	private Pool mypool;
	private String usuario;
	private String pass;
	
	public ProductoDaoImp(String usuario, String pass) {
		this.usuario=usuario;
		this.pass=pass;
	}
	
	public void probarConexion() {
		if(conectar()) {
			System.out.println("conectado");
		}else {
			System.out.println("no se ha podido conectar");
		}
		desconectar();
	}
	
	private boolean conectar() {
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
	
	private void desconectar() {
		try {
    		cn.close();
        }catch (SQLException ex) {
        	System.out.println(ex);		            	
        }
	}
}
