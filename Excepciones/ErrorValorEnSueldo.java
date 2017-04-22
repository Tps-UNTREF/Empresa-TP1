package Excepciones;

@SuppressWarnings("serial")
public class ErrorValorEnSueldo extends Exception {
	@Override
	public String getMessage(){
		return "Ingrese un valor de sueldo mayor a 0";
	}

}
