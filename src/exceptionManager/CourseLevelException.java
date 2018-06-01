package exceptionManager;

public class CourseLevelException extends Exception{
	private int codigoCurso;
	private String nome;	
	public CourseLevelException(int codigoCurso, String nome) {
		super("Inconsist�ncia ao definir o  n�vel  do  curso: " + codigoCurso + " - " + nome);
		this.codigoCurso = codigoCurso;
		this.nome = nome;
	}
	
	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
