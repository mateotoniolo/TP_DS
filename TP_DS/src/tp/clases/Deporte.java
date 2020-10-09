package tp.clases;

public class Deporte {
	
	private Integer id_deporte;
	private String nombre;
	
	// constructor sin params
	public Deporte() {
		super();
	}

	public Deporte(Integer id_deporte, String nombre) {
		this.setIdDeporte(id_deporte);
		this.setNombre(nombre);
	}

	// Getters y Setters
	public Integer getIdDeporte() {
		return id_deporte;
	}

	public void setIdDeporte(Integer id_deporte) {
		this.id_deporte = id_deporte;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}