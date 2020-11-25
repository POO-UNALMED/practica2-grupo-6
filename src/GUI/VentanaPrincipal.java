package GUI;

import java.util.ArrayList;

import Excepciones.ExcepcionCamposVacios;
import Excepciones.ExcepcionFecha;
import Excepciones.ExcepcionObjetoNoEncontrado;
import Excepciones.ExcepcionVerificarTipoDato;
import gestorAplicacion.cliente.Administrador;
import gestorAplicacion.cliente.Cliente;
import gestorAplicacion.factura.Factura;
import gestorAplicacion.factura.Pedido;
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
	Label nombre, descripcion = new Label();
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
				Scene scene1 = new Scene(p,750,600);
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
		nombre = new Label("INSTRUCCIONES");
		nombre.setFont(new Font("Arial",16));
		nombre.setAlignment(Pos.CENTER);
		descripcion.setFont(new Font("Arial",16));
		Rectangle rt = new Rectangle(250,50,Color.TRANSPARENT);
		rt.setStroke(Color.GRAY);
		StackPane sp = new StackPane(new Node[] { rt, nombre });
		
		Label instrucciones = new Label();
		
		instrucciones.setText("  La aplicación se desarolló con el fin de ayudar con los procesos de ventas.\r\n"
				+ " \r\n"
				+ "  Dentro de la aplicacion se pueden realizar ventas desde un usario administrador\r\n"
				+ "  el cual tiene el control de acceso para las ventas, puede realizar el registro de usuarios\r\n"
				+ "  creacion de pedidos, registro de productos, tambien se tendra acceso a las funcionalidades\r\n"
				+ "  de inventario, en la cual se podra ver y modificar las cantidades existentes de cada producto.\r\n"
				+ "\r\n "
				+ " Realizacion de devoluciones a pedidos realizados, un top 3 con los clientes que mas compras \r\n"
				+ "  han realizado, ver la mercancia inactiva, los balances y productos mas vendidos dentro de un\r\n"
				+ "  rango de fechas que el usuario escoja. \r\n"
				+ " \r\n"
				+ "  La aplicacion cuenta con un menu superior, Archivo, Procesos y consultas, Ayuda.\r\n"
				+ " \r\n" 
				+ "  En archivo podemos encontrar las opciones usuario y salir , en usuario encontramos\r\n"
				+ "  la version de la aplicacion.\r\n"
				+ " \r\n" 
				+ "  En procesos y consultas, encontramos las funcinalidades de la aplicacion algunas\r\n"
				+ "  como crear pedidos, y registrar clientes.\r\n"
				+ " \r\n" 
				+ "  A exepcion de  la funcionalidad Clientes mayoritas, todas requieren datos los cuales\r\n"
				+ "  deben ser ingresador por el usuarioy en la pestaña ayuda podemos encontrar la informacion\r\n"
				+ "  acerca de los desarrolladores");
		instrucciones.setFont(new Font("Arial",15));
		
		Rectangle rt1 = new Rectangle(650,450,Color.TRANSPARENT);
		rt1.setStroke(Color.GRAY);
		StackPane sp1 = new StackPane(new Node[] { rt1, instrucciones });
		consultas = new VBox(10);
		consultas.setAlignment(Pos.CENTER);
		consultas.getChildren().addAll(sp,sp1);
		
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
					b2.setOnAction(borrar);
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
					b2.setOnAction(borrar);
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
					boolean[] habilitado = {true};
					pane = new FieldPane("criterio",criterios,"valor",null,habilitado);
					Object[] d = {Producto.getCodigo_de_barras1()+""}; 
					String [] c = {"Codigo"};
					pane.datosNoEditables(d, c);
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
					b2.setOnAction(borrar);
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
					
					String[] criterios = {"ID Administrador","ID Cliente"};
					BorderPane panel = new BorderPane();
					
					boolean[] habilitado = {true};
					pane = new FieldPane("criterio",criterios,"valor",null,habilitado);
					Object[] d = {Pedido.getNpedido1()+""}; 
					String [] c = {"Codigo"};
					pane.datosNoEditables(d, c);
					panel.setCenter(pane);
					
					Rectangle rt2 = new Rectangle(500,290,Color.TRANSPARENT);
					rt2.setStroke(Color.GRAY);
					StackPane sp2 = new StackPane(new Node[] { rt2, panel });
					
					HBox botones = new HBox(100);
					Button b1 = new Button("Siguiente");
					Button b2 = new Button("Borrar");
					botones.getChildren().addAll(b1,b2);
					botones.setAlignment(Pos.CENTER);
					//b1.setOnAction(Aceptar3);
					b1.setOnAction(Siguiente);
					b2.setOnAction(borrar);
					panel.setBottom(botones);
					
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
					b2.setOnAction(borrar);
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
					b2.setOnAction(borrar);
					panel.setBottom(botones);
					
					consultas.setAlignment(Pos.CENTER);
					consultas.getChildren().addAll(sp,sp1,sp2);
					setCenter(consultas);
					setMargin(consultas, i);
				}
				else if((((MenuItem) cont).getText()).equals("Clientes Mayoritarios")) {
					
					String lista = "";
					if(Cliente.getClientes().size()>=3) {
						ArrayList <Cliente> Mayores = Usuario.clientesMayoritarios();
						for(int i = 0;i < Mayores.size();i++) {
							
							lista=lista+"Cliente "+ (i+1)+": " + Mayores.get(i)+" Compras= "+ Mayores.get(i).totalCompras()+"\n";
							
					
						}
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Resultado");
						alert.setHeaderText(null);
						alert.setContentText(lista);
						alert.getDialogPane().setPrefSize(500, 150);
						alert.showAndWait();
						
						
					}else {
						
					}
				}
				
				else if((((MenuItem) cont).getText()).equals("Mercancia Inactiva")) {
					consultas = new VBox(10);
					nombre.setText("Mercancia inactiva");
					descripcion.setText("Permite la visualización de los productos que no se han vendido\n dentro de una rango de fechas(formato de fecha 00/00/0000)");
					
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
					b2.setOnAction(borrar);
					panel.setBottom(botones);
					
					consultas.setAlignment(Pos.CENTER);
					consultas.getChildren().addAll(sp,sp1,sp2);
					setCenter(consultas);
					setMargin(consultas, i);
					
				}
				
				else if((((MenuItem) cont).getText()).equals("Balances")) {
					consultas = new VBox(10);
					nombre.setText("Balances");
					descripcion.setText("Permite la visualización del balance general de las ventas hechas en \nun rango de fechas");
					
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
					b2.setOnAction(borrar);
					panel.setBottom(botones);
					
					consultas.setAlignment(Pos.CENTER);
					consultas.getChildren().addAll(sp,sp1,sp2);
					setCenter(consultas);
					setMargin(consultas, i);
					
				}
				
				else if((((MenuItem) cont).getText()).equals("Productos Mas Vendidos")) {
					consultas = new VBox(10);
					nombre.setText("Productos Mas Vendidos");
					descripcion.setText("Permite la visualización de los productos mas vendidos dentro de \nun rango de fechas");
					
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
					b2.setOnAction(borrar);
					panel.setBottom(botones);
					
					consultas.setAlignment(Pos.CENTER);
					consultas.getChildren().addAll(sp,sp1,sp2);
					setCenter(consultas);


					
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
			
			if(verificarCampos()) {
				try {
					if(isNumeric(campos.get(1).getText()) && isDouble(campos.get(6).getText())){
						int id = Integer.parseInt(campos.get(1).getText());
						double salario = Double.parseDouble(campos.get(6).getText());
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Resultado");
						alert.setHeaderText(null);
						alert.setContentText(Usuario.registrarAdmin(campos.get(0).getText(), id, campos.get(2).getText(), campos.get(3).getText(), campos.get(4).getText(), campos.get(5).getText(), salario, campos.get(7).getText()));
						alert.showAndWait();
						borrar();}
				}
				catch(ExcepcionVerificarTipoDato e){
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Error Gravisimo");
					alert.setHeaderText(null);
					alert.setContentText(e.getMessage()+"\n en Identificacion y/o Salario");

					alert.showAndWait();
					borrar();
				}
				
			}
			
		}
		
	};
	
	///registrar cliente
		EventHandler<ActionEvent> Aceptar2 = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				ArrayList<TextField> campos= pane.getCampos();
				
				if(verificarCampos()) {
					try {
						if(isNumeric(campos.get(0).getText()) && isNumeric(campos.get(2).getText())) {
							int id = Integer.parseInt(campos.get(0).getText());
							int idc = Integer.parseInt(campos.get(2).getText());
							Administrador admin = Administrador.consultarAdmin(id);
							if(admin!=null) {
								Alert alert = new Alert(AlertType.INFORMATION);
								alert.setTitle("Resultado");
								alert.setHeaderText(null);
								alert.setContentText(Usuario.registrarCliente(admin,campos.get(1).getText(), idc, campos.get(3).getText(), campos.get(4).getText(), campos.get(5).getText(), campos.get(6).getText() ));
								alert.showAndWait();
								borrar();
							}
							else {
								throw new ExcepcionObjetoNoEncontrado("Administrador no encontrado");
							}
						}
						
						
					}
					catch(ExcepcionObjetoNoEncontrado e) {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Error Gravisimo");
						alert.setHeaderText(null);
						alert.setContentText(e.getMessage());

						alert.showAndWait();
						borrar();
					
					}
					catch(ExcepcionVerificarTipoDato f){
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Error Gravisimo");
						alert.setHeaderText(null);
						alert.setContentText(f.getMessage()+"\n en ID administrador y/o Identificacion");

						alert.showAndWait();
						borrar();
					}
					
					
				}
						
			}
			
		};
	
	
	///registrar producto
	EventHandler<ActionEvent> Aceptar3 = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent arg0) {
			campos =pane.getCampos();
			
			if(verificarCampos()) {
				try {
					if(isNumeric(campos.get(0).getText()) && isNumeric(campos.get(4).getText()) && isDouble(campos.get(5).getText())) {
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
							borrar();
						}
						else {
							throw new ExcepcionObjetoNoEncontrado("Administrador no encontrado");
						}
					}
					
				}
				catch(ExcepcionObjetoNoEncontrado e) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Error Gravisimo");
					alert.setHeaderText(null);
					alert.setContentText(e.getMessage());

					alert.showAndWait();
					borrar();
				
				}
				catch(ExcepcionVerificarTipoDato a){
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Error Gravisimo");
					alert.setHeaderText(null);
					alert.setContentText(a.getMessage()+"\n en ID administrador o Cantida o Precio");

					alert.showAndWait();
					borrar();
				}
				
			}
			
		}
		
	};
	
	
	
	///Editar inventario
		EventHandler<ActionEvent> editar = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				campos =pane.getCampos();
				
				if(verificarCampos()) {
					try {
						if(isNumeric(campos.get(0).getText()) && isLong(campos.get(1).getText()) && isNumeric(campos.get(2).getText())) {
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
								borrar();
							}
							else {
								//dialogo de informacion
								throw new ExcepcionObjetoNoEncontrado("Administrador no encontrado");
							}
						}
						
					}
					catch(ExcepcionObjetoNoEncontrado e) {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Error Gravisimo");
						alert.setHeaderText(null);
						alert.setContentText(e.getMessage());

						alert.showAndWait();
						borrar();
					}
					catch(ExcepcionVerificarTipoDato a){
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Error Gravisimo");
						alert.setHeaderText(null);
						alert.setContentText(a.getMessage()+"\n en ID administrador o Codigo del producto o Nueva cantidad");

						alert.showAndWait();
						borrar();
					}
				}

						
			}
			
		};
	
	
	
	
	///realizar devolucion
		EventHandler<ActionEvent> Aceptar6 = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				campos =pane.getCampos();
				
				if(verificarCampos()) {
					try {
						if(isNumeric(campos.get(0).getText()) && isNumeric(campos.get(0).getText()) && isNumeric(campos.get(0).getText())
								&& isNumeric(campos.get(0).getText())) {
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
										borrar();
					    			}else {
										throw new ExcepcionObjetoNoEncontrado("Producto no encontrado");
					    				
									}
			
					    		}
					    		else {
									throw new ExcepcionObjetoNoEncontrado("Factura no encontrada");
					    			
								}
				
							}else {
								throw new ExcepcionObjetoNoEncontrado("Cliente no encontrado");
							
							}
						}
						}
						
					catch(ExcepcionObjetoNoEncontrado e) {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Error Gravisimo");
						alert.setHeaderText(null);
						alert.setContentText(e.getMessage());
						alert.showAndWait();
						borrar();
					}
					catch(ExcepcionVerificarTipoDato a) {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Error Gravisimo");
						alert.setHeaderText(null);
						alert.setContentText(a.getMessage()+"\n en alguno de los campos");

						alert.showAndWait();
						borrar();
					}
						
				}
		
			}
			
		};
	
		///mercancia inactiva
		EventHandler<ActionEvent> Aceptar7 = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				campos =pane.getCampos();
				
				if(verificarCampos()) {
					String fecha1 = campos.get(0).getText();
					String fecha2 = campos.get(1).getText();
					
					String [] fecha_1 = fecha1.split("/"); 
			    	String [] fecha_2 = fecha2.split("/");
			    	try {
			    		if(Usuario.confirmarFechas(fecha1, fecha2)) {
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
										borrar();				
									}
				    			
				        		}else {
				        			//dialogo de informacion
									Alert alert = new Alert(AlertType.INFORMATION);
									alert.setTitle("Informacion de busqueda");
									alert.setHeaderText(null);
									alert.setContentText("No hay facturas realizadas en el rango de tiempo pedido");

									alert.showAndWait();
									borrar();
				        		}
			    			
			    		}
			    		
			    	}
			    	catch(ExcepcionFecha e) {
			    		Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("ERROR GRAVISIMO");
						alert.setHeaderText(null);
						alert.setContentText(e.getMessage());

						alert.showAndWait();
						borrar();
			    	}
				}
	
			}
			
		};
		///Balances
		EventHandler<ActionEvent> Aceptar8= new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				campos =pane.getCampos();
				
				if(verificarCampos()) {
					
					String f1 = campos.get(0).getText();
					String f2 = campos.get(1).getText();
					
					String [] fecha_f1 = f1.split("/"); 
			    	String [] fecha_f2 = f2.split("/");
			    	
			    	try {
			    		if(Usuario.confirmarFechas(f1, f2)) {
			    			if(!Factura.rangoDeFacturas(f1, f2).isEmpty()) {
				    			System.out.println(Usuario.Balance(f1, f2));
				    			
				        		}else {
				        			//dialogo de informacion
									Alert alert = new Alert(AlertType.INFORMATION);
									alert.setTitle("Informacion de balances");
									alert.setHeaderText(null);
									alert.setContentText("No hay facturas realizadas en el rango de tiempo pedido");

									alert.showAndWait();
									borrar();
				        		}
			    		}
			    	}
			    	catch(ExcepcionFecha e){
			    		Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("ERROR GRAVISIMO");
						alert.setHeaderText(null);
						alert.setContentText(e.getMessage());

						alert.showAndWait();
						borrar();
			    	}
				}
			
			}  	
			
		};
		///Productos mas vendidos
		EventHandler<ActionEvent> Aceptar9 = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				campos =pane.getCampos();
				if(verificarCampos()) {
					String fechan = campos.get(0).getText();
					String fechan2 = campos.get(1).getText();
					
					try {
						if(Usuario.confirmarFechas(fechan, fechan2)) {
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
									borrar();
				    			}
				       
				        		}else {
				        			//dialogo de informacion
									Alert alert = new Alert(AlertType.INFORMATION);
									alert.setTitle("Informacion de balances");
									alert.setHeaderText(null);
									alert.setContentText("No hay facturas realizadas en el rango de tiempo pedido");

									alert.showAndWait();
									borrar();
				        		}
						}
						
						
					}
					catch(ExcepcionFecha e){
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("ERROR GRAVISIMO");
						alert.setHeaderText(null);
						alert.setContentText(e.getMessage());

						alert.showAndWait();
						borrar();
					}
				}
				
				
				
			}
								
			
			
		};
		
		EventHandler<ActionEvent> borrar = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				borrar();
				
			}
			
		};
		//crear pedido
		
		EventHandler<ActionEvent> Siguiente = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				campos = pane.getCampos();
				
				if(verificarCampos()) {
					
					try {
						if(isNumeric(campos.get(0).getText()) && isNumeric(campos.get(1).getText())) {
							int idAdmin = Integer.parseInt(campos.get(0).getText());
							int idClient = Integer.parseInt(campos.get(1).getText());
							Administrador Admin = Administrador.consultarAdmin(idAdmin);
							Cliente cliente = Cliente.consultarCliente(idClient);
							if(Admin!=null) {
								if (cliente!=null) {
									Pedido pedido = Usuario.crearPedido(Admin);
									VentanaPedido pedido1 = new VentanaPedido();
									setCenter(pedido1);
									setMargin(pedido1, i);
									pedido1.setCliente(cliente);
									pedido1.setAdmin(Admin);
									pedido1.setPedido(pedido);
								}else {
									//dialogo de informacion
									throw new ExcepcionObjetoNoEncontrado("Cliente no encontrado");
								}

							}else {
								//dialogo de informacion
								throw new ExcepcionObjetoNoEncontrado("Administrador no encontrado");
							}
						}	
						}
						
					catch(ExcepcionObjetoNoEncontrado e){
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Error gravisimo");
						alert.setHeaderText(null);
						alert.setContentText(e.getMessage());

						alert.showAndWait();
						borrar();
					}
					catch(ExcepcionVerificarTipoDato a) {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Error Gravisimo");
						alert.setHeaderText(null);
						alert.setContentText(a.getMessage()+"\n en alguno de los campos");

						alert.showAndWait();
						borrar();
					}
					
					
				}
					
				
			}
			
		};
		
		private void borrar() {
			campos =pane.getCampos();
			for (int i = 0; i < campos.size(); i++) {
				campos.get(i).setText("");
			}
		}
		
		
		public boolean verificarCampos() {
			campos = pane.getCampos();
			String camposFaltantes = "";
			String [] criterios = pane.getCriterios();
			
			for (int i = 0; i < campos.size(); i++) {
				if(campos.get(i).getText()==null) {
					camposFaltantes+=criterios[i]+"\n";
				}
				else if(campos.get(i).getText().replace(" ", "").equals("")) {
					camposFaltantes+=criterios[i]+"\n";
				}
			}
			
			try {
				if(camposFaltantes.length()>=1) {
					throw new ExcepcionCamposVacios("Faltan por llenar campos");
				}
				else {
					return true;
				}
			}
			catch(ExcepcionCamposVacios e) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle(e.getMessage());
				alert.setHeaderText(null);
				alert.setContentText(camposFaltantes);

				alert.showAndWait();
				return false;
			}
		}


		private  boolean isNumeric(String cadena)throws ExcepcionVerificarTipoDato{
			try {
				Integer.parseInt(cadena);
				return true;
			} catch (NumberFormatException e){
				throw new ExcepcionVerificarTipoDato("Tipo de dato incorrecto");
			}
		}
		
		private  boolean isDouble(String cadena)throws ExcepcionVerificarTipoDato{
			try {
				Double.parseDouble(cadena);
				return true;
			} catch (NumberFormatException e){
				throw new ExcepcionVerificarTipoDato("Tipo de dato incorrecto");
				
			}
		}
		
		private  boolean isLong(String cadena)throws ExcepcionVerificarTipoDato{
			try {
				Long.parseLong(cadena);
				return true;
			} catch (NumberFormatException e){
				throw new ExcepcionVerificarTipoDato("Tipo de dato incorrecto");
				
			}
		}
}
