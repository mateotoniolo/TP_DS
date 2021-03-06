package tp.clases;

import java.util.List;
import java.util.Optional;

import tp.DTOs.ItemLugarDTO;
import tp.enums.EstadoCompetencia;
import tp.enums.Modalidad;
import tp.enums.ModalidadDePuntuacion;

public class CompetenciaEliminacionDoble extends Competencia {

	// constructor sin params
	public CompetenciaEliminacionDoble() {
		super();
	}
		
	public CompetenciaEliminacionDoble( String nombre, Modalidad modalidad,
			List<Participante> listaParticipantes, Fixture fixture, Integer cantSets, String reglamento, EstadoCompetencia estado,
			ModalidadDePuntuacion modalidadDePuntuacion, Double tantosXAusencia, Integer idAdministrador,
			Integer id_deporte, List<ItemLugarDTO> list, Boolean empate) {
		super( nombre, modalidad, listaParticipantes, fixture, cantSets, reglamento, estado, modalidadDePuntuacion, tantosXAusencia,
				idAdministrador, id_deporte, list, empate);
		
		
	}

}
