package tp.clases;

public class ItemLugar {
	private Integer codigo; // id_lugar o Objeto Lugar?
	private Integer competencia; // id_competencia o Objeto Competencia?
	private Integer cantidadEncuentros;
	private Boolean disponibilidad;
	
	// constructor
	public ItemLugar(Integer codigo, Integer competencia, Integer cantidadEncuentros, Boolean disponibilidad) {
		this.setCodigo(codigo);
		this.setCompetencia(competencia);
		this.setCantidadEncuentros(cantidadEncuentros);
		this.setDisponibilidad(disponibilidad);
	}

	// Getters y Setters
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCompetencia() {
		return competencia;
	}

	public void setCompetencia(Integer competencia) {
		this.competencia = competencia;
	}

	public Integer getCantidadEncuentros() {
		return cantidadEncuentros;
	}

	public void setCantidadEncuentros(Integer cantidadEncuentros) {
		this.cantidadEncuentros = cantidadEncuentros;
	}

	public Boolean getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(Boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
}
