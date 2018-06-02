package fileManager;

import instanciaveis.*;
import java.io.*;
import java.util.ArrayList;

import exceptionManager.*;

public class testadoraCSV {

	public static void main(String[] args) {
		ArrayList<PAD> padList;
		ArrayList<RHA> rhaList;
		try {			
				LePlanilha.selectPlanilha(args);
				
				
				padList = PAD.createPadList();
				for (PAD pad : padList) {
					System.out.println(pad);
				}
				rhaList = RHA.createRhaList();
				for (RHA rha : rhaList) {
					System.out.println(rha);
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
