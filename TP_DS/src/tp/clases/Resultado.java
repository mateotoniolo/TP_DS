package tp.clases;

public class Resultado {
	private Boolean aPresente;
	private Boolean bPresente;
	
	public Resultado(Boolean aPresente, Boolean bPresente) {
		this.setaPresente(aPresente);
		this.setbPresente(bPresente);
	}

	public Boolean getaPresente() {
		return aPresente;
	}

	public void setaPresente(Boolean aPresente) {
		this.aPresente = aPresente;
	}

	public Boolean getbPresente() {
		return bPresente;
	}

	public void setbPresente(Boolean bPresente) {
		this.bPresente = bPresente;
	}

}
