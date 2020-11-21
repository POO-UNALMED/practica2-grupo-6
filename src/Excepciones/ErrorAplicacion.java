package Excepciones;

public class ErrorAplicacion extends Exception {
	String mensaje = "Manejo de errores de la Aplicación: ";
	public ErrorAplicacion(String mensaje){
		super(mensaje);
	}
	
}
