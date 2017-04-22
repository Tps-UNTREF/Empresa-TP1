package Clases;

public class Voluntario extends Trabajador {
	/**
	 * pre : 
	 * 
	 * post:
	 * 
	 */
	public Voluntario(String nombre, int dni) {
		super(nombre, dni);
	}
	/**
	 * pre : 
	 * 
	 * post:
	 * 
	 */
	public String toString() {
		return "Tipo: Voluntario" +" Nombre: " + super.getNombre() + " DNI: " + super.getDni();
	}

}
