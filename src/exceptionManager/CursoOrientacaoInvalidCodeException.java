package exceptionManager;

public class CursoOrientacaoInvalidCodeException extends InvalidCodeException {

	public CursoOrientacaoInvalidCodeException(int codigo, String nome) {
		super(codigo, nome);
	}
	
	@Override
	public String getMessage() {
		return "C�digo de curso inv�lido na orienta��o do aluno " + nome + ": " + codigo;
	}

}
