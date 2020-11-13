package uiMain;
import java.util.ArrayList;
import java.util.Scanner;

import BaseDatos.Persistencia;
import gestorAplicacion.cliente.*;
import gestorAplicacion.factura.*;




public class Main {
	
	static Scanner entrada = new Scanner(System.in);
	static {
		Persistencia.leerArchivos();
		Persistencia.reasignar();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
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

