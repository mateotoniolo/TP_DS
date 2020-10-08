package tp.clases;

import java.util.List;
import java.util.Optional;

import tp.enums.EstadoCompetencia;
import tp.enums.Modalidad;
import tp.enums.ModalidadDePuntuacion;

public class CompetenciaLiga extends Competencia {
	
	private Boolean empate;
	private Integer puntosXPresentarse;
	private Integer puntosXGanado;
	private Integer puntosXEmpate;
	
	
	public CompetenciaLiga(int id, String nombre, Modalidad modalidad,
			List<Participante> listaParticipantes, Fixture fixture, Optional cantSets, String reglamento, EstadoCompetencia estado,
			ModalidadDePuntuacion modalidadDePuntuacion, Double tantosXAusencia, Integer idAdministrador,
			Integer id_deporte) {
		super(id, nombre, modalidad, listaParticipantes, fixture, cantSets, reglamento, estado, modalidadDePuntuacion, tantosXAusencia,
				idAdministrador, id_deporte);
		
		this.setEmpate(empate);
		this.setPuntosXPresentarse(puntosXPresentarse);
		this.setPuntosXGanado(puntosXGanado);
		this.setPuntosXEmpate(puntosXEmpate);
	}

	
	// Getters and Setters

	public Boolean getEmpate() {
		return empate;
	}


	public void setEmpate(Boolean empate) {
		this.empate = empate;
	}


	public Integer getPuntosXPresentarse() {
		return puntosXPresentarse;
	}


	public void setPuntosXPresentarse(Integer puntosXPresentarse) {
		this.puntosXPresentarse = puntosXPresentarse;
	}


	public Integer getPuntosXEmpate() {
		return puntosXEmpate;
	}


	public void setPuntosXEmpate(Integer puntosXEmpate) {
		this.puntosXEmpate = puntosXEmpate;
	}


	public Integer getPuntosXGanado() {
		return puntosXGanado;
	}


	public void setPuntosXGanado(Integer puntosXGanado) {
		this.puntosXGanado = puntosXGanado;
	}
	
}