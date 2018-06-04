package exceptionManager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InvalidFutureDateException extends Exception{
	private String nome;
	private LocalDate date;
	public InvalidFutureDateException(String nome, LocalDate date) {
		super();
		this.nome = nome;
		this.date = date;
	}
	
	@Override
	public String getMessage() {
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "Data de ingresso do aluno " + nome + " está no futuro: " + formatador.format(date) + ".";
	}
}
