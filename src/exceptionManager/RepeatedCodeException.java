package exceptionManager;

import instanciaveis.Disciplina;

public class RepeatedCodeException extends Exception{
	private long codigo;
	private String codigo_;
	private Object objeto;
	public RepeatedCodeException(long codigo, Object objeto) {
		super("Código repetido para " + objeto.getClass().getSimpleName() + ":" + codigo + ".");
		this.codigo = codigo;
		this.objeto = objeto;
	}
	
	public RepeatedCodeException(String codigoString, Object objeto) {
		super("Código repetido para " + objeto.getClass().getSimpleName() + ":" + codigoString + ".");
		this.codigo_ = codigoString;
		this.objeto = objeto;
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
	
}
