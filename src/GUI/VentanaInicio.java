package GUI;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Alert.AlertType;
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
import uiMain.Main;

public class VentanaInicio  extends BorderPane {
	
	Scene scene, scene1;
	Label Hvida;
	ImageView v1,v2,v3,v4;
	int contador=0;
	
	public VentanaInicio(){
		
		super();
		setPadding(new Insets(10,10,10,10));
		
		//parte izquierda ventana de inicio
		VBox p1 = new VBox(20);
		p1.setPadding(new Insets(10,10,10,10));
		Label text = new Label("Bienvenidos a CompuElectronics");
		text.setFont(new Font("Arial",15));
		text.setAlignment(Pos.CENTER);
		
		Button b1 = new Button("Siguiente");
		b1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				VBox v = new VBox();
				v.getChildren().addAll(new Node[] { new VentanaPrincipal() });
				Scene scene2 = new Scene(v,700,600);
				Main.window.setScene(scene2);
			}
			
		});
		
		Rectangle rt = new Rectangle(250,50,Color.TRANSPARENT);
		rt.setStroke(Color.GRAY);
		StackPane sp = new StackPane(new Node[] { rt, text });
		
		BorderPane p4 = new BorderPane();
		p4.setPadding(new Insets(10,10,10,10));
		Insets i = new Insets(10);
		
		Image image = new Image(getClass().getResourceAsStream("../imagenes/celular.jpg"));
		ImageView v = new ImageView();
		v.setImage(image);
		v.setFitWidth(185);
		v.setFitHeight(200);
		
		p4.setAlignment(b1, Pos.BOTTOM_RIGHT);
		p4.setBottom(b1);
		p4.setMargin(b1, i);
		
		p4.setCenter(v);
		p4.setMargin(v, i);
		
		
		p1.setAlignment(Pos.TOP_CENTER);
		p1.getChildren().addAll(sp,p4);
		
		//parte derecha Ventana de inicio
		VBox p2 = new VBox(20);
		p2.setPadding(new Insets(10,10,10,10));
		
		HBox p5 = new HBox();
		p5.setPadding(new Insets(10,10,10,10));
		p5.setAlignment(Pos.TOP_CENTER);
		
		Hvida = new Label("Nombre: Daniel Torres"
				+ "\nCorreo: dtorresag@unal.edu.co"
				+ "\nCarrera: Ingenieria en sistemas"
				+ "\nPasatiempo: Dibujar");
		Hvida.setFont(new Font("Arial",13));
		
		p5.getChildren().addAll(Hvida);
		p5.setOnMouseClicked(mouseHvida);
		
		GridPane p6 = new GridPane();
		p6.setVgap(5.0D);
	    p6.setHgap(4.0D);
	    
	    Image m1 = new Image(getClass().getResourceAsStream("../imagenes/daniel.jpg"));
	    v1 = new ImageView();
	    v1.setImage(m1);
	    v1.setFitWidth(135);
		v1.setFitHeight(135);
		
		v2 = new ImageView();
		v2.setFitWidth(135);
		v2.setFitHeight(135);
		
		v3 = new ImageView();
		v3.setFitWidth(135);
		v3.setFitHeight(135);
		
		v4 = new ImageView();
		v4.setFitWidth(135);
		v4.setFitHeight(135);
		
	    p6.add(v1, 1, 0);
		p6.add(v2, 2, 0);
		p6.add(v3, 1, 1);
		p6.add(v4, 2, 1);
		p2.getChildren().addAll(p5,p6);
		
		//menu
		//Manejo de la barra de menú de la ventana
		MenuBar barraMenu = new MenuBar();
		//Definición del Menu
		Menu menu1 = new Menu("Menu");
		barraMenu.getMenus().add(menu1); //se añade el menu1 a la barra de menu
		//Se adiciona los elementos de menu1
		MenuItem menuItem1 = new MenuItem("Descripcion");
		MenuItem menuItem2 = new MenuItem("Salir");
		SeparatorMenuItem separator = new SeparatorMenuItem();//linea de separación de menus
		menu1.getItems().add(menuItem1);
		menu1.getItems().addAll(separator, menuItem2);
		
		menuItem1.setOnAction(menu);
		menuItem2.setOnAction(menu);
		
		setRight(p2);
		setMargin(p2, i);
		setLeft(p1);
		setMargin(p1, i);
		setTop(barraMenu);
		
	}
	
	EventHandler<ActionEvent> menu = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent a) {
			Object cont = a.getSource();
			if(cont instanceof MenuItem) {
				if((((MenuItem) cont).getText()).equals("Descripcion")) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Acerca de CompuElectronics");
					alert.setHeaderText(null);
					alert.setContentText("La aplicacion fue diseñada con el proposito"
							+ "\nde tener un control de la entrada y salida de"
							+ "\ndatos de una tienda");
					alert.showAndWait();
				}else if((((MenuItem) cont).getText()).equals("Salir")) {
					Platform.exit();
				}
			}
			
		}
		
	};
	
	EventHandler<MouseEvent> mouseHvida = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent arg0) {
			if(contador==0) {
				Hvida.setText("Nombre: Deninson Chamorro"
						+ "\nCorreo: dachamorroru@unal.edu.co"
						+ "\nCarrera: Ingenieria en sistemas"
						+ "\nPasatiempo: futbol");
				v1.setImage(new Image(getClass().getResourceAsStream("../imagenes/deninson.jpg")));
				contador++;
			}else if(contador==1) {
				Hvida.setText("Nombre: Deyner Lopez"
						+ "\nCorreo: dachamorroru@unal.edu.co"
						+ "\nCarrera: Ingenieria en sistemas"
						+ "\nPasatiempo: futbol");
				v1.setImage(new Image(getClass().getResourceAsStream("../imagenes/deyner1.jpeg")));
				v2.setImage(new Image(getClass().getResourceAsStream("../imagenes/deyner2.jpeg")));
				v3.setImage(new Image(getClass().getResourceAsStream("../imagenes/deyner3.jpeg")));
				v4.setImage(new Image(getClass().getResourceAsStream("../imagenes/deyner4.jpeg")));
				contador++;
			}else if(contador==2) {
				Hvida.setText("Nombre: Daniel Torres"
						+ "\nCorreo: dtorresag@unal.edu.co"
						+ "\nCarrera: Ingenieria en sistemas"
						+ "\nPasatiempo: Dibujar");
				v1.setImage(new Image(getClass().getResourceAsStream("../imagenes/daniel.jpg")));
				v2.setImage(new Image(getClass().getResourceAsStream("../imagenes/deyner.jpg")));
				contador=0;
			}
			
		}
		
	};

	
	
	
}
