
public class PremioInvalidoExcepcion extends Exception {

	public PremioInvalidoExcepcion() {}
	
	public String error() {
		return "Ingresar un premio valido";
	}
	
}
