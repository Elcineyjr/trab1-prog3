import java.time.*;

public class AtividadeOrientadaDiscentePosGraduacao {
	private int codigoDocente;
	private int matriculaDiscente;
	private LocalDate dataIngressoDiscente; //mudanca pra LocalDate, uma versao melhorada de datas do java 8
	private String programa;
	private int cargaHorariaSemanal;
	
	
	public AtividadeOrientadaDiscentePosGraduacao(int codigoDocente, int matriculaDiscente, LocalDate dataIngressoDiscente,
			String programa, int cargaHorariaSemanal) {
		this.codigoDocente = codigoDocente;
		this.matriculaDiscente = matriculaDiscente;
		this.dataIngressoDiscente = dataIngressoDiscente; 
		this.programa = programa;
		this.cargaHorariaSemanal = cargaHorariaSemanal;
	}

	public int getCodigoDocente() {
		return codigoDocente;
	}
	
	public int getMatriculaDiscente() {
		return matriculaDiscente;
	}
	
	public LocalDate getDataIngressoDiscente() {
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
