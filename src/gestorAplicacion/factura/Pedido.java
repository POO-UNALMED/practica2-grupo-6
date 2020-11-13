// Esta clase se encarga de guardar los datos necesarios para generar una factura


package gestorAplicacion.factura;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import gestorAplicacion.cliente.Administrador;
import gestorAplicacion.cliente.Cliente;

public class Pedido implements Serializable {
	private static final long serialVersionUID = -1L;
	private ArrayList<String> productos = new ArrayList<String>();
	private ArrayList<DetallePedido> DetalleProductos = new ArrayList<DetallePedido>();
	private static ArrayList<Pedido> pedido = new ArrayList<Pedido>();
	private final int num_pedido;
	private static int Npedido=1001;
	private boolean estado;
	private Factura factura;
	private double totalPago;
	
	
	public static ArrayList<Pedido> getLpedidos(){
		
		return pedido;
	}
	
	
	public Pedido() {
		this.num_pedido=Npedido;
		Npedido++;
		pedido.add(this);
	}
	
	
	public String Agregar_producto(long codigo,int cantidad) {
		Producto p=Producto.consultarProducto(codigo);
		if(p!=null) {
			if(cantidad<=p.getCantidad()) {
				DetallePedido d= new DetallePedido(cantidad,this,p);
				DetalleProductos.add(d);
				return "producto agregado";
			}else {
				return"Supero la cantidad en el inventario";
			}
		}else {
			return"Producto no encontrado";
		}
		
	}
	public void quitar_producto(int id) {
		for (int i = 0; i < DetalleProductos.size(); i++) {
			if(DetalleProductos.get(i).getId()==id) {
				DetalleProductos.get(i).eliminarDetalle(DetalleProductos.get(i), DetalleProductos.get(i).getCantidad());
				DetalleProductos.remove(DetalleProductos.get(i));
				break;
			}
		}
	}
	public void totalPago() {
		double total=0;
		for (int i = 0; i < DetalleProductos.size(); i++) {
			DetallePedido p1=DetalleProductos.get(i);							/*Producto X de la lista*/
			double cant=p1.getCantidad();										/*cantidad de productos*/ 
			Producto product=p1.getProducto();									/*producto X */
			double valor=product.getPrecio_venta();								/*valor de venta de producto X*/
			total=total+ (cant*valor);
		}
		totalPago=total;
	}
	public boolean confirmacion(String x) {
		if (x=="si") {
			return true;
		}
		return false;
	}
	
	public String crearFactura(boolean confirmacion,String fecha,Cliente cliente) {
		
		if(confirmacion) {
			Factura factura = new Factura(fecha,this,cliente);
			this.factura=factura;
			this.estado=true;
			totalPago();
			return "Factura realizada";
			
		}else {
			pedido.remove(this);
			return "No se ha realizado el pedido";
			
		}
	}
	
	public DetallePedido consultarProducto(int codigo) {
		DetallePedido p=null;
		for (int i = 0; i < DetalleProductos.size(); i++) {
			if(DetalleProductos.get(i).getId()==codigo) {
				p=DetalleProductos.get(i);
				break;
			}else {
				p=null;
			}		
		}
		return p;
	}
	
	public String listaProductos() {
		Iterator<DetallePedido> iterator= DetalleProductos.iterator();
		StringBuffer lista=new StringBuffer ("Nombre   CodidoDetalle  Cantidad \n");
		while(iterator.hasNext()) {
			DetallePedido producto =(DetallePedido) iterator.next();
			lista.append(producto.toString()+"\n");

		}
		return lista.toString();
	}


	public ArrayList<DetallePedido> getDetalleProductos() {
		return DetalleProductos;
	}


	public Factura getFactura() {
		return factura;
	}
	
	public double gettotalPago() {
		return totalPago;
	}
	
	public void setSumaVentas() {
		for(int i =0;i<DetalleProductos.size();i++) {
			DetalleProductos.get(i).getProducto().setVentas(DetalleProductos.get(i).getCantidad());
		}
	}
	
	public int CantidadProductos() {
		int total = 0;
		for (int i=0;i<DetalleProductos.size();i++) {
			total += DetalleProductos.get(i).getCantidad();
		}
		return total;
	}

	public static void setPedido(ArrayList<Pedido> pedido) {
		Pedido.pedido = pedido;
	}


	public  int getNpedido() {
		return num_pedido;
	}


	public static void setNpedido(int npedido) {
		Npedido = npedido;
	}

	
	
}
