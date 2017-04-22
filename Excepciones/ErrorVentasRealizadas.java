package Excepciones;

@SuppressWarnings("serial")
public class ErrorVentasRealizadas extends Exception {
	@Override
	public String getMessage(){
		return "Ingresar numero de ventas validas";
	}

}
