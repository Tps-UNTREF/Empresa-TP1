package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Clases.Ejecutivo;
import Clases.Empleado;
import Clases.EmpleadoPorHora;
import Clases.EmpleadoPorHoraAComision;
import Excepciones.CuilInvalidoExcepcion;
import Excepciones.DniInvalidoExcepcion;
import Excepciones.ErrorValorEnSueldo;
import Excepciones.ErrorDeComision;
import Excepciones.ErrorVentasRealizadas;
import Excepciones.HorasTrabajadasInvalidasExcepcion;
import Excepciones.NombreInvalidoExcepcion;


public class EmpresaTest {
	
	///---------------------------------------------TEST DE TRABAJADOR----------------------------------------------//
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
//		new Trabajador("", 389919111);
//	}
//	
//	@Test(expected=NombreInvalidoExcepcion.class)
//	public void _TrabajadorNewConNombreInvalidoSoloNumeros() throws DniInvalidoExcepcion, NombreInvalidoExcepcion{
//		new Trabajador("123", 389919111);
//	}
//
//	@Test(expected=DniInvalidoExcepcion.class)
//	public void _TrabajadorNewConDniInvalidoMasGrande() throws DniInvalidoExcepcion, NombreInvalidoExcepcion{
//		new Trabajador("Franco De Alesandro", 389919111);
//	}
//	
//	@Test(expected=DniInvalidoExcepcion.class)
//	public void _TrabajadorNewConDniInvalidoNegativo() throws DniInvalidoExcepcion, NombreInvalidoExcepcion{
//		new Trabajador("Franco De Alesandro", -3899191);
//	}
	
	///---------------------------------------------TEST DE EMPLEADO----------------------------------------------//
	public void Empleado_ProbarCuil() throws NumberFormatException, CuilInvalidoExcepcion, DniInvalidoExcepcion, NombreInvalidoExcepcion {
		Empleado empleado = new Empleado("Matias Juguera","20205446530",150000.0);
		assertEquals("20205446530" , empleado.getCuil());
	}
	
	@Test
	public void Empleado_ProbarNombre() throws NumberFormatException, CuilInvalidoExcepcion, DniInvalidoExcepcion, NombreInvalidoExcepcion {
		Empleado empleado = new Empleado("Nicolas Hansen","20205446530",150000.0);
		assertEquals("Nicolas Hansen" , empleado.getNombre());
	}
	
	@Test
	public void crearEjecutivo() throws NumberFormatException, CuilInvalidoExcepcion, DniInvalidoExcepcion, NombreInvalidoExcepcion {
		Ejecutivo ejecutivo = new Ejecutivo("Nicolas Hansen","20205446530",150000.0);
		assertEquals("Nicolas Hansen",ejecutivo.getNombre());
		assertEquals("20205446530",ejecutivo.getCuil());
		assertEquals(150000,ejecutivo.getSueldo(),000.0);
	}
	
	public void Empleado_ProbarSueldo() throws NumberFormatException, CuilInvalidoExcepcion, DniInvalidoExcepcion, NombreInvalidoExcepcion {
		Empleado empleado = new Empleado("Matias Bellotti","20205446530",150000.0);
		assertEquals(150000.0 , empleado.getSueldo(), 0.0);
	}
	
	@Test (expected = CuilInvalidoExcepcion.class)
	public void Empleado_ProbarCuil_EsperandoError() throws NumberFormatException, CuilInvalidoExcepcion, DniInvalidoExcepcion, NombreInvalidoExcepcion {
		new Empleado("Franco de Alessandro","20544653",150000.0);
	}
	
	@Test (expected = ErrorValorEnSueldo.class)
	public void Empleado_ProbarSueldo_EsperandoError() throws CuilInvalidoExcepcion, NumberFormatException, DniInvalidoExcepcion, NombreInvalidoExcepcion {
		new Empleado("Matias Bellotti","20205446530",-150.0);
	}
	
	///---------------------------------------------TEST DE EMPLEADOPORHORA----------------------------------------------//
	
