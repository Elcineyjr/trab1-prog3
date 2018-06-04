package exceptionManager;

public class CursoDisciplinaInvalidCodeException extends InvalidCodeException {
	
	public CursoDisciplinaInvalidCodeException(int codigo, String nome) {
		super(codigo, nome);
	}
	
	@Override
	public String getMessage() {
		return "Código de curso inválido na disciplina " + nome + ": " + codigo + ".";
	}

}

