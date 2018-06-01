package exceptionManager;

public class DocenteOrientacaoInvalidCodeException extends InvalidCodeException {

	public DocenteOrientacaoInvalidCodeException(int codigo, String nome) {
		super(codigo, nome);
	}
	
	@Override
	public String getMessage() {
		return "Código de docente inválido na orientação do aluno " + nome + ": " + codigo;
	}

}
