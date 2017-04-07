package Clases;
import Excepciones.HorasTrabajadasInvalidasExcepcion;

public class EmpleadoPorHora extends Empleado {

	int horasTrabajadas;
	
	public EmpleadoPorHora(String nombre, int dni, double sueldoPorHora) {
		super(nombre, dni, sueldoPorHora);
	}

	public int getHorasTrabajadas() {
		return horasTrabajadas;
	}

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
	
	public double getSueldo(){
		
		return super.getSueldo() * horasTrabajadas ;
		
	}
	
	public String toString(){
		return "Nombre :" + super.getNombre() + "DNI :" + super.getDni() + "Sueldo por hora :" + super.getSueldo();
		
	}
}
