package fileManager;

import java.io.*;

public class planilhaDocentes {

	
	public static void lePlanilhaDocentes(File arq) {	
		String[] linhaLida = null;
		try(BufferedReader br = new BufferedReader(new FileReader(arq))){	//abre arquivo
			while((linhaLida = csvReader.leLinhaCSV(br)) != null) {		//le linha 
				
				//converte o codigo lido pra inteiro
				int codigo = Integer.parseInt(linhaLida[0]);
				
				String nome = linhaLida[1];
				String departamento = linhaLida[2];
				
				//printa pra teste
				System.out.println(codigo + "\n" + nome + "\n" + departamento + "\n");
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("-------------------------------------");
	}

	
	
}
