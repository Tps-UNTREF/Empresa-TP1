
public class Voluntario extends Trabajador {

	public Voluntario(String nombre, int dni) {
		super(nombre, dni);
	}
	
	public String toString() {
		return "Nombre: " + super.getNombre() + " DNI: " + super.getDni();
	}

}