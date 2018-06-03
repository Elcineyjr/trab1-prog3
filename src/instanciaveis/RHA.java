package instanciaveis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import fileManager.LePlanilha;

public class RHA {
	private String nomeDepartamento;
	private String nomeDocente;
	private int codigoCurso;
	private String nomeCurso;
	private int totalHorasSemestraisAulas;
	private static ArrayList<RHA> rhaList = new ArrayList<RHA>();

	
	public String getNomeDepartamento() {
		return nomeDepartamento;
	}

	public int getCodigoCurso() {
		return codigoCurso;
	}

	public int getTotalHorasSemestraisAulas() {
		return totalHorasSemestraisAulas;
	}

	public String getNomeDocente() {
		return nomeDocente;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public RHA(Docente docente, Curso curso) {
		this.nomeDepartamento = docente.getDepartamento();
		this.nomeDocente = docente.getNome();
		this.codigoCurso = curso.getCodigo();
		this.nomeCurso = curso.getNome();
		this.totalHorasSemestraisAulas = somaHorasSemestraisDocentePorCurso(docente, curso);
	}
	
	public int somaHorasSemestraisDocentePorCurso(Docente docente, Curso curso) {
		int totalHoras = 0;
		for(Disciplina disciplina : LePlanilha.getDisciplinas()) {
			if(docente.getCodigo() == disciplina.getCodigoDoDocente() && curso.getCodigo() == disciplina.getCodigoDoCurso())
				totalHoras += disciplina.getCargaHorariaSemestral();	
		}
		return totalHoras;
	}
	
	
	public static ArrayList<RHA> createRhaList(){
		for(Disciplina disciplina : LePlanilha.getDisciplinas()) {
			for(Docente docente : LePlanilha.getDocentes()) {
				if(disciplina.getCodigoDoDocente() == docente.getCodigo()) {
					for(Curso curso : LePlanilha.getCursos()) {
						if(disciplina.getCodigoDoCurso() == curso.getCodigo()) {
							RHA rha = new RHA(docente, curso);
							rhaList.add(rha);
						}	
					}
				}	
			}
		}
		
		//TODO ordenar primeiro pelo departamento, dps pelo docente e dps por nome do do curso
		//ordena apenas pelo nome do departamento
		Collections.sort(rhaList, new Comparator<Object>() {
            public int compare(Object o1, Object o2) {
                RHA rha1 = (RHA) o1;
                RHA rha2 = (RHA) o2;
                return rha1.getNomeDepartamento().compareToIgnoreCase(rha2.getNomeDepartamento());
            }
        });
		
		return rhaList;
	}
		
	@Override
	public String toString() {
		return "RHA [nomeDepartamento=" + nomeDepartamento + ", nomeDocente=" + nomeDocente + ", codigoCurso="
				+ codigoCurso + ", nomeCurso=" + nomeCurso + ", totalHorasSemestraisAulas=" + totalHorasSemestraisAulas
				+ "]";
	}

}
