package fileManager;

import java.io.*;

import exceptionManager.*;

public class testadoraCSV {

	public static void main(String[] args) {
		File arq = null;
		
		try {
			for(int i = 0; i < args.length; i+= 2) {
				arq = new File(args[i+1]);
			
				LePlanilha.selectPlanilha(arq, args[i]);

			}
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
