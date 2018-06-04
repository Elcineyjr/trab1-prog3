package exceptionManager;

public class CursoOrientacaoInvalidCodeException extends InvalidCodeException {

	public CursoOrientacaoInvalidCodeException(int codigo, String nome) {
		super(codigo, nome);
	}
	
	@Override
	public String getMessage() {
		return "Código de curso inválido na orientação do aluno " + nome + ": " + codigo + ".";
	}

}
