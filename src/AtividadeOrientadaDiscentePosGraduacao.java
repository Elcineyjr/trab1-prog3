import java.util.Date;

public class AtividadeOrientadaDiscentePosGraduacao {
	private int codigoDocente;
	private int matriculaDiscente;
	private Date dataIngressoDiscente;
	private String programa;
	private int cargaHorariaSemanal;
	
	
	public AtividadeOrientadaDiscentePosGraduacao(int codigoDocente, int matriculaDiscente, Date dataIngressoDiscente,
			String programa, int cargaHorariaSemanal) {
		this.codigoDocente = codigoDocente;
		this.matriculaDiscente = matriculaDiscente;
		this.dataIngressoDiscente = dataIngressoDiscente; // Corrigir funcionamento
		this.programa = programa;
		this.cargaHorariaSemanal = cargaHorariaSemanal;
	}

	public int getCodigoDocente() {
		return codigoDocente;
	}
	
	public int getMatriculaDiscente() {
		return matriculaDiscente;
	}
	
	public Date getDataIngressoDiscente() {
		return dataIngressoDiscente;
	}
	
	public String getPrograma() {
		return programa;
	}
	
	public int getCargaHorariaSemanal() {
		return cargaHorariaSemanal;
	}

	@Override
	public String toString() {
		return "AtividadeOrientadaDiscentePosGraduacao [codigoDocente=" + codigoDocente + ", matriculaDiscente="
				+ matriculaDiscente + ", dataIngressoDiscente=" + dataIngressoDiscente + ", programa=" + programa
				+ ", cargaHorariaSemanal=" + cargaHorariaSemanal + "]";
	}
	
	
}
