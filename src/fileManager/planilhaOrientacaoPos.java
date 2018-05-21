package fileManager;

import java.io.*;

public class planilhaOrientacaoPos {

	public static void lePlanilhaOrientacaoPos(File arq) {
		String[] linhaLida = null;
		try(BufferedReader br = new BufferedReader(new FileReader(arq))){
			while( (linhaLida = csvReader.leLinhaCSV(br)) != null ) {
				
				int codigoDocente = Integer.parseInt(linhaLida[0]);
				
				//matricula nao pode exceder o max int value
				int matriculaDiscente = Integer.parseInt(linhaLida[1]); 
				
				//TODO parsing da data do ingresso do discente
				
				String programa = linhaLida[2];
				
				int cargaSemanal = Integer.parseInt(linhaLida[3]);
				
				//print pra teste
				System.out.println(codigoDocente + "\n" + matriculaDiscente + "\n" + programa + "\n" + cargaSemanal + "\n");
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("-------------------------------------");
				
	}
}