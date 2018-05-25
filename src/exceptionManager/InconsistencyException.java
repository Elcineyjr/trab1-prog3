package exceptionManager;

public class InconsistencyException extends Exception{
	private int codigoCurso;
	private String nome;
	
	public InconsistencyException(int codigoCurso, String nome) {
		super("Inconsistência ao definir o  nível  do  curso de codígo: " + codigoCurso + " e nome: " + nome);
		this.codigoCurso = codigoCurso;
		this.nome = nome;
	}
	
	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
