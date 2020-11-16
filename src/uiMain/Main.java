package uiMain;
import java.util.ArrayList;
import java.util.Scanner;

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
	Stage window;
	Label Hvida;
	int contador=0;
	ImageView v1;
	
	static Scanner entrada = new Scanner(System.in);
	static {
		Persistencia.leerArchivos();
		Persistencia.reasignar();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		launch(args);
		int numero;
		
		do {
			
			System.out.println("---------------------------");
			System.out.println("      CompuElectronics ");
			System.out.println("---------------------------");
			System.out.println("Elija una opcion:");
			System.out.println("---------------------------");
			System.out.println("|1.Registrar cliente");
			System.out.println("---------------------------");
			System.out.println("|2.Registrar Producto");
			System.out.println("---------------------------");
			System.out.println("|3.Crear Pedido");
			System.out.println("---------------------------");
			System.out.println("|4.inventario");	/*un sub menu...1 editar inventario 2 salir*/
			System.out.println("---------------------------");
			System.out.println("|5.Realizar devolucion");
			System.out.println("---------------------------");
			System.out.println("|6.Clientes mayoritarios");
			System.out.println("---------------------------");
			System.out.println("|7.Mercancia inactiva");
			System.out.println("---------------------------");
			System.out.println("|8.Balances");
			System.out.println("---------------------------");
			System.out.println("|9.Productos mas vendidos");
			System.out.println("---------------------------");
			System.out.println("|10.Crear administrador");
			System.out.println("---------------------------");
			System.out.println("|0.Salir");
			System.out.println("---------------------------");
			
			numero = entrada.nextInt();
			
	
		         
		        switch (numero) 
		        {
		            case 1:		            	
		            	registrarCliente();		            	
		                     break;
		            case 2:  	            	
		            	registrarProducto();
		                     break;
		            case 3: 
		            	crearPedido();
		                     break;
		            case 4:
		            	inventario();
		            	break;
		            case 5:  
		            	realizarDevolucion();
		            	break;    
		            case 6:
		            	clientesMayoritarios();
		            	break;      
		            case 7:  
		            	Mercanciainactiva();
		            	break;
		            case 8:  
		            	balance();
		            	break;
		            case 9:  
		            	productosMasVendidos();
		            	break;
		            case 10:  
		            	crearAdmin();
		            	break;
		            case 0:
		            	System.out.println("Programa finalizado correctamente.");
		            	break;
		         
		            	
		            default: System.out.println("Opcion no valida");;
		                     break;
		        }
		        
			
		}while(numero!=0);
		
		Persistencia.guardarArchivos();
      

	}
	
	public void start(Stage myStage) throws Exception{
		window = myStage;
		window.setTitle("Aplicacion");
		BorderPane borde = new BorderPane();
		borde.setPadding(new Insets(10,10,10,10));
		
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
				window.setScene(scene2);
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
		v1.setFitHeight(150);
	    p6.add(v1, 0, 0);
		
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
		
		borde.setRight(p2);
		borde.setMargin(p2, i);
		borde.setLeft(p1);
		borde.setMargin(p1, i);
		borde.setTop(barraMenu);
		
		 scene1 = new Scene(borde,700,500);
		
		VBox p = new VBox(20);
		Label text2 = new Label("ventana principal");
		text2.setFont(new Font("Arial",15));
		text2.setAlignment(Pos.CENTER);
		
		Button b2 = new Button("atras");
		b2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				window.setScene(scene1);			
			}
			
		});
		
		p.setAlignment(Pos.CENTER);
		p.getChildren().addAll(text2,b2);
		
		scene2 = new Scene(p,600,400);
		
		scene = scene1;
		
		window.setScene(scene);
		window.show();
	}
	
	public void stop() {
		System.out.println("la app se cerro");
		
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
				v1.setImage(new Image(getClass().getResourceAsStream("../imagenes/deyner.jpg")));
				contador++;
			}else if(contador==2) {
				Hvida.setText("Nombre: Daniel Torres"
						+ "\nCorreo: dtorresag@unal.edu.co"
						+ "\nCarrera: Ingenieria en sistemas"
						+ "\nPasatiempo: Dibujar");
				v1.setImage(new Image(getClass().getResourceAsStream("../imagenes/daniel.jpg")));
				contador=0;
			}
			
		}
		
	};
	
	static void registrarCliente() {
		
		System.out.println("");
		System.out.println("Ingrese identificacion del administrador: ");
		System.out.println("");
		int ident = entrada.nextInt();
		Administrador admin = Administrador.consultarAdmin(ident);
		if(admin!=null) {
			System.out.println("Ingrese nombre del cliente: ");
	    	String nombre= entrada.next();
	    	
	    	System.out.println("Ingrese identificacion del cliente:");

	    	int  id= entrada.nextInt();
	    	
	    	System.out.println("Ingrese correo:");
	    	String correo= entrada.next();
	    	
	    	System.out.println("Ingrese direccion:");
	    	String direcion= entrada.next();
	    	
	    	System.out.println("Ingrese telefono:");
	    	String telefono= entrada.next();
	    	
	    	System.out.println("Ingrese genero:");
	    	String genero=entrada.next();
	    	
	    	System.out.println(Usuario.registrarCliente(admin,nombre,id,correo,direcion,telefono,genero));
		}
		else {
			System.out.println("Identificacion incorrecta");
		}
		
	}
	
	static void registrarProducto() {
		System.out.println("");
		System.out.println("Ingrese identificacion del administrador: ");
		System.out.println("");
		int ident = entrada.nextInt();
		Administrador admin = Administrador.consultarAdmin(ident);
		if(admin!=null) {
			System.out.println("Ingrese nombre producto: ");
        	String nombrep= entrada.next();
        	
        	System.out.println("Ingrese marca:");
        	String  marcap= entrada.next();
        	
        	System.out.println("Ingrese tipo:");
        	String tipop= entrada.next();
        	
        	System.out.println("Ingrese cantidad:");
        	int cantidadp= entrada.nextInt();
        	
        	System.out.println("Ingrese precio: ");
        	double precio_referencia= entrada.nextDouble();
	    	
	    	System.out.println(Usuario.registrarProducto(admin, nombrep, marcap, tipop, cantidadp, precio_referencia));
		}
		else {
			System.out.println("Identificacion incorrecta");
		}
	}
	
	static void crearPedido() {
		System.out.println("");
		System.out.println("Ingrese identificacion del administrador: ");
		System.out.println("");
		int ident = entrada.nextInt();
		Administrador admin = Administrador.consultarAdmin(ident);
		if(admin!=null) {
			System.out.println("Ingrese identificacion del cliente: ");
        	
        	int identificacion= entrada.nextInt();
        	
        	Cliente c=Cliente.consultarCliente(identificacion);
        	if(c!=null) {
        		Pedido p=Usuario.crearPedido(admin);
        		int opcion;
        		do {//se registran los productos
        			System.out.println("---------------------------");
        			System.out.println("|Ingrese una opcion");
        			System.out.println("---------------------------");
        			System.out.println("|1.Agregar Producto");
        			System.out.println("---------------------------");
        			System.out.println("|2.Retirar Producto");
        			System.out.println("---------------------------");
        			System.out.println("|3.Terminar Pedido");
        			System.out.println("---------------------------");
        			opcion=entrada.nextInt();
        			
        			switch (opcion) {
        			case 1:
        				if(!Producto.getProductos().isEmpty()) { 			//se confirma que hayan productos en el inventario 
        					System.out.println("Ingrese codigo del producto: ");
        					long codigo = entrada.nextLong();
        					
        					System.out.println("Ingrese cantidad a llevar: ");
        					int cantidad = entrada.nextInt();
        					
        					System.out.println(p.Agregar_producto(codigo, cantidad));
        				}else {
        					System.out.println("No hay productos en el inventario");
        				}
        				break;
        			case 2:
        				System.out.println(p.listaProductos());
        				if(!p.getDetalleProductos().isEmpty()) {			
        					System.out.println("Ingrese codigo de detalle: ");
        					int codigoDetalle = entrada.nextInt();	            					
        					p.quitar_producto(codigoDetalle);
        				}else {
        					System.out.println("No se ha registrado ningun producto");
        				}
        				break;
        			case 3:
        				System.out.println("Pedido terminado");
        				break;
        			default:
        				System.out.println("Opcion invalida");
        				break;
        			}
        			
        		}while(opcion!=3);
        		
        		int op;
        		boolean conf=false;
        		do {// se confirma el pedido
        			System.out.println("---------------------------");
        			System.out.println("|Ingrese una opcion: ");
        			System.out.println("---------------------------");
            		System.out.println("|1.confirmar pedido");
            		System.out.println("---------------------------");
            		System.out.println("|2.cancelar pedido");
            		System.out.println("---------------------------");
            		
            		 op = entrada.nextInt();
            		
            		switch(op) {
            		
            		case 1:
            			conf=p.confirmacion("si");
            			break;
            		case 2:
            			conf=p.confirmacion("no");
            			break;
            		default:
            			System.out.println("opcion no valida");
            		}
        		}while(op!=1&&op!=2);
        		
       
        		if(conf) {//se crea la factura
        			System.out.println("Ingrese la fecha");
            		String fecha = entrada.next();
            		p.crearFactura(conf, fecha, c);
        			System.out.println(p.getFactura().imprimirFactura());
        			
        		}
        		
        	}else {
        		System.out.println("cliente no registrado");
        	}
		}else {
			System.out.println("Identificacion incorrecta");
		}
	}
	
	static void inventario() {
		System.out.println("");
		System.out.println("Ingrese identificacion del administrador: ");
		System.out.println("");
		int ident = entrada.nextInt();
		System.out.println("");
		Administrador admin = Administrador.consultarAdmin(ident);
		if(admin!=null) {
			if(Producto.getProductos().isEmpty()) {
        		System.out.println("No hay productos en el inventario");
        		
        	}
        	
        	else {
        		System.out.println(Producto.listaProductos());				//se muestra el inventario 
        		System.out.println("---------------------------");
        		System.out.println("|Ingrese una opcion");
        		System.out.println("---------------------------");
    			System.out.println("|1.editar inventario");
    			System.out.println("---------------------------");
    			System.out.println("|2.Salir");
    			System.out.println("---------------------------");
    			int opcion1=entrada.nextInt();
    			
    			switch (opcion1) {
    			case 1:
    				System.out.println("Ingrese el codigo del producto: ");
	            	long codigo = entrada.nextLong();
	            	
	            	System.out.println("Ingresa la cantidad: ");
	            	int cantidad = entrada.nextInt();
	            	
	            	System.out.println(Usuario.agregarInventario(admin, codigo, cantidad));
	            	break;
    			case 2:
    				break;
    			}
            	
        	}
		}else {
			System.out.println("Identificacion incorrecta");
		}
	}
	
	static void realizarDevolucion() {
		System.out.println("Ingrese identificacion del cliente: ");
    	int identificacion_2= entrada.nextInt(); 	
    	Cliente devolucion = Cliente.consultarCliente(identificacion_2);
    	
    	if(devolucion!=null) {
    		System.out.println(devolucion.listaFactura());
    		System.out.println("Ingrese codigo de Factura ");
    		int Nfactura  = entrada.nextInt();
    		Factura consulta = Factura.consultarFactura(Nfactura);
    		
    		if(consulta!=null) {												//verifica que exista la factura
    			System.out.println(consulta.getPedido().listaProductos());
    			System.out.println("Ingrese el CodigoDetalle del producto: ");
    			int codigoPro = entrada.nextInt();
    			if(consulta.getPedido().consultarProducto(codigoPro)!=null) {
    				System.out.println("Ingrese la cantidad de devolucion");
    				int cantidad = entrada.nextInt();
    				
    				System.out.println(Usuario.devolucion(Nfactura, codigoPro, cantidad));
    			}else {
    				System.out.println("producto no encontrado");
    			}
    			
    		}
    		else {
    			System.out.println("No se encontro factura");
    			
    		}
   		}else {
   			System.out.println("Cliente no encontrado");
   		}
	}
	
	static void clientesMayoritarios() {
		if(Cliente.getClientes().size()>=3) {
			ArrayList <Cliente> Mayores = Usuario.clientesMayoritarios();
			for(int i = 0;i < Mayores.size();i++) {
				
				System.out.println("Cliente "+ (i+1)+": " + Mayores.get(i)+" Compras= "+ Mayores.get(i).totalCompras());
				
			}
		}
		else {
			System.out.println("No hay clientes suficientes para esta funcion");
		}
	}
	static void Mercanciainactiva() {
		System.out.println("---------------------------");
		System.out.println("|Ingrese la fecha inicial: ");
    	System.out.println("|ejemplo(12/11/2020)");
    	System.out.println("---------------------------");
    	String fecha1 = entrada.next();
    	
    	System.out.println("---------------------------");
    	System.out.println("|Ingrese la fecha final: ");
    	System.out.println("|ejemplo(20/11/2020)");
    	System.out.println("---------------------------");
    	String fecha2 = entrada.next();
    	
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
						System.out.println("No hay suficientes productos vendidos");
					}
        		}else {
        			System.out.println("No hay facturas realizadas en el rango de tiempo pedido");
        		}
    		
    		
    		
    	}else if(Integer.parseInt(fecha_1[2])==Integer.parseInt(fecha_2[2])&&Integer.parseInt(fecha_1[1])<Integer.parseInt(fecha_2[1])) {
    		
    		if(!Factura.rangoDeFacturas(fecha1, fecha2).isEmpty()) {
    			ArrayList<Producto> Productos = Usuario.mercanciaMuerta(fecha1, fecha2);
        		System.out.println("Nombre   Codido de barras   Cantidad");
        		for (int i = 0; i < Productos.size(); i++) {
					System.out.println(Productos.get(i).toString());
					}
        		}else {
        			System.out.println("No hay facturas realizadas en el rango de tiempo pedido");
        		}
    		
    	}else {
    		System.out.println("El rango de las fechas no es correcto");
    	}
	}
	
	static void balance() {
		/*ingrese fecha(mes o año)
    	 * retorne clientes, #Total productos Vendidos y total precio de ventas*/
		System.out.println("---------------------------");
    	System.out.println("|Ingrese la fecha inicial: ");
    	System.out.println("|ejemplo(12/11/2020)");
    	System.out.println("---------------------------");
    	String f1 = entrada.next();
    	
    	System.out.println("---------------------------");
    	System.out.println("|Ingrese la fecha final: ");
    	System.out.println("|ejemplo(20/11/2020)");
    	System.out.println("---------------------------");
    	String f2 = entrada.next();
    	String [] fecha_f1 = f1.split("/"); 
    	String [] fecha_f2 = f2.split("/");
        
    	if(Integer.parseInt(fecha_f1[2])==Integer.parseInt(fecha_f2[2])&&Integer.parseInt(fecha_f1[1])==Integer.parseInt(fecha_f2[1])&&Integer.parseInt(fecha_f1[0])<Integer.parseInt(fecha_f2[0])) {
    		
    		if(!Factura.rangoDeFacturas(f1, f2).isEmpty()) {
    			System.out.println(Usuario.Balance(f1, f2));
    			
        		}else {
        			System.out.println("No hay facturas realizadas en el rango de tiempo pedido");
        		}
    		
    		
    		
    		
    	}else if(Integer.parseInt(fecha_f1[2])==Integer.parseInt(fecha_f2[2])&&Integer.parseInt(fecha_f1[1])<Integer.parseInt(fecha_f2[1])) {
    		
    		if(!Factura.rangoDeFacturas(f1, f2).isEmpty()) {
    			System.out.println(Usuario.Balance(f1, f2));
        		}else {
        			System.out.println("No hay facturas realizadas en el rango de tiempo pedido");
        		}
    		
    	}else {
    		System.out.println("El rango de las fechas no es correcto");
    	} 
    	
    	
    	
    	
	}
	
	
	
	static void productosMasVendidos() {
		System.out.println("---------------------------");
		System.out.println("|Ingrese la fecha inicial: ");
    	System.out.println("|ejemplo(12/11/2020)");
    	System.out.println("---------------------------");
    	String fechan = entrada.next();
    	
    	System.out.println("---------------------------");
    	System.out.println("|Ingrese la fecha final: ");
    	System.out.println("|ejemplo(20/11/2020)");
    	System.out.println("---------------------------");
    	String fechan2 = entrada.next();
    	
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
    				System.out.println("No se han vendido suficientes productos");
    			}
       
        		}else {
        			System.out.println("No hay facturas realizadas en el rango de tiempo pedido");
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
    				System.out.println("No se han vendido suficientes productos");
    			}
        		
        		}else {
        			System.out.println("No hay facturas realizadas en el rango de tiempo pedido");
        		}
    		
    	}else {
    		System.out.println("El rango de las fechas no es correcto");
    	}
        
	}
	
	static void crearAdmin() {
		
			System.out.println("Ingrese nombre administrador: ");
	    	String nombre= entrada.next();
	    	
	    	System.out.println("Ingrese identificacion:");
	    	int  id= entrada.nextInt();
	    	
	    	System.out.println("Ingrese correo:");
	    	String correo= entrada.next();
	    	
	    	System.out.println("Ingrese direccion:");
	    	String direcion= entrada.next();
	    	
	    	System.out.println("Ingrese telefono:");
	    	String telefono= entrada.next();
	    	
	    	System.out.println("Ingrese genero:");
	    	String genero=entrada.next();
	    	
	    	System.out.println("Ingrese salario:");
	    	double salario= entrada.nextDouble();
	    	
	    	System.out.println("Ingrese profesion:");
	    	String pr= entrada.next();
	    	
	    	System.out.println(Usuario.registrarAdmin(nombre,id,correo,direcion,telefono,genero,salario,pr));
	
	}
	
}

