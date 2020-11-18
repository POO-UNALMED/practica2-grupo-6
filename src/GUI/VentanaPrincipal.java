package GUI;

import gestorAplicacion.factura.Producto;
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
	Insets i = new Insets(10);
	
	public VentanaPrincipal() {
		super();
		
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
		MenuItem op3 = new MenuItem("Registrar Producto");
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
		
		op2.setOnAction(menu);
		op3.setOnAction(menu);
		op4.setOnAction(menu);
		ver.setOnAction(menu);
		editar.setOnAction(menu);
		op6.setOnAction(menu);
		op7.setOnAction(menu);
		op8.setOnAction(menu);
		op9.setOnAction(menu);
		op10.setOnAction(menu);
		
		//Ayuda
		Menu menu3 = new Menu("Ayuda");
		MenuItem Acerca = new MenuItem("Acerca de");
		menu3.getItems().add(Acerca);
		
		barra.getMenus().addAll(menu1,menu2,menu3);
		
		setTop(barra);
		setMargin(barra, i);
		
		//Formularios
		consultas = new VBox(10);
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
		
		//campos
		
		String[] criterios = {"Nombre","Identificacion","Correo","Direccion","Telefono","Genero","Salario","Profesion"};
		BorderPane panel = new BorderPane();
		panel.setAlignment(panel, Pos.CENTER);
		panel.setCenter(new FieldPane("criterio",criterios,"valor",null,null));
		
		Rectangle rt2 = new Rectangle(500,290,Color.TRANSPARENT);
		rt2.setStroke(Color.GRAY);
		StackPane sp2 = new StackPane(new Node[] { rt2, panel });
		
		consultas.setAlignment(Pos.CENTER);
		consultas.getChildren().addAll(sp,sp1,sp2);
		
		setCenter(consultas);
		setMargin(consultas, i);
		
	}
	
	EventHandler<ActionEvent> menu = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent a) {
			Object cont = a.getSource();
			if (cont instanceof MenuItem) {
				if((((MenuItem) cont).getText()).equals("Registrar Cliente")) {
					consultas = new VBox(10);
					nombre.setText("Registrar Cliente");
					descripcion.setText("Funcion realizada para registrar los clientes que operan en la tienda");
					
					Rectangle rt = new Rectangle(250,50,Color.TRANSPARENT);
					rt.setStroke(Color.GRAY);
					StackPane sp = new StackPane(new Node[] { rt, nombre });
					
					Rectangle rt1 = new Rectangle(600,50,Color.TRANSPARENT);
					rt1.setStroke(Color.GRAY);
					StackPane sp1 = new StackPane(new Node[] { rt1, descripcion });
					
					String[] criterios = {"ID Administrador","Nombre","Identificacion","Correo","Direccion","Telefono","Genero"};
					BorderPane panel = new BorderPane();
					panel.setCenter(new FieldPane("criterio",criterios,"valor",null,null));
					
					Rectangle rt2 = new Rectangle(500,290,Color.TRANSPARENT);
					rt2.setStroke(Color.GRAY);
					StackPane sp2 = new StackPane(new Node[] { rt2, panel });
					
					consultas.setAlignment(Pos.CENTER);
					consultas.getChildren().addAll(sp,sp1,sp2);
					setCenter(consultas);
					setMargin(consultas, i);
					
				}
				
				else if((((MenuItem) cont).getText()).equals("Registrar Producto")) {
					consultas = new VBox(10);
					nombre.setText("Registrar Producto");
					descripcion.setText("Funcion realizada para registrar los productos vendidos en la tienda");
					
					Rectangle rt = new Rectangle(250,50,Color.TRANSPARENT);
					rt.setStroke(Color.GRAY);
					StackPane sp = new StackPane(new Node[] { rt, nombre });
					
					Rectangle rt1 = new Rectangle(600,50,Color.TRANSPARENT);
					rt1.setStroke(Color.GRAY);
					StackPane sp1 = new StackPane(new Node[] { rt1, descripcion });
					
					String[] criterios = {"ID Administrador","Marca","Tipo","Cantidad","Precio"};
					BorderPane panel = new BorderPane();
					panel.setCenter(new FieldPane("criterio",criterios,"valor",null,null));
					
					Rectangle rt2 = new Rectangle(500,290,Color.TRANSPARENT);
					rt2.setStroke(Color.GRAY);
					StackPane sp2 = new StackPane(new Node[] { rt2, panel });
					
					consultas.setAlignment(Pos.CENTER);
					consultas.getChildren().addAll(sp,sp1,sp2);
					setCenter(consultas);
					setMargin(consultas, i);
					
				}
				
				else if((((MenuItem) cont).getText()).equals("Crear Pedido")) {
					consultas = new VBox(10);
					nombre.setText("Crear Pedido");
					descripcion.setText("Creación de pedidos");
					
					Rectangle rt = new Rectangle(250,50,Color.TRANSPARENT);
					rt.setStroke(Color.GRAY);
					StackPane sp = new StackPane(new Node[] { rt, nombre });
					
					Rectangle rt1 = new Rectangle(600,50,Color.TRANSPARENT);
					rt1.setStroke(Color.GRAY);
					StackPane sp1 = new StackPane(new Node[] { rt1, descripcion });
					
					String[] criterios = {"ID Administrador"};
					BorderPane panel = new BorderPane();
					panel.setCenter(new FieldPane("criterio",criterios,"valor",null,null));
					
					Rectangle rt2 = new Rectangle(500,290,Color.TRANSPARENT);
					rt2.setStroke(Color.GRAY);
					StackPane sp2 = new StackPane(new Node[] { rt2, panel });
					
					consultas.setAlignment(Pos.CENTER);
					consultas.getChildren().addAll(sp,sp1,sp2);
					setCenter(consultas);
					setMargin(consultas, i);
				}
				
				else if((((MenuItem) cont).getText()).equals("Ver")) {
					consultas = new VBox(10);
					nombre.setText("Lista de Productos");
					descripcion.setText("Lista del estado de los productos en inventario");
					
					Rectangle rt = new Rectangle(250,50,Color.TRANSPARENT);
					rt.setStroke(Color.GRAY);
					StackPane sp = new StackPane(new Node[] { rt, nombre });
					
					Rectangle rt1 = new Rectangle(600,50,Color.TRANSPARENT);
					rt1.setStroke(Color.GRAY);
					StackPane sp1 = new StackPane(new Node[] { rt1, descripcion });
					
					Label mostrar = new Label (Producto.listaProductos());
					
					Rectangle rt2 = new Rectangle(500,290,Color.TRANSPARENT);
					rt2.setStroke(Color.GRAY);
					StackPane sp2 = new StackPane(new Node[] { rt2, mostrar });
					
					consultas.setAlignment(Pos.CENTER);
					consultas.getChildren().addAll(sp,sp1,sp2);
					setCenter(consultas);
					setMargin(consultas, i);
				}
				
				else if((((MenuItem) cont).getText()).equals("Editar")) {
					consultas = new VBox(10);
					nombre.setText("Editar Productos");
					descripcion.setText("Permite modificar la cantidad disponible de un producto");
					
					Rectangle rt = new Rectangle(250,50,Color.TRANSPARENT);
					rt.setStroke(Color.GRAY);
					StackPane sp = new StackPane(new Node[] { rt, nombre });
					
					Rectangle rt1 = new Rectangle(600,50,Color.TRANSPARENT);
					rt1.setStroke(Color.GRAY);
					StackPane sp1 = new StackPane(new Node[] { rt1, descripcion });
					
					String[] criterios = {"ID Administrador","Codigo del Producto","Nueva Cantidad"};
					BorderPane panel = new BorderPane();
					panel.setCenter(new FieldPane("criterio",criterios,"valor",null,null));
					
					Rectangle rt2 = new Rectangle(500,290,Color.TRANSPARENT);
					rt2.setStroke(Color.GRAY);
					StackPane sp2 = new StackPane(new Node[] { rt2, panel });
					
					consultas.setAlignment(Pos.CENTER);
					consultas.getChildren().addAll(sp,sp1,sp2);
					setCenter(consultas);
					setMargin(consultas, i);
				}
				
				else if((((MenuItem) cont).getText()).equals("Realizar Devolucion")) {
					consultas = new VBox(10);
					nombre.setText("Realizar devolución");
					descripcion.setText("Permite realizar la devolución de un producto vendido");
					
					Rectangle rt = new Rectangle(250,50,Color.TRANSPARENT);
					rt.setStroke(Color.GRAY);
					StackPane sp = new StackPane(new Node[] { rt, nombre });
					
					Rectangle rt1 = new Rectangle(600,50,Color.TRANSPARENT);
					rt1.setStroke(Color.GRAY);
					StackPane sp1 = new StackPane(new Node[] { rt1, descripcion });
					
					String[] criterios = {"ID Cliente","Codigo Factura","Codigo Detalle del producto","Cantidad a devolver"};
					BorderPane panel = new BorderPane();
					panel.setCenter(new FieldPane("criterio",criterios,"valor",null,null));
					
					Rectangle rt2 = new Rectangle(500,290,Color.TRANSPARENT);
					rt2.setStroke(Color.GRAY);
					StackPane sp2 = new StackPane(new Node[] { rt2, panel });
					
					consultas.setAlignment(Pos.CENTER);
					consultas.getChildren().addAll(sp,sp1,sp2);
					setCenter(consultas);
					setMargin(consultas, i);
				}
				else if((((MenuItem) cont).getText()).equals("Clientes Mayoritarios")) {
					
				}
				
				else if((((MenuItem) cont).getText()).equals("Mercancia Inactiva")) {
					consultas = new VBox(10);
					nombre.setText("Mercancia inactiva");
					descripcion.setText("Permite la visualización de los productos que no se han vendido\n dentro de una rango de fechas");
					
					Rectangle rt = new Rectangle(250,50,Color.TRANSPARENT);
					rt.setStroke(Color.GRAY);
					StackPane sp = new StackPane(new Node[] { rt, nombre });
					
					Rectangle rt1 = new Rectangle(600,50,Color.TRANSPARENT);
					rt1.setStroke(Color.GRAY);
					StackPane sp1 = new StackPane(new Node[] { rt1, descripcion });
					
					String[] criterios = {"Fecha inicial","Fecha final"};
					BorderPane panel = new BorderPane();
					panel.setCenter(new FieldPane("criterio",criterios,"valor",null,null));
					
					Rectangle rt2 = new Rectangle(500,290,Color.TRANSPARENT);
					rt2.setStroke(Color.GRAY);
					StackPane sp2 = new StackPane(new Node[] { rt2, panel });
					
					consultas.setAlignment(Pos.CENTER);
					consultas.getChildren().addAll(sp,sp1,sp2);
					setCenter(consultas);
					setMargin(consultas, i);
					
				}
				
				else if((((MenuItem) cont).getText()).equals("Balances")) {
					consultas = new VBox(10);
					nombre.setText("Balances");
					descripcion.setText("Permite la visualización del balance general de las ventas hechas en un rango de fechas");
					
					Rectangle rt = new Rectangle(250,50,Color.TRANSPARENT);
					rt.setStroke(Color.GRAY);
					StackPane sp = new StackPane(new Node[] { rt, nombre });
					
					Rectangle rt1 = new Rectangle(600,50,Color.TRANSPARENT);
					rt1.setStroke(Color.GRAY);
					StackPane sp1 = new StackPane(new Node[] { rt1, descripcion });
					
					String[] criterios = {"Fecha inicial","Fecha final"};
					BorderPane panel = new BorderPane();
					panel.setCenter(new FieldPane("criterio",criterios,"valor",null,null));
					
					Rectangle rt2 = new Rectangle(500,290,Color.TRANSPARENT);
					rt2.setStroke(Color.GRAY);
					StackPane sp2 = new StackPane(new Node[] { rt2, panel });
					
					consultas.setAlignment(Pos.CENTER);
					consultas.getChildren().addAll(sp,sp1,sp2);
					setCenter(consultas);
					setMargin(consultas, i);
					
				}
				
				else if((((MenuItem) cont).getText()).equals("Productos Mas Vendidos")) {
					consultas = new VBox(10);
					nombre.setText("Balances");
					descripcion.setText("Permite la visualización de los productos mas vendidos dentro de un rango de fechas");
					
					Rectangle rt = new Rectangle(250,50,Color.TRANSPARENT);
					rt.setStroke(Color.GRAY);
					StackPane sp = new StackPane(new Node[] { rt, nombre });
					
					Rectangle rt1 = new Rectangle(600,50,Color.TRANSPARENT);
					rt1.setStroke(Color.GRAY);
					StackPane sp1 = new StackPane(new Node[] { rt1, descripcion });
					
					String[] criterios = {"Fecha inicial","Fecha final"};
					BorderPane panel = new BorderPane();
					panel.setCenter(new FieldPane("criterio",criterios,"valor",null,null));
					
					Rectangle rt2 = new Rectangle(500,290,Color.TRANSPARENT);
					rt2.setStroke(Color.GRAY);
					StackPane sp2 = new StackPane(new Node[] { rt2, panel });
					
					consultas.setAlignment(Pos.CENTER);
					consultas.getChildren().addAll(sp,sp1,sp2);
					setCenter(consultas);
					setMargin(consultas, i);
					
				}
			}
			
			
			
		}
		
	};

}
