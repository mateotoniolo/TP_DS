package tp.clases;

import java.util.List;

public class Fixture {
	private List<Fecha> listaFechas;
	
	public Fixture() {
		
	}

	public List<Fecha> getListaFechas() {
		return listaFechas;
	}

	public void setListaFechas(List<Fecha> listaFechas) {
		this.listaFechas = listaFechas;
	}
	
	public void addFecha(Fecha fecha) {
		this.listaFechas.add(fecha);
	}
}
