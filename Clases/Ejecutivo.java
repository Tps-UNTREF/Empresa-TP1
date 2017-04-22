package Clases;
import Excepciones.CuilInvalidoExcepcion;
import Excepciones.PremioInvalidoExcepcion;

public class Ejecutivo extends Empleado {
	
	private double premio;
	/**
	 * pre : 
	 * 
	 * post: 
	 * 
	 */
	public Ejecutivo(String nombre, String cuil, double sueldo) throws NumberFormatException, CuilInvalidoExcepcion {
		super(nombre, cuil, sueldo);
	}
	/**
	 * pre : 
	 * 
	 * post:
	 * 
	 */
	public void setPremio(double premio) throws PremioInvalidoExcepcion {
		try {
			if(premio > 0){
				this.premio = premio;
			} else {
				throw new PremioInvalidoExcepcion();
			}
		}
		catch(PremioInvalidoExcepcion e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * pre : 
	 * 
	 * post:
	 * 
	 */
	public double getPremio() {
		return this.premio;
	}
	/**
	 * pre : 
	 * 
	 * post:
	 * 
	 */
	@Override
	public double getSueldo() {
		return super.getSueldo() + premio;
	}
	/**
	 * pre : 
	 * 
	 * post:
	 * 
	 */
	public String toString() {
		return "Tipo:Ejecutivo, Nombre:" + super.getNombre() + ", CUIL:" + super.getCuil() + ", Sueldo:" + this.getSueldo();
	}

}
