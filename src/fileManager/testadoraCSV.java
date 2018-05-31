package fileManager;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.*;

import exceptionManager.*;

public class testadoraCSV {

	public static void main(String[] args) {
//		File arq = null;
		
		try {			
				LePlanilha.selectPlanilha(args);
		} 
		catch (RepeatedCodeException | InvalidCodeException | CourseLevelException | InvalidFutureDateException e) {
			System.out.println(e.getMessage());
		}
		catch (NumberFormatException e) {
			System.out.println("Erro de formatação");
		}
		catch (IOException e) {
			System.out.println("Erro de I/O");
		}
	}
	
}
