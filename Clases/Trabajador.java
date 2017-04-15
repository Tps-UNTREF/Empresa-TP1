package Clases;

 abstract class Trabajador{
	
	private String nombre;
	private int dni;
	/**
	 * pre : 
	 * 
	 * post:
	 * 
	 */
	public Trabajador(String nombre, int dni) {
		this.nombre = nombre;
		this.dni = dni;
	}
	/**
	 * pre : 
	 * 
	 * post:
	 * 
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * pre : 
	 * 
	 * post:
	 * 
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * pre : 
	 * 
	 * post:
	 * 
	 */
	public Integer getDni() {
		return dni;
	}		
}
