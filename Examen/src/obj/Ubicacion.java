package obj;

public class Ubicacion {
	private int id_ubic;
	private String seccion;
	private String ubicacion;
	private int num_estanteria;
	
	public Ubicacion(int id_ubic, String seccion, String ubicacion, int num_estanteria) {
		super();
		this.id_ubic = id_ubic;
		this.seccion = seccion;
		this.ubicacion = ubicacion;
		this.num_estanteria = num_estanteria;
	}
	
	public Ubicacion(int id_ubic) {
		this.id_ubic=id_ubic;
	}

	public int getId_ubic() {
		return id_ubic;
	}

	public String getSeccion() {
		return seccion;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public int getNum_estanteria() {
		return num_estanteria;
	}
}
