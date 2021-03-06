package objetos;

import java.util.ArrayList;

public class Editorial {

	private int id_Editorial;
	private String nombre_Editorial;
	private ArrayList<Autor> lista_de_autores;

	public Editorial(int id_Editorial, String nombre_Editorial, ArrayList<Autor> lista_de_autores) {
		super();
		this.id_Editorial = id_Editorial;
		this.nombre_Editorial = nombre_Editorial;
		this.lista_de_autores = lista_de_autores;
	}

	public int getId_Editorial() {
		return id_Editorial;
	}

	public void setId_Editorial(int id_Editorial) {
		this.id_Editorial = id_Editorial;
	}

	public String getNombre_Editorial() {
		return nombre_Editorial;
	}

	public void setNombre_Editorial(String nombre_Editorial) {
		this.nombre_Editorial = nombre_Editorial;
	}

	public String getLista_de_autores() {
		String aux = "";
		for (Autor autor : lista_de_autores) {
			aux = aux + autor.getNombre_Autor() + ", ";
		}
		aux = aux.substring(0, aux.length() - 2);
		return aux;
	}

	public void setLista_de_autores(ArrayList<Autor> lista_de_autores) {
		this.lista_de_autores = lista_de_autores;
	}

}
