package instanciaveis;


public class Docente {
	private int codigo;
	private String nome;
	private String departamento;
	
	public Docente(int codigo, String nome, String departamento) {
		this.codigo = codigo;
		this.nome = nome;
		this.departamento = departamento;
		
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public String getDepartamento() {
		return departamento;
	}

	@Override
	public String toString() {
		return "Docente [codigo=" + codigo + ", nome=" + nome + ", departamento=" + departamento + "]";
	}
	

	public boolean compareTo(Docente d) {
		return this.codigo == d.getCodigo();
	}
	
	public boolean compareNome(Docente d) {
		return this.nome.equals(d.getNome());
	}
}
