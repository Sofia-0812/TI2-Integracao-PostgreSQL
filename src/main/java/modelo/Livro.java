package modelo;

public class Livro {
	private int codigo;
	private String titulo;
	private String autor;
	private float nota;
	
	public Livro() {
		this.codigo = -1;
		this.titulo = "";
		this.autor = "";
		this.nota = '*';
	}
	
	public Livro(int codigo, String titulo, String autor, float nota) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.autor = autor;
		this.nota = nota;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Livro [codigo=" + codigo + ", titulo=" + titulo + ", autor=" + autor + ", nota=" + nota + "]";
	}	
}
