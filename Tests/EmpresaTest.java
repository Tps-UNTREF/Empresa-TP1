package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Clases.Ejecutivo;
import Clases.Empleado;
import Clases.EmpleadoPorHora;
import Clases.EmpleadoPorHoraAComision;
import Excepciones.CuilInvalidoExcepcion;
import Excepciones.ErrorVentasRealizadas;
import Excepciones.HorasTrabajadasInvalidasExcepcion;


public class EmpresaTest {

	@Test
	public void crearEmpleado() throws NumberFormatException, CuilInvalidoExcepcion {
		Empleado empleado = new Empleado("Matias Juguera","20205446530",150000.0);
		assertEquals("Matias Juguera",empleado.getNombre());
		assertEquals("20205446530",empleado.getCuil());
		assertEquals(150000,empleado.getSueldo(),000.0);
	}
	@Test
	public void crearEjecutivo() throws NumberFormatException, CuilInvalidoExcepcion {
		Ejecutivo ejecutivo = new Ejecutivo("Nicolas Hansen","20205446530",150000.0);
		assertEquals("Nicolas Hansen",ejecutivo.getNombre());
		assertEquals("20205446530",ejecutivo.getCuil());
		assertEquals(150000,ejecutivo.getSueldo(),000.0);
	}
	@Test
	public void crearEmpleadoPorHora() throws HorasTrabajadasInvalidasExcepcion, NumberFormatException, CuilInvalidoExcepcion {
		EmpleadoPorHora empleadoPorHora = new EmpleadoPorHora("Matias Bellotti","20205446530",80.0);
		empleadoPorHora.setHorasTrabajadas(10);
		assertEquals(10,empleadoPorHora.getHorasTrabajadas());
		assertEquals("Matias Bellotti",empleadoPorHora.getNombre());
		assertEquals("20205446530",empleadoPorHora.getCuil());
		assertEquals(800,empleadoPorHora.getSueldo(),000.0);
	}
	@Test
	public void crearEmpleadoPorHoraAComision() throws HorasTrabajadasInvalidasExcepcion, ErrorVentasRealizadas, NumberFormatException, CuilInvalidoExcepcion {
		EmpleadoPorHoraAComision empleadoPorHoraAComision = new EmpleadoPorHoraAComision("Franco de Alessandro","20205446530",80.0,50);
		empleadoPorHoraAComision.setHorasTrabajadas(100);
		empleadoPorHoraAComision.setVentasRealizadas(10);
		assertEquals(100,empleadoPorHoraAComision.getHorasTrabajadas());
		assertEquals("Franco de Alessandro",empleadoPorHoraAComision.getNombre());
		assertEquals("20205446530",empleadoPorHoraAComision.getCuil());
		assertEquals(8005,empleadoPorHoraAComision.getSueldo(),000.0);
	}
	
	
	
	
	
	

}
