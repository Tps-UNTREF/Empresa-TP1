package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Clases.Ejecutivo;
import Clases.Empleado;
import Clases.EmpleadoPorHora;
import Clases.EmpleadoPorHoraAComision;
import Excepciones.CuilInvalidoExcepcion;
import Excepciones.ErrorDeComision;
import Excepciones.ErrorVentasRealizadas;
import Excepciones.HorasTrabajadasInvalidasExcepcion;


public class EmpresaTest {

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
