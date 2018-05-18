package fileManager;

import java.io.*;

public class csvReader {
	public static String[] leLinhaCSV(BufferedReader br) {
		String line = "";
		String csvSplitBy = ";";
		String[] palavra = null;
		try{
			
			if((line = br.readLine()) != null) // corrigir aqui
				
			//usa o ; como separador 
			palavra = line.split(csvSplitBy);
		}catch (IOException e) {
			e.printStackTrace();
		}
		return palavra;
	}
}
