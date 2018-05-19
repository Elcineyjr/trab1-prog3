package fileManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class planilhaOrientacaoGrad {
	
	public static void lePlanilhaOrientacaoGrad() {
		
		String caminho = "C:\\\\Users\\\\Júnior\\\\Desktop\\\\UFES\\\\trab\\\\src\\\\fileManager\\\\teste.csv";
		
		String[] linhaLida = null;
		
		try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
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
	}
	
}
