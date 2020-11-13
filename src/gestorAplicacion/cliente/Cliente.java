// Esta clase se encarga de guardar clientes y compras

package gestorAplicacion.cliente;
import java.util.ArrayList;
import java.util.Iterator;

import gestorAplicacion.factura.Factura;

public class Cliente extends Persona{
	

	static private ArrayList<Cliente>clientes=new ArrayList();			/*listado de clientes tipo clientes*/
	private ArrayList<Factura>listaFacturas=new ArrayList();	
	private long compras;											/*compras realizadas anteriormente*/
	static int Nclientes;												/*numero de clientes*/
	
	/*constructor*/
	
	public Cliente(String nombre, int identificacion, String correo, String direccion, String telefono,
			String genero) {
		super(nombre, identificacion, correo, direccion, telefono, genero);
		Nclientes++;
		clientes.add(this);
	}


	/*metodos*/
	public double totalCompras() {
		double control=0;
		for (int i = 0;i <listaFacturas.size();i++) {
			control=control+listaFacturas.get(i).getPedido().gettotalPago();
		}
		
		return control;
	}
	
	public int cantidadClientes() {
		return (Nclientes);													/*total clientes numero*/
	}
	
	public long getCompras() {
		return compras;
	}
	public void setCompras(){													/*suma compra al historial*/
		this.compras++;
	}

	
	public String listaObjetos() {												
		Iterator<Cliente> iterator= clientes.iterator();
		StringBuffer lista=new StringBuffer ("lista clientes \n");
		while(iterator.hasNext()) {
			Cliente cliente1 =(Cliente) iterator.next();
			lista.append(cliente1.toString()+"\n");

		}
		return lista.toString();
	}
	public static Cliente consultarCliente(int id) {
		Cliente p=null;
		for (int i = 0; i < clientes.size(); i++) {
			if(clientes.get(i).getIdentificacion()==id) {
					p=clientes.get(i);
					break;
			}else {
				p=null;
				}
		}
		return p;
	}
	
	public void agregarFactura(Factura f) {
		listaFacturas.add(f);
	}

	public String listaFactura() {
		Iterator<Factura> iterator= listaFacturas.iterator();
		StringBuffer lista=new StringBuffer ("Fecha       Codigo factura\n");
		while(iterator.hasNext()) {
			Factura factura =(Factura) iterator.next();
			lista.append(factura.toString()+"\n");

		}
		return lista.toString();
	}
	public static ArrayList<Cliente> getClientes(){
		return clientes;
	}
	
	public static void setCliente(ArrayList<Cliente> clientes) {
		Cliente.clientes= clientes;
	}
	
	
}
