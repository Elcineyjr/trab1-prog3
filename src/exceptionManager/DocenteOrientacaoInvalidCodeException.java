package exceptionManager;

public class DocenteOrientacaoInvalidCodeException extends InvalidCodeException {

	public DocenteOrientacaoInvalidCodeException(int codigo, String nome) {
		super(codigo, nome);
	}
	
	@Override
	public String getMessage() {
		return "C�digo de docente inv�lido na orienta��o do aluno " + nome + ": " + codigo;
	}

}
