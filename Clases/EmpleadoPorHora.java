package Clases;
import Excepciones.HorasTrabajadasInvalidasExcepcion;

public class EmpleadoPorHora extends Empleado {

	int horasTrabajadas;
	/**
	 * pre : 
	 * 
	 * post:
	 * 
	 */
	public EmpleadoPorHora(String nombre, int dni, double sueldoPorHora) {
		super(nombre, dni, sueldoPorHora);
	}
	/**
	 * pre : 
	 * 
	 * post:
	 * 
	 */
	public int getHorasTrabajadas() {
		return horasTrabajadas;
	}
	/**
	 * pre : 
	 * 
	 * post:
	 * 
	 */
	public void setHorasTrabajadas(int horasTrabajadas) throws HorasTrabajadasInvalidasExcepcion {
		
		try{
			
			if(horasTrabajadas > 0){
				
				this.horasTrabajadas = horasTrabajadas;
			
			}else{
				
				throw new HorasTrabajadasInvalidasExcepcion();
			}
		}
		catch(HorasTrabajadasInvalidasExcepcion e){
			
			System.out.println(e.error());
			
		}
			
			
	}
	/**
	 * pre : 
	 * 
	 * post:
	 * 
	 */
	public double getSueldo(){
		
		return super.getSueldo() * horasTrabajadas ;
		
	}
	/**
	 * pre : 
	 * 
	 * post:
	 * 
	 */
	public String toString(){
		return "Tipo: EmpleadoPorHora"+" Nombre: " + super.getNombre() + " Cuil :" + super.getCuil() + " Sueldo por hora: " + super.getSueldo();
		
	}
}
