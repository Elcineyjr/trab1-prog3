package fileManager;

import java.io.*;

public class csvReader {
	public static void main(String args[]) {
		String caminho = "C:\\Users\\Júnior\\Desktop\\UFES\\trab\\src\\fileManager\\testFile.csv";
		BufferedReader br = null;
		String line = "";
		String csvSplitBy = ";";
		
		try {
			br = new BufferedReader(new FileReader(caminho));
			while ( (line = br.readLine()) != null) {
				
				//usa o ; como separador 
				String[] palavra = line.split(csvSplitBy);
				
				System.out.println(palavra[0] + " " + palavra[1] + " " + palavra[2] + " " + palavra[3] + " " + palavra[4]);
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
