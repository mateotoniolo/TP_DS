package tp.clases;

import tp.enums.TipoDni;

public class Usuario {

	private String id_Usuario;
	private String correoElectronico;
	private String contrase�a;
	private String nombre;
	private String apellido;
	private TipoDni tipoDni;
	private Double documento;
	private Localidad localidad;

	public Usuario(String idUsuario, String correoElectronico, String contrase�a, String nombre, String apellido, TipoDni tipoDni, Double documento, Localidad localidad){
		this.setIdUsuario(idUsuario);
		this.setCcorreoElectronico(correoElectronico);
		this.setContrase�a(contrase�a);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setTipoDocumento(tipoDni);
		this.setNroDocumento(documento);
		this.setLocalidad(localidad);
	}

	// Getters y Setters
	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCcorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public Double getNroDocumento() {
		return documento;
	}

	public void setNroDocumento(Double documento) {
		this.documento = documento;
	}

	public TipoDni getTipoDocumento() {
		return tipoDni;
	}

	public void setTipoDocumento(TipoDni tipoDni) {
		this.tipoDni = tipoDni;
	}

	public String getIdUsuario() {
		return id_Usuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.id_Usuario = idUsuario;
	}
	
}
