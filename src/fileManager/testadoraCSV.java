package fileManager;

import java.io.*;

public class testadoraCSV {

	public static void main(String[] args) {
		File arq = null;
		
		for(int i = 0; i < args.length; i++) {
			arq = new File(args[i]);
			
			if(args[i].equals("docentes.csv")) 
				planilhaDocentes.lePlanilhaDocentes(arq);
			if(args[i].equals("discentes.csv")) 
				planilhaDiscentes.lePlanilhaDiscentes(arq);
			if(args[i].equals("producoes.csv")) 
				planilhaProducaoCientifica.lePlanilhaProducaoCientifica(arq);
			if(args[i].equals("cursos.csv")) 
				planilhaCursos.lePlanilhaCursos(arq);
			if(args[i].equals("disciplinas.csv")) 
				planilhaDisciplinas.lePlanilhaDisciplinas(arq);
			if(args[i].equals("orientacaograd.csv")) 
				planilhaOrientacaoGrad.lePlanilhaOrientacaoGrad(arq);
			if(args[i].equals("orientacaoPos.csv")) 
				planilhaOrientacaoPos.lePlanilhaOrientacaoPos(arq);
		}
	}

}
