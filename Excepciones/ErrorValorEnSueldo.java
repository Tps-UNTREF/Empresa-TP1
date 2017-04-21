package Excepciones;

@SuppressWarnings("serial")
public class ErrorValorEnSueldo extends Exception {
	
	public String Error(){
		return "Ingrese un valor de sueldo mayor a 0";
	}

}
