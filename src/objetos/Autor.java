package objetos;

public class Autor {

	private int id_Autor, libros_Publicados, nacimiento;
	private String nombre_Autor, pais;

	public Autor(int id_Autor, int libros_Publicados, String nombre_Autor, String pais, int nacimiento) {
		super();
		this.id_Autor = id_Autor;
		this.libros_Publicados = libros_Publicados;
		this.nombre_Autor = nombre_Autor;
		this.pais = pais;
		this.nacimiento = nacimiento;
	}

	public int getId_Autor() {
		return id_Autor;
	}

	public void setId_Autor(int id_Autor) {
		this.id_Autor = id_Autor;
	}

	public int getLibros_Publicados() {
		return libros_Publicados;
	}

	public void setLibros_Publicados(int libros_Publicados) {
		this.libros_Publicados = libros_Publicados;
	}

	public String getNombre_Autor() {
		return nombre_Autor;
	}

	public void setNombre_Autor(String nombre_Autor) {
		this.nombre_Autor = nombre_Autor;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getFecha_Nacimiento() {
		return nacimiento;
	}

	public void setFecha_Nacimiento(int fecha_Nacimiento) {
		this.nacimiento = fecha_Nacimiento;
	}

}
