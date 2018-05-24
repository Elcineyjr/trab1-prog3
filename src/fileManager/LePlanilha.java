package fileManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import instanciaveis.*;


public class LePlanilha {
	private static boolean validadeDosArquivosDeLeitura = true; //variavel para verificar se a leitura de todos os arquivos foi validada, se terminar a leitura dos arquivos com o valor true, significa que não houveram erros na leitura dos arquivos de entrada.
	
	public static void setObjects() {
		
	}
	
	public static boolean selectPlanilha(File arq, String flag) {
		try {
			
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
		catch(NumberFormatException e) {
			System.out.println("Erro de formatação");
			validadeDosArquivosDeLeitura = false;
		}
		catch(IOException e) {
			System.out.println("Erro de I/O");
			validadeDosArquivosDeLeitura = false;
		}
		return validadeDosArquivosDeLeitura;
	}
	
	public static ArrayList<Discente> lePlanilhaDiscentes(File arq)throws NumberFormatException, IOException {
		ArrayList<Discente> alunos = new ArrayList<Discente>();
		String[] linhaLida = null;
			BufferedReader br = new BufferedReader(new FileReader(arq)); //abre arquivo
			while((linhaLida = csvReader.leLinhaCSV(br)) != null) {		//le linha 
				
				//matricula nao pode exceder o max int value
				//converte o codigo lido pra inteiro
					int matricula = Integer.parseInt(linhaLida[0]);					
					String nome = linhaLida[1];
					int codigoDoCurso = Integer.parseInt(linhaLida[2]);
					
					//instancia objeto
					Discente aluno = new Discente(matricula, nome, codigoDoCurso);
					
					alunos.add(aluno);
					//printa pra teste
//					System.out.println(matricula + "\n" + nome + "\n" + codigoDoCurso + "\n");
				
			}
		return alunos;
//		System.out.println("-------------------------------------");
	}
	
	public static ArrayList<Curso> lePlanilhaCursos(File arq)throws NumberFormatException, IOException {
		String[] linhaLida = null;
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		BufferedReader br = new BufferedReader(new FileReader(arq)); //abre arquivo
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
				//instancia objeto
				Curso curso = new Curso(codigoCurso, nome);
				cursos.add(curso);
				//printa pra teste
//				System.out.println(codigoCurso + "\n" + nome + "\n");
			}
			return cursos;

//		System.out.println("-------------------------------------");
	}
	
	public static ArrayList<Docente> lePlanilhaDocentes(File arq) throws NumberFormatException, IOException{	
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
				docentes.add(docente);
				//printa pra teste
//				System.out.println(codigo + "\n" + nome + "\n" + departamento + "\n");
			}
			return docentes;
//		System.out.println("-------------------------------------");
	}
	
	public static ArrayList<AtividadeOrientadaDiscenteGraduacao> lePlanilhaOrientacaoGrad(File arq) throws NumberFormatException, IOException{
		String[] linhaLida = null;
		ArrayList<AtividadeOrientadaDiscenteGraduacao> atividadesGrad = new ArrayList<AtividadeOrientadaDiscenteGraduacao>();
			BufferedReader br = new BufferedReader(new FileReader(arq));
			while((linhaLida = csvReader.leLinhaCSV(br)) != null) {
				
				int codigoDoDocente = Integer.parseInt(linhaLida[0]);
				
				//matricula nao pode exceder o max int value
				int matriculaDoDiscente = Integer.parseInt(linhaLida[1]);
				
				int codigoDoCursoDiscente = Integer.parseInt(linhaLida[2]);
				
				int cargaHorariaSemanal = Integer.parseInt(linhaLida[3]);
				
				AtividadeOrientadaDiscenteGraduacao grad = new AtividadeOrientadaDiscenteGraduacao(codigoDoDocente, matriculaDoDiscente, codigoDoCursoDiscente, cargaHorariaSemanal);
				atividadesGrad.add(grad);
				//printa pra teste
//				System.out.println(codigoDocente + "\n" + matriculaDiscente + "\n" + codigoCursoDiscente + "\n" + cargaHorariaSemananal + "\n");
			}
			return atividadesGrad;
//		System.out.println("-------------------------------------");
	}
	
	public static ArrayList<Disciplina> lePlanilhaDisciplinas(File arq) throws NumberFormatException, IOException {
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
				
				Disciplina disciplina = new Disciplina(codigoDisciplina, nomeDisciplina, codigoDocente, cargaHorariaSemanal, cargaHorariaSemestral, codigoCurso);
				disciplinas.add(disciplina);
				//printa pra teste
//				System.out.println(codigoDisciplina + "\n" + nomeDisciplina + "\n" + codigoDocente + "\n" + cargaHorariaSemanal + "\n" + cargaHorariaSemestral + "\n" + codigoCurso + "\n");

		}
//		System.out.println("-------------------------------------");
			return disciplinas;
	}
	
	public static ArrayList<AtividadeOrientadaDiscentePosGraduacao> lePlanilhaOrientacaoPos(File arq) throws NumberFormatException, IOException{
		String[] linhaLida = null;
		ArrayList<AtividadeOrientadaDiscentePosGraduacao> atividadesPos = new ArrayList<AtividadeOrientadaDiscentePosGraduacao>();
		BufferedReader br = new BufferedReader(new FileReader(arq)); //abre arquivo
			while( (linhaLida = csvReader.leLinhaCSV(br)) != null ) {
				
				int codigoDocente = Integer.parseInt(linhaLida[0]);
				
				//matricula nao pode exceder o max int value
				int matriculaDiscente = Integer.parseInt(linhaLida[1]); 
				
				//TODO parsing da data do ingresso do discente e ajustar index
				LocalDate dataIngressoDiscente = LocalDate.of(1996, 12, 02);
				
				String programa = linhaLida[2];
				
				int cargaSemanal = Integer.parseInt(linhaLida[3]);
				
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
				
				//TODO verificar se nao foi digitado mais de um char ou outra letra sem ser X
				//csv deve ter campo vazio se nao for qualificada?
//				char qualificado = linhaLida[2].charAt(0); 
				boolean qualificado = true;

				//instancia objeto
				ProducaoCientifica prod = new ProducaoCientifica(codigoDocente, titulo, qualificado);
				producoes.add(prod);
				//printa pra teste
//				System.out.println(codigoDocente + "\n" + titulo + "\n" + qualificado + "\n");
			}
			return producoes;
//		System.out.println("-------------------------------------");
	}
	
}
