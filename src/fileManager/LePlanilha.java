package fileManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import exceptionManager.*;

import instanciaveis.*;


public class LePlanilha {
	
	public static void selectPlanilha(File arq, String flag) throws NumberFormatException, IOException,RepeatedCodeException, InvalidCodeException, CourseLevelException, InvalidFutureDateException{
			
		switch(flag) {
		case "-d":
			ArrayList<Docente> docentes = lePlanilhaDocentes(arq);
			for (Docente professor: docentes) {
				System.out.println(professor);
			}
			break;
		case "-a":
			ArrayList<Discente> discentes = lePlanilhaDiscentes(arq);
			for (Discente aluno: discentes) {
				System.out.println(aluno);
			}
			break;
		case "-p":
			ArrayList<ProducaoCientifica> producoes = lePlanilhaProducaoCientifica(arq);
			for (ProducaoCientifica producaoCientifica : producoes) {
				System.out.println(producaoCientifica);
			}
			break;
		case "-c":
			ArrayList<Curso> cursos = lePlanilhaCursos(arq);
			for (Curso curso : cursos) {
				System.out.println(curso);
			}
			break;
		case "-r":
			ArrayList<Disciplina> disciplinas = lePlanilhaDisciplinas(arq);
			for (Disciplina disciplina : disciplinas) {
				System.out.println(disciplina);
			}
			break;
		case "-og":
			ArrayList<AtividadeOrientadaDiscenteGraduacao> atividadesGrad = lePlanilhaOrientacaoGrad(arq);
			for (AtividadeOrientadaDiscenteGraduacao atividadeOrientadaDiscenteGraduacao : atividadesGrad) {
				System.out.println(atividadeOrientadaDiscenteGraduacao);
			}
			break;
		case "-op":
			ArrayList<AtividadeOrientadaDiscentePosGraduacao> atividadesPosGrad = lePlanilhaOrientacaoPos(arq);
			for (AtividadeOrientadaDiscentePosGraduacao atividadeOrientadaDiscentePosGraduacao : atividadesPosGrad) {
				System.out.println(atividadeOrientadaDiscentePosGraduacao);
			}
			break;
		}
	}
	
	public static ArrayList<Discente> lePlanilhaDiscentes(File arq)throws NumberFormatException, IOException, RepeatedCodeException {
		ArrayList<Discente> alunos = new ArrayList<Discente>();
		String[] linhaLida = null;
			BufferedReader br = new BufferedReader(new FileReader(arq)); //abre arquivo
			while((linhaLida = csvReader.leLinhaCSV(br)) != null) {		//le linha 
				
				//matricula nao pode exceder 10 digitos
				if(linhaLida[0].length() != 10)
					throw new NumberFormatException();
				
				//converte o codigo lido pra long
				long matricula = Long.parseLong(linhaLida[0]);					
				String nome = linhaLida[1];
				int codigoDoCurso = Integer.parseInt(linhaLida[2]);
				
				//instancia objeto
				Discente aluno = new Discente(matricula, nome, codigoDoCurso);
				
				//verifica se na ha conflito de matriculas
				for (Discente a : alunos) {
					if(aluno.compareTo(a) == true)
						throw new RepeatedCodeException(matricula, aluno);
				}
				
				//adiciona o aluno na lista
				alunos.add(aluno);
			}
		return alunos;
	}
	
	public static ArrayList<Curso> lePlanilhaCursos(File arq)throws IOException, CourseLevelException {
		String[] linhaLida = new String[4];

		ArrayList<Curso> cursos = new ArrayList<Curso>();
		BufferedReader br = new BufferedReader(new FileReader(arq)); //abre arquivo
			while((linhaLida = csvReader.leLinhaCSV(br)) != null) {		//le linha  
				//converte o codigo lido pra inteiro
				int tipoCurso = 0;
				int codigoCurso = Integer.parseInt(linhaLida[0]);
				
				String nome = linhaLida[1];
				
				//testa se possui marcação além da esperada
				if (linhaLida.length == 2) { //nenhum curso foi marcado
					throw new CourseLevelException(codigoCurso, nome); 
				}
				
				if(linhaLida.length == 4) { //possivel marcação de duas opções
					if(linhaLida[2].isEmpty() && linhaLida[3].equalsIgnoreCase("x")) 
						tipoCurso = 1; // pos graduação 
					if (linhaLida[2].equalsIgnoreCase("x") && linhaLida[3].isEmpty())
						tipoCurso = 0; // graduação
					if (linhaLida[2].equalsIgnoreCase("x") && linhaLida[3].equalsIgnoreCase("x"))
						throw new CourseLevelException(codigoCurso, nome);
					if (!linhaLida[2].equalsIgnoreCase("x") && !linhaLida[3].equalsIgnoreCase("x"))
						throw new CourseLevelException(codigoCurso, nome);
				}
				
						
				if(linhaLida.length == 3) { // possivel marcação de x apenas em graduação
					if(!linhaLida[2].equalsIgnoreCase("x")){
						throw new CourseLevelException(codigoCurso, nome);
					} else {
						tipoCurso = 0; //graduação
					}
				}				
				
				//instancia objeto
				Curso curso = new Curso(codigoCurso, nome, tipoCurso);
				cursos.add(curso);
				//printa pra teste
//				System.out.println(codigoCurso + "\n" + nome + "\n");
			}
			return cursos;

//		System.out.println("-------------------------------------");
	}
	
