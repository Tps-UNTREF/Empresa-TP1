package Clases;
import Excepciones.CuilInvalidoExcepcion;
import Excepciones.DniInvalidoExcepcion;
import Excepciones.ErrorDeComision;
import Excepciones.ErrorVentasRealizadas;
import Excepciones.NombreInvalidoExcepcion;

public class EmpleadoPorHoraAComision extends EmpleadoPorHora {

	int comision;
	int ventasRealizadas;
	/**
	 * pre: Se le ingresa nombre, cuil de 11 digitos, sueldo por hora y una comision. 
	 */
	public EmpleadoPorHoraAComision(String nombre, String cuil, double sueldoPorHora , int comision) throws NumberFormatException, CuilInvalidoExcepcion, DniInvalidoExcepcion, NombreInvalidoExcepcion, ErrorDeComision {
		super(nombre, cuil, sueldoPorHora);
		setCambiarComision(comision);
	}
	/**
	 * 
	 * 
	 * post: Obtenes el valor de la comision en un valor entero.
	 * 
	 */
	public int getComision() {
		return comision;
	}
	/**
	 * pre: Se le ingresa un entero como nuevo porcentaje de comision, la comision tiene que ser mayor a 0 y menor o igual a 100.
	 * post: Cambia la comision que ya teniamos.  
	 */
	public void setCambiarComision(int comision) throws ErrorDeComision {
		if(comision > 0 && comision <= 100){
			this.comision = comision;
		}else{
			throw new ErrorDeComision();	
		}	
	}
	/**
	 * post: Se obtiene la cantidad de ventas realizadas.
	 * 
	 */
	public int getVentasRealizadas() {
		return ventasRealizadas;
	}
	/**
	 * pre: Se ingresa le ingresa un entero que son la cantidad de ventas que realizó, estas ventas no pueden ser menor a 0.
	 * post: Cambia el valor de las ventas realizadas.
	 */
	public void setVentasRealizadas(int ventasRealizadas) throws ErrorVentasRealizadas {
		if(ventasRealizadas < 0){
			throw new ErrorVentasRealizadas();	
		}else{
			this.ventasRealizadas = ventasRealizadas;	
		}
	}
	/**
	 * post: Se obtiene el valor del sueldo, sabiendo la cantidad de ventas realizadas y 
	 * 
	 */
	public double getSueldo(){
		double comisionEnVentas = 0;
		comisionEnVentas = (this.comision * this.ventasRealizadas) / 100;
		return comisionEnVentas + super.getSueldo();
	}
	/** 
	 * post: Devuelve la descripcion del EmpleadoPorHoraAComision
	 */
	public String toString(){
		return "Tipo: EmpleadoPorHoraAComision"+" Nombre: " + super.getNombre() + "Cuil: " + super.getCuil() + super.getSueldo() + " Comision: " + this.getComision();
	}
}
