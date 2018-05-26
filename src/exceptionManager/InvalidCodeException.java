package exceptionManager;

public class InvalidCodeException extends Exception {
	protected int codigo;
	protected String nome;
	public InvalidCodeException(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}
	
	@Override
	public String getMessage() {
		return super.getMessage();
	}
	
	
}
