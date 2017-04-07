package Tests;
import static org.junit.Assert.*;

import org.junit.Test;

import Clases.Empleado;


public class EmpresaTest {

	@Test
	public void CambiarNombreAEmpleado() {
		Empleado empleado = new Empleado("Ricky Centurion",20544653,150000.0);
		empleado.setCuil(20544654);
		assertEquals("20-20544654-7",empleado.getCuil());
	}

}
