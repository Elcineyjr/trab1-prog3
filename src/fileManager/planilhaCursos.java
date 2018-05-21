package fileManager;

import java.io.*;

public class planilhaCursos {
	
	public static void lePlanilhaCursos(File arq) {
		String[] linhaLida = null;
		try(BufferedReader br = new BufferedReader(new FileReader(arq))){	//abre arquivo
			while((linhaLida = csvReader.leLinhaCSV(br)) != null) {		//le linha  
				
				//converte o codigo lido pra inteiro
				int codigoCurso = Integer.parseInt(linhaLida[0]);
				
				String nome = linhaLida[1];
				
				//TODO terminar isso
//				//TODO verificar se nao foi digitado mais de um char ou outra letra sem ser X
//				if (linhaLida[2] != null) {
//					
//					char graduacao = linhaLida[2].charAt(0);
//				}
//				
//				char pos = linhaLida[3].charAt(0); 
//				
				
				//printa pra teste
				System.out.println(codigoCurso + "\n" + nome + "\n");
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("-------------------------------------");
	}
}
