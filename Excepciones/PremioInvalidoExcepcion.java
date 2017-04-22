package Excepciones;

@SuppressWarnings("serial")
public class PremioInvalidoExcepcion extends Exception {
	@Override
	public String getMessage() {
		return "Ingresar un premio valido";
	}
	
}
