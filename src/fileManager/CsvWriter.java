package fileManager;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

//import com.sun.tools.javac.code.Attribute.Array;

import instanciaveis.PAD;
import instanciaveis.RHA;
import instanciaveis.Alocacao;
import instanciaveis.PPG;


public class CsvWriter {
	private static ArrayList<PAD> padList;
	private static ArrayList<RHA> rhaList;
	private static ArrayList<Alocacao> alocacaoList;
	private static ArrayList<PPG> ppgList;
	
    public static void printPADIntoFile(ArrayList<PAD> padList) throws IOException{
        PrintWriter pw = new PrintWriter(new File("1-pad.csv"));
        StringBuilder sb = new StringBuilder();
        sb.append("Docente");
        sb.append(';');
        sb.append("Departamento");
        sb.append(';');
        sb.append("Horas Semanais Aula");
        sb.append(';');
        sb.append("Horas Semestrais Aula");
        sb.append(';');
        sb.append("Horas Semanais Orientação");
        sb.append(';');
        sb.append("Produções Qualificadas");
        sb.append(';');
        sb.append("Produções Não Qualificadas");
        
        for (PAD pad : padList) {
        	sb.append('\n');
			sb.append(pad.getNome());
			sb.append(';');
			sb.append(pad.getDepartamento());
			sb.append(';');
			sb.append(pad.getTotalHorasSemanaisAulas());
			sb.append(';');
			sb.append(pad.getTotalHorasSemestraisAulas());
			sb.append(';');
			sb.append(pad.getTotalHorasSemanaisOrientacao());
			sb.append(';');
			sb.append(pad.getProducoesQualificadas());
			sb.append(';');
			sb.append(pad.getProducoesNaoQualificadas());
			
		}

        pw.write(sb.toString());
        pw.close();
    }
    
    public static void printRHAIntoFile(ArrayList<RHA> rhaList) throws IOException{
        PrintWriter pw = new PrintWriter(new File("2-rha.csv"));
        StringBuilder sb = new StringBuilder();
        sb.append("Departamento");
        sb.append(';');
        sb.append("Docente");
        sb.append(';');
        sb.append("Código do Curso");
        sb.append(';');
        sb.append("Curso");
        sb.append(';');
        sb.append("Horas Semestrais Aula");
        
        for (RHA rha : rhaList) {
        	sb.append('\n');
			sb.append(rha.getNomeDepartamento());
			sb.append(';');
			sb.append(rha.getNomeDocente());
			sb.append(';');
			sb.append(rha.getCodigoCurso());
			sb.append(';');
			sb.append(rha.getNomeCurso());
			sb.append(';');
			sb.append(rha.getTotalHorasSemestraisAulas());												
		}

        pw.write(sb.toString());
        pw.close();
    }
    
    public static void printAlocacaoIntoFile(ArrayList<Alocacao> alocacaoList) throws IOException{
    	 PrintWriter pw = new PrintWriter(new File("3-alocacao.csv"));
         StringBuilder sb = new StringBuilder();
         sb.append("Docente");
         sb.append(';');
         sb.append("Código");
         sb.append(';');
         sb.append("Nome");
         sb.append(';');
         sb.append("Carga Horária Semestral");
         
         for(Alocacao alocacao : alocacaoList) {
        	 sb.append('\n');
        	 sb.append(alocacao.getNomeDocente());
        	 sb.append(';');
        	 sb.append(alocacao.getCodigoDisciplina());
        	 sb.append(';');
        	 sb.append(alocacao.getNomeDisciplina());
        	 sb.append(';');
        	 sb.append(alocacao.getCargaHorariaSemestral());
         }
         
         pw.write(sb.toString());
         pw.close();
    }
    
    public static void printPPGIntoFile(ArrayList<PPG> ppgList) throws IOException{
    	PrintWriter pw = new PrintWriter(new File("4-ppg.csv"));
        StringBuilder sb = new StringBuilder();
        sb.append("Nome do Programa");
        sb.append(';');
        sb.append("Data de Ingresso");
        sb.append(';');
        sb.append("Matrícula");
        sb.append(';');
        sb.append("Nome");
        
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        for(PPG ppg : ppgList) {
        	sb.append('\n');
        	sb.append(ppg.getNomeProgramaPos());
        	sb.append(';');
        	sb.append(formatador.format(ppg.getDataIngressoDiscente()));
        	sb.append(';');
        	sb.append(ppg.getMatriculaDiscente());
        	sb.append(';');
        	sb.append(ppg.getNomeDiscente());
        }
        
        pw.write(sb.toString());
        pw.close();
    }
    
    public static void generateOutputFiles() throws IOException {
    	padList = PAD.createPadList();
		CsvWriter.printPADIntoFile(padList);
		rhaList = RHA.createRhaList();
		CsvWriter.printRHAIntoFile(rhaList);
		alocacaoList = Alocacao.createAlocacaoList();
		CsvWriter.printAlocacaoIntoFile(alocacaoList);
		ppgList = PPG.createPpgList();
		CsvWriter.printPPGIntoFile(ppgList);
    }
}
