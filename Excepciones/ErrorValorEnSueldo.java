package Excepciones;

@SuppressWarnings("serial")
public class ErrorValorEnSueldo extends NumberFormatException {
	@Override
	public String getMessage(){
		return "Ingrese un valor de sueldo mayor a 0";
	}

}
