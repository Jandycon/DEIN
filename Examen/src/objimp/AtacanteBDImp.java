package objimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import con.Pool;
import interfaces.AtacanteDAO;
import obj.Producto;
import obj.Ubicacion;

public class AtacanteBDImp implements AtacanteDAO {
	private Connection cn;
	private Pool mypool;
	private String usuario;
	private String pass;
	
	public AtacanteBDImp(String usuario, String pass) {
		this.usuario=usuario;
		this.pass=pass;
	}
		
	/*********************** PRODUCTO *********************/
	
	@Override
	public void agregarProducto(Producto producto) {
		String strquery = "INSERT INTO productos VALUES(?,?,?,?,?,?)";
		PreparedStatement ps=null;
		try {
			if (conectar()) {
				ps = cn.prepareStatement(strquery);	
				ps.setInt(1, producto.getId());
				ps.setString(2, producto.getProducto());
				ps.setFloat(3, producto.getPrecio());
				ps.setString(4, producto.getSeccion());
				ps.setString(5, producto.getEstanteria());
				ps.setInt(6, producto.getDisponible());
				ps.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println("Error en agregar producto");
		}		
		finally {
			desconectar();
		}		
	}

	@Override
	public void borrarProducto(Producto producto) {
		String strquery = "DELETE FROM productos WHERE id=?";
		PreparedStatement ps=null;
		try {
			if (conectar()) {
				ps = cn.prepareStatement(strquery);	
				ps.setInt(1, producto.getId());
				ps.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println("Error en borrar producto");
		}		
		finally {
			desconectar();
		}			
	}

	@Override
	public void actualizarProducto(Producto producto) {
		String strquery = "UPDATE productos SET producto=?, precio=?, seccion=?, estanteria=?, disponible=? WHERE id=?";
		PreparedStatement ps=null;
		try {
			if (conectar()) {
				ps = cn.prepareStatement(strquery);	
				ps.setString(1, producto.getProducto());
				ps.setFloat(2, producto.getPrecio());
				ps.setString(3, producto.getSeccion());
				ps.setString(4, producto.getEstanteria());
				ps.setInt(5, producto.getDisponible());
				ps.setInt(6, producto.getId());
				ps.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println("Error en actualizar producto");
		}		
		finally {
			desconectar();
		}		
	}

	@Override
	public Producto obtenerProducto(String nomproducto) {
		Producto foundPro = null;
		String strquery = "SELECT id, producto, precio, seccion, estanteria, disponible FROM productos WHERE producto=?";
		PreparedStatement ps=null;
		try {
			if (conectar()) {
				ps = cn.prepareStatement(strquery);	
				ps.setString(1, nomproducto);		
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					foundPro = new Producto(rs.getInt("id"), rs.getString("producto"), rs.getFloat("precio"), rs.getString("seccion"), rs.getString("estanteria"), rs.getInt("disponible"));					
				}			
			}
		} catch (Exception e) {
			System.out.println("Error en obtener todos los productos");
		}		
		finally {
			desconectar();
		}			
		return foundPro;
	}
	
	@Override
	public ArrayList<Producto> getAllProductos() {
		ArrayList<Producto> estaLista = new ArrayList<Producto>();
		String strquery = "SELECT id, producto, precio, seccion, estanteria, disponible FROM productos";
		PreparedStatement ps=null;
		try {
			if (conectar()) {
				ps = cn.prepareStatement(strquery);	
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					Producto esteProducto = new Producto(rs.getInt("id"), rs.getString("producto"), rs.getFloat("precio"), rs.getString("seccion"), rs.getString("estanteria"), rs.getInt("disponible"));
					estaLista.add(esteProducto);
				}			
			}
		} catch (Exception e) {
			System.out.println("Error en obtener todos los productos");
		}		
		finally {
			desconectar();
		}		
		return estaLista;		
	}
			
	/*********************** UBICACION *********************/

	@Override
	public void agregarUbicacion(Ubicacion ubicacion) {
		String strquery = "INSERT INTO ubicacion VALUES(?,?,?,?)";
		PreparedStatement ps=null;
		try {
			if (conectar()) {
				ps = cn.prepareStatement(strquery);	
				ps.setInt(1, ubicacion.getId_ubic());
				ps.setString(2, ubicacion.getSeccion());
				ps.setString(3, ubicacion.getUbicacion());
				ps.setInt(4, ubicacion.getNum_estanteria());
				ps.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println("Error en agregar ubicacion");
		}		
		finally {
			desconectar();
		}				
	}

	@Override
	public void borrarUbicacion(Ubicacion ubicacion) {
		String strquery = "DELETE FROM ubicacion WHERE id_ubic=?";
		PreparedStatement ps=null;
		try {
			if (conectar()) {
				ps = cn.prepareStatement(strquery);	
				ps.setInt(1, ubicacion.getId_ubic());
				ps.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println("Error en borrar ubicacion");
		}		
		finally {
			desconectar();
		}	
	}

	@Override
	public void actualizarUbicacion(Ubicacion ubicacion) {
		String strquery = "UPDATE ubicacion SET seccion=?, ubicacion=?, num_estanteria=? WHERE id_ubic=?";
		PreparedStatement ps=null;
		try {
			if (conectar()) {
				ps = cn.prepareStatement(strquery);	
				ps.setString(3, ubicacion.getSeccion());
				ps.setString(4, ubicacion.getUbicacion());
				ps.setInt(5, ubicacion.getNum_estanteria());
				ps.setInt(6, ubicacion.getId_ubic());
				ps.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println("Error en actualizar ubicacion");
		}		
		finally {
			desconectar();
		}	
	}

	@Override
	public ArrayList<Ubicacion> getAllUbicacion() {
		ArrayList<Ubicacion> estaLista = new ArrayList<Ubicacion>();
		String strquery = "SELECT id_ubic, seccion, ubicacion, num_estanteria FROM ubicacion";
		PreparedStatement ps=null;
		try {
			if (conectar()) {
				ps = cn.prepareStatement(strquery);	
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					Ubicacion estaUbicacion = new Ubicacion(rs.getInt("id_ubic"), rs.getString("seccion"), rs.getString("ubicacion"), rs.getInt("num_estanteria"));
					estaLista.add(estaUbicacion);
				}			
			}
		} catch (Exception e) {
			System.out.println("Error en obtener todos las ubicaciones");
		}		
		finally {
			desconectar();
		}		
		return estaLista;	
	}
	
	/*********************** GESTIONAR CONEXION *********************/
		
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
