// Esta clase es el inventario de la tienda y contiene los metodos como guardar y otros

package gestorAplicacion.factura;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import gestorAplicacion.cliente.Administrador;
import gestorAplicacion.cliente.Cliente;

public class Producto implements Serializable{
	private static final long serialVersionUID = -1L;
	private int ventas;
	private String nombre;
	private String marca;
	private String tipo;
	private double precio_venta;
	private static long codigo_de_barras1=1001;
	private long codigo_de_barras;
	private int cantidad;
	private double precio_referencia;
	private ArrayList<DetallePedido> Detalles = new ArrayList<DetallePedido>();
	private static ArrayList<Producto> productos = new ArrayList<Producto>();
	
	public Producto(String nombre, String marca, String tipo, int cantidad, double precio_referencia) {		      
		super();
		this.nombre = nombre;
		this.marca = marca;
		this.tipo = tipo;
		this.cantidad = cantidad;
		this.precio_referencia = precio_referencia;
		this.codigo_de_barras=codigo_de_barras1;
		productos.add(this);
		asignarPrecioVenta(precio_referencia);
		codigo_de_barras1++;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void modificarStock(int cantidad) {
		this.cantidad +=cantidad;
	}
	
	private void asignarPrecioVenta(double precio_referencia) {
		this.precio_venta= precio_referencia + precio_referencia*0.1;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPrecio_venta() {												//
		return precio_venta;
	}

	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}
	
	public static Producto consultarProducto(long codigo) {
		Producto p=null;
		for (int i = 0; i < productos.size(); i++) {
			if(productos.get(i).codigo_de_barras==codigo) {
					p=productos.get(i);
					break;
			}else {
				p=null;
				}
		}
		return p;
	}

	public static long getCodigo_de_barras1() {
		return codigo_de_barras1;
	}

	public static ArrayList<Producto> getProductos() {
		return productos;
	}
	
	
	
	@Override
	public String toString() {
		return  nombre + "---" +  codigo_de_barras + "---" + cantidad;
	}

	public static String listaProductos() {
		Iterator<Producto> iterator= productos.iterator();
		StringBuffer lista=new StringBuffer ("Nombre  Codigo  Cantidad \n");
		while(iterator.hasNext()) {
			Producto producto =(Producto) iterator.next();
			lista.append(producto.toString()+"\n");

		}
		return lista.toString();
	}
	
	public void setVentas(int can) {										//sobrecarga de metodos
		ventas= can+ventas;
	}
	public int getVentas() {
		return ventas;
	}
	public void setVentas() {												//sobrecarga de metodos
		ventas= 0;
	}
	
	public static void setProducto(ArrayList<Producto> producto) {
		Producto.productos= producto;
	}

	public static void setCodigo_de_barras1(long codigo_de_barras1) {
		Producto.codigo_de_barras1 = codigo_de_barras1;
	}

	public long getCodigo_de_barras() {
		return codigo_de_barras;
	}
	
	
}
