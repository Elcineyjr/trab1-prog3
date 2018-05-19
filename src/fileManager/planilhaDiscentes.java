package fileManager;

import java.io.*;

public class planilhaDiscentes {

	public static void lePlanilhaDiscentes(/*receber arquivo como parametro*/) {
		
		String caminho = "C:\\Users\\Júnior\\Desktop\\UFES\\trab\\src\\fileManager\\teste.csv";
		
		String[] linhaLida = null;
		try(BufferedReader br = new BufferedReader(new FileReader(caminho))){	//abre arquivo
			while((linhaLida = csvReader.leLinhaCSV(br)) != null) {		//le linha 
				
				//matricula nao pode exceder o max int value
				//converte o codigo lido pra inteiro
				int matricula = Integer.parseInt(linhaLida[0]);
				
				String nome = linhaLida[1];
				int codigoCurso = Integer.parseInt(linhaLida[2]);
				
				//printa pra teste
				System.out.println(matricula + "\n" + nome + "\n" + codigoCurso + "\n");
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
