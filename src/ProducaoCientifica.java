

public class ProducaoCientifica {
	private int codigoDoDocente;
	private String tituloDaPublicacao;
	private boolean qualificada;
	
	public ProducaoCientifica(int codigoDoDocente, String tituloDaPublicacao, boolean qualificada) {
		super();
		this.codigoDoDocente = codigoDoDocente;
		this.tituloDaPublicacao = tituloDaPublicacao;
		this.qualificada = qualificada;
	}
	
	public int getCodigoDoDocente() {
		return codigoDoDocente;
	}
	public String getTituloDaPublicacao() {
		return tituloDaPublicacao;
	}
	public boolean isQualificada() {
		return qualificada;
	}

	@Override
	public String toString() {
		return "ProducaoCientifica [codigoDoDocente=" + codigoDoDocente + ", tituloDaPublicacao=" + tituloDaPublicacao
				+ ", qualificada=" + qualificada + "]";
	}
	
	
	
}
