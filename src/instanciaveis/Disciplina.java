package instanciaveis;


public class Disciplina {
	private String codigoDaDisciplina;
	private String nome;
	private int codigoDoDocente;
	private int cargaHorariaSemanal;
	private int cargaHorariaSemestral;
	private int codigoDoCurso;
	
	public Disciplina(String codigoDaDisciplina, String nome, int codigoDoDocente, int cargaHorariaSemanal,
			int cargaHorariaSemestral, int codigoDoCurso) {
		super();
		this.codigoDaDisciplina = codigoDaDisciplina;
		this.nome = nome;
		this.codigoDoDocente = codigoDoDocente;
		this.cargaHorariaSemanal = cargaHorariaSemanal;
		this.cargaHorariaSemestral = cargaHorariaSemestral;
		this.codigoDoCurso = codigoDoCurso;
	}

	public String getCodigoDaDisciplina() {
		return codigoDaDisciplina;
	}

	public String getNome() {
		return nome;
	}

	public int getCodigoDoDocente() {
		return codigoDoDocente;
	}

	public int getCargaHorariaSemanal() {
		return cargaHorariaSemanal;
	}

	public int getCargaHorariaSemestral() {
		return cargaHorariaSemestral;
	}

	public int getCodigoDoCurso() {
		return codigoDoCurso;
	}

	@Override
	public String toString() {
		return "Disciplina [codigoDaDisciplina=" + codigoDaDisciplina + ", nome=" + nome + ", codigoDoDocente="
				+ codigoDoDocente + ", cargaHorariaSemanal=" + cargaHorariaSemanal + ", cargaHorariaSemestral="
				+ cargaHorariaSemestral + ", codigoDoCurso=" + codigoDoCurso + "]";
	}
	
	
}
