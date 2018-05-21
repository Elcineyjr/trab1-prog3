package fileManager;

import java.io.*;

public class planilhaOrientacaoGrad {
	
	public static void lePlanilhaOrientacaoGrad(File arq) {
		String[] linhaLida = null;
		
		try(BufferedReader br = new BufferedReader(new FileReader(arq))){
			while((linhaLida = csvReader.leLinhaCSV(br)) != null) {
				
				int codigoDocente = Integer.parseInt(linhaLida[0]);
				
				//matricula nao pode exceder o max int value
				int matriculaDiscente = Integer.parseInt(linhaLida[1]);
				
				int codigoCursoDiscente = Integer.parseInt(linhaLida[2]);
				
				int cargaHorariaSemananal = Integer.parseInt(linhaLida[3]);
				
				//printa pra teste
				System.out.println(codigoDocente + "\n" + matriculaDiscente + "\n" + codigoCursoDiscente + "\n" + cargaHorariaSemananal + "\n");
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		System.out.println("-------------------------------------");
	}
	
}
