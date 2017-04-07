package Excepciones;

@SuppressWarnings("serial")
public class ValorFueraDeRangoException extends Exception {
	
	public ValorFueraDeRangoException() {
	}
	
	public String error(){
		return "Valor fuera de rango";
	}
}