	public static ArrayList<Docente> lePlanilhaDocentes(File arq) throws NumberFormatException, IOException, RepeatedCodeException{	
		String[] linhaLida = null;
		ArrayList<Docente> docentes = new ArrayList<Docente>();
		BufferedReader br = new BufferedReader(new FileReader(arq));//abre arquivo
			while((linhaLida = csvReader.leLinhaCSV(br)) != null) {		//le linha 
				
				//converte o codigo lido pra inteiro
				int codigo = Integer.parseInt(linhaLida[0]);
				
				String nome = linhaLida[1];
				String departamento = linhaLida[2];
				
				//instancia o objeto
				Docente docente = new Docente(codigo, nome, departamento);
				
				//verifica se nao ha conflito de codigo
				for (Docente d : docentes) {
					if(docente.compareTo(d) == true)
						throw new RepeatedCodeException(codigo, docente);
				}
				
				//adiciona na lista de docentes
				docentes.add(docente);
			}
			return docentes;
	}
	
	public static ArrayList<AtividadeOrientadaDiscenteGraduacao> lePlanilhaOrientacaoGrad(File arq) throws NumberFormatException, IOException, RepeatedCodeException{
		String[] linhaLida = null;
		ArrayList<AtividadeOrientadaDiscenteGraduacao> atividadesGrad = new ArrayList<AtividadeOrientadaDiscenteGraduacao>();
			BufferedReader br = new BufferedReader(new FileReader(arq));
			while((linhaLida = csvReader.leLinhaCSV(br)) != null) {
				
				int codigoDoDocente = Integer.parseInt(linhaLida[0]);
				
				//matricula nao pode exceder o max int value
				int matriculaDoDiscente = Integer.parseInt(linhaLida[1]);
				
				int codigoDoCursoDiscente = Integer.parseInt(linhaLida[2]);
				
				int cargaHorariaSemanal = Integer.parseInt(linhaLida[3]);
				
				//instancia o objeto
				AtividadeOrientadaDiscenteGraduacao grad = new AtividadeOrientadaDiscenteGraduacao(codigoDoDocente, matriculaDoDiscente, codigoDoCursoDiscente, cargaHorariaSemanal);
				
				//verifica conflito de codigos de curso
				for (AtividadeOrientadaDiscenteGraduacao a : atividadesGrad) {
					if(grad.compareCodigoDocente(a) == true)
						throw new RepeatedCodeException(codigoDoDocente, grad);
					if(grad.compareCodigoCurso(a) == true)
						throw new RepeatedCodeException(codigoDoCursoDiscente, grad);
				}
				
				//insere na lista
				atividadesGrad.add(grad);
				//printa pra teste
//				System.out.println(codigoDocente + "\n" + matriculaDiscente + "\n" + codigoCursoDiscente + "\n" + cargaHorariaSemananal + "\n");
			}
			return atividadesGrad;
//		System.out.println("-------------------------------------");
	}
	
