package instanciaveis;

import java.util.ArrayList;

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
	
	public static Discente getDiscentePorMatricula(ArrayList<Discente> discentes, long matricula) {
		for (Discente aluno : discentes) {
			if(aluno.getMatricula() == matricula)
				return aluno;
		}
		return null;
	}

	@Override
	public String toString() {
		return "Discente [matricula=" + matricula + ", nome=" + nome + ", codigoDoCurso=" + codigoDoCurso + "]";
	}
	
	public boolean compareTo(Discente d) {
		return this.matricula == d.getMatricula();
	}
	
}
