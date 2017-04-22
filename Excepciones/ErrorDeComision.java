package Excepciones;

@SuppressWarnings("serial")
public class ErrorDeComision extends Exception {
	@Override
	public String getMessage(){
		return "Ingresar comision valida";
	}
	

}
