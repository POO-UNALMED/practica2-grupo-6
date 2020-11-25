package GUI;

import java.util.ArrayList;
import java.util.Optional;

import Excepciones.ExcepcionCantidad;
import gestorAplicacion.cliente.Administrador;
import gestorAplicacion.cliente.Cliente;
import gestorAplicacion.factura.Factura;
import gestorAplicacion.factura.Pedido;
import gestorAplicacion.factura.Producto;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
//clase que contiene una ventana adicional de un proceso
public class VentanaPedido extends VBox{
	
	private Administrador admin;
	private Cliente cliente;
	private Pedido pedido;
	private FieldPane pane;
	private BorderPane panel;
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public VentanaPedido () {
		super(10);
		panel = new BorderPane();
		
		Label text = new Label("Registrar Productos");
		text.setFont(new Font("Arial",16));
		text.setAlignment(Pos.CENTER);
		Rectangle rt1 = new Rectangle(250,50,Color.TRANSPARENT);
		rt1.setStroke(Color.GRAY);
		StackPane sp1 = new StackPane(new Node[] { rt1, text });
		
		String [] criterios = {"Codigo","Cantidad"};
		pane = new FieldPane("criterio",criterios,"valor",null,null);
		panel.setCenter(pane);
		
		HBox botones = new HBox(100);
		Button b1 = new Button("Agregar");
		Button b2 = new Button("Retirar");
		Button b3 = new Button("Confirmar");
		botones.getChildren().addAll(b1,b2,b3);
		botones.setAlignment(Pos.CENTER);
		b1.setOnAction(Agregar);
		b2.setOnAction(Retirar);
		b3.setOnAction(Confirmar);
		panel.setBottom(botones);
		
		Rectangle rt2 = new Rectangle(500,290,Color.TRANSPARENT);
		rt2.setStroke(Color.GRAY);
		StackPane sp2 = new StackPane(new Node[] { rt2, panel });
		
		setAlignment(Pos.CENTER);
		getChildren().addAll(sp1,sp2);
	}

	public void setAdmin(Administrador admin) {
		this.admin = admin;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	EventHandler<ActionEvent> Agregar = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			ArrayList<TextField> campos = pane.getCampos();
			try {
				if(!Producto.getProductos().isEmpty()) {
					long codigo = Long.parseLong(campos.get(0).getText());
					int cantidad = Integer.parseInt(campos.get(1).getText());
					
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Pedido");
					alert.setHeaderText(null);
					alert.setContentText(pedido.Agregar_producto(codigo, cantidad));

					alert.showAndWait();
				}else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Pedido");
					alert.setHeaderText(null);
					alert.setContentText("No hay productos en el inventario");

					alert.showAndWait();
				}
				
				for (int i = 0; i < campos.size(); i++) {
					campos.get(i).setText("");
				
				
			}
			}catch(ExcepcionCantidad e) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle(e.getMessage());
				alert.setHeaderText(null);
				alert.setContentText(e.getMessage());

				alert.showAndWait();
			}
			}
		
	};
	
	EventHandler<ActionEvent> Confirmar = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent arg0) {
			TextInputDialog dialog = new TextInputDialog();
			dialog.setTitle("Pedido");
			dialog.setHeaderText(null);
			dialog.setContentText("Ingrese la Fecha:");

			// Traditional way to get the response value.
			Optional<String> result = dialog.showAndWait();
			if (result.isPresent()){
			    pedido.crearFactura(true, result.get(), cliente);
			   Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Factura");
				alert.setHeaderText(null);
				alert.setContentText(pedido.getFactura().imprimirFactura());

				alert.showAndWait();
				
				Label texto = new Label("Pedido Realizado Correctamente");
				texto.setFont(new Font("Arial",20));
				panel.setCenter(texto);
				panel.setBottom(null);
			}
			
		}
		
	};
	
	EventHandler<ActionEvent> Retirar = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent arg0) {
			
			
			if(!pedido.getDetalleProductos().isEmpty()) {
				TextInputDialog dialog = new TextInputDialog();
				dialog.setTitle("Retirar Producto del Pedido");
				dialog.setHeaderText(pedido.listaProductos());
				dialog.setContentText("Ingrese Codigo detalle del Producto: ");
				
				// Traditional way to get the response value.
				Optional<String> result = dialog.showAndWait();
				if(result.isPresent()) {
					
					pedido.quitar_producto(Integer.parseInt(result.get()));
				}
									}
			else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Pedido");
				alert.setHeaderText(null);
				alert.setContentText("No se ha registrado ningun producto");

				alert.showAndWait();
			}	
			
		}
		
	};
	
	
	
	
	
		

	}