	@Test
	public void crearEmpleadoPorHora() throws HorasTrabajadasInvalidasExcepcion, NumberFormatException, CuilInvalidoExcepcion, DniInvalidoExcepcion, NombreInvalidoExcepcion {
		EmpleadoPorHora empleadoPorHora = new EmpleadoPorHora("Matias Bellotti","20205446530",80.0);
		empleadoPorHora.setHorasTrabajadas(10);
		assertEquals(10,empleadoPorHora.getHorasTrabajadas());
		assertEquals("Matias Bellotti",empleadoPorHora.getNombre());
		assertEquals("20205446530",empleadoPorHora.getCuil());
		assertEquals(800,empleadoPorHora.getSueldo(),000.0);
	}
		
	public void empleadoPorHora_ProbarNombre() throws NumberFormatException, CuilInvalidoExcepcion, DniInvalidoExcepcion, NombreInvalidoExcepcion {
		EmpleadoPorHora empleado = new EmpleadoPorHora("Matias Bellotti","20205446530",100);
		assertEquals("Matias Bellotti" , empleado.getNombre());
	}
	
	@Test
	public void crearEmpleadoPorHoraAComision() throws HorasTrabajadasInvalidasExcepcion, ErrorVentasRealizadas, NumberFormatException, CuilInvalidoExcepcion, DniInvalidoExcepcion, NombreInvalidoExcepcion, ErrorDeComision {
		EmpleadoPorHoraAComision empleadoPorHoraAComision = new EmpleadoPorHoraAComision("Franco de Alessandro","20205446530",80.0,50);
		empleadoPorHoraAComision.setHorasTrabajadas(100);
		empleadoPorHoraAComision.setVentasRealizadas(10);
		assertEquals(100,empleadoPorHoraAComision.getHorasTrabajadas());
		assertEquals("Franco de Alessandro",empleadoPorHoraAComision.getNombre());
		assertEquals("20205446530",empleadoPorHoraAComision.getCuil());
		assertEquals(8005,empleadoPorHoraAComision.getSueldo(),000.0);
	}
		
	public void empleadoPorHora_ProbarCuil() throws NumberFormatException, CuilInvalidoExcepcion, DniInvalidoExcepcion, NombreInvalidoExcepcion {
		EmpleadoPorHora empleado = new EmpleadoPorHora("Matias Bellotti","20205446530",100);
		assertEquals("20205446530" , empleado.getCuil());
	}
	
	@Test(expected = CuilInvalidoExcepcion.class)
	public void empleadoPorHora_ProbarCuilIncorrecto() throws NumberFormatException, CuilInvalidoExcepcion, DniInvalidoExcepcion, NombreInvalidoExcepcion {
		new EmpleadoPorHora("Matias Bellotti","202054",100);
	}
	
	@Test
	public void empleadoPorHora_ProbarSueldo() throws NumberFormatException, CuilInvalidoExcepcion, HorasTrabajadasInvalidasExcepcion, DniInvalidoExcepcion, NombreInvalidoExcepcion {
		EmpleadoPorHora empleado = new EmpleadoPorHora("Matias Bellotti","20205446530",100);
		empleado.setHorasTrabajadas(100);
		assertEquals(10000,empleado.getSueldo(), 0.01);
	}	
	
	///---------------------------------------------TEST DE EMPLEADOPORHORAACOMISION----------------------------------------------//
		@Test
	public void EmpleadoPorHoraAComision_ProbarNombre() throws NumberFormatException, CuilInvalidoExcepcion, ErrorDeComision, DniInvalidoExcepcion, NombreInvalidoExcepcion {
		EmpleadoPorHoraAComision empleado = new EmpleadoPorHoraAComision("Matias Juguera","XX39560630X",20,20);
		assertEquals("Matias Juguera",empleado.getNombre());	
	}
	
	@Test
	public void EmpleadoPorHoraAComision_ProbarComision() throws NumberFormatException, CuilInvalidoExcepcion, ErrorDeComision, DniInvalidoExcepcion, NombreInvalidoExcepcion {
		EmpleadoPorHoraAComision empleado = new EmpleadoPorHoraAComision("Matias Juguera","XX39560630X",20,20);
		assertEquals(20,empleado.getComision());	
	}
	
