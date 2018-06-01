package exceptionManager;

public class DocenteProducaoInvalidCodeException extends InvalidCodeException {

	public DocenteProducaoInvalidCodeException(int codigo, String nome) {
		super(codigo, nome);
	}
	
	@Override
	public String getMessage() {
		return "C�digo de docente inv�lido na publica��o " + nome + ": " + codigo;
	}

}
