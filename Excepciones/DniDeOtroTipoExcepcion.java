package Excepciones;

@SuppressWarnings("serial")
public class DniDeOtroTipoExcepcion extends Exception {
	@Override
	public String getMessage(){
		return "Ingreso el Dni de otro tipo de Empleado";
	}
}
