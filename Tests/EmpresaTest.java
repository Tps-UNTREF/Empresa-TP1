package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Clases.Ejecutivo;
import Clases.Empleado;
import Clases.EmpleadoPorHora;
import Clases.EmpleadoPorHoraAComision;
import Excepciones.CuilInvalidoExcepcion;
import Excepciones.DniInvalidoExcepcion;
import Excepciones.ErrorVentasRealizadas;
import Excepciones.HorasTrabajadasInvalidasExcepcion;
import Excepciones.NombreInvalidoExcepcion;


public class EmpresaTest {

	@Test
	public void crearEmpleado() throws NumberFormatException, CuilInvalidoExcepcion, DniInvalidoExcepcion, NombreInvalidoExcepcion {
		Empleado empleado = new Empleado("Matias Juguera","20205446530",150000.0);
		assertEquals("Matias Juguera",empleado.getNombre());
		assertEquals("20205446530",empleado.getCuil());
		assertEquals(150000,empleado.getSueldo(),000.0);
	}
	@Test
	public void crearEjecutivo() throws NumberFormatException, CuilInvalidoExcepcion, DniInvalidoExcepcion, NombreInvalidoExcepcion {
		Ejecutivo ejecutivo = new Ejecutivo("Nicolas Hansen","20205446530",150000.0);
		assertEquals("Nicolas Hansen",ejecutivo.getNombre());
		assertEquals("20205446530",ejecutivo.getCuil());
		assertEquals(150000,ejecutivo.getSueldo(),000.0);
	}
	@Test
	public void crearEmpleadoPorHora() throws HorasTrabajadasInvalidasExcepcion, NumberFormatException, CuilInvalidoExcepcion, DniInvalidoExcepcion, NombreInvalidoExcepcion {
		EmpleadoPorHora empleadoPorHora = new EmpleadoPorHora("Matias Bellotti","20205446530",80.0);
		empleadoPorHora.setHorasTrabajadas(10);
		assertEquals(10,empleadoPorHora.getHorasTrabajadas());
		assertEquals("Matias Bellotti",empleadoPorHora.getNombre());
		assertEquals("20205446530",empleadoPorHora.getCuil());
		assertEquals(800,empleadoPorHora.getSueldo(),000.0);
	}
	@Test
	public void crearEmpleadoPorHoraAComision() throws HorasTrabajadasInvalidasExcepcion, ErrorVentasRealizadas, NumberFormatException, CuilInvalidoExcepcion, DniInvalidoExcepcion, NombreInvalidoExcepcion {
		EmpleadoPorHoraAComision empleadoPorHoraAComision = new EmpleadoPorHoraAComision("Franco de Alessandro","20205446530",80.0,50);
		empleadoPorHoraAComision.setHorasTrabajadas(100);
		empleadoPorHoraAComision.setVentasRealizadas(10);
		assertEquals(100,empleadoPorHoraAComision.getHorasTrabajadas());
		assertEquals("Franco de Alessandro",empleadoPorHoraAComision.getNombre());
		assertEquals("20205446530",empleadoPorHoraAComision.getCuil());
		assertEquals(8005,empleadoPorHoraAComision.getSueldo(),000.0);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Test
//	public void _TrabajadorNew() throws DniInvalidoExcepcion, NombreInvalidoExcepcion{
//		Trabajador t = new Trabajador("Franco De Alesandro", 38991911);
//		assertEquals("Franco De Alesandro", t.getNombre());
//		assertEquals(38991911, t.getDni(), 0);
//	}
//	
//	@Test
//	public void _TrabajadorNewMasChico() throws DniInvalidoExcepcion, NombreInvalidoExcepcion{
//		Trabajador t = new Trabajador("Franco De Alesandro", 8991911);
//		assertEquals("Franco De Alesandro", t.getNombre());
//		assertEquals(8991911, t.getDni(), 0);
//	}
//	
//	@Test(expected=NombreInvalidoExcepcion.class)
//	public void _TrabajadorNewConNombreInvalidoVacio() throws DniInvalidoExcepcion, NombreInvalidoExcepcion{
//		Trabajador t = new Trabajador("", 389919111);
//		assertEquals("Franco De Alesandro", t.getNombre());
//		assertEquals(38991911, t.getDni(), 0);
//	}
//	
//	@Test(expected=NombreInvalidoExcepcion.class)
//	public void _TrabajadorNewConNombreInvalidoSoloNumeros() throws DniInvalidoExcepcion, NombreInvalidoExcepcion{
//		Trabajador t = new Trabajador("123", 389919111);
//		assertEquals("Franco De Alesandro", t.getNombre());
//		assertEquals(38991911, t.getDni(), 0);
//	}
//
//	@Test(expected=DniInvalidoExcepcion.class)
//	public void _TrabajadorNewConDniInvalidoMasGrande() throws DniInvalidoExcepcion, NombreInvalidoExcepcion{
//		Trabajador t = new Trabajador("Franco De Alesandro", 389919111);
//		assertEquals("Franco De Alesandro", t.getNombre());
//		assertEquals(38991911, t.getDni(), 0);
//	}
//	
//	@Test(expected=DniInvalidoExcepcion.class)
//	public void _TrabajadorNewConDniInvalidoNegativo() throws DniInvalidoExcepcion, NombreInvalidoExcepcion{
//		Trabajador t = new Trabajador("Franco De Alesandro", -3899191);
//		assertEquals("Franco De Alesandro", t.getNombre());
//		assertEquals(38991911, t.getDni(), 0);
//	}
	
}
