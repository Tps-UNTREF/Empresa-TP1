
 abstract class Trabajador {
	
	private String nombre;
	private int dni;
	
	public Trabajador(String nombre, int dni) {
		this.nombre = nombre;
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDni() {
		return dni;
	}
		
}
