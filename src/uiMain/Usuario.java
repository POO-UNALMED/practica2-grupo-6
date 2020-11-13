

package uiMain;

import java.util.ArrayList;
import java.util.Iterator;

import gestorAplicacion.cliente.*;
import gestorAplicacion.factura.*;

public class Usuario {
	
	 static public String devolucion(int codFac, int codProd, int cantidad) {        //
		Factura d1 = Factura.consultarFactura(codFac);
		if(d1 != null) {
			Pedido p = d1.getPedido();
			
			DetallePedido dp = p.consultarProducto(codProd);
			if(dp != null) {
				
				if(dp.modificarCantidad(cantidad)){
					p.totalPago();
					return "Devolucion exitosa";
				}
				else {
					return "cantidad de devolucion no es correcta";
				}
			}else {
				return "Producto no encontrado";
			}
			
		}else {
			return "factura no registrada";
		}
		
	}
	
	static public ArrayList<Cliente> clientesMayoritarios() {
		ArrayList<Cliente> MayorCliente = Cliente.getClientes();
		ArrayList<Cliente> TopFinal = new ArrayList<Cliente>();
		
		for (int i = 0;i < 3;i++) {
			double compra = 0;
			int x=0;
			for (int j=0;j<MayorCliente.size();j++) {
				if(MayorCliente.get(j).totalCompras()>compra&&!TopFinal.contains(MayorCliente.get(j))) {
					x=j;
					compra=MayorCliente.get(j).totalCompras();
				}
			}
			TopFinal.add(MayorCliente.get(x));
			
		}
		return TopFinal;
	}
	
 static public ArrayList<Producto> mercanciaMuerta (String fechaInicial,String fechaFinal){
		
		ArrayList<Factura> facturas = Factura.rangoDeFacturas(fechaInicial, fechaFinal);
		ArrayList<Producto> productosVendidos = new ArrayList<>();
		
		for (int i = 0; i < facturas.size(); i++) {
			Pedido p = facturas.get(i).getPedido();
			ArrayList<DetallePedido> productos = p.getDetalleProductos();
			for (int j = 0; j < productos.size(); j++) {
				
				if(!productosVendidos.contains(productos.get(j).getProducto())) {
					productosVendidos.add(productos.get(j).getProducto());
				}
				
			}
			
		}
		
		ArrayList<Producto> mercanciaMuerta = new ArrayList<>();
		ArrayList<Producto> inventario = Producto.getProductos();
		for (int i = 0; i < inventario.size(); i++) {
			if(!productosVendidos.contains(inventario.get(i))) {
				mercanciaMuerta.add(inventario.get(i));
			}
		}
		
		return mercanciaMuerta;
		
	}

static public ArrayList<Producto> productosMasVendidos(String fechaInicial,String fechaFinal){
	ArrayList<Factura> facturas = Factura.rangoDeFacturas(fechaInicial, fechaFinal);
	ArrayList<Producto> productosVendidos = new ArrayList<>();
	ArrayList<Producto> topMasVendidos = new ArrayList<>();
	ArrayList<Producto> productosT = Producto.getProductos();
	
	for (int i = 0; i < facturas.size(); i++) {
		Pedido p = facturas.get(i).getPedido();
		ArrayList<DetallePedido> productos = p.getDetalleProductos();
		
		p.setSumaVentas();
		for (int j = 0; j < productos.size(); j++) {
			
			if(!productosVendidos.contains(productos.get(j).getProducto())) {
				productosVendidos.add(productos.get(j).getProducto());
			}
			
			
		}
		
	}
	
	if(productosVendidos.size()>=3) {
		for (int i = 0;i < 3;i++) {
			int venta = 0;
			int x=0;
			for (int j=0;j<productosVendidos.size();j++) {
				if(productosVendidos.get(j).getVentas()>venta) {
					x=j;
					venta=productosVendidos.get(j).getVentas();
				}
			}
			topMasVendidos.add(productosVendidos.get(x));
			productosVendidos.remove(productosVendidos.get(x));
		}
	}
	
	for(int i=0; i<productosT.size();i++) {
		productosT.get(i).setVentas();
	}
	return topMasVendidos;
}

static public String Balance(String fecha1,String fecha2){
	ArrayList<Factura> BalanceF = Factura.rangoDeFacturas(fecha1, fecha2);
	ArrayList<Cliente> ListaBaClientes = new ArrayList<>();
	double Totalpagos=0;
	int totalProductos =0;
	/*total de ventas*/
	for(int j = 0;j<BalanceF.size();j++) {
		Totalpagos += BalanceF.get(j).getPedido().gettotalPago();
	}
	/*Total de Productos*/
	for(int p = 0;p<BalanceF.size();p++) {
		totalProductos += BalanceF.get(p).getPedido().CantidadProductos();
	}
	
	for(int i = 0;i<BalanceF.size();i++) {
		
		if(!ListaBaClientes.contains(BalanceF.get(i).getClientes())) {
			ListaBaClientes.add(BalanceF.get(i).getClientes());
			
		}
		
	}
	Iterator<Cliente> iterator= ListaBaClientes.iterator();
	StringBuffer lista=new StringBuffer ("lista clientes \n");
	while(iterator.hasNext()) {
		Cliente cliente1 =(Cliente) iterator.next();
		lista.append(cliente1.toString()+"\n");

	}
	
	return lista.toString()+"\n Total Vendido : "+Totalpagos+"\n Total Productos : "+totalProductos;
}

static public String registrarCliente(Administrador admin,String nombre, int identificacion, String correo, String direccion, String telefono,
			String gener) {
	return admin.registrarCliente(nombre, identificacion, correo, direccion, telefono, gener);
}

static public String registrarProducto(Administrador admin,String nombre, String marca, String tipo, int cantidad, double precio_referencia) {
	return admin.registrarProducto(nombre, marca, tipo, cantidad, precio_referencia);
}

static public Pedido crearPedido(Administrador admin) {
	return admin.crearPedido();
}

static public String agregarInventario(Administrador admin,long codigo, int cantidad) {
	return admin.agregarInventario(codigo, cantidad);
}

static public String registrarAdmin(String nombre, int identificacion, String correo, String direccion, String telefono,
		String gener, double salario, String profesion) {
		
		
		if(Administrador.consultarAdmin(identificacion)==null) {
			new Administrador(nombre, identificacion, correo, direccion, telefono, gener,salario,profesion);
			return "Administrador registrado exitosamente";
			
		}else {
			return "Administrador ya registrado!!!";
			
		}
}

}
