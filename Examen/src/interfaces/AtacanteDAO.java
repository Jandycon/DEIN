package interfaces;

import java.util.ArrayList;

import obj.Producto;
import obj.Ubicacion;

public interface AtacanteDAO {
	void agregarProducto(Producto producto);
	void borrarProducto(Producto producto);
	void actualizarProducto(Producto producto);
	Producto obtenerProducto(String nomproducto);
	ArrayList<Producto> getAllProductos();
	
	void agregarUbicacion(Ubicacion ubicacion);
	void borrarUbicacion(Ubicacion ubicacion);
	void actualizarUbicacion(Ubicacion ubicacion);
	ArrayList<Ubicacion> getAllUbicacion();	
}
