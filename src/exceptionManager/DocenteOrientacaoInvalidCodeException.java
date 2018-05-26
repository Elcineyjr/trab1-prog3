package exceptionManager;

public class DocenteOrientacaoInvalidCodeException extends InvalidCodeException {

	public DocenteOrientacaoInvalidCodeException(int codigo, String nome) {
		super(codigo, nome);
	}
	
	@Override
	public String getMessage() {
		return "Codigo de docente invalido na orientação do aluno " + nome + ": " + codigo;
	}

}
