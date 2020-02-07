package controladores;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import objetos.Autor;
import objetos.Editorial;
import objetos.Empleado;
import objetos.Libro;

public class Datos {

	public static ObservableList<Libro> listaLibros = FXCollections.observableArrayList();
	public static ObservableList<Empleado> listaEmpleados = FXCollections.observableArrayList();

	public static void cargarDatos() {
		listaLibros.clear();

		Autor bSanderson = new Autor(1, 34, "Brandon Sanderson", "Estados Unidos", 1975);
		Autor sKing = new Autor(2, 69, "Stephen king", "Estados Unidos", 1947);
		Autor pRothfuss = new Autor(3, 8, "Patrick Rothfuss", "Estados Unidos", 1973);
		Autor rZafon = new Autor(4, 9, "Carlos Ruiz Zafon", "España", 1964);
		Autor aSapkowski = new Autor(5, 13, "Andrzej Sapkowski", "Polonia", 1948);
		
		ArrayList<Autor> listaDeBolsillo = new ArrayList<Autor>();
		listaDeBolsillo.add(bSanderson);
		listaDeBolsillo.add(sKing);
		listaDeBolsillo.add(pRothfuss);
		
		ArrayList<Autor> listaAlamut = new ArrayList<Autor>();
		listaAlamut.add(rZafon);
		listaAlamut.add(aSapkowski);
		
		Editorial deBolsillo = new Editorial(1, "B de Bolsillo", listaDeBolsillo);
		Editorial alamut = new Editorial(2, "Alamut Ediciones", listaAlamut);
		
		Libro mist1 = new Libro("9788498726138", 42, 688, "El Imperio Final (Mistborn 1)", true, deBolsillo, bSanderson, 19.99f);
		Libro mist2 = new Libro("849872709X", 30, 800, "El Pozo de la Ascension (Mistborn 2)", true, deBolsillo, bSanderson, 19.99f);
		Libro mist3 = new Libro("8466658912", 77, 760, "El Heroe de las Eras (Mistborn 3)", false, deBolsillo, bSanderson, 29.99f);
		Libro it = new Libro("8497593790", 13, 1504, "IT", false, deBolsillo, sKing, 25.95f);
		Libro resplandor = new Libro("8490328722", 22, 688, "El Resplandor", true, deBolsillo, sKing, 25.95f);
		Libro cdadr1 = new Libro("8499082475", 5, 880, "El Nombre del Viento (CDADR 2)", true, deBolsillo, pRothfuss, 23.65f);
		Libro cdadr2 = new Libro("8499899617", 16, 1200, "El Temor de un Hombre Sabio (CDADR 2)", true, deBolsillo, pRothfuss, 29.99f);
		Libro palacio = new Libro("840807279X", 50, 352, "El Palacio de la medianoche", false, alamut, rZafon, 8.50f);
		Libro witcher1 = new Libro("8498890373", 0, 272, "El Ultimo Deseo (Saga Geralt de Rivia 1)", true, alamut, aSapkowski, 44.00f);
		Libro witcher2 = new Libro("8498890438", 9, 288, "La Espada del Destino (Saga Geralt de Rivia 2)", true, alamut, aSapkowski, 50.00f);
		
		listaLibros.addAll(mist1, mist2, mist3, it, resplandor, cdadr1, cdadr2, palacio, witcher1, witcher2);
		
		listaEmpleados.clear();
		
		Empleado emp1 = new Empleado("Sergio", "pass");
		Empleado emp2 = new Empleado("Jonatan", "pass");
		Empleado emp3 = new Empleado("Gabri", "pass");
		Empleado emp4 = new Empleado("Rosa", "pass");
		Empleado emp5 = new Empleado("Willy", "pass");
		Empleado emp6 = new Empleado("Rafa", "pass");

		listaEmpleados.addAll(emp1, emp2, emp3, emp4, emp5, emp6);
	}
}
