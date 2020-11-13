// Esta clase se encarga de guardar cada producto con su respectiva cantidad en un pedido

package gestorAplicacion.factura;

import java.io.Serializable;
import java.util.ArrayList;

import gestorAplicacion.cliente.Administrador;
import gestorAplicacion.cliente.Cliente;

public class DetallePedido implements Serializable{
	private static final long serialVersionUID = -1L;
	private int id;
	private int Cantidad;
	private Pedido pedido;
	private Producto producto;
	private static int  id1=1001;
	private static ArrayList<DetallePedido> Detalles = new ArrayList<DetallePedido>();
	
	public DetallePedido( int cantidad, Pedido pedido, Producto producto) {
		super();
		this.id = id1;
		Cantidad = cantidad;
		this.pedido = pedido;
		this.producto = producto;
		this.producto.modificarStock(-cantidad);
		Detalles.add(this);
		id1++;
	}
	public static ArrayList<DetallePedido> getDetallePedido(){
		return Detalles;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return Cantidad;
	}

	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public boolean modificarCantidad(int cantidad) {
		if(cantidad<=this.Cantidad) {
			this.Cantidad=this.Cantidad-cantidad;
			this.producto.modificarStock(cantidad);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public String toString() {
		return this.producto.getNombre()+ "---"+this.id+"---"+Cantidad ;
	}
	
	public void eliminarDetalle(DetallePedido d,int Cantidad) {
		Detalles.remove(d);
		modificarCantidad(Cantidad);
	}
	
	public static void setDpedido(ArrayList<DetallePedido> detallePedido) {
		DetallePedido.Detalles = detallePedido;
	}
	public static void setId1(int id1) {
		DetallePedido.id1 = id1;
	}
	
	

}
