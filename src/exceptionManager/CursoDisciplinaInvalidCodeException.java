package exceptionManager;

public class CursoDisciplinaInvalidCodeException extends InvalidCodeException {
	
	public CursoDisciplinaInvalidCodeException(int codigo, String nome) {
		super(codigo, nome);
	}
	
	@Override
	public String getMessage() {
		return "C�digo de curso inv�lido na disciplina " + nome + ": " + codigo;
	}

}

