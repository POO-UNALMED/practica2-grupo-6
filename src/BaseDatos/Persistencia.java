package BaseDatos;

import java.io.*;
import java.util.ArrayList;

import gestorAplicacion.cliente.Administrador;
import gestorAplicacion.cliente.Cliente;
import gestorAplicacion.factura.DetallePedido;
import gestorAplicacion.factura.Factura;
import gestorAplicacion.factura.Pedido;
import gestorAplicacion.factura.Producto;

public class Persistencia {
	public static void guardarArchivos (){												
		ObjectOutputStream escribir;
		File Adminis = new File("src\\BaseDatos\\temp\\Administradores.txt");
		File cl = new File("src\\BaseDatos\\temp\\Clientes.txt");
		File dtpedido = new File("src\\BaseDatos\\temp\\DetallePedido.txt");
		File factura1 = new File("src\\BaseDatos\\temp\\Factura.txt");
		File Pedido1 = new File("src\\BaseDatos\\temp\\Pedido.txt");
		File producto1 = new File("src\\BaseDatos\\temp\\Producto.txt");
		
		if(!Adminis.exists() ) {													//si no existe crea el archivo
			try {
				Adminis.createNewFile();
				
				
			}
			catch(IOException e){
				System.out.println("No se pudo crear archivo administrador");
			}
		}
		
		try {																		//Escribir en el archivo
			escribir =new ObjectOutputStream(new FileOutputStream(Adminis));
			ArrayList<Administrador> mostrarAdmin = Administrador.getAdministradores();
			escribir.writeObject(mostrarAdmin);
			escribir.close();
			
		}
		catch(IOException p){
			System.out.println("Se ha generado un error en escritura administrador");
			
		}
		
		if(!cl.exists() ) {
			try {
				cl.createNewFile();
			}
			catch(IOException e){
				System.out.println("No se pudo crear archivo cliente");
			}
		}
		try {
			escribir =new ObjectOutputStream(new FileOutputStream(cl));
			ArrayList<Cliente> mostrarClient = Cliente.getClientes();
			escribir.writeObject(mostrarClient);
			escribir.close();
			
		}
		catch(IOException p){
			System.out.println("Se ha generado un error en escritura cliente");
		}
		
		
		if(!dtpedido.exists() ) {
			try {
				dtpedido.createNewFile();
			}
			catch(IOException e){
				System.out.println("No se pudo crear archivo pedido");
			}
		}
		try {
			escribir =new ObjectOutputStream(new FileOutputStream(dtpedido));
			ArrayList<DetallePedido> mostrardtpedido = DetallePedido.getDetallePedido();
			escribir.writeObject(mostrardtpedido);
			escribir.close();
			
		}
		catch(IOException p){
			System.out.println("Se ha generado un error en escritura pedido");
		}
		
		
		if(!factura1.exists() ) {
			try {
				factura1.createNewFile();
			}
			catch(IOException e){
				System.out.println("No se pudo crear archivo factura");
			}
		}
		try {
			escribir =new ObjectOutputStream(new FileOutputStream(factura1));
			ArrayList<Factura> mostrarfactura1 = Factura.getLFacturas();
			escribir.writeObject(mostrarfactura1);
			escribir.close();
			
		}
		catch(IOException p){
			System.out.println("Se ha generado un error en escritura factura");
		}
		
		
		if(!Pedido1.exists() ) {
			try {
				Pedido1.createNewFile();
			}
			catch(IOException e){
				System.out.println("No se pudo crear archivo Pedido");
			}
		}
		try {
			escribir =new ObjectOutputStream(new FileOutputStream(Pedido1));
			ArrayList<Pedido> mostrarPedido1 = Pedido.getLpedidos();
			escribir.writeObject(mostrarPedido1);
			escribir.close();
			
		}
		catch(IOException p){
			System.out.println("Se ha generado un error en escritura Pedido");
		}
		
		//
		if(!producto1.exists() ) {
			try {
				producto1.createNewFile();
			}
			catch(IOException e){
				System.out.println("No se pudo crear archivo producto1");
			}
		}
		try {
			escribir =new ObjectOutputStream(new FileOutputStream(producto1));
			ArrayList<Producto> mostrarproducto1 = Producto.getProductos();
			escribir.writeObject(mostrarproducto1);
			escribir.close();
			
		}
		catch(IOException p){
			System.out.println("Se ha generado un error en escritura producto1");
		}
	}
	
	
	
	
	public static void leerArchivos() {
		ObjectInputStream leer;
		File Admin = new File("src\\BaseDatos\\temp\\Administradores.txt");
		File cl = new File("src\\BaseDatos\\temp\\Clientes.txt");
		File dtpedido2 = new File("src\\BaseDatos\\temp\\DetallePedido.txt");
		File factura2 = new File("src\\BaseDatos\\temp\\Factura.txt");
		File Pedido2 = new File("src\\BaseDatos\\temp\\Pedido.txt");
		File producto2 = new File("src\\BaseDatos\\temp\\Producto.txt");
		
		if(!Admin.exists()) {												//si no existe , se crea el archivo
			try {
				Admin.createNewFile();													
				
			}catch(Exception e) {
				System.out.println("Archivo no enconotrado");
			}
		}
		
		try {
			
			leer = new ObjectInputStream(new FileInputStream(Admin));							// si existe se lee el archivo
			@SuppressWarnings("unchecked")
			ArrayList<Administrador> Admins = (ArrayList<Administrador>) leer.readObject();
			Administrador.setAdministradores(Admins);
			
		}catch(Exception e) {
			System.out.println("Archivo no enconotrado");
		}
		
		//
		
		if(!cl.exists()) {
			try {
				cl.createNewFile();
				
			}catch(Exception e) {
				System.out.println("Archivo no enconotrado");
			}
		}
		
		try {
			
			leer = new ObjectInputStream(new FileInputStream(cl));
			@SuppressWarnings("unchecked")
			ArrayList<Cliente> cliente = (ArrayList<Cliente>) leer.readObject();
			Cliente.setCliente(cliente);
			leer.close();
			
		}catch(Exception e) {
			System.out.println("Archivo no enconotrado");
		}
		
		//
		
		if(!dtpedido2.exists()) {
			try {
				dtpedido2.createNewFile();
				
			}catch(Exception e) {
				System.out.println("Archivo no enconotrado");
			}
		}
		
		try {
			
			leer = new ObjectInputStream(new FileInputStream(dtpedido2));
			@SuppressWarnings("unchecked")
			ArrayList<DetallePedido> detallePedido = (ArrayList<DetallePedido>) leer.readObject();
			DetallePedido.setDpedido(detallePedido);
			leer.close();
			
		}catch(Exception e) {
			System.out.println("Archivo no enconotrado");
		}
		
		//
		
		if(!factura2.exists()) {
			try {
				factura2.createNewFile();
				
			}catch(Exception e) {
				System.out.println("Archivo no enconotrado");
			}
		}
		
		try {
			
			leer = new ObjectInputStream(new FileInputStream(factura2));
			@SuppressWarnings("unchecked")
			ArrayList<Factura> fact = (ArrayList<Factura>) leer.readObject();
			Factura.setFacturas(fact);
			leer.close();
			
		}catch(Exception e) {
			System.out.println("Archivo no enconotrado");
		}
		
		//
		
		if(!Pedido2.exists()) {
			try {
				Pedido2.createNewFile();
				
			}catch(Exception e) {
				System.out.println("Archivo no enconotrado");
			}
		}
		
		try {
			
			leer = new ObjectInputStream(new FileInputStream(Pedido2));
			@SuppressWarnings("unchecked")
			ArrayList<Pedido> pedido = (ArrayList<Pedido>) leer.readObject();
			Pedido.setPedido(pedido);
			leer.close();
			
		}catch(Exception e) {
			System.out.println("Archivo no enconotrado");
		}
		
		//
		
		if(!producto2.exists()) {
			try {
				producto2.createNewFile();
				
			}catch(Exception e) {
				System.out.println("Archivo no enconotrado");
			}
		}
		
		try {
			
			leer = new ObjectInputStream(new FileInputStream(producto2));
			@SuppressWarnings("unchecked")
			ArrayList<Producto> producto = (ArrayList<Producto>) leer.readObject();
			Producto.setProducto(producto);
			leer.close();
			
		}catch(Exception e) {
			System.out.println("Archivo no enconotrado");
		}
		
		
	}
	
	public static void reasignar() {
		if(!Factura.getLFacturas().isEmpty()) {
			Factura.setNumfactura(Factura.getLFacturas().get(Factura.getLFacturas().size()-1).getNfacturas()+1);
		}
		
		if(!Pedido.getLpedidos().isEmpty()) {
			int x = Pedido.getLpedidos().size()-1;
			Pedido.setNpedido(Pedido.getLpedidos().get(x).getNpedido());
		}
		
		if(!Producto.getProductos().isEmpty()) {
			int x = Producto.getProductos().size()-1;
			Producto.setCodigo_de_barras1(Producto.getProductos().get(x).getCodigo_de_barras()+1);
		}
		
		if(!DetallePedido.getDetallePedido().isEmpty()) {
			int x =DetallePedido.getDetallePedido().size()-1;
			DetallePedido.setId1(DetallePedido.getDetallePedido().get(x).getId()+1);
		}
	}
}


