package application;

import controladores.Datos;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {

	public static Stage primaryStage = new Stage();
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			Datos.cargarDatos();
			Main.primaryStage.setResizable(false);
			Parent root = FXMLLoader.load(getClass().getResource("../vistas/MainScreen.fxml"));
			Scene scene = new Scene(root, 1280, 720);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Main.primaryStage.setScene(scene);
			Main.primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
