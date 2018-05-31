package instanciaveis;

public class AtividadeOrientadaDiscenteGraduacao {
	private int codigoDoDocente;
	private long matriculaDoDiscente;
	private int codigoDoCurso;
	private int cargaHorariaSemanal;
	
	public AtividadeOrientadaDiscenteGraduacao(int codigoDoDocente, long matriculaDoDiscente, int codigoDoCurso,
			int cargaHorariaSemanal) {
		super();
		this.codigoDoDocente = codigoDoDocente;
		this.matriculaDoDiscente = matriculaDoDiscente;
		this.codigoDoCurso = codigoDoCurso;
		this.cargaHorariaSemanal = cargaHorariaSemanal;
	}
	
	public int getCodigoDoDocente() {
		return codigoDoDocente;
	}
	public long getMatriculaDoDiscente() {
		return matriculaDoDiscente;
	}
	public int getcodigoDoCurso() {
		return codigoDoCurso;
	}
	public int getCargaHorariaSemanal() {
		return cargaHorariaSemanal;
	}

	@Override
	public String toString() {
		return "AtividadeOrientadaDiscenteGraduacao [codigoDoDocente=" + codigoDoDocente + ", matriculaDoDiscente="
				+ matriculaDoDiscente + ", codigoDoCurso=" + codigoDoCurso + ", cargaHorariaSemanal="
				+ cargaHorariaSemanal + "]";
	}
	
	public boolean compareCodigoDocente(AtividadeOrientadaDiscenteGraduacao a) {
		return this.codigoDoDocente == a.getCodigoDoDocente();
	}
	
	public boolean compareCodigoCurso(AtividadeOrientadaDiscenteGraduacao a) {
		return this.codigoDoCurso == a.getcodigoDoCurso();
	}
	
}
