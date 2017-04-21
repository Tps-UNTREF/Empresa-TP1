package Excepciones;

@SuppressWarnings("serial")
public class ValorFueraDeRangoException extends Exception {
	@Override
	public String getMessage(){
		return "Valor fuera de rango";
	}
}
