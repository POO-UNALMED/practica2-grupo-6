package Excepciones;

public class ErrorAplicacion extends Exception {
	String mensaje = "Manejo de errores de la Aplicaci�n: ";
	public ErrorAplicacion(String mensaje){
		super(mensaje);
	}
	
}
