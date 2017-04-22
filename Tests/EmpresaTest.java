package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Clases.Ejecutivo;
import Clases.Empleado;
import Clases.EmpleadoPorHora;
import Clases.EmpleadoPorHoraAComision;
import Excepciones.CuilInvalidoExcepcion;
import Excepciones.ErrorValorEnSueldo;
import Excepciones.ErrorVentasRealizadas;
import Excepciones.HorasTrabajadasInvalidasExcepcion;


public class EmpresaTest {

	@Test
	public void empleadoPorHora_ProbarNombre() throws NumberFormatException, CuilInvalidoExcepcion {
		EmpleadoPorHora empleado = new EmpleadoPorHora("Matias Bellotti","20205446530",100);
		assertEquals("Matias Bellotti" , empleado.getNombre());
	}
	
	@Test
	public void empleadoPorHora_ProbarCuil() throws NumberFormatException, CuilInvalidoExcepcion {
		EmpleadoPorHora empleado = new EmpleadoPorHora("Matias Bellotti","20205446530",100);
		assertEquals("20205446530" , empleado.getCuil());
	}
	
	@Test(expected = CuilInvalidoExcepcion.class)
	public void empleadoPorHora_ProbarCuilIncorrecto() throws NumberFormatException, CuilInvalidoExcepcion {
		Empleado empleado = new EmpleadoPorHora("Matias Bellotti","202054",100);
	}
	
	@Test
	public void empleadoPorHora_ProbarSueldo() throws NumberFormatException, CuilInvalidoExcepcion, HorasTrabajadasInvalidasExcepcion {
		EmpleadoPorHora empleado = new EmpleadoPorHora("Matias Bellotti","20205446530",100);
		empleado.setHorasTrabajadas(100);
		assertEquals(10000,empleado.getSueldo(), 0.01);
	}
	
	@Test(expected = ErrorValorEnSueldo.class)
	public void empleadoPorHora_ProbarSueldoPorHoraInvalido() throws NumberFormatException, CuilInvalidoExcepcion, HorasTrabajadasInvalidasExcepcion {
		EmpleadoPorHora empleado = new EmpleadoPorHora("Matias Bellotti","20205446530",-100);
	}
	
	@Test(expected = HorasTrabajadasInvalidasExcepcion.class)
	public void empleadoPorHora_ProbarHorasTrabajadasInvalidas() throws NumberFormatException, CuilInvalidoExcepcion, HorasTrabajadasInvalidasExcepcion {
		EmpleadoPorHora empleado = new EmpleadoPorHora("Matias Bellotti","20205446530",100);
		empleado.setHorasTrabajadas(-100);
	}
}
