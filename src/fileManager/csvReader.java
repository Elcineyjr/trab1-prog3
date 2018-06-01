package fileManager;

import java.io.*;

public class csvReader {
	
	public static String[] leLinhaCSV(BufferedReader br) throws IOException {
		String line = "";
		String csvSplitBy = ";";
		String[] palavra = null;
		
			
		if((line = br.readLine()) == null) 
			return palavra;
			
		//usa o ; como separador 
		palavra = line.split(csvSplitBy);
		
		return palavra;
	}
}
