package objetos;

public class Libro {

	private String ISBN;
	private int cantidad, paginas;
	private String nombre_Libro;
	private boolean tapa_Dura, reservado;
	private Editorial editorial;
	private Autor autor;
	private float precio;

	public Libro(String iSBN, int cantidad, int paginas, String nombre_Libro, boolean tapa_Dura, Editorial editorial,
			Autor autor, float precio, boolean reservado) {
		super();
		this.ISBN = iSBN;
		this.cantidad = cantidad;
		this.paginas = paginas;
		this.nombre_Libro = nombre_Libro;
		this.tapa_Dura = tapa_Dura;
		this.editorial = editorial;
		this.autor = autor;
		this.precio = precio;
		this.reservado = reservado;
	}

	public Libro() {
		super();
	}

	@Override
	public String toString() {
		return getNombre_Libro();
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		this.ISBN = iSBN;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public String getNombre_Libro() {
		return nombre_Libro;
	}

	public void setNombre_Libro(String nombre_Libro) {
		this.nombre_Libro = nombre_Libro;
	}

	public boolean isTapa_Dura() {
		return tapa_Dura;
	}

	public void setTapa_Dura(boolean tapa_Dura) {
		this.tapa_Dura = tapa_Dura;
	}

	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public boolean isReservado() {
		return reservado;
	}

	public void setReservado(boolean reservado) {
		this.reservado = reservado;
	}

}
