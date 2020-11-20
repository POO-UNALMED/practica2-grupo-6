package GUI;

import java.util.ArrayList;

import gestorAplicacion.cliente.Administrador;
import gestorAplicacion.cliente.Cliente;
import gestorAplicacion.factura.Factura;
import gestorAplicacion.factura.Producto;
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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import uiMain.Main;
import uiMain.Usuario;

public class VentanaPrincipal extends BorderPane {
	
	VBox consultas;
	Label nombre, descripcion;
	Insets i = new Insets(10);
	FieldPane pane;
	ArrayList<TextField> campos;
	
	public VentanaPrincipal() {
		super();
		
		//barra menu
		MenuBar barra = new MenuBar();
		//archivo
		Menu menu1 = new Menu("Archivo");
		MenuItem usuario = new MenuItem("Usuario");
		//acionar boton usuario
		usuario.setOnAction(menu);
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
		
		op1.setOnAction(menu);
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
		//activar boton de acerca
		Acerca.setOnAction(menu);
		
		
		
		
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
		
		pane = new FieldPane("criterio",criterios,"valor",null,null);
		panel.setAlignment(pane, Pos.CENTER);
		panel.setCenter(pane);
		//botones
		HBox botones = new HBox(100);
		Button b1 = new Button("Aceptar");
		Button b2 = new Button("Borrar");
		botones.getChildren().addAll(b1,b2);
		botones.setAlignment(Pos.CENTER);
		b1.setOnAction(Aceptar);
		panel.setBottom(botones);
		
		Rectangle rt2 = new Rectangle(500,300,Color.TRANSPARENT);
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
				if((((MenuItem) cont).getText()).equals("Registrar Administrador")) {
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
					pane=new FieldPane("criterio",criterios,"valor",null,null);
					panel.setCenter(pane);
					
					Rectangle rt2 = new Rectangle(500,290,Color.TRANSPARENT);
					rt2.setStroke(Color.GRAY);
					StackPane sp2 = new StackPane(new Node[] { rt2, panel });
					
					HBox botones = new HBox(100);
					Button b1 = new Button("Aceptar");
					Button b2 = new Button("Borrar");
					botones.getChildren().addAll(b1,b2);
					botones.setAlignment(Pos.CENTER);
					b1.setOnAction(Aceptar);
					panel.setBottom(botones);
					
					consultas.setAlignment(Pos.CENTER);
					consultas.getChildren().addAll(sp,sp1,sp2);
					
					setCenter(consultas);
					setMargin(consultas, i);
					
				}
				else if((((MenuItem) cont).getText()).equals("Registrar Cliente")) {
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
					pane = new FieldPane("criterio",criterios,"valor",null,null);
					panel.setCenter(pane);
					
					Rectangle rt2 = new Rectangle(500,290,Color.TRANSPARENT);
					rt2.setStroke(Color.GRAY);
					StackPane sp2 = new StackPane(new Node[] { rt2, panel });
					
					HBox botones = new HBox(100);
					Button b1 = new Button("Aceptar");
					Button b2 = new Button("Borrar");
					botones.getChildren().addAll(b1,b2);
					botones.setAlignment(Pos.CENTER);
					b1.setOnAction(Aceptar2);
					panel.setBottom(botones);
					
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
					
					String[] criterios = {"ID Administrador","Nombre","Marca","Tipo","Cantidad","Precio"};
					BorderPane panel = new BorderPane();
					//agregue este pane
					pane = new FieldPane("criterio",criterios,"valor",null,null);
					panel.setCenter(pane);
					
					Rectangle rt2 = new Rectangle(500,290,Color.TRANSPARENT);
					rt2.setStroke(Color.GRAY);
					StackPane sp2 = new StackPane(new Node[] { rt2, panel });
					
					
					//botones
					HBox botones = new HBox(100);
					Button b1 = new Button("Aceptar");
					Button b2 = new Button("Borrar");
					botones.getChildren().addAll(b1,b2);
					botones.setAlignment(Pos.CENTER);
					b1.setOnAction(Aceptar3);
					panel.setBottom(botones);
					
					
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
					//agregue este pane
					pane = new FieldPane("criterio",criterios,"valor",null,null);
					panel.setCenter(pane);
					
					Rectangle rt2 = new Rectangle(500,290,Color.TRANSPARENT);
					rt2.setStroke(Color.GRAY);
					StackPane sp2 = new StackPane(new Node[] { rt2, panel });
					
					
					//botones
					HBox botones = new HBox(100);
					Button b1 = new Button("Aceptar");
					Button b2 = new Button("Borrar");
					botones.getChildren().addAll(b1,b2);
					botones.setAlignment(Pos.CENTER);
					b1.setOnAction(editar);
					panel.setBottom(botones);
					
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
					//agregue este pane
					pane = new FieldPane("criterio",criterios,"valor",null,null);
					panel.setCenter(pane);
					
					Rectangle rt2 = new Rectangle(500,290,Color.TRANSPARENT);
					rt2.setStroke(Color.GRAY);
					StackPane sp2 = new StackPane(new Node[] { rt2, panel });
					
					
					//botones
					HBox botones = new HBox(100);
					Button b1 = new Button("Aceptar");
					Button b2 = new Button("Borrar");
					botones.getChildren().addAll(b1,b2);
					botones.setAlignment(Pos.CENTER);
					b1.setOnAction(Aceptar6);
					panel.setBottom(botones);
					
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
					//agregue este pane
					pane = new FieldPane("criterio",criterios,"valor",null,null);
					panel.setCenter(pane);
					
					Rectangle rt2 = new Rectangle(500,290,Color.TRANSPARENT);
					rt2.setStroke(Color.GRAY);
					StackPane sp2 = new StackPane(new Node[] { rt2, panel });
					
					//botones
					HBox botones = new HBox(100);
					Button b1 = new Button("Aceptar");
					Button b2 = new Button("Borrar");
					botones.getChildren().addAll(b1,b2);
					botones.setAlignment(Pos.CENTER);
					b1.setOnAction(Aceptar7);
					panel.setBottom(botones);
					
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
					//agregue este pane
					pane = new FieldPane("criterio",criterios,"valor",null,null);
					panel.setCenter(pane);
					
					Rectangle rt2 = new Rectangle(500,290,Color.TRANSPARENT);
					rt2.setStroke(Color.GRAY);
					StackPane sp2 = new StackPane(new Node[] { rt2, panel });
					
					//botones
					HBox botones = new HBox(100);
					Button b1 = new Button("Aceptar");
					Button b2 = new Button("Borrar");
					botones.getChildren().addAll(b1,b2);
					botones.setAlignment(Pos.CENTER);
					b1.setOnAction(Aceptar8);
					panel.setBottom(botones);
					
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
					//agregue este pane
					pane = new FieldPane("criterio",criterios,"valor",null,null);
					panel.setCenter(pane);
					
					Rectangle rt2 = new Rectangle(500,290,Color.TRANSPARENT);
					rt2.setStroke(Color.GRAY);
					StackPane sp2 = new StackPane(new Node[] { rt2, panel });
					
					//botones
					HBox botones = new HBox(100);
					Button b1 = new Button("Aceptar");
					Button b2 = new Button("Borrar");
					botones.getChildren().addAll(b1,b2);
					botones.setAlignment(Pos.CENTER);
					b1.setOnAction(Aceptar9);
					panel.setBottom(botones);
					
					consultas.setAlignment(Pos.CENTER);
					consultas.getChildren().addAll(sp,sp1,sp2);
					setCenter(consultas);
					setMargin(consultas, i);
					
				}
				
				//Acerca de
				else if((((MenuItem) cont).getText()).equals("Acerca de")) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Acerca de CompuElectronics");
					alert.setHeaderText(null);
					alert.setContentText("INTEGRANTES:"
							+ "\n\nDaniel Torres"
							+ "\nDeyner Lopez"
							+ "\nDeninson Chamorro"
							+ "\n\n   Programacion orientada a objetos");
					alert.showAndWait();
					
				}
				
				
				
