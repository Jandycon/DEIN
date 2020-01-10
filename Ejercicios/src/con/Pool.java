package con;

import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;

public class Pool {
	public DataSource dataSource;
    
    //Atributos para la conexcion de mysql
    public String db = "mercado";
    public String url = "jdbc:mysql://localhost/"+db;
    public String user;
    public String pass;
    
    //Constructor con 2 parametros para mysql
    public Pool(String usuario, String pass){
    	this.user=usuario;
    	this.pass=pass;
    	inicializaMySQLDataSource();
    }
    
    private void inicializaMySQLDataSource(){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUsername(user);
        basicDataSource.setPassword(pass);
        basicDataSource.setUrl(url);
        basicDataSource.setMaxActive(50);
        dataSource = basicDataSource;
    }
}