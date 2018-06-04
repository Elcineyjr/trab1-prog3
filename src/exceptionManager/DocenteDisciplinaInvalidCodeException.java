package exceptionManager;

public class DocenteDisciplinaInvalidCodeException extends InvalidCodeException {
	
	public DocenteDisciplinaInvalidCodeException(int codigo, String nome) {
		super(codigo, nome);
	}
	
	@Override
	public String getMessage() {
		return "Código de docente inválido na disciplina " + nome + ": " + codigo + ".";
	}

}
