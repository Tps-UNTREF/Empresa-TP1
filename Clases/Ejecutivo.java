package Clases;
import Excepciones.PremioInvalidoExcepcion;

public class Ejecutivo extends Empleado {
	
	private double premio;

	public Ejecutivo(String nombre, int dni, double sueldo) {
		super(nombre, dni, sueldo);
	}
	
	public void setPremio(double premio) throws PremioInvalidoExcepcion {
		try {
			if(premio > 0){
				this.premio = premio;
			} else {
				throw new PremioInvalidoExcepcion();
			}
		}
		catch(PremioInvalidoExcepcion e) {
			System.out.println(e.error());
		}
	}
	
	public double getPremio() {
		return this.premio;
	}
	
	@Override
	public double getSueldo() {
		return super.getSueldo() + premio;
	}
	
	public String toString() {
		return "Nombre: " + super.getNombre() + " DNI: " + super.getDni() + " Sueldo: " + this.getSueldo();
	}

}
