package uiMain;
import java.util.ArrayList;
import java.util.Scanner;

import Excepciones.ExcepcionesArchivosBasesDatos;
import BaseDatos.Persistencia;
import GUI.VentanaInicio;
import gestorAplicacion.cliente.*;
import gestorAplicacion.factura.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;




public class Main extends Application{
	Scene scene, scene1, scene2;
	public static Stage window;
	Label Hvida;
	int contador=0;
	ImageView v1;
	
	static Scanner entrada = new Scanner(System.in);
	static {
		try {
			Persistencia.leerArchivos();
		} catch (ExcepcionesArchivosBasesDatos e) {
			// TODO Auto-generated catch block
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Error Gravisimo");
			alert.setHeaderText(null);
			alert.setContentText(e.getMessage());
			alert.showAndWait();
			
		}
		Persistencia.reasignar();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		launch(args);

	}

	public void start(Stage myStage) throws Exception{
		window = myStage;
		window.setTitle("Inicio");
		
		BorderPane p = new BorderPane();
		p.setCenter(new VentanaInicio());
		Scene scene1 = new Scene(p,720,520);
		
		window.setScene(scene1);
		window.show();
		window.setResizable(false);
	}
	
	public void stop() {
		//se guardan los archivos al cerrar la aplicacion 
		try {
			Persistencia.guardarArchivos();
		} catch (ExcepcionesArchivosBasesDatos e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Error Gravisimo");
			alert.setHeaderText(null);
			alert.setContentText(e.getMessage());
			alert.showAndWait();
			
		}
	}	
	
	
}