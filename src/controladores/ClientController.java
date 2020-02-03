package controladores;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import objetos.Autor;
import objetos.Editorial;
import objetos.Libro;

public class ClientController implements Initializable {
	
	ObservableList<Libro> lista = FXCollections.observableArrayList();
		
	@FXML
	private ListView<Libro> ListView_Stock;
	
	@FXML
	private TextField TextField_Stock;
	
	@FXML
	private Button Button_ComprobarStock;

	@FXML
	private TableView<Libro> TableView_Informacion;
	
	@FXML 
	private TableColumn<Libro, String> ColISBN;
	
	@FXML 
	private TableColumn<Libro, String> ColPaginas;
	
	@FXML 
	private TableColumn<Libro, String> ColTapaDura;
	
	@FXML 
	private TableColumn<Libro, String> ColNombreEditorial;
	
	@FXML 
	private TableColumn<Libro, String> ColNombreAutor;
	
	@FXML 
	private TableColumn<Libro, String> ColPrecio;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		TableView_Informacion.setPlaceholder(new Label(""));
		cargarDatos();
	}
	
	public void cargarDatos() {
		lista.clear();

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
		
		lista.addAll(mist1, mist2, mist3, it, resplandor, cdadr1, cdadr2, palacio, witcher1, witcher2);
		ListView_Stock.getItems().addAll(lista);
		
		ListView_Stock.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Libro>() {
		  
			@Override
			public void changed(ObservableValue<? extends Libro> arg0, Libro arg1, Libro arg2) {
				lista.clear();
				TextField_Stock.setText("");
				lista.add(new Libro());
				
				ColISBN.setCellValueFactory(c-> new SimpleStringProperty(ListView_Stock.getSelectionModel().getSelectedItem().getISBN()));
				ColPaginas.setCellValueFactory(c-> new SimpleStringProperty(Integer.toString(ListView_Stock.getSelectionModel().getSelectedItem().getPaginas())));
				ColTapaDura.setCellValueFactory(c-> new SimpleStringProperty(Boolean.toString(ListView_Stock.getSelectionModel().getSelectedItem().isTapa_Dura())));
				ColNombreEditorial.setCellValueFactory(c-> new SimpleStringProperty(ListView_Stock.getSelectionModel().getSelectedItem().getEditorial().getNombre_Editorial()));
				ColNombreAutor.setCellValueFactory(c-> new SimpleStringProperty(ListView_Stock.getSelectionModel().getSelectedItem().getAutor().getNombre_Autor()));
				ColPrecio.setCellValueFactory(c-> new SimpleStringProperty(Float.toString(ListView_Stock.getSelectionModel().getSelectedItem().getPrecio())));
				
				TableView_Informacion.setItems(lista);
			}
		});
	}
	
	public void comprobarStock() {
		try {
			if (ListView_Stock.getSelectionModel().getSelectedItem().getCantidad() == 0) {
				TextField_Stock.setText("El libro no se encuentra en stock");
			} else {
				TextField_Stock.setText("El libro se encuentra en stock");
			}
		} catch (Exception e) {
			TextField_Stock.setText("Selecciona un libro");
		}
	}
	
}
