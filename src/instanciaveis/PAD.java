package instanciaveis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import fileManager.LePlanilha;

public class PAD {

	private String nome;
	private String departamento;
	private int totalHorasSemanaisAulas;// pronto
	private int totalHorasSemestraisAulas;// pronto
	private int totalHorasSemanaisOrientacao; //pronto
	private int producoesQualificadas; // pronto
	private int producoesNaoQualificadas; //pronto
	private static ArrayList<PAD> padList = new ArrayList<PAD>();
	
	
	public String getNome() {
		return nome;
	}
	
	public String getDepartamento() {
		return departamento;
	}
	
	public int getTotalHorasSemanaisAulas() {
		return totalHorasSemanaisAulas;
	}
	
	public int getTotalHorasSemestraisAulas() {
		return totalHorasSemestraisAulas;
	}
	
	public int getTotalHorasSemanaisOrientacao() {
		return totalHorasSemanaisOrientacao;
	}
	
	public int getProducoesQualificadas() {
		return producoesQualificadas;
	}
	
	public int getProducoesNaoQualificadas() {
		return producoesNaoQualificadas;
	}
	
	public PAD(Docente docente) {
		this.nome = docente.getNome();
		this.departamento = docente.getDepartamento();
		somaHorasAulaDocente(docente);
		somaHorasOrientacaoDocente(docente);
		checkQualificacaoProducao(docente);
	}
	
	public void somaHorasAulaDocente(Docente docente) {		
		for (Disciplina disciplina : LePlanilha.getDisciplinas()) {
			if(docente.getCodigo() == disciplina.getCodigoDoDocente()) {
				this.totalHorasSemanaisAulas += disciplina.getCargaHorariaSemanal();
				this.totalHorasSemestraisAulas += disciplina.getCargaHorariaSemestral();
			}				
		}
	}
	public void somaHorasOrientacaoDocente(Docente docente) {
		for (AtividadeOrientadaDiscenteGraduacao atividadeGrad : LePlanilha.getAtividadesGrad()) {
			if(docente.getCodigo() == atividadeGrad.getCodigoDoDocente())
				this.totalHorasSemanaisOrientacao += atividadeGrad.getCargaHorariaSemanal();
		}
		for (AtividadeOrientadaDiscentePosGraduacao atividadePos : LePlanilha.getAtividadesPos()) {
			if(docente.getCodigo() == atividadePos.getCodigoDocente())
				this.totalHorasSemanaisOrientacao += atividadePos.getCargaHorariaSemanal();
		}
	}
	public void checkQualificacaoProducao(Docente docente) {
		for (ProducaoCientifica producao : LePlanilha.getProducoes()) {
			if(docente.getCodigo() == producao.getCodigoDoDocente())
				if(producao.isQualificada())
					this.producoesQualificadas++;
				else
					this.producoesNaoQualificadas++;
		}
	}	
	
	public static ArrayList<PAD> createPadList(){
		for (Docente docente : LePlanilha.getDocentes()) {
			PAD pad = new PAD(docente);
			padList.add(pad);
		}

		Collections.sort(padList, new Comparator<Object>() {
            public int compare(Object o1, Object o2) {
                PAD pad1 = (PAD) o1;
                PAD pad2 = (PAD) o2;
                return pad1.getNome().compareToIgnoreCase(pad2.getNome());
            }
        });

		return padList;
	}
	
	@Override
	public String toString() {
		return "PAD [nome=" + nome + ", departamento=" + departamento + ", totalHorasSemanaisAulas="
				+ totalHorasSemanaisAulas + ", totalHorasSemestraisAulas=" + totalHorasSemestraisAulas
				+ ", totalHorasSemanaisOrientacao=" + totalHorasSemanaisOrientacao + ", producoesQualificadas="
				+ producoesQualificadas + ", producoesNaoQualificadas=" + producoesNaoQualificadas + "]";
	}
	
	
}
