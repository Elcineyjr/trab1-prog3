package fileManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LePlanilha {
	
	public static void selectPlanilha(File arq, String flag) {
		switch(flag) {
		case "-d":
			lePlanilhaDocentes(arq);
			break;
		case "-a":
			lePlanilhaDiscentes(arq);
			break;
		case "-p":
			lePlanilhaProducaoCientifica(arq);
			break;
		case "-c":
			lePlanilhaCursos(arq);
			break;
		case "-r":
			lePlanilhaDisciplinas(arq);
			break;
		case "-og":
			lePlanilhaOrientacaoGrad(arq);
			break;
		case "-op":
			lePlanilhaOrientacaoPos(arq);
			break;
		}
	}
	
	public static void lePlanilhaDiscentes(File arq) {
		String[] linhaLida = null;
		try(BufferedReader br = new BufferedReader(new FileReader(arq))){	//abre arquivo
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
		System.out.println("-------------------------------------");
	}
	
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
	
	public static void lePlanilhaDisciplinas(File arq) {
		String[] linhaLida = null;
		try(BufferedReader br = new BufferedReader(new FileReader(arq))){	//abre arquivo
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
		System.out.println("-------------------------------------");
	}
	
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
