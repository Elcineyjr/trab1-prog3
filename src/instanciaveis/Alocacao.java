package instanciaveis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import fileManager.LePlanilha;

public class Alocacao {
	private String nomeDocente;
	private String codigoDisciplina;
	private String nomeDisciplina;
	private int cargaHorariaSemestral;
	private static ArrayList<Alocacao> alocacaoList = new ArrayList<Alocacao>();
	
	
	public String getNomeDocente() {
		return nomeDocente;
	}
	
	public String getCodigoDisciplina() {
		return codigoDisciplina;
	}
	
	public String getNomeDisciplina() {
		return nomeDisciplina;
	}
	
	public int getCargaHorariaSemestral() {
		return cargaHorariaSemestral;
	}

	
	public Alocacao (String nomeDocente, Disciplina d) {
		this.nomeDocente = nomeDocente;
		this.codigoDisciplina = d.getCodigoDaDisciplina();
		this.nomeDisciplina = d.getNome();
		this.cargaHorariaSemestral = d.getCargaHorariaSemestral();
	}
	
	public static ArrayList<Alocacao> createAlocacaoList(){
		for(Disciplina disciplina : LePlanilha.getDisciplinas()) {
			for(Docente docente : LePlanilha.getDocentes()) {
				if(disciplina.getCodigoDoDocente() == docente.getCodigo()) {
					Alocacao alocacao = new Alocacao(docente.getNome(), disciplina);
					alocacaoList.add(alocacao);
				}
			}
		}
			Collections.sort(alocacaoList, new Comparator<Object>() {
	            public int compare(Object o1, Object o2) {
	                Alocacao alocacao1 = (Alocacao) o1;
	                Alocacao alocacao2 = (Alocacao) o2;
	                
	                int comparaDocente = alocacao1.getNomeDocente().compareToIgnoreCase(alocacao2.getNomeDocente());
	                int comparaDisciplina = alocacao1.getNomeDisciplina().compareToIgnoreCase(alocacao2.getNomeDisciplina());
	                if(comparaDocente < 0)
	                	return -1;
	                else
	                	if(comparaDocente > 0)
	                		return 1;
	                	else
	                		if(comparaDisciplina < 0)
	                			return -1;
	                		else
	                			if(comparaDisciplina > 0)
	                				return 1;
	                return 0;
	            }
	        });
		return alocacaoList;
	}

	@Override
	public String toString() {
		return "Alocacao [nomeDocente=" + nomeDocente + ", codigoDisciplina=" + codigoDisciplina + ", nomeDisciplina="
				+ nomeDisciplina + ", cargaHorariaSemestral=" + cargaHorariaSemestral + "]";
	}
	
	
}
