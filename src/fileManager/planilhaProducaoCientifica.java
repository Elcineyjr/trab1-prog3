package fileManager;

import java.io.*; 

public class planilhaProducaoCientifica {
	
	public static void lePlanilhaProducaoCientifica(File arq) {
		String[] linhaLida = null;
		try(BufferedReader br = new BufferedReader(new FileReader(arq))){	//abre arquivo
			while((linhaLida = csvReader.leLinhaCSV(br)) != null) {		//le linha 
				
				//converte o codigo lido pra inteiro
				int codigoDocente = Integer.parseInt(linhaLida[0]);
				
				String titulo = linhaLida[1];
				
				//TODO verificar se nao foi digitado mais de um char ou outra letra sem ser X
				//csv deve ter campo vazio se nao for qualificada?
				char qualificado = linhaLida[2].charAt(0); 
				
				//printa pra teste
				System.out.println(codigoDocente + "\n" + titulo + "\n" + qualificado + "\n");
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("-------------------------------------");
	}
}
