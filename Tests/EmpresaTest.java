package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Clases.Ejecutivo;
import Clases.Empleado;
import Clases.EmpleadoPorHora;
import Clases.EmpleadoPorHoraAComision;
import Excepciones.CuilInvalidoExcepcion;
import Excepciones.ErrorDeComision;
import Excepciones.ErrorValorEnSueldo;
import Excepciones.ErrorVentasRealizadas;
import Excepciones.HorasTrabajadasInvalidasExcepcion;


public class EmpresaTest {

	///---------------------------------------------TEST DE EMPLEADO----------------------------------------------//
	public void Empleado_ProbarCuil() throws NumberFormatException, CuilInvalidoExcepcion {
		Empleado empleado = new Empleado("Matias Juguera","20205446530",150000.0);
		assertEquals("20205446530" , empleado.getCuil());
	}
	
	@Test
	public void Empleado_ProbarNombre() throws NumberFormatException, CuilInvalidoExcepcion {
		Empleado empleado = new Empleado("Nicolas Hansen","20205446530",150000.0);
		assertEquals("Nicolas Hansen" , empleado.getNombre());
	}
	
	@Test
	public void Empleado_ProbarSueldo() throws NumberFormatException, CuilInvalidoExcepcion {
		Empleado empleado = new Empleado("Matias Bellotti","20205446530",150000.0);
		assertEquals(150000.0 , empleado.getSueldo(), 0.0);
	}
	
	@Test (expected = CuilInvalidoExcepcion.class)
	public void Empleado_ProbarCuil_EsperandoError() throws NumberFormatException, CuilInvalidoExcepcion {
		new Empleado("Franco de Alessandro","20544653",150000.0);
	}
	
	@Test (expected = ErrorValorEnSueldo.class)
	public void Empleado_ProbarSueldo_EsperandoError() throws ErrorValorEnSueldo, CuilInvalidoExcepcion {
		new Empleado("Matias Bellotti","20205446530",-150.0);
	}
	///---------------------------------------------TEST DE EMPLEADOPORHORAACOMISION----------------------------------------------//
		@Test
	public void EmpleadoPorHoraAComision_ProbarNombre() throws NumberFormatException, CuilInvalidoExcepcion, ErrorDeComision {
		EmpleadoPorHoraAComision empleado = new EmpleadoPorHoraAComision("Matias Juguera","XX39560630X",20,20);
		assertEquals("Matias Juguera",empleado.getNombre());	
	}
	
	@Test
	public void EmpleadoPorHoraAComision_ProbarComision() throws NumberFormatException, CuilInvalidoExcepcion, ErrorDeComision {
		EmpleadoPorHoraAComision empleado = new EmpleadoPorHoraAComision("Matias Juguera","XX39560630X",20,20);
		assertEquals(20,empleado.getComision());	
	}
	@Test(expected = ErrorDeComision.class)
	public void EmpleadoPorHoraAComision_ProbarComisionMayorA100() throws NumberFormatException, CuilInvalidoExcepcion, ErrorDeComision {
		EmpleadoPorHoraAComision empleado = new EmpleadoPorHoraAComision("Matias Juguera","XX39560630X",20,120);	
	}
	@Test(expected = ErrorDeComision.class)
	public void EmpleadoPorHoraAComision_ProbarComisionMenorA0() throws NumberFormatException, CuilInvalidoExcepcion, ErrorDeComision {
		EmpleadoPorHoraAComision empleado = new EmpleadoPorHoraAComision("Matias Juguera","XX39560630X",20,0);	
	}
	
	@Test
	public void EmpleadoPorHoraAComision_ProbarCambiarComision() throws NumberFormatException, CuilInvalidoExcepcion, ErrorDeComision {
		EmpleadoPorHoraAComision empleado = new EmpleadoPorHoraAComision("Matias Juguera","XX39560630X",20,20);
		empleado.setCambiarComision(30);
		assertEquals(30,empleado.getComision());	
	}
	
	@Test
	public void EmpleadoPorHoraAComision_ProbarVentasRealizadas() throws NumberFormatException, CuilInvalidoExcepcion, ErrorDeComision, ErrorVentasRealizadas {
		EmpleadoPorHoraAComision empleado = new EmpleadoPorHoraAComision("Matias Juguera","XX39560630X",20,20);
		empleado.setVentasRealizadas(40);
		assertEquals(40,empleado.getVentasRealizadas());	
	}
	@Test(expected = ErrorVentasRealizadas.class)
	public void EmpleadoPorHoraAComision_ProbarVentasRealizadasNegativas() throws NumberFormatException, CuilInvalidoExcepcion, ErrorDeComision, ErrorVentasRealizadas {
		EmpleadoPorHoraAComision empleado = new EmpleadoPorHoraAComision("Matias Juguera","XX39560630X",20,20);
		empleado.setVentasRealizadas(-40);	
	}
	
	@Test
	public void EmpleadoPorHoraAComision_ProbarSueldo() throws NumberFormatException, CuilInvalidoExcepcion, ErrorDeComision, ErrorVentasRealizadas, HorasTrabajadasInvalidasExcepcion {
		EmpleadoPorHoraAComision empleado = new EmpleadoPorHoraAComision("Matias Juguera","XX39560630X",80,10);
		empleado.setVentasRealizadas(40);
		empleado.setHorasTrabajadas(160);
		assertEquals(12804,empleado.getSueldo(),00000.1);	
	}
	

	
	
	
	
	
	

}
