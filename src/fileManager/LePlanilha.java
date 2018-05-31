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
	private static ArrayList<Integer> codigosDocentesList;
	private static ArrayList<Integer> codigosCursosList;
	private static ArrayList<Discente> discentesList = new ArrayList<Discente>();
	
	
	public static void selectPlanilha(String[] args) throws NumberFormatException, IOException,RepeatedCodeException, InvalidCodeException, CourseLevelException, InvalidFutureDateException{
		File arq = null;
		String flag = null;
		File[] arquivos = new File[4]; 
		for(int i = 0; i < args.length; i+= 2) {
			arq = new File(args[i+1]);
			flag = args[i];

			switch(flag) {
			case "-d": //docentes
				ArrayList<Docente> docentes = lePlanilhaDocentes(arq);
				for (Docente professor: docentes) {
					System.out.println(professor);
				}
				break;
			case "-a": // discentes
				ArrayList<Discente> discentes = lePlanilhaDiscentes(arq);
				for (Discente aluno: discentes) {
					System.out.println(aluno);
				}
				break;
			case "-c": //cursos
				ArrayList<Curso> cursos = lePlanilhaCursos(arq);
				for (Curso curso : cursos) {
					System.out.println(curso);
				}
				break;
			case "-p": // producoes
				arquivos[0] = arq;
				break;
			case "-r": //disciplinas
				arquivos[1] = arq;
				break;
			case "-og": //Orientação Grad
				arquivos[2] = arq;
				break;
			case "-op": //Orientação Pos Grad
				arquivos[3] = arq;
				break;
			}			
		}
		
		//producoes
		ArrayList<ProducaoCientifica> producoes = lePlanilhaProducaoCientifica(arquivos[0]);
		for (ProducaoCientifica producaoCientifica : producoes) {
			System.out.println(producaoCientifica);
		}
		
		//disciplinas
		ArrayList<Disciplina> disciplinas = lePlanilhaDisciplinas(arquivos[1]);
		for (Disciplina disciplina : disciplinas) {
			System.out.println(disciplina);
		}
		
		//Orientação Grad
		ArrayList<AtividadeOrientadaDiscenteGraduacao> atividadesGrad = lePlanilhaOrientacaoGrad(arquivos[2]);
		for (AtividadeOrientadaDiscenteGraduacao atividadeOrientadaDiscenteGraduacao : atividadesGrad) {
			System.out.println(atividadeOrientadaDiscenteGraduacao);
		}
		
		//Orientação Pos Grad
		ArrayList<AtividadeOrientadaDiscentePosGraduacao> atividadesPosGrad = lePlanilhaOrientacaoPos(arquivos[3]);
		for (AtividadeOrientadaDiscentePosGraduacao atividadeOrientadaDiscentePosGraduacao : atividadesPosGrad) {
			System.out.println(atividadeOrientadaDiscentePosGraduacao);
		}
		
	}
	
	public static ArrayList<Discente> lePlanilhaDiscentes(File arq)throws NumberFormatException, IOException, RepeatedCodeException {
		ArrayList<Discente> alunos = new ArrayList<Discente>();
		String[] linhaLida = null;
			BufferedReader br = new BufferedReader(new FileReader(arq)); //abre arquivo
			while((linhaLida = csvReader.leLinhaCSV(br)) != null) {		//le linha 
				
				//matricula nao pode exceder 10 digitos
				if(linhaLida[0].length() != 10) //ESSA ERA A DUVIDA
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
			discentesList = alunos;
		return alunos;
	}
	
	public static ArrayList<Curso> lePlanilhaCursos(File arq)throws IOException, CourseLevelException, RepeatedCodeException {
		String[] linhaLida = new String[4];
		
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		codigosCursosList = new ArrayList<Integer>();
		BufferedReader br = new BufferedReader(new FileReader(arq)); //abre arquivo
			while((linhaLida = csvReader.leLinhaCSV(br)) != null) {		//le linha  
				//converte o codigo lido pra inteiro
				int tipoCurso = 0;
				int codigoCurso = Integer.parseInt(linhaLida[0]);
				
				String nome = linhaLida[1];
				
				//testa se nao possui marcacao
				if (linhaLida.length == 2) { //nenhum curso foi marcado
					throw new CourseLevelException(codigoCurso, nome); 
				}
				
				if(linhaLida.length == 4) { //possivel marcacao de duas opcoes
					if(linhaLida[2].isEmpty() && linhaLida[3].equalsIgnoreCase("x")) 
						tipoCurso = 1; // pos graduacao 
					if (linhaLida[2].equalsIgnoreCase("x") && linhaLida[3].isEmpty())
						tipoCurso = 0; // graduacao
					if ((!linhaLida[2].isEmpty() && !linhaLida[2].equalsIgnoreCase("x")) || (!linhaLida[3].isEmpty() && !linhaLida[3].equalsIgnoreCase("x")))
						throw new NumberFormatException();
					if (linhaLida[2].equalsIgnoreCase("x") && linhaLida[3].equalsIgnoreCase("x"))
						throw new CourseLevelException(codigoCurso, nome);
					if (!linhaLida[2].equalsIgnoreCase("x") && !linhaLida[3].equalsIgnoreCase("x"))
						throw new CourseLevelException(codigoCurso, nome);
				}
				

				if(linhaLida.length == 3) { // possivel marcacao de x apenas em graduacao
					if(!linhaLida[2].equalsIgnoreCase("x")){
						throw new CourseLevelException(codigoCurso, nome);
					} else {
						tipoCurso = 0; //graduacao
					}
				}				
				
				//instancia objeto
				Curso novoCurso = new Curso(codigoCurso, nome, tipoCurso);
				//verifica se mesmo código de curso foi utilizado para dois cursos diferentes
				//TODO testar isso com o contains dps
				for (Curso curso : cursos) {
					if(novoCurso.compareTo(curso))
						throw new RepeatedCodeException(codigoCurso, novoCurso);
				}
				//adiciona codigo do curso num array de codigos para posterior uso
				codigosCursosList.add(codigoCurso);
				
				//adiciona novo curso na lista de cursos
				cursos.add(novoCurso);
			}
			return cursos;
	}
	
	public static ArrayList<Docente> lePlanilhaDocentes(File arq) throws NumberFormatException, IOException, RepeatedCodeException{	
		String[] linhaLida = null;
		codigosDocentesList = new ArrayList<Integer>();
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
				codigosDocentesList.add(codigo);
				docentes.add(docente);			
			}
			return docentes;
	}
	
	public static ArrayList<AtividadeOrientadaDiscenteGraduacao> lePlanilhaOrientacaoGrad(File arq) throws NumberFormatException, IOException, RepeatedCodeException, DocenteOrientacaoInvalidCodeException, CursoOrientacaoInvalidCodeException{
		String[] linhaLida = null;
		ArrayList<AtividadeOrientadaDiscenteGraduacao> atividadesGrad = new ArrayList<AtividadeOrientadaDiscenteGraduacao>();
			BufferedReader br = new BufferedReader(new FileReader(arq));
			while((linhaLida = csvReader.leLinhaCSV(br)) != null) {
				
				int codigoDoDocente = Integer.parseInt(linhaLida[0]);
				
				//matricula nao pode exceder o max int value
				long matriculaDoDiscente = Long.parseLong(linhaLida[1]);
				
				//verifica se codigo de docente é valido
				if(!codigosDocentesList.contains(codigoDoDocente))
					throw new DocenteOrientacaoInvalidCodeException(codigoDoDocente, Discente.getDiscentePorMatricula(discentesList, matriculaDoDiscente).getNome());

				int codigoDoCursoDiscente = Integer.parseInt(linhaLida[2]);
				
				//testa se o codigo do curso é valido
				if(!codigosCursosList.contains(codigoDoCursoDiscente))
					throw new CursoOrientacaoInvalidCodeException(codigoDoCursoDiscente, Discente.getDiscentePorMatricula(discentesList, matriculaDoDiscente).getNome());
				
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
			}
			return atividadesGrad;
	}
	
	public static ArrayList<Disciplina> lePlanilhaDisciplinas(File arq) throws NumberFormatException, IOException, RepeatedCodeException, DocenteDisciplinaInvalidCodeException, CursoDisciplinaInvalidCodeException{
		String[] linhaLida = null;
		ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
		BufferedReader br = new BufferedReader(new FileReader(arq)); // abre arquivo
		while((linhaLida = csvReader.leLinhaCSV(br)) != null) {		//le linha 
			
			//codigo alfanumerico da disciplina
			String codigoDisciplina = linhaLida[0];
			
			//nome da disciplina
			String nomeDisciplina = linhaLida[1];
			
			int codigoDocente = Integer.parseInt(linhaLida[2]);
			
			//testa se o codigo do docente é valido
			if(!codigosDocentesList.contains(codigoDocente))
				throw new DocenteDisciplinaInvalidCodeException(codigoDocente, nomeDisciplina);
			
			int cargaHorariaSemanal = Integer.parseInt(linhaLida[3]);
			
			int cargaHorariaSemestral = Integer.parseInt(linhaLida[4]);
			
			int codigoCurso = Integer.parseInt(linhaLida[5]);
			
			if(!codigosCursosList.contains(codigoCurso))
				throw new CursoDisciplinaInvalidCodeException(codigoCurso, nomeDisciplina);
			
			//instancia o objeto
			Disciplina disciplina = new Disciplina(codigoDisciplina, nomeDisciplina, codigoDocente, cargaHorariaSemanal, cargaHorariaSemestral, codigoCurso);
			
			//verifica conflitos na disciplina 
			//TODO ainda falta outras comparacoes
			for (Disciplina d : disciplinas) {
				if(disciplina.compareCodigoDisciplina(d) == true)
					throw new RepeatedCodeException(codigoDisciplina, disciplina);
			}
			
			//adiciona na lista
			disciplinas.add(disciplina);
		}
			return disciplinas;
	}
	
	public static ArrayList<AtividadeOrientadaDiscentePosGraduacao> lePlanilhaOrientacaoPos(File arq) throws NumberFormatException, IOException, InvalidFutureDateException, DocenteOrientacaoInvalidCodeException{
		String[] linhaLida = null;
		ArrayList<AtividadeOrientadaDiscentePosGraduacao> atividadesPos = new ArrayList<AtividadeOrientadaDiscentePosGraduacao>();
		BufferedReader br = new BufferedReader(new FileReader(arq)); //abre arquivo
			while( (linhaLida = csvReader.leLinhaCSV(br)) != null ) {
				
				int codigoDocente = Integer.parseInt(linhaLida[0]);
				
				//matricula nao pode exceder o max int value
				long matriculaDiscente = Long.parseLong(linhaLida[1]); 
				
				//verifica se codigo de docente é valido
				if(!codigosDocentesList.contains(codigoDocente))
					throw new DocenteOrientacaoInvalidCodeException(codigoDocente, Discente.getDiscentePorMatricula(discentesList, matriculaDiscente).getNome());
				
				//estabalece o formato q a data sera recebida
				DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				
				LocalDate dataIngressoDiscente = LocalDate.parse(linhaLida[2], formatador);
							
				if(dataIngressoDiscente.isAfter(LocalDate.now()) == true) {
					Discente aluno = Discente.getDiscentePorMatricula(discentesList, matriculaDiscente);
					throw new InvalidFutureDateException(aluno.getNome(), dataIngressoDiscente);
				}
				
				String programa = linhaLida[3];								
				
				int cargaSemanal = Integer.parseInt(linhaLida[4]);
				
				//instancia o objeto
				AtividadeOrientadaDiscentePosGraduacao posGrad = new AtividadeOrientadaDiscentePosGraduacao(codigoDocente, matriculaDiscente, dataIngressoDiscente, programa, cargaSemanal);
				
				//adiciona na lista de atividades de pos graduacao
				atividadesPos.add(posGrad);
			}
			return atividadesPos;	
	}
	
	public static ArrayList<ProducaoCientifica> lePlanilhaProducaoCientifica(File arq) throws NumberFormatException, IOException, DocenteProducaoInvalidCodeException{
		String[] linhaLida = null;
		ArrayList<ProducaoCientifica> producoes = new ArrayList<ProducaoCientifica>();
		//try(BufferedReader br = new BufferedReader(new FileReader(arq))){	//abre arquivo
			BufferedReader br = new BufferedReader(new FileReader(arq));
		
			while((linhaLida = csvReader.leLinhaCSV(br)) != null) {		//le linha 
				
				//converte o codigo lido pra inteiro
				int codigoDocente = Integer.parseInt(linhaLida[0]);
				
				
				String titulo = linhaLida[1];
				
				//testa se o codigo do docente é valido
				if(!codigosDocentesList.contains(codigoDocente))
					throw new DocenteProducaoInvalidCodeException(codigoDocente, titulo);

					boolean qualificado;
				if (linhaLida.length == 3)
					qualificado = verificaCheckbox(linhaLida[2]);
				else
					qualificado = false;

				//instancia objeto
				ProducaoCientifica prod = new ProducaoCientifica(codigoDocente, titulo, qualificado);
				producoes.add(prod);
			}
			return producoes;
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
