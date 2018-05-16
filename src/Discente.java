

public class Discente {
	private int matricula;
	private String nome;
	private int codigoDoCurso;
	
	public Discente(int matricula, String nome, int codigoDoCurso) {
		this.matricula = matricula;
		this.nome = nome;
		this.codigoDoCurso = codigoDoCurso;
	}

	public int getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public int getCodigoDoCurso() {
		return codigoDoCurso;
	}

	@Override
	public String toString() {
		return "Discente [matricula=" + matricula + ", nome=" + nome + ", codigoDoCurso=" + codigoDoCurso + "]";
	}
	
	
	
}
