
public class Empleado extends Trabajador {

	private String cuil;
	private double sueldo;
	
	public Empleado(String nombre, int dni, double sueldo) {
		super(nombre, dni);
		this.sueldo = sueldo;
	}

	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	
		

}
