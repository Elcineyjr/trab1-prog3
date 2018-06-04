package exceptionManager;

public class DocenteProducaoInvalidCodeException extends InvalidCodeException {

	public DocenteProducaoInvalidCodeException(int codigo, String nome) {
		super(codigo, nome);
	}
	
	@Override
	public String getMessage() {
		return "Código de docente inválido na publicação " + nome + ": " + codigo + ".";
	}

}
