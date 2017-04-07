package Excepciones;

public class HorasTrabajadasInvalidasExcepcion extends Exception {

	public HorasTrabajadasInvalidasExcepcion() {
		
	}
	
	public String error(){
		return "Ingresar horas validas";
	}
	
	

}
