package controladores;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class BuyController implements Initializable {
	
	@FXML
	private TextField TextField_NombreLibro, TextField_PrecioTotal;
	
	@FXML
	private ComboBox<Integer> ComboBox_Cantidad;
	
	@FXML
	private RadioButton RadioButton_TDC, RadioButton_CR, RadioButton_PP;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		TextField_NombreLibro.setText(ClientController.libroEscogido);
		TextField_PrecioTotal.setText(String.valueOf(ClientController.precio));
		ComboBox_Cantidad.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5));
		ComboBox_Cantidad.getSelectionModel().selectFirst();
	}
	
	public void calcularPrecio() {
		TextField_PrecioTotal.setText(String.valueOf(ClientController.precio * ComboBox_Cantidad.getSelectionModel().getSelectedItem()));
	}

}
