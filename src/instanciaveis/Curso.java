package instanciaveis;

public class Curso {
	private int codigo;
	private String nome;
	
	
	public Curso(int codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	@Override
	public String toString() {
		return "Curso [codigo=" + this.codigo +  ", nome=" + this.nome + "]";
		
	}
	
}
