package controladores;

import java.net.URL;
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
import objetos.Libro;

public class ClientController implements Initializable {
	
	ObservableList<Libro> listaAux = FXCollections.observableArrayList();
	
	@FXML
	private ListView<Libro> ListView_Stock;
	
	@FXML
	private TextField TextField_Stock;
	
	@FXML
	private Button Button_ComprobarStock, Button_Comprar;

	@FXML
	private TableView<Libro> TableView_Informacion;
	
	@FXML 
	private TableColumn<Libro, String> ColISBN, ColPaginas, ColTapaDura, ColNombreEditorial, ColNombreAutor, ColPrecio;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		TableView_Informacion.setPlaceholder(new Label(""));
		cargarDatos();
	}
	
	public void cargarDatos() {
		ListView_Stock.getItems().addAll(Datos.listaLibros);
		
		ListView_Stock.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Libro>() {
		  
			@Override
			public void changed(ObservableValue<? extends Libro> arg0, Libro arg1, Libro arg2) {
				listaAux.clear();
				TextField_Stock.setText("");
				listaAux.add(new Libro());
				
				ColISBN.setCellValueFactory(c-> new SimpleStringProperty(ListView_Stock.getSelectionModel().getSelectedItem().getISBN()));
				ColPaginas.setCellValueFactory(c-> new SimpleStringProperty(Integer.toString(ListView_Stock.getSelectionModel().getSelectedItem().getPaginas())));
				ColTapaDura.setCellValueFactory(c-> new SimpleStringProperty(Boolean.toString(ListView_Stock.getSelectionModel().getSelectedItem().isTapa_Dura())));
				ColNombreEditorial.setCellValueFactory(c-> new SimpleStringProperty(ListView_Stock.getSelectionModel().getSelectedItem().getEditorial().getNombre_Editorial()));
				ColNombreAutor.setCellValueFactory(c-> new SimpleStringProperty(ListView_Stock.getSelectionModel().getSelectedItem().getAutor().getNombre_Autor()));
				ColPrecio.setCellValueFactory(c-> new SimpleStringProperty(Float.toString(ListView_Stock.getSelectionModel().getSelectedItem().getPrecio())));
				
				TableView_Informacion.setItems(listaAux);
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
