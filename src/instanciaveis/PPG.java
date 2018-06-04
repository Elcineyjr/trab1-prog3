package instanciaveis;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import fileManager.LePlanilha;

public class PPG {
	/*
	 * nome do programa de pos
	 * data de ingresso
	 * matricula
	 * nome do discente
	 */
	private String nomeProgramaPos;
	private LocalDate dataIngressoDiscente;
	private long matriculaDiscente;
	private String nomeDiscente;
	private static ArrayList<PPG> ppgList = new ArrayList<PPG>();
	
	public String getNomeProgramaPos() {
		return nomeProgramaPos;
	}
	
	public LocalDate getDataIngressoDiscente() {
		return dataIngressoDiscente;
	}
	
	public long getMatriculaDiscente() {
		return matriculaDiscente;
	}
	
	public String getNomeDiscente() {
		return nomeDiscente;
	}
	
	public PPG (String nomeDiscente, AtividadeOrientadaDiscentePosGraduacao atividade) {
		this.nomeProgramaPos = atividade.getPrograma();
		this.dataIngressoDiscente = atividade.getDataIngressoDiscente();
		this.matriculaDiscente = atividade.getMatriculaDiscente();
		this.nomeDiscente = nomeDiscente;
	}
	
	public static ArrayList<PPG> createPpgList(){
		for(AtividadeOrientadaDiscentePosGraduacao atividade : LePlanilha.getAtividadesPos()) {
			for(Discente discente : LePlanilha.getDiscentes()) {
				if(atividade.getMatriculaDiscente() == discente.getMatricula()) {
					PPG ppg = new PPG(discente.getNome(), atividade);
					ppgList.add(ppg);
				}
			}
		}
		
		Collections.sort(ppgList, new Comparator<Object>() {
            public int compare(Object o1, Object o2) {
                PPG ppg1 = (PPG) o1;
                PPG ppg2 = (PPG) o2;
                
                int comparaNomePrograma = ppg1.getNomeProgramaPos().compareToIgnoreCase(ppg2.getNomeProgramaPos());
                int comparaDataIngresso = ppg1.getDataIngressoDiscente().compareTo(ppg2.getDataIngressoDiscente());
                int comparaNomeDiscente = ppg1.getNomeDiscente().compareToIgnoreCase(ppg2.getNomeDiscente());
                if(comparaNomePrograma < 0)
                	return -1;
                else
                	if(comparaNomePrograma > 0)
                		return 1;
                	else
                		if(comparaDataIngresso < 0)
                			return -1;
                		else
                			if(comparaDataIngresso > 0)
                				return 1;
                			else 
                				if(comparaNomeDiscente < 0)
                					return -1;
                				else
                					if(comparaNomeDiscente > 0)
                						return 1;
                return 0;
            }
        });
		
		return ppgList;
	}

	@Override
	public String toString() {
		return "PPG [nomeProgramaPos=" + nomeProgramaPos + ", dataIngressoDiscente=" + dataIngressoDiscente
				+ ", matriculaDiscente=" + matriculaDiscente + ", nomeDiscente=" + nomeDiscente + "]";
	}
	
}
