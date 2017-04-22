package Excepciones;

@SuppressWarnings("serial")
public class NombreInvalidoExcepcion extends Exception {
	@Override
	public String getMessage(){
		return "Ingresar Nombre valido";
	}
}