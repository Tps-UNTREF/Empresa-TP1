package Excepciones;

@SuppressWarnings("serial")
public class ErrorDeComision extends Exception {
	@Override
	public String getMessage(){
		return "Ingresar comision con valor mayor a 0 y menor o igual a 100";
	}
	

}
