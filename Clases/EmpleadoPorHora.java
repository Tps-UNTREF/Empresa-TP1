package Clases;
import Excepciones.CuilInvalidoExcepcion;
import Excepciones.HorasTrabajadasInvalidasExcepcion;

public class EmpleadoPorHora extends Empleado {

	int horasTrabajadas;
	/**
	 * pre:se le ingresa nombre, cuil (se le agregua un de 11 digitos) y sueldo por hora al empleadoPorHora mayor o igual a 0;
	 */
	public EmpleadoPorHora(String nombre, String cuil, double sueldoPorHora) throws NumberFormatException, CuilInvalidoExcepcion {
		super(nombre, cuil, sueldoPorHora);
	}
	/**
	 * post:obtener el valor de horas trabajadas;
	 */
	public int getHorasTrabajadas() {
		return horasTrabajadas;
	}
	/**
	 * pre :se le ingresa las horas trabajadas mayores a 0;
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
	 * post: se optiene el sueldo del empleado por las cantidad de horas trabajadas;
	 */
	public double getSueldo(){
		
		return super.getSueldo() * horasTrabajadas ;
		
	}
	/**
	 * post: se optiene la descripcion del empleado;
	 */
	public String toString(){
		return "Tipo: EmpleadoPorHora"+" Nombre: " + super.getNombre() + " Cuil :" + super.getCuil() + " Sueldo por hora: " + super.getSueldo();
		
	}
}
