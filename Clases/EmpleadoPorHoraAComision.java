package Clases;
import Excepciones.ErrorDeComision;
import Excepciones.ErrorVentasRealizadas;

public class EmpleadoPorHoraAComision extends EmpleadoPorHora {

	int comision;
	int ventasRealizadas;
	/**
	 * pre : 
	 * 
	 * post:
	 * 
	 */
	public EmpleadoPorHoraAComision(String nombre, String cuil, double sueldoPorHora , int comision) {
		super(nombre, cuil, sueldoPorHora);
		this.comision = comision;
	}
	/**
	 * pre : 
	 * 
	 * post:
	 * 
	 */
	public int getComision() {
		return comision;
	}
	/**
	 * pre : 
	 * 
	 * post:
	 * 
	 */
	public void setCambiarComision(int comision) {
		
		try{
			if(comision > 0){
				
				this.comision = comision;
			}else{
				
				throw new ErrorDeComision();
				
			}
		}	
			catch(ErrorDeComision e){
				
				System.out.println(e.getMessage());
				
			}
		
	}
	/**
	 * pre : 
	 * 
	 * post:
	 * 
	 */
	public int getVentasRealizadas() {
		
		return ventasRealizadas;
	}
	/**
	 * pre : 
	 * 
	 * post:
	 * 
	 */
	public void setVentasRealizadas(int ventasRealizadas) throws ErrorVentasRealizadas {
		
		if(ventasRealizadas < 0){
			
			throw new ErrorVentasRealizadas();
			
		}else{
			
			this.ventasRealizadas = ventasRealizadas;
			
		}
	}
	/**
	 * pre : 
	 * 
	 * post:
	 * 
	 */
	public double getSueldo(){
		
		double comisionEnVentas = 0;
		
		comisionEnVentas = (this.comision * this.ventasRealizadas) / 100;
		
		
		return comisionEnVentas + super.getSueldo();
	}
	/**
	 * pre : 
	 * 
	 * post:
	 * 
	 */
	public String toString(){
		
		return "Tipo: EmpleadoPorHoraAComision"+" Nombre: " + super.getNombre() + "Cuil: " + super.getCuil() + super.getSueldo() + " Comision: " + this.getComision();
	}
}
