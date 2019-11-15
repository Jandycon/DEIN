package obj;

public class Producto {

	private int id;
	private String producto;
	private float precio;
	private String seccion;
	private String estanteria;
	private int disponible;
	
	public Producto(int id, String producto, float precio, String seccion, String estanteria, int disponible) {
		super();
		this.id = id;
		this.producto = producto;
		this.precio = precio;
		this.seccion = seccion;
		this.estanteria = estanteria;
		this.disponible = disponible;
	}
	
	public Producto(String producto) {
		this.producto=producto;
	}
	
	public Producto(int id) {
		this.id=id;
	}
	
	public int getId() {
		return id;
	}
	public String getProducto() {
		return producto;
	}
	public float getPrecio() {
		return precio;
	}
	public String getSeccion() {
		return seccion;
	}
	public String getEstanteria() {
		return estanteria;
	}
	public int getDisponible() {
		return disponible;
	}	
}
