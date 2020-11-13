// Esta clase se encarga de registrar clientes,productos,consultar cliente,crear pedido, agregar al inventario y guardar los administradores.


package gestorAplicacion.cliente;
import gestorAplicacion.factura.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;



public class Administrador extends Persona  {
	
	private double salario;
	private String profesion;
	static private ArrayList<Administrador>administradores=new ArrayList();
	static private ArrayList<Producto>productosMasVendidos=new ArrayList();
	
	
	public Administrador(String nombre, int identificacion, String correo, String direccion, String telefono,
			String genero, double salario, String profesion) {
		super(nombre, identificacion, correo, direccion, telefono, genero);
		this.salario = salario;
		this.profesion = profesion;
		administradores.add(this);
	}
	public static ArrayList<Administrador> getAdministradores() {
		return administradores;
	}
	public double getSalario() {
		return salario;
	}
	
	public String getProfesion() {
		return profesion;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public static Administrador consultarAdmin(int id) {
		Administrador p=null;
		for (int i = 0; i < administradores.size(); i++) {
			if(administradores.get(i).getIdentificacion()==id) {
					p=administradores.get(i);
					break;
			}else {
				p=null;
				}
		}
		return p;
	}
	
	public String listaObjetos() {
		Iterator<Administrador> iterator= administradores.iterator();
		StringBuffer lista=new StringBuffer ("lista administradores \n");
		while(iterator.hasNext()) {
			Administrador admin =(Administrador) iterator.next();
			lista.append(admin.toString()+"\n");

		}
		return lista.toString();
	}
	
	public String registrarProducto(String nombre, String marca, String tipo, int cantidad, double precio_referencia) {
		Producto producto = new Producto(nombre,marca,tipo,cantidad,precio_referencia);
		return "Producto registrado exitosamente";
	}
	public String registrarCliente(String nombre, int identificacion, String correo, String direccion, String telefono,
			String genero) {
		
		if(Cliente.consultarCliente(identificacion)==null) {
			Cliente clienteN = new Cliente(nombre,identificacion,correo,direccion,telefono,genero);
			return "cliente registrado exitosamente";
			
		}else {
			return "Cliente ya registrado!!!";
			
		}
		
	}
	
	
	public Pedido crearPedido() {
		Pedido p= new Pedido();
		return p;
	}
	
	public String agregarInventario(long codigo, int cantidad) {
		Producto p = Producto.consultarProducto(codigo);
		if(p!=null) {
			p.modificarStock(cantidad);
			return "Cantidad ingresada";
		}else {
			return "Producto no encontrado";
		}
	}
	
	public static void setAdministradores(ArrayList<Administrador> administradores) {
		Administrador.administradores = administradores;
	}
	
	
	
	
	
	
	
	
}



