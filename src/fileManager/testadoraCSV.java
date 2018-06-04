package fileManager;

//import java.util.Locale;
import java.io.*;


//import com.sun.tools.javac.code.Attribute.Array;

import exceptionManager.*;

public class testadoraCSV {
	public static void main(String[] args) {
	//Locale.setDefault(new Locale("pt", "BR"));
		try {			
				LePlanilha.selectPlanilha(args);
				CsvWriter.generateOutputFiles();								
				
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
