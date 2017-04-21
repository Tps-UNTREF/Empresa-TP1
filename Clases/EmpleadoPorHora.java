package Clases;
import Excepciones.CuilInvalidoExcepcion;
import Excepciones.HorasTrabajadasInvalidasExcepcion;

public class EmpleadoPorHora extends Empleado {

	int horasTrabajadas;
	/**
	 * pre : 
	 * 
	 * post:
	 * 
	 */
	public EmpleadoPorHora(String nombre, String cuil, double sueldoPorHora) throws NumberFormatException, CuilInvalidoExcepcion {
		super(nombre, cuil, sueldoPorHora);
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
			
			System.out.println(e.getMessage());
			
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