				//
				//usuario
				else if((((MenuItem) cont).getText()).equals("Usuario")) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Usuario de CompuElectronics");
					alert.setHeaderText(null);
					alert.setContentText("Aplicacion --CompuElectronics---"
							+ "\nMonoUsuario"
							+ "\nVersion 2.1");
					alert.showAndWait();
					
				}
				
				//
				
				
			}
			
			
			
		}
		
	};
	
	EventHandler<ActionEvent> Aceptar = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent arg0) {
			campos =pane.getCampos();
			int id = Integer.parseInt(campos.get(1).getText());
			double salario = Double.parseDouble(campos.get(6).getText());
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Resultado");
			alert.setHeaderText(null);
			alert.setContentText(Usuario.registrarAdmin(campos.get(0).getText(), id, campos.get(2).getText(), campos.get(3).getText(), campos.get(4).getText(), campos.get(5).getText(), salario, campos.get(7).getText()));
			alert.showAndWait();		
		}
		
	};
	
	///registrar cliente
		EventHandler<ActionEvent> Aceptar2 = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				ArrayList<TextField> campos= pane.getCampos();
				int id = Integer.parseInt(campos.get(0).getText());
				int idc = Integer.parseInt(campos.get(2).getText());
				Administrador admin = Administrador.consultarAdmin(id);
				if(admin!=null) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Resultado");
					alert.setHeaderText(null);
					alert.setContentText(Usuario.registrarCliente(admin,campos.get(1).getText(), idc, campos.get(3).getText(), campos.get(4).getText(), campos.get(5).getText(), campos.get(6).getText() ));
					alert.showAndWait();
					
				}
				else {
					System.out.println("Identificacion incorrecta");
				}
						
			}
			
		};
	
	
	///registrar producto
	EventHandler<ActionEvent> Aceptar3 = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent arg0) {
			campos =pane.getCampos();
			int id = Integer.parseInt(campos.get(0).getText());
			int cantidad = Integer.parseInt(campos.get(4).getText());
			double precio = Double.parseDouble(campos.get(5).getText());
			
			Administrador admin = Administrador.consultarAdmin(id);
			if(admin!=null) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Resultado");
				alert.setHeaderText(null);
				alert.setContentText(Usuario.registrarProducto(admin,campos.get(1).getText(),campos.get(2).getText(), campos.get(3).getText(),cantidad,precio ));
				alert.showAndWait();
				
			}
			else {
				System.out.println("Identificacion incorrecta");
			}
			
					
		}
		
	};
	
	
	
	///Editar inventario
		EventHandler<ActionEvent> editar = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				campos =pane.getCampos();
				int id = Integer.parseInt(campos.get(0).getText());				
				Long codPro1 = Long.parseLong(campos.get(1).getText());
				int cantidad = Integer.parseInt(campos.get(2).getText());
				Administrador admin = Administrador.consultarAdmin(id);
				if(admin!=null) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Resultado");
					alert.setHeaderText(null);
					alert.setContentText(Usuario.agregarInventario(admin, codPro1, cantidad));
					alert.showAndWait();
					
				}
				else {
					//dialogo de informacion
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Editar inventario dice..");
					alert.setHeaderText(null);
					alert.setContentText("Identificacion de administrador incorrecta");

					alert.showAndWait();
					//System.out.println("Identificacion de administrador incorrecta");
				}
						
			}
			
		};
	
	
	
	
	///realizar devolucion
		EventHandler<ActionEvent> Aceptar6 = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				campos =pane.getCampos();
				int id = Integer.parseInt(campos.get(0).getText());
				int codF = Integer.parseInt(campos.get(1).getText());
				int codDet = Integer.parseInt(campos.get(2).getText());
				int cantidad = Integer.parseInt(campos.get(3).getText());
				Cliente devolucion = Cliente.consultarCliente(id);
				if(devolucion!=null) {
					Factura consulta = Factura.consultarFactura(codF);
		    		
		    		if(consulta!=null) {
		    			if(consulta.getPedido().consultarProducto(codDet)!=null) {
		    				Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Resultado");
							alert.setHeaderText(null);
							alert.setContentText(Usuario.devolucion(codF, codDet, cantidad));
							alert.showAndWait();
		    				
		    			}else {
		    				System.out.println("producto no encontrado");
						}
		    			
		    			
		    			
		    		}
		    		else {
		    			System.out.println("No se encontro factura");
					}
					
					
						
						
				}else {
	    			System.out.println("No se encontro cliente");
				}
				
					
			}
			
		};
	
		///mercancia inactiva
		EventHandler<ActionEvent> Aceptar7 = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				campos =pane.getCampos();
				//main
				String fecha1 = campos.get(0).getText();
				String fecha2 = campos.get(1).getText();
				
				String [] fecha_1 = fecha1.split("/"); 
		    	String [] fecha_2 = fecha2.split("/");
		    	
		    	if(Integer.parseInt(fecha_1[2])==Integer.parseInt(fecha_2[2])&&Integer.parseInt(fecha_1[1])==Integer.parseInt(fecha_2[1])&&Integer.parseInt(fecha_1[0])<Integer.parseInt(fecha_2[0])) {
		    		
		    		if(!Factura.rangoDeFacturas(fecha1, fecha2).isEmpty()) {
		    			ArrayList<Producto> Productos = Usuario.mercanciaMuerta(fecha1, fecha2);
		    			
		    			if(!Productos.isEmpty()) {
		    				System.out.println("Nombre   Codido de barras   Cantidad en inventario");
		            		for (int i = 0; i < Productos.size(); i++) {
								System.out.println(Productos.get(i).toString());
		    			}
							}else {
								//dialogo de informacion
								Alert alert = new Alert(AlertType.INFORMATION);
								alert.setTitle("Informacion de busqueda");
								alert.setHeaderText(null);
								alert.setContentText("No hay suficientes productos vendidos");

								alert.showAndWait();
								
								//System.out.println("No hay suficientes productos vendidos");
														
							}
		        		}else {
		        			//dialogo de informacion
							Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Informacion de busqueda");
							alert.setHeaderText(null);
							alert.setContentText("No hay facturas realizadas en el rango de tiempo pedido");

							alert.showAndWait();
		        			
		        			//System.out.println("No hay facturas realizadas en el rango de tiempo pedido");
		        		}	    		
		    		
		    	}else if(Integer.parseInt(fecha_1[2])==Integer.parseInt(fecha_2[2])&&Integer.parseInt(fecha_1[1])<Integer.parseInt(fecha_2[1])) {
		    		
		    		if(!Factura.rangoDeFacturas(fecha1, fecha2).isEmpty()) {
		    			ArrayList<Producto> Productos = Usuario.mercanciaMuerta(fecha1, fecha2);
		        		System.out.println("Nombre   Codido de barras   Cantidad");
		        		for (int i = 0; i < Productos.size(); i++) {
							System.out.println(Productos.get(i).toString());
							}
		        		}else {
		        			//dialogo de informacion
							Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Informacion de busqueda");
							alert.setHeaderText(null);
							alert.setContentText("No hay facturas realizadas en el rango de tiempo pedido");

							alert.showAndWait();
		        			//System.out.println("No hay facturas realizadas en el rango de tiempo pedido");
		        		}
		    		
		    	}else {
		    		//dialogo de informacion
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Informacion de busqueda");
					alert.setHeaderText(null);
					alert.setContentText("El rango de las fechas no es correcto");

					alert.showAndWait();
		    		//System.out.println("El rango de las fechas no es correcto");
		    	}
				
			}
			
		};
		///Balances
		EventHandler<ActionEvent> Aceptar8= new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				campos =pane.getCampos();
				//main
				String f1 = campos.get(0).getText();
				String f2 = campos.get(1).getText();
				
				String [] fecha_f1 = f1.split("/"); 
		    	String [] fecha_f2 = f2.split("/");
		    	
		    	if(Integer.parseInt(fecha_f1[2])==Integer.parseInt(fecha_f2[2])&&Integer.parseInt(fecha_f1[1])==Integer.parseInt(fecha_f2[1])&&Integer.parseInt(fecha_f1[0])<Integer.parseInt(fecha_f2[0])) {
		    		
		    		if(!Factura.rangoDeFacturas(f1, f2).isEmpty()) {
		    			System.out.println(Usuario.Balance(f1, f2));
		    			
		        		}else {
		        			//dialogo de informacion
							Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Informacion de balances");
							alert.setHeaderText(null);
							alert.setContentText("No hay facturas realizadas en el rango de tiempo pedido");

							alert.showAndWait();
		        			//System.out.println("No hay facturas realizadas en el rango de tiempo pedido");
		        		}
		    		
		    		
		    		
		    		
		    	}else if(Integer.parseInt(fecha_f1[2])==Integer.parseInt(fecha_f2[2])&&Integer.parseInt(fecha_f1[1])<Integer.parseInt(fecha_f2[1])) {
		    		
		    		if(!Factura.rangoDeFacturas(f1, f2).isEmpty()) {
		    			System.out.println(Usuario.Balance(f1, f2));
		        		}else {
		        			//dialogo de informacion
							Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Informacion de balances");
							alert.setHeaderText(null);
							alert.setContentText("No hay facturas realizadas en el rango de tiempo pedido");

							alert.showAndWait();
		        			//System.out.println("No hay facturas realizadas en el rango de tiempo pedido");
		        		}
		    		
		    	}else {
		    		//dialogo de informacion
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Informacion de balances");
					alert.setHeaderText(null);
					alert.setContentText("El rango de las fechas no es correcto");

					alert.showAndWait();
		    		//System.out.println("El rango de las fechas no es correcto");
		    	} 
					
			}
			
		};
		///Productos mas vendidos
		EventHandler<ActionEvent> Aceptar9 = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				campos =pane.getCampos();
				//main
				String fechan = campos.get(0).getText();
				String fechan2 = campos.get(1).getText();
				
				String [] fecha_n = fechan.split("/"); 
		    	String [] fecha_n2 = fechan2.split("/");
		    	
		    	if(Integer.parseInt(fecha_n[2])==Integer.parseInt(fecha_n2[2])&&Integer.parseInt(fecha_n[1])==Integer.parseInt(fecha_n2[1])&&Integer.parseInt(fecha_n[0])<Integer.parseInt(fecha_n2[0])) {
		    		
		    		if(!Factura.rangoDeFacturas(fechan, fechan2).isEmpty()) {
		    			ArrayList<Producto> Productos = Usuario.productosMasVendidos(fechan, fechan2);
		    			if(!Productos.isEmpty()) {
		    				System.out.println("Nombre   Codido de barras   Cantidad");
		            		for (int i = 0; i < Productos.size(); i++) {
								System.out.println(Productos.get(i).toString());
								}
		    			}else {
		    				//dialogo de informacion
							Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Informacion de balances");
							alert.setHeaderText(null);
							alert.setContentText("No se han vendido suficientes productos");

							alert.showAndWait();
		    				//System.out.println("No se han vendido suficientes productos");
		    			}
		       
		        		}else {
		        			//dialogo de informacion
							Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Informacion de balances");
							alert.setHeaderText(null);
							alert.setContentText("No hay facturas realizadas en el rango de tiempo pedido");

							alert.showAndWait();
		        			//System.out.println("No hay facturas realizadas en el rango de tiempo pedido");
		        		}
		    		
		    		
		    		
		    	}else if(Integer.parseInt(fecha_n[2])==Integer.parseInt(fecha_n2[2])&&Integer.parseInt(fecha_n[1])<Integer.parseInt(fecha_n2[1])) {
		    		
		    		if(!Factura.rangoDeFacturas(fechan, fechan2).isEmpty()) {
		    			ArrayList<Producto> Productos = Usuario.productosMasVendidos(fechan, fechan2);
		    			if(!Productos.isEmpty()) {
		    				System.out.println("Nombre   Codido de barras   Cantidad");
		            		for (int i = 0; i < Productos.size(); i++) {
								System.out.println(Productos.get(i).toString());
								}
		    			}else {
		    				//dialogo de informacion
							Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Informacion de balances");
							alert.setHeaderText(null);
							alert.setContentText("No se han vendido suficientes productos");

							alert.showAndWait();
		    				//System.out.println("No se han vendido suficientes productos");
		    			}
		        		
		        		}else {
		        			//dialogo de informacion
							Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Informacion de balances");
							alert.setHeaderText(null);
							alert.setContentText("No hay facturas realizadas en el rango de tiempo pedido");

							alert.showAndWait();
		        			//System.out.println("No hay facturas realizadas en el rango de tiempo pedido");
		        		}
		    		
		    	}else {
		    		//dialogo de informacion
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Informacion de balances");
					alert.setHeaderText(null);
					alert.setContentText("El rango de las fechas no es correcto");

					alert.showAndWait();
		    		//System.out.println("El rango de las fechas no es correcto");
		    	}
								
			}
			
		};

}
