package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import uiMain.Main;

public class VentanaPrincipal extends BorderPane {
	
	VBox consultas;
	Label nombre, descripcion;
	
	public VentanaPrincipal() {
		super();
		Insets i = new Insets(10);
		//barra menu
		MenuBar barra = new MenuBar();
		//archivo
		Menu menu1 = new Menu("Archivo");
		MenuItem usuario = new MenuItem("Usuario");
		SeparatorMenuItem separator = new SeparatorMenuItem();
		MenuItem salir = new MenuItem("Salir");
		menu1.getItems().addAll(usuario,separator, salir);
		salir.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				BorderPane p = new BorderPane();
				p.setCenter(new VentanaInicio());
				Scene scene1 = new Scene(p,700,500);
				Main.window.setScene(scene1);;			
			}
			
		});
		
		//Procesos y consultas
		Menu menu2 = new Menu("Procesos y Consultas");
		MenuItem op1 = new MenuItem("Registrar Administrador");
		MenuItem op2 = new MenuItem("Registrar Cliente");
		MenuItem op3 = new MenuItem("Usuario");
		MenuItem op4 = new MenuItem("Crear Pedido");
		Menu op5 = new Menu("Inventario");
		//Inventario
		MenuItem ver = new MenuItem("Ver");
		MenuItem editar = new MenuItem("Editar");
		op5.getItems().addAll(ver,editar);
		MenuItem op6 = new MenuItem("Realizar Devolucion");
		MenuItem op7 = new MenuItem("Clientes Mayoritarios");
		MenuItem op8 = new MenuItem("Mercancia Inactiva");
		MenuItem op9 = new MenuItem("Balances");
		MenuItem op10 = new MenuItem("Productos Mas Vendidos");
		menu2.getItems().addAll(op1,op2,op3,op4,op5,op6,op7,op8,op9,op10);
		
		//Ayuda
		Menu menu3 = new Menu("Ayuda");
		MenuItem Acerca = new MenuItem("Acerca de");
		menu3.getItems().add(Acerca);
		
		barra.getMenus().addAll(menu1,menu2,menu3);
		
		setTop(barra);
		setMargin(barra, i);
		
		//Formularios
		consultas = new VBox(20);
		nombre = new Label("Registrar Administrador");
		nombre.setFont(new Font("Arial",16));
		nombre.setAlignment(Pos.CENTER);
		
		Rectangle rt = new Rectangle(250,50,Color.TRANSPARENT);
		rt.setStroke(Color.GRAY);
		StackPane sp = new StackPane(new Node[] { rt, nombre });
		
		descripcion = new Label("Funcion realizada para registrar los administradores que operan en la tienda");
		descripcion.setFont(new Font("Arial",16));
		descripcion.setAlignment(Pos.CENTER);
		
		Rectangle rt1 = new Rectangle(600,50,Color.TRANSPARENT);
		rt1.setStroke(Color.GRAY);
		StackPane sp1 = new StackPane(new Node[] { rt1, descripcion });
		
		consultas.setAlignment(Pos.CENTER);
		consultas.getChildren().addAll(sp,sp1);
		
		setCenter(consultas);
		setMargin(consultas, i);
		
	}

}
