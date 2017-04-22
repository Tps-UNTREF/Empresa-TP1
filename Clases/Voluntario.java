package Clases;

public class Voluntario extends Trabajador {
	/**
	 * pre : Se ingresa un nombre y un DNI valido.
	 * 
	 */
	public Voluntario(String nombre, int dni) {
		super(nombre, dni);
	}
	/**
	 * post: Devuelve la descripcion del empleado.
	 * 
	 */
	public String toString() {
		return "Tipo: Voluntario" +" Nombre: " + super.getNombre() + " DNI: " + super.getDni();
	}

}
