package fileManager;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import instanciaveis.PAD;
import instanciaveis.RHA;


public class CsvWriter {
    public static void printPADIntoFile(ArrayList<PAD> padList) throws IOException{
        PrintWriter pw = new PrintWriter(new File("pad.csv"));
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
        System.out.println("done!");
    }
    
    public static void printRHAIntoFile(ArrayList<RHA> rhaList) throws IOException{
        PrintWriter pw = new PrintWriter(new File("rha.csv"));
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
        System.out.println("done!");
    }
}
