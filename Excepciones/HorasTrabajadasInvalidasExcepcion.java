package Excepciones;

@SuppressWarnings("serial")
public class HorasTrabajadasInvalidasExcepcion extends Exception {
	@Override
	public String getMessage(){
		return "Ingresar horas validas";
	}

}
