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
	private static ArrayList<Discente> discentes;
	private static ArrayList<Curso> cursos;
	private static ArrayList<Docente> docentes;
	private static ArrayList<AtividadeOrientadaDiscenteGraduacao> atividadesGrad;
	private static ArrayList<AtividadeOrientadaDiscentePosGraduacao> atividadesPos;
	private static ArrayList<Disciplina> disciplinas;
	private static ArrayList<ProducaoCientifica> producoes;
	
	public static ArrayList<Docente> getDocentes(){
		return docentes;
	}
	
	
	public static ArrayList<Discente> getDiscentes() {
		return discentes;
	}


	public static ArrayList<Curso> getCursos() {
		return cursos;
	}


	public static ArrayList<AtividadeOrientadaDiscenteGraduacao> getAtividadesGrad() {
		return atividadesGrad;
	}


	public static ArrayList<AtividadeOrientadaDiscentePosGraduacao> getAtividadesPos() {
		return atividadesPos;
	}


	public static ArrayList<Disciplina> getDisciplinas() {
		return disciplinas;
	}


	public static ArrayList<ProducaoCientifica> getProducoes() {
		return producoes;
	}


	public static void selectPlanilha(String[] args) throws NumberFormatException, IOException,RepeatedCodeException, InvalidCodeException, CourseLevelException, InvalidFutureDateException{
		File arq = null;
		String flag = null;
		File[] arquivos = new File[4]; 
		for(int i = 0; i < args.length; i+= 2) {
			arq = new File(args[i+1]);
			flag = args[i];

			switch(flag) {
			case "-d": //docentes
				docentes = lePlanilhaDocentes(arq);
				break;
			case "-a": // discentes
				discentes = lePlanilhaDiscentes(arq);
				break;
			case "-c": //cursos
				cursos = lePlanilhaCursos(arq);
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
		producoes = lePlanilhaProducaoCientifica(arquivos[0]);
		
		//disciplinas
		disciplinas = lePlanilhaDisciplinas(arquivos[1]);
		
		//Orientação Grad
		atividadesGrad = lePlanilhaOrientacaoGrad(arquivos[2]);
		
		//Orientação Pos Grad
		atividadesPos = lePlanilhaOrientacaoPos(arquivos[3]);
		
	}
	
	public static ArrayList<Discente> lePlanilhaDiscentes(File arq)throws NumberFormatException, IOException, RepeatedCodeException {
		ArrayList<Discente> alunos = new ArrayList<Discente>();
		String[] linhaLida = null;
		BufferedReader br = new BufferedReader(new FileReader(arq)); //abre arquivo
		
		br.readLine(); //ignora primeira linha do arquivo
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
	return alunos;
	}
	
	public static ArrayList<Curso> lePlanilhaCursos(File arq)throws IOException, CourseLevelException, RepeatedCodeException {
		String[] linhaLida = new String[4];
		
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		codigosCursosList = new ArrayList<Integer>();
		BufferedReader br = new BufferedReader(new FileReader(arq)); //abre arquivo
		
		br.readLine(); //ignora primeira linha do arquivo
		while((linhaLida = csvReader.leLinhaCSV(br)) != null) {		//le linha  
			int tipoCurso = 0;
			//converte o codigo lido pra inteiro
			int codigoCurso = Integer.parseInt(linhaLida[0]);
			
			String nome = linhaLida[1];
			
			//testa se nao possui marcacao
			if (linhaLida.length == 2) { //nenhum curso foi marcado
				throw new CourseLevelException(codigoCurso, nome); 
			}
			
			if(linhaLida.length == 4) { //possivel marcacao de duas opcoes
				if((linhaLida[2].isEmpty() || linhaLida[2].equalsIgnoreCase(" ") ) && linhaLida[3].equalsIgnoreCase("x")) // pos graduacao 
					tipoCurso = 1;  
				if (linhaLida[2].equalsIgnoreCase("x") && (linhaLida[3].isEmpty() || linhaLida[3].equalsIgnoreCase(" ") )) // graduacao
					tipoCurso = 0; 
				if (linhaLida[2].equalsIgnoreCase("x") && linhaLida[3].equalsIgnoreCase("x")) //ambas foram marcadas com x
					throw new CourseLevelException(codigoCurso, nome);
				if (!linhaLida[2].equalsIgnoreCase("x") && !linhaLida[3].equalsIgnoreCase("x")) //ambas foram marcadas mas com algo diferente de x
					throw new CourseLevelException(codigoCurso, nome);
				//uma pode ter sido marcada com x, mas a outra foi invalida 
				if ((!linhaLida[2].isEmpty() && (!linhaLida[2].equalsIgnoreCase("x") && !linhaLida[2].equalsIgnoreCase(" ")) ) || (!linhaLida[3].isEmpty() && (!linhaLida[3].equalsIgnoreCase("x") && !linhaLida[3].equalsIgnoreCase(" ")) )) 
					throw new NumberFormatException();
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
			if(codigosCursosList.contains(novoCurso.getCodigo()))
				throw new RepeatedCodeException(codigoCurso, novoCurso);
			
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
		
		br.readLine(); //ignora primeira linha do arquivo
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
		
		br.readLine(); //ignora primeira linha do arquivo
		while((linhaLida = csvReader.leLinhaCSV(br)) != null) {
			
			int codigoDoDocente = Integer.parseInt(linhaLida[0]);
			
			//matricula nao pode exceder o max int value
			long matriculaDoDiscente = Long.parseLong(linhaLida[1]);
			
			//verifica se codigo de docente eh valido
			if(!codigosDocentesList.contains(codigoDoDocente))
				throw new DocenteOrientacaoInvalidCodeException(codigoDoDocente, Discente.getDiscentePorMatricula(discentes, matriculaDoDiscente).getNome());

			int codigoDoCursoDiscente = Integer.parseInt(linhaLida[2]);
			
			//testa se o codigo do curso eh valido
			if(!codigosCursosList.contains(codigoDoCursoDiscente))
				throw new CursoOrientacaoInvalidCodeException(codigoDoCursoDiscente, Discente.getDiscentePorMatricula(discentes, matriculaDoDiscente).getNome());
			
			int cargaHorariaSemanal = Integer.parseInt(linhaLida[3]);
			
			//instancia o objeto
			AtividadeOrientadaDiscenteGraduacao grad = new AtividadeOrientadaDiscenteGraduacao(codigoDoDocente, matriculaDoDiscente, codigoDoCursoDiscente, cargaHorariaSemanal);			
			
			//insere na lista
			atividadesGrad.add(grad);
		}
		return atividadesGrad;
	}
	
	public static ArrayList<Disciplina> lePlanilhaDisciplinas(File arq) throws NumberFormatException, IOException, RepeatedCodeException, DocenteDisciplinaInvalidCodeException, CursoDisciplinaInvalidCodeException{
		String[] linhaLida = null;
		ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
		BufferedReader br = new BufferedReader(new FileReader(arq)); // abre arquivo
		
		br.readLine(); //ignora primeira linha do arquivo
		while((linhaLida = csvReader.leLinhaCSV(br)) != null) {		//le linha 
			
			//codigo alfanumerico da disciplina
			String codigoDisciplina = linhaLida[0];
			
			//nome da disciplina
			String nomeDisciplina = linhaLida[1];
			
			int codigoDocente = Integer.parseInt(linhaLida[2]);
			
			//verifica se o codigo do docente eh valido
			if(!codigosDocentesList.contains(codigoDocente))
				throw new DocenteDisciplinaInvalidCodeException(codigoDocente, nomeDisciplina);
			
			int cargaHorariaSemanal = Integer.parseInt(linhaLida[3]);
			
			int cargaHorariaSemestral = Integer.parseInt(linhaLida[4]);
			
			int codigoCurso = Integer.parseInt(linhaLida[5]);
			
			//verifica se o codigo do curso eh valido
			if(!codigosCursosList.contains(codigoCurso))
				throw new CursoDisciplinaInvalidCodeException(codigoCurso, nomeDisciplina);
			
			//instancia o objeto
			Disciplina disciplina = new Disciplina(codigoDisciplina, nomeDisciplina, codigoDocente, cargaHorariaSemanal, cargaHorariaSemestral, codigoCurso);
			
			//verifica conflitos no codigo na disciplina
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
		
		br.readLine(); //ignora primeira linha do arquivo
		while( (linhaLida = csvReader.leLinhaCSV(br)) != null ) {
			
			int codigoDocente = Integer.parseInt(linhaLida[0]);
			
			//matricula nao pode exceder o max int value
			long matriculaDiscente = Long.parseLong(linhaLida[1]); 
			
			//verifica se codigo de docente é valido
			if(!codigosDocentesList.contains(codigoDocente))
				throw new DocenteOrientacaoInvalidCodeException(codigoDocente, Discente.getDiscentePorMatricula(discentes, matriculaDiscente).getNome());
			
			//estabalece o formato q a data sera recebida
			DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			
			LocalDate dataIngressoDiscente = LocalDate.parse(linhaLida[2], formatador);
						
			if(dataIngressoDiscente.isAfter(LocalDate.now()) == true) {
				Discente aluno = Discente.getDiscentePorMatricula(discentes, matriculaDiscente);
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
		BufferedReader br = new BufferedReader(new FileReader(arq));	//abre arquivo
	
		br.readLine(); //ignora primeira linha do arquivo
		while((linhaLida = csvReader.leLinhaCSV(br)) != null) {		//le linha 
			
			//converte o codigo lido pra inteiro
			int codigoDocente = Integer.parseInt(linhaLida[0]);
			
			
			String titulo = linhaLida[1];
			
			//verifica se o codigo do docente eh valido
			if(!codigosDocentesList.contains(codigoDocente))
				throw new DocenteProducaoInvalidCodeException(codigoDocente, titulo);

			boolean qualificado;
			if (linhaLida.length == 3)
				qualificado = verificaCheckbox(linhaLida[2]);
			else
				qualificado = false;

			//instancia objeto
			ProducaoCientifica prod = new ProducaoCientifica(codigoDocente, titulo, qualificado);
			
			//adiciona na lista de producoes
			producoes.add(prod);
		}
		return producoes;
	}
	
	
	public static boolean verificaCheckbox (String s) {
		char[] array = s.toCharArray();
		if(array.length > 1)
			throw new NumberFormatException();			
		else
			if(!(s.equalsIgnoreCase("x") || s.equalsIgnoreCase(" ")))
				throw new NumberFormatException();		
		
		return s.equalsIgnoreCase("x");
	}
	
}
