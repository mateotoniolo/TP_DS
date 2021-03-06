package tp.Gestores;

import java.util.List;

import tp.DAO.CompetenciaDAO;
import tp.DAO.DeporteDAO;
import tp.DTOs.CompetenciaDTO;
import tp.DTOs.DeporteDTO;
import tp.clases.Competencia;
import tp.clases.CompetenciaEliminacionDoble;
import tp.clases.CompetenciaEliminacionSimple;
import tp.clases.CompetenciaLiga;
import tp.enums.Modalidad;

public class GestorCompetencia {

	private CompetenciaDAO competenciaDao = new CompetenciaDAO();
	private Competencia competencia ;
	
	
	public Boolean Save(CompetenciaDTO DTO) {
	
	switch(DTO.getModalidad()) {
		case LIGA:
			 competencia = new CompetenciaLiga(DTO.getNombre(),DTO.getModalidad(),null,
					 null,DTO.getCantSets(),DTO.getReglamento(), DTO.getPuntuacion(),
					 DTO.getTantosXAusencia(),DTO.getId_usuario(),DTO.getId_deporte(),
					 null,DTO.getLugares(),DTO.getEmpate());
			 break;
		case ELIMINACION_DIRECTA:
			 competencia = new CompetenciaEliminacionSimple(DTO.getNombre(), DTO.getModalidad(),
					 null,null,DTO.getCantSets(),DTO.getReglamento(),null,DTO.getPuntuacion(),
					 DTO.getTantosXAusencia(),DTO.getId_usuario(),DTO.getId_deporte(),DTO.getLugares(),DTO.getEmpate());
			 break;
		case ELIMINACION_DOBLE:
			 competencia = new CompetenciaEliminacionDoble(DTO.getNombre(), DTO.getModalidad(),
					 null,null,DTO.getCantSets(),DTO.getReglamento(),null,DTO.getPuntuacion(),
					 DTO.getTantosXAusencia(),DTO.getId_usuario(),DTO.getId_deporte(),DTO.getLugares(),DTO.getEmpate());
			 	break;
		}
		
		return this.competenciaDao.Save(competencia);
		}
	
	public static List<DeporteDTO> getDeportes(){
		
		return DeporteDAO.getNombres();
		
	}
}
