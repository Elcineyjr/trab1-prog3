package fileManager;

import java.io.*;

public class planilhaDisciplinas {

	public static void lePlanilhaDisciplinas(/*receber arquivo aqui*/) {
		
		String caminho = "C:\\Users\\Júnior\\Desktop\\UFES\\trab\\src\\fileManager\\teste.csv";
		
		String[] linhaLida = null;
		try(BufferedReader br = new BufferedReader(new FileReader(caminho))){	//abre arquivo
			while((linhaLida = csvReader.leLinhaCSV(br)) != null) {		//le linha 
				
				//codigo alfanumerico da disciplina
				String codigoDisciplina = linhaLida[0];
				
				//nome da disciplina
				String nomeDisciplina = linhaLida[1];
				
				int codigoDocente = Integer.parseInt(linhaLida[2]);
				
				int cargaHorariaSemanal = Integer.parseInt(linhaLida[3]);
				
				int cargaHorariaSemestral = Integer.parseInt(linhaLida[4]);
				
				int codigoCurso = Integer.parseInt(linhaLida[5]);
				
				//printa pra teste
				System.out.println(codigoDisciplina + "\n" + nomeDisciplina + "\n" + codigoDocente + "\n" + cargaHorariaSemanal + "\n" + cargaHorariaSemestral + "\n" + codigoCurso + "\n");
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
