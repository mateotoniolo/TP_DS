package tp.clases;

import java.util.List;
import java.util.Optional;

import tp.enums.EstadoCompetencia;
import tp.enums.Modalidad;
import tp.enums.ModalidadDePuntuacion;

public class CompetenciaEliminacionSimple extends Competencia {

	public CompetenciaEliminacionSimple(int id, String nombre, Modalidad modalidad,
			List<Participante> listaParticipantes, Fixture fixture, Optional cantSets, String reglamento, EstadoCompetencia estado,
			ModalidadDePuntuacion modalidadDePuntuacion, Double tantosXAusencia, Integer idAdministrador,
			Integer id_deporte) {
		super(id, nombre, modalidad, listaParticipantes, fixture, cantSets, reglamento, estado, modalidadDePuntuacion, tantosXAusencia,
				idAdministrador, id_deporte);
		
		
	}

}
