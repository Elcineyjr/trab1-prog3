package instanciaveis;
import java.time.*;

public class testadora {

	public static void main(String[] args) {
		AtividadeOrientadaDiscentePosGraduacao posgrad = new AtividadeOrientadaDiscentePosGraduacao(155, 2015100338,LocalDate.of(1996, 12, 02), "blablabla", 75);
		System.out.println(posgrad);

	}

}
