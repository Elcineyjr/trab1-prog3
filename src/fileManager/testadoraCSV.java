package fileManager;

import java.io.*;

public class testadoraCSV {

	public static void main(String[] args) {
		File arq = null;
		
		for(int i = 0; i < args.length; i+= 2) {
			arq = new File(args[i+1]);
			
			LePlanilha.selectPlanilha(arq, args[i]);

		}
	}

}
