package exceptionManager;

public class DocenteDisciplinaInvalidCodeException extends InvalidCodeException {
	
	public DocenteDisciplinaInvalidCodeException(int codigo, String nome) {
		super(codigo, nome);
	}
	
	@Override
	public String getMessage() {
		return "C�digo de docente inv�lido na disciplina " + nome + ": " + codigo;
	}

}
