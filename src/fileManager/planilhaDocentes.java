package fileManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class planilhaDocentes {
	public static void main(String[] agrs) {
		String caminho = "/home/2015100338/Área de Trabalho/Trabalho Prog 3/trab1-prog3/src/fileManager/teste.csv";
		String[] linhaLida = null;
		try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
			for(int i = 0; i < 3; i++) {				
				linhaLida = csvReader.leLinhaCSV(br);
//				System.out.println(linhaLida[0] + "\n" + linhaLida[1] + "\n" + linhaLida[2] + "\n");	
				int codigo = Integer.parseInt(linhaLida[0]);
				String nome = linhaLida[1];
				String departamento = linhaLida[2];
				System.out.println(codigo + "\n" + nome + "\n" + departamento + "\n");
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
//		br.close();
	}
}
