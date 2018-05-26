package exceptionManager;

public class CursoDisciplinaInvalidCodeException extends InvalidCodeException {
	
	public CursoDisciplinaInvalidCodeException(int codigo, String nome) {
		super(codigo, nome);
	}
	
	@Override
	public String getMessage() {
		return "Codigo de curso invalido na disciplina " + nome + ": " + codigo;
	}

}

