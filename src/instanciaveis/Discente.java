package instanciaveis;


public class Discente {
	private long matricula;
	private String nome;
	private int codigoDoCurso;
	
	public Discente(long matricula, String nome, int codigoDoCurso) {
		this.matricula = matricula;
		this.nome = nome;
		this.codigoDoCurso = codigoDoCurso;
	}

	public long getMatricula() {
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
	
	public boolean compareTo(Discente d) {
		return this.matricula == d.getMatricula();
	}
	
}
