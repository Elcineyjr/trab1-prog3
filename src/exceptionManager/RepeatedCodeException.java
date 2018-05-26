package exceptionManager;

public class RepeatedCodeException extends Exception{
	private int codigo;
	private Object objeto;
	public RepeatedCodeException(int codigo, Object objeto) {
		super("Código repetido para " + objeto.getClass().getSimpleName() + ":" + codigo + ".");
		this.codigo = codigo;
		this.objeto = objeto;
	}
	
	@Override
	public String getMessage() {
		return super.getMessage();
	}
	
}