	@Test(expected = ErrorDeComision.class)
	public void EmpleadoPorHoraAComision_ProbarComisionMayorA100() throws NumberFormatException, CuilInvalidoExcepcion, ErrorDeComision, DniInvalidoExcepcion, NombreInvalidoExcepcion {
		new EmpleadoPorHoraAComision("Matias Juguera","XX39560630X",20,120);	
	}

	@Test(expected = ErrorDeComision.class)
	public void EmpleadoPorHoraAComision_ProbarComisionMenorA0() throws NumberFormatException, CuilInvalidoExcepcion, ErrorDeComision, DniInvalidoExcepcion, NombreInvalidoExcepcion {
		new EmpleadoPorHoraAComision("Matias Juguera","XX39560630X",20,0);	
	}
	
	@Test
	public void EmpleadoPorHoraAComision_ProbarCambiarComision() throws NumberFormatException, CuilInvalidoExcepcion, ErrorDeComision, DniInvalidoExcepcion, NombreInvalidoExcepcion {
		EmpleadoPorHoraAComision empleado = new EmpleadoPorHoraAComision("Matias Juguera","XX39560630X",20,20);
		empleado.setCambiarComision(30);
		assertEquals(30,empleado.getComision());	
	}
	
	@Test
	public void EmpleadoPorHoraAComision_ProbarVentasRealizadas() throws NumberFormatException, CuilInvalidoExcepcion, ErrorDeComision, ErrorVentasRealizadas, DniInvalidoExcepcion, NombreInvalidoExcepcion {
		EmpleadoPorHoraAComision empleado = new EmpleadoPorHoraAComision("Matias Juguera","XX39560630X",20,20);
		empleado.setVentasRealizadas(40);
		assertEquals(40,empleado.getVentasRealizadas());	
	}
	
	@Test(expected = ErrorVentasRealizadas.class)
	public void EmpleadoPorHoraAComision_ProbarVentasRealizadasNegativas() throws NumberFormatException, CuilInvalidoExcepcion, ErrorDeComision, ErrorVentasRealizadas, DniInvalidoExcepcion, NombreInvalidoExcepcion {
		EmpleadoPorHoraAComision empleado = new EmpleadoPorHoraAComision("Matias Juguera","XX39560630X",20,20);
		empleado.setVentasRealizadas(-40);	
	}
	
	@Test
	public void EmpleadoPorHoraAComision_ProbarSueldo() throws NumberFormatException, CuilInvalidoExcepcion, ErrorDeComision, ErrorVentasRealizadas, HorasTrabajadasInvalidasExcepcion, DniInvalidoExcepcion, NombreInvalidoExcepcion {
		EmpleadoPorHoraAComision empleado = new EmpleadoPorHoraAComision("Matias Juguera","XX39560630X",80,10);
		empleado.setVentasRealizadas(40);
		empleado.setHorasTrabajadas(160);
		assertEquals(12804,empleado.getSueldo(),00000.1);	
	}
	
	@Test(expected = ErrorValorEnSueldo.class)
	public void empleadoPorHora_ProbarSueldoPorHoraInvalido() throws NumberFormatException, CuilInvalidoExcepcion, HorasTrabajadasInvalidasExcepcion, DniInvalidoExcepcion, NombreInvalidoExcepcion {
		new EmpleadoPorHora("Matias Bellotti","20205446530",-100);
	}
	
	@Test(expected = HorasTrabajadasInvalidasExcepcion.class)
	public void empleadoPorHora_ProbarHorasTrabajadasInvalidas() throws NumberFormatException, CuilInvalidoExcepcion, HorasTrabajadasInvalidasExcepcion, DniInvalidoExcepcion, NombreInvalidoExcepcion {
		EmpleadoPorHora empleado = new EmpleadoPorHora("Matias Bellotti","20205446530",100);
		empleado.setHorasTrabajadas(-100);
	}
}
