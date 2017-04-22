package Excepciones;

@SuppressWarnings("serial")
public class CuilInvalidoExcepcion extends Exception {
	@Override
	public String getMessage(){
		return "Ingresar CUIL valido";
	}
}
