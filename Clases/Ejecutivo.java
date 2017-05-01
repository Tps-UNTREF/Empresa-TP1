package Clases;
import Excepciones.CuilInvalidoExcepcion;
import Excepciones.DniInvalidoExcepcion;
import Excepciones.NombreInvalidoExcepcion;
import Excepciones.PremioInvalidoExcepcion;

public class Ejecutivo extends Empleado {
	
	private double premio;
	/**
	 * pre : Se ingresa un nombre, un cuil de 11 digitos y un sueldo correcto.
	 * 
	 */
	public Ejecutivo(String nombre, String cuil, double sueldo) throws NumberFormatException, CuilInvalidoExcepcion, DniInvalidoExcepcion, NombreInvalidoExcepcion {
		super(nombre, cuil, sueldo);
	}
	/**
	 * pre : Se ingresa un premio valido.
	 * 
	 * post: Establece el premio del ejecutivo.
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
	 * post: Devuelve el premio.
	 * 
	 */
	public double getPremio() {
		return this.premio;
	}
	/**
	 * post: Devuelve la suma del premio con el sueldo del ejecutivo.
	 * 
	 */
	@Override
	public double getSueldo() {
		return super.getSueldo() + premio;
	}
	/**
	 * post:Devuelve la descripcion del ejecutivo.
	 * 
	 */
	public String toString() {
		return "Tipo: Ejecutivo" +" Nombre: " + super.getNombre() + " CUIL: " + super.getCuil() + " Sueldo: " + this.getSueldo();
	}

}
