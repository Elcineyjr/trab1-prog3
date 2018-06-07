package exceptionManager;

public class CourseLevelException extends Exception{
	private int codigoCurso;
	private String nome;	
	public CourseLevelException(int codigoCurso, String nome) {
		super("Inconsistência ao definir o nível do curso: " + codigoCurso + " - " + nome + ".");
		this.codigoCurso = codigoCurso;
		this.nome = nome;
	}
	
	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
