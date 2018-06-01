package fileManager;

import java.io.*;

public class csvReader {
	
	public static String[] leLinhaCSV(BufferedReader br) {
		String line = "";
		String csvSplitBy = ";";
		String[] palavra = null;
		
		label: try{
			
			if((line = br.readLine()) == null) 
				break label;
				
			//usa o ; como separador 
			palavra = line.split(csvSplitBy);
		}catch (IOException e) {
			e.printStackTrace();
		}
		return palavra;
	}
}
