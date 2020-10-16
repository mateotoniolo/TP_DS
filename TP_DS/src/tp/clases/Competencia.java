package tp.clases;

import tp.enums.EstadoCompetencia;
import tp.enums.Modalidad;
import tp.enums.ModalidadDePuntuacion;

import java.util.List;
import java.util.Optional;
import tp.auditorias.AuditoriaDeBajaDeCompetencia;
public abstract class Competencia {
	
	private Integer id_Competencia;
	private String nombre;
	private Modalidad modalidad;
	
	// necesario?
	private List<Participante> listaParticipantes;
	
	private Fixture fixture;
	private String reglamento;
	private EstadoCompetencia estado;
	private Integer cantSets;
	private ModalidadDePuntuacion puntuacion;
	private Double tantosXAusencia;
	private Integer id_administrador;
	private Integer id_deporte;	
	private List<ItemLugar> Lugares;
	private List<AuditoriaDeBajaDeCompetencia> historialBaja;
	
	
	// constructor sin params
	public Competencia() {
		super();
	}
		
	// constructor
	public Competencia( String nombre, Modalidad modalidad, List<Participante> listaParticipantes, Fixture fixture, Integer cantSets, String reglamento, EstadoCompetencia estado, ModalidadDePuntuacion modalidadDePuntuacion, Double tantosXAusencia, Integer idAdministrador, Integer id_deporte,List<ItemLugar> items) {
		//this.setIdCompetencia(id);
		this.setNombre(nombre);
		this.setModalidad(modalidad);
		this.setParticipantes(listaParticipantes);
		this.setFixture(fixture);
		this.setReglamento(reglamento);
		this.setEstado(estado);
		this.setCantSets(cantSets);
		this.setModalidadDePuntuacion(modalidadDePuntuacion);
		this.setTantosXAusencia(tantosXAusencia);		
		this.setIdAdministrador(idAdministrador);
		this.setIdDeporte(id_deporte);
		this.Lugares = items;
	}
	
	// Getters y Setters	
	public Integer getIdDeporte(){
		return id_deporte;
	}
	
	public void setIdDeporte(Integer id_deporte){
		this.id_deporte = id_deporte;
	}

	public void setFixture(Fixture fixture) {
		this.fixture = fixture;
	}
	
	public Integer getFixtureID(){
		return fixture.getId_fixture();
	}	
	
	public Integer getIdCompetencia() {
		return id_Competencia;
	}
	

	public void setIdCompetencia(Integer id) {
		this.id_Competencia = id;
	}


	public EstadoCompetencia getEstado() {
		return estado;
	}
	

	public void setEstado(EstadoCompetencia estado) {
		this.estado = estado;
	}
	

	public ModalidadDePuntuacion getModalidadDePuntuacion() {
		return puntuacion;
	}

	
	public void setModalidadDePuntuacion(ModalidadDePuntuacion puntuacion) {
		this.puntuacion = puntuacion;
	}


	public List<Participante> getParticipantes() {
		return listaParticipantes;
	}


	public void setParticipantes(List<Participante> listaParticipantes) {
		this.listaParticipantes = listaParticipantes;
	}


	public Modalidad getModalidad() {
		return modalidad;
	}


	public void setModalidad(Modalidad modalidad) {
		this.modalidad = modalidad;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getReglamento() {
		return reglamento;
	}


	public void setReglamento(String reglamento) {
		this.reglamento = reglamento;
	}


	public Integer getIdAdministrador() {
		return id_administrador;
	}
	
	
	public Double getTantosXAusencia() {
		return tantosXAusencia;
	}

	
	public void setTantosXAusencia(Double tantosXAusencia2) {
		this.tantosXAusencia = tantosXAusencia2;
	}

	public void setIdAdministrador(Integer id) {
		this.id_administrador = id;
	}

	public Integer getCantSets() {
		return cantSets;
	}

	public void setCantSets(Integer cantSets2) {
		this.cantSets = cantSets2;
	}

	public List<ItemLugar> getLugares() {
		return Lugares;
	}

	public void setLugares(List<ItemLugar> lugares) {
		Lugares = lugares;
	}
	
	public void addItem(ItemLugar lugar) {
		this.Lugares.add(lugar);
	}

	public List<AuditoriaDeBajaDeCompetencia> getHistorialBaja() {
		return historialBaja;
	}

	public void setHistorialBaja(List<AuditoriaDeBajaDeCompetencia> historialBaja) {
		this.historialBaja = historialBaja;
	}
	
	public void addBajaDeCompetencia(AuditoriaDeBajaDeCompetencia baja) {
		this.historialBaja.add(baja);
	}
}