	public static ArrayList<Disciplina> lePlanilhaDisciplinas(File arq) throws NumberFormatException, IOException, RepeatedCodeException{
		String[] linhaLida = null;
		ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
			BufferedReader br = new BufferedReader(new FileReader(arq)); // abre arquivo
			while((linhaLida = csvReader.leLinhaCSV(br)) != null) {		//le linha 
				
				//codigo alfanumerico da disciplina
				String codigoDisciplina = linhaLida[0];
				
				//nome da disciplina
				String nomeDisciplina = linhaLida[1];
				
				int codigoDocente = Integer.parseInt(linhaLida[2]);
				
				int cargaHorariaSemanal = Integer.parseInt(linhaLida[3]);
				
				int cargaHorariaSemestral = Integer.parseInt(linhaLida[4]);
				
				int codigoCurso = Integer.parseInt(linhaLida[5]);
				
				//instancia o objeto
				Disciplina disciplina = new Disciplina(codigoDisciplina, nomeDisciplina, codigoDocente, cargaHorariaSemanal, cargaHorariaSemestral, codigoCurso);
				
				//verifica conflitos na disciplina 
				//TODO ainda falta outras compara�oes
				for (Disciplina d : disciplinas) {
					if(disciplina.compareCodigoDisciplina(d) == true)
						throw new RepeatedCodeException(codigoDisciplina, disciplina);
				}
				
				//adiciona na lista
				disciplinas.add(disciplina);
				//printa pra teste
//				System.out.println(codigoDisciplina + "\n" + nomeDisciplina + "\n" + codigoDocente + "\n" + cargaHorariaSemanal + "\n" + cargaHorariaSemestral + "\n" + codigoCurso + "\n");

		}
//		System.out.println("-------------------------------------");
			return disciplinas;
	}
	
	public static ArrayList<AtividadeOrientadaDiscentePosGraduacao> lePlanilhaOrientacaoPos(File arq) throws NumberFormatException, IOException, InvalidFutureDateException{
		String[] linhaLida = null;
		ArrayList<AtividadeOrientadaDiscentePosGraduacao> atividadesPos = new ArrayList<AtividadeOrientadaDiscentePosGraduacao>();
		BufferedReader br = new BufferedReader(new FileReader(arq)); //abre arquivo
			while( (linhaLida = csvReader.leLinhaCSV(br)) != null ) {
				
				int codigoDocente = Integer.parseInt(linhaLida[0]);
				
				//matricula nao pode exceder o max int value
				int matriculaDiscente = Integer.parseInt(linhaLida[1]); 
				
				DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				
				LocalDate dataIngressoDiscente = LocalDate.parse(linhaLida[2], formatador);
				
				String programa = linhaLida[3];
				
				int cargaSemanal = Integer.parseInt(linhaLida[4]);
				
				//instancia o objeto
				AtividadeOrientadaDiscentePosGraduacao posGrad = new AtividadeOrientadaDiscentePosGraduacao(codigoDocente, matriculaDiscente, dataIngressoDiscente, programa, cargaSemanal);
				atividadesPos.add(posGrad);
				//print pra teste
//				System.out.println(codigoDocente + "\n" + matriculaDiscente + "\n" + programa + "\n" + cargaSemanal + "\n");
			}
			return atividadesPos;
//		System.out.println("-------------------------------------");
				
	}
	
	public static ArrayList<ProducaoCientifica> lePlanilhaProducaoCientifica(File arq) throws NumberFormatException, IOException{
		String[] linhaLida = null;
		ArrayList<ProducaoCientifica> producoes = new ArrayList<ProducaoCientifica>();
		//try(BufferedReader br = new BufferedReader(new FileReader(arq))){	//abre arquivo
			BufferedReader br = new BufferedReader(new FileReader(arq));
		
			while((linhaLida = csvReader.leLinhaCSV(br)) != null) {		//le linha 
				
				//converte o codigo lido pra inteiro
				int codigoDocente = Integer.parseInt(linhaLida[0]);
				
				String titulo = linhaLida[1];
				
				boolean qualificado;
				if (linhaLida.length == 3)
					qualificado = verificaCheckbox(linhaLida[2]);
				else
					qualificado = false;

				//instancia objeto
				ProducaoCientifica prod = new ProducaoCientifica(codigoDocente, titulo, qualificado);
				producoes.add(prod);
				//printa pra teste
//				System.out.println(codigoDocente + "\n" + titulo + "\n" + qualificado + "\n");
			}
			return producoes;
//		System.out.println("-------------------------------------");
	}
	
	
	public static boolean verificaCheckbox (String s) {
		char[] array = s.toCharArray();
		if(array.length > 1)
			throw new NumberFormatException();			
		else
			if(s.equalsIgnoreCase("x") == false)
				throw new NumberFormatException();		
		
		return s.equalsIgnoreCase("x");
	}
	
}
