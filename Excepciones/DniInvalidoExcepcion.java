package Excepciones;

@SuppressWarnings("serial")
public class DniInvalidoExcepcion extends Exception {
	@Override
	public String getMessage(){
		return "Ingresar DNI valido";
	}
}
