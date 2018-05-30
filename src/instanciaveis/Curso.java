package instanciaveis;

public class Curso {
	private static final int GRAD = 0;
	private static final int POS = 1;
	private int codigo;
	private String nome;
	private int tipoCurso;
	
	
	public Curso(int codigo, String nome, int tipoCurso) {
		this.codigo = codigo;
		this.nome = nome;
		this.tipoCurso = tipoCurso;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getTipoCurso() {
		return tipoCurso;
	}

	@Override
	public String toString() {
		if(this.tipoCurso == GRAD)
			return "Curso [codigo=" + this.codigo +  ", nome=" + this.nome + ", tipo de curso=Gradua�ao" + "]";
		return "Curso [codigo=" + this.codigo +  ", nome=" + this.nome + ", tipo de curso=Pos-Gradua�ao" + "]";
		
	}
	
	
	public boolean compareTo(Curso c) {
		return this.codigo == c.codigo;
	}
}
