package fileManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class planilhaDocentes {

	
	public static void lePlanilhaDocentes() {
		
		//TODO receber o arquivo como parametro
		String caminho = "C:\\Users\\J�nior\\Desktop\\UFES\\trab\\src\\fileManager\\teste.csv";
		
		String[] linhaLida = null;
		try(BufferedReader br = new BufferedReader(new FileReader(caminho))){	//abre arquivo
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
	}

	
	
}
